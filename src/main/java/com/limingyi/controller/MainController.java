package com.limingyi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Tab;
import com.limingyi.entity.User;
import com.limingyi.serviceImpl.ReplyServiceImpl;
import com.limingyi.serviceImpl.TabServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;

@Controller
public class MainController {
	 @Autowired
	    public TopicServiceImpl topicService;
	    @Autowired
	    public ReplyServiceImpl replyService;
	    @Autowired
	    public UserServiceImpl userService;
	    @Autowired
	    public TabServiceImpl tabService;
    /**
     * 进入登录页面.
     */
    @RequestMapping(value = {"/signin"})
    public ModelAndView signin(){
        ModelAndView signinPage=new ModelAndView("user/signin");

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signinPage.addObject("topicsNum",topicsNum);
        signinPage.addObject("usersNum",usersNum);
        return  signinPage;
    }
    /**
     * 进入后台登录页面.
     */
    @RequestMapping(value = {"/adminlogin"})
    public ModelAndView adminlogin(){
        ModelAndView signinPage=new ModelAndView("admin/adminlogin");

        return  signinPage;
    }

    /**
     * 进入注册页面.
     */
    @RequestMapping("/signup")
    public ModelAndView signup(){
        ModelAndView signupPage=new ModelAndView("user/signup");

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        signupPage.addObject("topicsNum",topicsNum);
        signupPage.addObject("usersNum",usersNum);
        return  signupPage;
    }

    /**
     * 进入新建主题页面
     */
    @RequestMapping(value = {"/new"})
    public ModelAndView newTopic(HttpSession session){
        ModelAndView newTopicPage=new ModelAndView("user/new");
        List<Tab> tabs=tabService.getAllTabs();
        for(Tab tab:tabs) {
        	System.out.println(tab);
        }
        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
       // System.out.println(collectTopicNum);   
        User user=userService.getUserById(uid);

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        newTopicPage.addObject("tabs",tabs);
        newTopicPage.addObject("topicsNum",topicsNum);
        newTopicPage.addObject("usersNum",usersNum);
        newTopicPage.addObject("user",user);
        return  newTopicPage;
    }

    /**
     * 配置404页面
     */
    @RequestMapping("*")
    public String notFind(){
        return "error";
    }
}
