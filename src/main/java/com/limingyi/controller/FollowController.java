package com.limingyi.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.limingyi.entity.Collect;
import com.limingyi.entity.Follow;
import com.limingyi.serviceImpl.FollowServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;

@Controller
public class FollowController {
	@Autowired
	private FollowServiceImpl followService;
	@Autowired
	private TopicServiceImpl topicService;
	@Autowired
	private UserServiceImpl userService;
	/**
	 * 是否已关注此用户
	 * @param uid
	 * @param tid
	 * @return
	 */
	@RequestMapping(value = "/follow/isFollow",method = RequestMethod.GET)
	@ResponseBody
	private Object isfollow( HttpSession session){
			Integer uid = (Integer)session.getAttribute("userId");
			Integer fid=(Integer) session.getAttribute("fid");
			System.out.println(uid+","+fid);
			 HashMap<String, Object> res = new HashMap<String, Object>();
			if(uid!=null) {
			Follow follow = followService.isFollow(uid,fid);
			System.out.println(follow);
			if(!uid.equals(fid)) {
			if(follow!=null) {
			    res.put("result","取消关注");
			}else {
				res.put("result", "加入特别关注");
			}
			}else {
				res.put("result", "本人不需要关注");
			}
			
			}
			
			return res;
	}
	/**
	 * 取消关注
	 * @param co
	 * 
	 * @return
	 */
	@RequestMapping(value = "/follow/delete",method = RequestMethod.POST)
	@ResponseBody
	private Object delete(HttpSession session){
		Integer uid = (Integer)session.getAttribute("userId");
		Integer fid=(Integer) session.getAttribute("fid");
		System.out.println(uid+","+fid);
		 HashMap<String, Object> res = new HashMap<String, Object>();
		 followService.delete(uid,fid);
		 res.put("result","0");
		return res;
	}
	@RequestMapping(value = "/follow/delete1",method = RequestMethod.GET)

	private String delete1(HttpSession session,@RequestParam(value = "id") Integer fid){
		System.out.println(fid);
		Integer uid = (Integer)session.getAttribute("userId");
		System.out.println(uid+","+fid);

		 followService.delete(uid,fid);

		return "redirect:/tomain";
	}
	/**
	   * 加入关注
	 * @param uid
	 * @param tid
	 * @return
	 */
	@RequestMapping(value = "/follow/save",method = RequestMethod.POST)
	@ResponseBody
	private Object save(HttpSession session){
		Integer uid = (Integer)session.getAttribute("userId");
		Integer fid=(Integer) session.getAttribute("fid");
		 HashMap<String, Object> res = new HashMap<String, Object>();
		Follow follow = new Follow();
		follow.setUid(uid);
		follow.setFid(fid);
		follow.setIsDelete(false);
		follow.setCreateTime(new Date());
		//添加收藏记录
		followService.insert(follow);
		res.put("result","1");
	return res;
	}
}
