package com.limingyi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Lunbo;
import com.limingyi.entity.Movies;
import com.limingyi.entity.Reply;
import com.limingyi.entity.User;
import com.limingyi.service.LunboService;
import com.limingyi.service.MoviesService;
import com.limingyi.service.ReplyService;
import com.limingyi.service.TopicService;
import com.limingyi.service.UserService;

@Controller
public class MovieCotroller {
	@Autowired UserService userService;
	@Autowired TopicService topicService;
	@Autowired MoviesService moviesService;
	@Autowired ReplyService replyService;
	  @Autowired
	    public LunboService lunboService;
	
	 @RequestMapping("/movies")
	    public ModelAndView tomovies(HttpSession session){
	    	ModelAndView  mv = new ModelAndView("movies/movieIndex");
	    	//获取全部影片
	    	List<Movies> movies = moviesService.getAllMovies();
	    	System.out.println(movies);
	    	//获取全部轮播
	    	List<Lunbo> lunbolist = lunboService.getAllLunbo();
	    	//获取用户信息
	        Integer userId=(Integer) session.getAttribute("userId");
	        User user = userService.getUserById(userId);
			int  topicsNumofuser = topicService.getTopicsNumByUser(userId);     //获取我的主题数
	        mv.addObject("user",user);   
	        mv.addObject("movies",movies);
	        mv.addObject("lunbolist",lunbolist);
	        mv.addObject("topicsNumofuser",topicsNumofuser);
	    	return mv;
	 }
	    
	 @SuppressWarnings("unchecked")
	@RequestMapping("/view/{id}")
	    public ModelAndView view(@PathVariable("id")Integer id,@RequestParam(value="targetuserId",  required = false)Integer targetuserId,HttpSession session){
		//观看量量加一
	        boolean ifSucc=moviesService.clickAddOne(id);        //进入详细界面 观看量加一；
	      //获取影片信息
	        Movies movies=moviesService.selectById(id);
	        //电影一级评论
	        List<Reply> replies=replyService.getRepliesOfMovies(id);    
	        //电影二级全部回复评论
	        List<Reply> secondreplies = replyService.getRepliesOfMovieSecond(id);

	        //获取评论数
	        int repliesNum=replyService.repliesNum(id);
	    	ModelAndView  mv = new ModelAndView("movies/movieInfo");
	    	//获取用户信息
	        Integer userId=(Integer) session.getAttribute("userId");
	        User user = userService.getUserById(userId);
	       
			int  topicsNumofuser = topicService.getTopicsNumByUser(userId);
	        mv.addObject("user",user);   
	        mv.addObject("movies", movies);
	        mv.addObject("secondreplies", secondreplies);
	        mv.addObject("replies",replies);
	        mv.addObject("repliesNum",repliesNum);
	        mv.addObject("topicsNumofuser",topicsNumofuser);
	    	return mv;
	 }
}
