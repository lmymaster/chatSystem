package com.limingyi.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Follow;
import com.limingyi.entity.Lunbo;
import com.limingyi.entity.Movies;
import com.limingyi.entity.Page;
import com.limingyi.entity.Reply;
import com.limingyi.entity.Tab;
import com.limingyi.entity.Topic;
import com.limingyi.entity.User;
import com.limingyi.service.LunboService;
import com.limingyi.service.MoviesService;
import com.limingyi.service.sensitivefilter.SensitiveFilterService;
import com.limingyi.serviceImpl.CollectServiceImpl;
import com.limingyi.serviceImpl.FollowServiceImpl;
import com.limingyi.serviceImpl.ReplyServiceImpl;
import com.limingyi.serviceImpl.TabServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;


/**
 * 主题相关控制类
 */
@Controller

public class TopicController {

    @Autowired
    public TopicServiceImpl topicService;
    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public TabServiceImpl tabService;
    @Autowired
    public CollectServiceImpl collectService;
    @Autowired
    public FollowServiceImpl followService;
    @Autowired
    public MoviesService moviesService;
    @Autowired
    public LunboService lunboService;

    //log4j对象
    private final Log log = LogFactory.getLog(getClass());

    /**
     * 渲染首页
     * @param session
     * @return
     */
    @RequestMapping("/tomain")
    public ModelAndView toMain(@RequestParam(value = "currentpage", defaultValue = "1") Integer currentPage,HttpSession session){
        ModelAndView indexPage=new ModelAndView("common/main");
        //全部主题
       // List<Topic> topics=topicService.listTopicsAndUsers();
   
        //获取统计信息
        int topicsNum=topicService.getTopicsNum();    //主题总数
        int usersNum=userService.getUserCount();
        int pageSize =10;
        //根据页面全部主题
        List<Topic> topicBypage=topicService.listTopicsBypage((currentPage-1)*pageSize, pageSize);
        Page topic = new Page(topicBypage,currentPage,pageSize,topicsNum);
        //将分页获取全部主题写入Session
        session.setAttribute("topics",topic);
  
        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
        //用户收藏话题的数目
        int collectTopicNum = collectService.countByUid(uid);
        int followUserNum = followService.countByUid(uid);
        //登录账户话题的数目
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        session.setAttribute("collectTopicNum", collectTopicNum);
        session.setAttribute("followUserNum", followUserNum);
       // System.out.println(collectTopicNum);   
        User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //特别关注的用户
        List<Follow> follows = followService.listOfFollow(uid);
      //获取全部轮播
    	List<Lunbo> lunbolist = lunboService.getAllLunbo();
        System.out.println(follows);
        indexPage.addObject("topics",topic);
        indexPage.addObject("follows", follows);
        indexPage.addObject("lunbolist", lunbolist);
        indexPage.addObject("hotestTopics",hotestTopics);
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("topicsNumofuser",topicsNumofuser);
        indexPage.addObject("followUserNum",followUserNum);
        indexPage.addObject("hotestMovies",hotestMovies);
        indexPage.addObject("collectTopicNum",collectTopicNum);
        indexPage.addObject("user",user);                    //side.jsp中要显示积分和姓名 user.credit
        return  indexPage;
    }

