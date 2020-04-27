package com.limingyi.controller.admin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Movies;
import com.limingyi.entity.User;
import com.limingyi.service.MoviesService;
import com.limingyi.service.ReplyService;
import com.limingyi.service.TopicService;
import com.limingyi.service.UserService;

@Controller
public class adminMoviesController {
	@Autowired 
	private UserService userService;
	@Autowired 
	private MoviesService moviesService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ReplyService replyService;
	 @RequestMapping("/upmovies")
	    public ModelAndView upmovies(HttpSession session){
	    	ModelAndView  mv = new ModelAndView("admin/movies/upmovies");
	    	   //获取用户信息
	        Integer uid=(Integer) session.getAttribute("userId");
	       // System.out.println(collectTopicNum);   
	        User user=userService.getUserById(uid);
	        mv.addObject("user",user);
        	return mv;
	 }
	 @RequestMapping(value = "/admin/movies/addmovie")
		public ModelAndView update(HttpSession session,
				@RequestParam(value = "moviename") String moviename,
				@RequestParam(value = "area") String area,
				@RequestParam(value = "uptime") String upTime,
				@RequestParam(value = "director") String director,
				@RequestParam(value = "actor") String actor,
				@RequestParam(value = "introduce") String introduce,
				@RequestPart("avatar") MultipartFile avatarFile,
				@RequestPart("address") MultipartFile addressFile) {
		System.out.println(moviename+","+area);
			    String fileName=avatarFile.getOriginalFilename();
			    String fileName1=addressFile.getOriginalFilename();
		        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		        String suffix1=fileName1.substring(fileName1.lastIndexOf(".")+1, fileName1.length());
		        Long date=new Date().getTime();
		        String newFileName=date+"."+suffix;
		        String newFileName1=date+"."+suffix1;      //电影资源的URL
		        String absolutePath=session.getServletContext().getRealPath("/static/default/images/movies")+"/"+newFileName;
		        String absolutePath1=session.getServletContext().getRealPath("/static/default/images/movies")+"/"+newFileName1;
		        String relativePath="/images/movies"+"/"+newFileName;
		        String relativePath1="/images/movies"+"/"+newFileName1;
		        Movies movies = new Movies();
		        movies.setArea(area);
		        movies.setDirector(director);
		        movies.setAvatar(relativePath);
		        movies.setActor(actor);
		        movies.setUpTime(upTime);
		        movies.setAddress(relativePath1);
		        movies.setClick(0);
		        movies.setCreateTime(new Date());
		        movies.setIntroduce(introduce);
		        movies.setMoviename(moviename);
		       System.out.println(movies.toString());
		        File file=new File(absolutePath);
		        File file1=new File(absolutePath1);
		 
			
		        if (!file.exists()){
		            try { 
		            	
		            	//电影资源一种方式
		              avatarFile.transferTo(file); 
		              addressFile.transferTo(file1);
				/*
				 * //==========================================================================
				 * //电影资源另一种方式 InputStream fis = (FileInputStream)addressFile.getInputStream();
				 * InputStream fis1 = (FileInputStream)avatarFile.getInputStream();
				 * FileOutputStream fos = new FileOutputStream(file1); FileOutputStream fos1 =
				 * new FileOutputStream(file1); //定义一个缓冲区。 byte[] buf = new byte[10240000]; int
				 * len = 0; while ((len = fis.read(buf)) != -1&&(len = fis1.read(buf)) != -1) {
				 * fos.write(buf, 0, len);// 将数组中的指定长度的数据写入到输出流中。 fos1.write(buf, 0, len); } //
				 * 关闭资源。 fos.close(); fis.close();
				 * //===========================================================================
				 * ====
				 */
						
		                moviesService.addMovies(movies);
		            }catch (Exception e){
		                e.printStackTrace();
		            }
		        }
			ModelAndView mv=new ModelAndView("admin/adminmain");
		
		     Integer uid=(Integer) session.getAttribute("userId");
		     User user=userService.getUserById(uid);  
		 	// 查询当天新增话题
	    	    mv.addObject("topic_count", topicService.countToday());
	    	    // 查询当天新增评论
	    	    mv.addObject("comment_count", replyService.countToday());
	    	    // 查询当天新增用户
	    	    mv.addObject("user_count", userService.countToday());
		     mv.addObject("user",user); 
		     return mv;
		}

}
