package com.limingyi.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Lunbo;
import com.limingyi.entity.Movies;
import com.limingyi.entity.User;
import com.limingyi.service.LunboService;
import com.limingyi.service.ReplyService;
import com.limingyi.service.TopicService;
import com.limingyi.service.UserService;

@Controller
public class adminSystemController {
	@Autowired UserService userService;
	@Autowired LunboService lunboService;
	@Autowired TopicService topicService;
	@Autowired ReplyService replyService;
	 @RequestMapping("/admin/lunbo")
	    public ModelAndView upmovies(HttpSession session){
	    	ModelAndView  mv = new ModelAndView("admin/sys/lunbolist");
	    	
	    //获取全部轮播
	    	List<Lunbo> lunbolist = lunboService.getAllLunbo();
	    	   //获取用户信息
	        Integer uid=(Integer) session.getAttribute("userId");
	       // System.out.println(collectTopicNum);   
	        User user=userService.getUserById(uid);
	        mv.addObject("user",user);
	        mv.addObject("lunbolist", lunbolist);
     	return mv;
	 }
	 @RequestMapping("/admin/lunbo/update/{id}")
	 public ModelAndView update(HttpSession session,@PathVariable("id") Integer id,@RequestPart("file") MultipartFile avatarFile) {
	            System.out.println(id);   //验证前台获取的id
			    String fileName=avatarFile.getOriginalFilename();   //文件名称
		        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()); //截取文件拓展名
		        Long date=new Date().getTime();
		        String newFileName=date+"."+suffix;
		        System.out.println(newFileName);
		        String absolutePath=session.getServletContext().getRealPath("/static/default/images/lunbo")+"/"+newFileName;
		        String relativePath="/static/default/images/lunbo"+"/"+newFileName;

		       Lunbo lunbo = new Lunbo();
               lunbo.setId(id);
               lunbo.setAvatar(relativePath);
		        File file=new File(absolutePath);

		        if (!file.exists()){
		            try { 
	
		              avatarFile.transferTo(file); 
		                lunboService.updatelunbo(lunbo);
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