    /**
     * 渲染主题详细页面
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("t/{id}")
    public ModelAndView toTopic(@PathVariable("id")Integer id,HttpSession session){
    	session.setAttribute("tid", id);   //点赞需要用到uid
    	System.out.println("dfafdsf"+id);
        //点击量加一
        boolean ifSucc=topicService.clickAddOne(id);        //进入详细界面 点击量加一；
        //获取主题信息
        Topic topic=topicService.selectById(id);
        //获取主题全部评论
        List<Reply> replies=replyService.getRepliesOfTopic(id);
        //获取评论数
        int repliesNum=replyService.repliesNum(id);
        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();
       
        
        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //特别关注的用户
        List<Follow> follows = followService.listOfFollow(uid);
    
        //渲染视图
        ModelAndView topicPage=new ModelAndView("common/detail");
        topicPage.addObject("topic",topic);
        topicPage.addObject("follows",follows);
        topicPage.addObject("replies",replies);
        topicPage.addObject("repliesNum",repliesNum);
        topicPage.addObject("topicsNumofuser",topicsNumofuser);
        topicPage.addObject("topicsNum",topicsNum);
        topicPage.addObject("usersNum",usersNum);
        topicPage.addObject("user",user);
        topicPage.addObject("hotestMovies",hotestMovies);
        topicPage.addObject("hotestTopics",hotestTopics);
        return topicPage;
    }

    /**
     * 渲染指定板块页面
     */
    @RequestMapping("tab/{tabNameEn}")
    public ModelAndView toTabPage(@RequestParam(value = "p", defaultValue = "1") Integer currentPage,@PathVariable("tabNameEn")String tabNameEn,HttpSession session){
    	Tab tab=tabService.getByTabNameEn(tabNameEn);
        Integer tabId=tab.getId();
        session.setAttribute("tabNameEn", tabNameEn);
        session.setAttribute("tabId", tabId);
       // Integer currentPage = (Integer)session.getAttribute("currentpage");

        ModelAndView indexPage=new ModelAndView("common/main");
        //全部主题
    //    List<Topic> topics=topicService.listTopicsAndUsersOfTab(tabId);

        //获取统计信息;
        int topicsNumOfTab =topicService.getTopicsNumOfTab(tabId);
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();
        int pageSize =10;
        //根据页面全部主题
        List<Topic> topicBypage=topicService.listTopicsBypageOfTab(tabId,(currentPage-1)*pageSize, pageSize);
        Page topics = new Page(topicBypage,currentPage,pageSize,topicsNumOfTab);

        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //获取全部轮播
      	List<Lunbo> lunbolist = lunboService.getAllLunbo();
      //特别关注的用户
        List<Follow> follows = followService.listOfFollow(uid);
      	 indexPage.addObject("lunbolist", lunbolist);
    	 indexPage.addObject("follows", follows);
        indexPage.addObject("topics",topics);
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("tab",tab);
        indexPage.addObject("topicsNumofuser",topicsNumofuser);
        indexPage.addObject("user",user);
        indexPage.addObject("hotestTopics",hotestTopics);
        indexPage.addObject("hotestMovies",hotestMovies);
        return  indexPage;
    }
    @RequestMapping("/good")
    public ModelAndView good(@RequestParam(value = "p", defaultValue = "1") Integer currentPage,HttpSession session) {
    	ModelAndView indexPage=new ModelAndView("common/main");
    	 //获取统计信息
        int topicsNum=topicService.getTopicsNum();    //主题总数
        int usersNum=userService.getUserCount();
        int topicsNumByGood = topicService.getTopicsNumByGoo();
        int pageSize =10;
        //根据页面全部主题
        List<Topic> topicBypage=topicService.selectAllGood((currentPage-1)*pageSize, pageSize);
        Page topic = new Page(topicBypage,currentPage,pageSize,topicsNumByGood);
        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
        //用户收藏话题的数目
        int collectTopicNum = collectService.countByUid(uid);
        int followUserNum = followService.countByUid(uid);
        //登录账户话题的数目
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        session.setAttribute("collectTopicNum", collectTopicNum);
        session.setAttribute("followUserNum", followUserNum);
       // System.out.println(collectTopicNum);   
        User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //获取全部轮播
      	List<Lunbo> lunbolist = lunboService.getAllLunbo();
      	 indexPage.addObject("lunbolist", lunbolist);
        //特别关注的用户
        List<Follow> follows = followService.listOfFollow(uid);
        System.out.println(follows);
        indexPage.addObject("topics",topic);
        indexPage.addObject("follows", follows);
        indexPage.addObject("hotestTopics",hotestTopics);
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("topicsNumofuser",topicsNumofuser);
        indexPage.addObject("followUserNum",followUserNum);
        indexPage.addObject("hotestMovies",hotestMovies);
        indexPage.addObject("collectTopicNum",collectTopicNum);
        indexPage.addObject("user",user);                    //side.jsp中要显示积分和姓名 user.credit
        return  indexPage;
    }
    /**
     * 发表主题
     * @param request
     * @param session
     * @return
     */
    @RequestMapping(value = "topic/add", method = RequestMethod.POST)
    public String addTopic(HttpServletRequest request,HttpSession session){
  
        //处理参数
       Integer userId=(Integer) session.getAttribute("userId");
         String title=request.getParameter("title");
        String content=request.getParameter("content");
        System.out.println(content);
        Byte tabId=Byte.parseByte(request.getParameter("tab"));

        
        //过滤敏感词汇
        SensitiveFilterService filter = SensitiveFilterService.getInstance();
       //如果需要过滤则用“”替换
        //如果需要屏蔽，则用“*”替换
        String titlehou = filter.replaceSensitiveWord(title, 1, "*");
        String contenthou = filter.replaceSensitiveWord(content, 1, "*");
        System.out.println("替换前的文字为：" + title);
        System.out.println("替换后的文字为：" + titlehou);
        System.out.println("替换后的文字为：" + contenthou);
        //新建Topic
        Topic topic=new Topic();
        topic.setUserId(userId);
        topic.setTitle(titlehou);
        topic.setContent(content);
        topic.setTabId(tabId);
        topic.setNice(0);
        topic.setCreateTime(new Date());
        topic.setUpdateTime(new Date());
        topic.setTop(false);
        topic.setGood(false);
        //添加topic
        boolean ifSucc=topicService.addTopic(topic);
        boolean ifSuccAddCredit=userService.addCredit(1,userId);          //添加积分
        if (ifSucc){
            if (log.isInfoEnabled()){
                log.info("添加主题成功!");
            }
        }
        return  "redirect:/tomain";
    }
    
