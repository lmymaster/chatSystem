package com.limingyi.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Reply;
import com.limingyi.entity.User;
import com.limingyi.serviceImpl.NoticeServiceImpl;
import com.limingyi.serviceImpl.ReplyServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;


@Controller
public class NoticeCotroller {
	@Autowired
	private NoticeServiceImpl noticeService;
	@Autowired
	private ReplyServiceImpl replyService;
	@Autowired
	private UserServiceImpl userService;
	/**
	 * 通知列表
	 * @return
	 */
	@RequestMapping(value = "/notice/list", method = RequestMethod.GET)
	private ModelAndView noticeList(HttpSession session) {
		 ModelAndView indexPage=new ModelAndView("common/notice");
		Integer uid = (Integer)session.getAttribute("userId");
		 User user=userService.getUserById(uid);
		List<Reply> replies = replyService.listTopicsByNotice(uid);   // 获取通知主题
		System.out.println(replies);
		indexPage.addObject("replies",replies);
		indexPage.addObject("user",user);
		noticeService.updateIsRead(uid);//将通知都置为已读
		return indexPage;
		
	}

	/**
	 * 是否有回复通知
	 * @param uid
	 * @param tid
	 * @return
	 */
	@RequestMapping(value = "/notice/isRead",method = RequestMethod.GET)
	@ResponseBody
	private Object isRead( HttpSession session){
			Integer uid = (Integer)session.getAttribute("userId");
			System.out.println(uid);
			HashMap<String, Object> res = new HashMap<String, Object>();
			Integer notice = noticeService.isRead(uid);      //判断是否有位回复的，若有为回复查找未的数量
			System.out.println(notice);
			if(notice>0) {
				res.put("result",notice+"");
			}
			
			return res;
	}
	
}
