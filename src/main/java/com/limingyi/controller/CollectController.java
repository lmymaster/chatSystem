package com.limingyi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Collect;
import com.limingyi.entity.Movies;
import com.limingyi.entity.Topic;
import com.limingyi.entity.User;
import com.limingyi.service.MoviesService;
import com.limingyi.serviceImpl.CollectServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;








@Controller
public class CollectController {
	@Autowired
	private CollectServiceImpl collectService;
	@Autowired
	private TopicServiceImpl topicService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private MoviesService moviesService;
	/**
	 * 是否已收藏此话题
	 * @param uid
	 * @param tid
	 * @return
	 */
	@RequestMapping(value = "/collect/isCollect",method = RequestMethod.GET)
	@ResponseBody
	private Object isCollect( HttpSession session){
			Integer uid = (Integer)session.getAttribute("userId");
			Integer tid=(Integer) session.getAttribute("tid");
			//System.out.println(uid+","+tid);
			 HashMap<String, Object> res = new HashMap<String, Object>();
			if(uid!=null) {
			Collect collect = collectService.isCollect(uid,tid);
			
			if(collect!=null) {
			    res.put("result","取消收藏");
			}else {
				res.put("result", "加入收藏");
			}
			
			}
			
			return res;
	}
	/**
	 * 取消收藏
	 * @param co
	 * 
	 * @return
	 */
	@RequestMapping(value = "/collect/delete",method = RequestMethod.POST)
	@ResponseBody
	private Object delete(HttpSession session){
		Integer uid = (Integer)session.getAttribute("userId");
		Integer tid=(Integer) session.getAttribute("tid");
		System.out.println(uid+","+tid);
		 HashMap<String, Object> res = new HashMap<String, Object>();
		 collectService.delete(uid,tid);
		 res.put("result","0");
		return res;
	}
	/**
	 * 收藏话题
	 * @param uid
	 * @param tid
	 * @return
	 */
	@RequestMapping(value = "/collect/save",method = RequestMethod.POST)
	@ResponseBody
	private Object save(HttpSession session){
		Integer uid = (Integer)session.getAttribute("userId");
		Integer tid=(Integer) session.getAttribute("tid");
		 HashMap<String, Object> res = new HashMap<String, Object>();
		Collect collect = new Collect();
		collect.setUserId(uid);
		collect.setTopicId(tid);
		collect.setCreateDate(new Date());
		collect.setUpdateDate(new Date());
		//添加收藏记录
		collectService.insert(collect);
		res.put("result","1");
	return res;
	}
	/**
	 * 收藏话题列表
	 * @param p
	 * @param uid
	 * @return
	 	*/
	@RequestMapping(value = "/collect/topics",method = RequestMethod.GET)
	public ModelAndView list(HttpSession session) {
		ModelAndView indexPage=new ModelAndView("common/collect");
        //获取统计信息
        int topicsNum=topicService.getTopicsNum();    //主题总数
        int usersNum=userService.getUserCount();  
        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
        //用户收藏话题的数目
        int collectTopicNum = collectService.countByUid(uid);
        System.out.println(collectTopicNum);   
        User user=userService.getUserById(uid);
        //收藏主题
        List<Topic> topic = topicService.listTopicsByCollect(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        indexPage.addObject("hotestMovies",hotestMovies);
        indexPage.addObject("topics",topic);
        indexPage.addObject("hotestTopics",hotestTopics);
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("collectTopicNum",collectTopicNum);
        indexPage.addObject("user",user);                           //side.jsp中要显示积分和姓名 user.credit
        return  indexPage;
	}


}