    /**
     * 获取个人主题(我的主题)
     */
    @RequestMapping("/getOwnList")
    public ModelAndView getmytopic(HttpSession session){
    	 ModelAndView mv=new ModelAndView("user/mytopic");
    	 //获取统计信息
         int topicsNum=topicService.getTopicsNum();
         int usersNum=userService.getUserCount();
         //获取用户信息
         Integer userId=(Integer) session.getAttribute("userId");
         //用户收藏话题的数目
         int collectTopicNum = collectService.countByUid(userId);
         int followUserNum = followService.countByUid(userId);

         int  topicsNumofuser = topicService.getTopicsNumByUser(userId);
         User user = userService.getUserById(userId);
         //获取我的主题
         List<Topic> topics = topicService.getOwnList(userId);
       //最热主题
         List<Topic> hotestTopics=topicService.listMostCommentsTopics();
         //最热影片
         List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
         //特别关注的用户
         List<Follow> follows = followService.listOfFollow(userId);
    	 mv.addObject("follows", follows);
    	 mv.addObject("topics",topics);
         mv.addObject("hotestTopics",hotestTopics);
         mv.addObject("hotestMovies",hotestMovies);
         mv.addObject("collectTopicNum",collectTopicNum);
         mv.addObject("followUserNum",followUserNum);
         mv.addObject("topicsNumofuser",topicsNumofuser);
         mv.addObject("topicsNum",topicsNum);
         mv.addObject("usersNum",usersNum);
         mv.addObject("user",user);             
		return mv;
        }
    /**
     * 删除指定Id主题
     */
    @RequestMapping("/delete")
    public ModelAndView deleteTopic(@RequestParam("id") Integer id,HttpSession session){
    	ModelAndView mv;
    	System.out.println(id);
   	   //删除主题
   	   boolean del = topicService.deleteById(id);
   	   if(del) {
   		 mv = new ModelAndView("user/mytopic");
   	   //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();
        //获取用户信息
        Integer userId=(Integer) session.getAttribute("userId");
        User user = userService.getUserById(userId);
        //获取我的主题
        List<Topic> topics = topicService.getOwnList(userId);
      //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //特别关注的用户
        List<Follow> follows = followService.listOfFollow(userId);
        mv.addObject("hotestMovies",hotestMovies);
   	   mv.addObject("topics",topics);
   	   mv.addObject("follows",follows);
        mv.addObject("hotestTopics",hotestTopics);
        mv.addObject("topicsNum",topicsNum);
        mv.addObject("usersNum",usersNum);
        mv.addObject("user",user);             
		return mv;
   	   }else {
   		   mv = new ModelAndView("/");
   		   return mv;
   	   } 
   	   
            }
    
    
   	   }
    


