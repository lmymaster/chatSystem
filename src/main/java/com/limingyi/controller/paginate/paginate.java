package com.limingyi.controller.paginate;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Follow;
import com.limingyi.entity.Lunbo;
import com.limingyi.entity.Movies;
import com.limingyi.entity.Page;
import com.limingyi.entity.Topic;
import com.limingyi.entity.User;
import com.limingyi.service.LunboService;
import com.limingyi.service.MoviesService;
import com.limingyi.serviceImpl.FollowServiceImpl;
import com.limingyi.serviceImpl.ReplyServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;

@Controller
public class paginate {
	 @Autowired
	    public TopicServiceImpl topicService;
	    @Autowired
	    public ReplyServiceImpl replyService;
	    @Autowired
	    public UserServiceImpl userService;
	@Autowired
	public MoviesService moviesService;
	@Autowired
	public LunboService lunboService;
	
	@Autowired
	public FollowServiceImpl followService;
	    /**
	     * 
	     * @param session
	     * @return
	     */
	    /*
	    @RequestMapping("/paginate/{currentpage}")
	    public ModelAndView pagenate(@PathVariable("currentpage") Integer currentPage,HttpSession session){
	        ModelAndView indexPage=new ModelAndView("common/main");
	        //获取主题总数量
	     
	        int totalrow=topicService.getTopicsNum(); 
	        int usersNum=userService.getUserCount();
	        //获取用户信息
	        Integer uid=(Integer) session.getAttribute("userId");
	        User user=userService.getUserById(uid);
	        //最热主题
	        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
	     
	        int pageSize =10;
	      
	       
		        //根据页面全部主题
			        List<Topic> topicBypage=topicService.listTopicsBypage((currentPage-1)*pageSize, pageSize);
					Page topics = new Page(topicBypage,currentPage,pageSize,totalrow);
			        indexPage.addObject("topics",topics);
	                 
	            
	        indexPage.addObject("hotestTopics",hotestTopics);
	        indexPage.addObject("topicsNum",totalrow);
	        indexPage.addObject("usersNum",usersNum);
	        indexPage.addObject("user",user);                 //side.jsp中要显示积分和姓名 user.credit
	        return  indexPage;
	        }*/
	    @RequestMapping("/paginate")
	    public ModelAndView pagenate(@RequestParam("p") Integer currentPage,HttpSession session){
	    	//@PathVariable("currentpage") Integer currentPage
	    	System.out.println(currentPage);
	        ModelAndView indexPage=new ModelAndView("common/main");
	        //获取主题总数量
	        session.setAttribute("currentpage", currentPage);
	        int totalrow=topicService.getTopicsNum(); 
	        int usersNum=userService.getUserCount();
	        //获取用户信息
	        Integer uid=(Integer) session.getAttribute("userId");
	        User user=userService.getUserById(uid);
	        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
	        //最热主题
	        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
	        //最热影片
	        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
	        int pageSize =10;
	      
		        //根据页面全部主题
			        List<Topic> topicBypage=topicService.listTopicsBypage((currentPage-1)*pageSize, pageSize);
					Page topics = new Page(topicBypage,currentPage,pageSize,totalrow);
			        indexPage.addObject("topics",topics);
			        //获取全部轮播
			      	List<Lunbo> lunbolist = lunboService.getAllLunbo();
			      	 indexPage.addObject("lunbolist", lunbolist);
			        //特别关注的用户
			        List<Follow> follows = followService.listOfFollow(uid);  
			        indexPage.addObject("follows", follows);
	        indexPage.addObject("hotestTopics",hotestTopics);
	        indexPage.addObject("hotestMovies",hotestMovies);
	        indexPage.addObject("topicsNumofuser",topicsNumofuser);
	        indexPage.addObject("topicsNum",totalrow);
	        indexPage.addObject("usersNum",usersNum);
	        indexPage.addObject("user",user);                 //side.jsp中要显示积分和姓名 user.credit
	        return  indexPage;
	    }
}
