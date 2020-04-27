package com.limingyi.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Notice;
import com.limingyi.entity.Reply;
import com.limingyi.serviceImpl.NoticeServiceImpl;
import com.limingyi.serviceImpl.ReplyServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;

/**
 * 回复相关控制类
 */
@Controller
public class ReplyController {

    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public NoticeServiceImpl noticeService;

    /**
     * 添加评论
     */
    @RequestMapping(value = "reply/add",method = RequestMethod.POST)
    public ModelAndView addReply(HttpServletRequest request, HttpSession session){
        //处理参数
        Integer topicId=Integer.parseInt(request.getParameter("topicId"));
        Integer replyUserId=Integer.parseInt(request.getParameter("replyUserId"));
        Integer targetuserId=Integer.parseInt(request.getParameter("topicUserId"));
        System.out.println(targetuserId);
        String content=request.getParameter("content");
        //创建reply
        Reply reply=new Reply();
        reply.setTopicId(topicId);
        reply.setReplyUserId(replyUserId);
        reply.setContent(content);
        reply.setCreateTime(new Date());
        reply.setUpdateTime(new Date());
        //执行添加
        boolean ifSucc=replyService.addReply(reply);
        Byte type=new Byte("0");   //信息是否已读
        Notice notice = new Notice();
        notice.setNoticeuserId(replyUserId);
        notice.setIsRead(type);
        notice.setTargetuserId(targetuserId);
        notice.setTopicId(topicId);
        notice.setCreateDate(new Date());
         noticeService.addNotice(notice);
        
        //添加积分
        boolean ifSuccAddCredit=userService.addCredit(1,replyUserId);

        //新建视图
        ModelAndView view=new ModelAndView("redirect:/t/"+topicId);
        return view;
    }
    /**
     * 评论电影模块
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "reply/add1",method = RequestMethod.POST)
    public ModelAndView addReply1(HttpServletRequest request, HttpSession session){
        //处理参数
        Integer moviesId=Integer.parseInt(request.getParameter("moviesId"));
        Integer replyUserId=Integer.parseInt(request.getParameter("replyUserId"));
        String content=request.getParameter("content");
        //创建reply
        Reply reply=new Reply();
        reply.setMoviesId(moviesId);
        reply.setReplyUserId(replyUserId);
        reply.setContent(content);
        reply.setCreateTime(new Date());
        reply.setUpdateTime(new Date());
        //执行添加
        boolean ifSucc=replyService.addReply1(reply);
    
 
        
        //添加积分
        boolean ifSuccAddCredit=userService.addCredit(1,replyUserId);

        //新建视图
        ModelAndView view=new ModelAndView("redirect:/view/"+moviesId);
        return view;
    }

    /**
     * 二级评论电影模块
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "reply/add2",method = RequestMethod.POST)
    public ModelAndView addReply2(HttpServletRequest request, HttpSession session){
        //处理参数
    	Integer moviesId=Integer.parseInt(request.getParameter("moviesId"));
        Integer secondreplyUserId=Integer.parseInt(request.getParameter("secondreplyUserId"));
        Integer targetuserId=Integer.parseInt(request.getParameter("targetuserId"));
        String content=request.getParameter("content");
        //创建reply
        Reply reply=new Reply();
        reply.setSecondreplyUserId(secondreplyUserId);
        reply.setTargetuserId(targetuserId);
        reply.setContent(content);
        reply.setMoviesId(moviesId);
        reply.setCreateTime(new Date());
        //执行添加
        boolean ifSucc=replyService.addReply2(reply);
    
 
        
   

        //新建视图
        ModelAndView view=new ModelAndView("redirect:/view/"+moviesId+"?targetuserId="+targetuserId);
        return view;
    }


}
