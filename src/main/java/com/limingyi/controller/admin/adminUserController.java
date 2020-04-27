package com.limingyi.controller.admin;


import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Page;
import com.limingyi.entity.Reply;
import com.limingyi.entity.Topic;
import com.limingyi.entity.User;
import com.limingyi.service.ReplyService;
import com.limingyi.service.TopicService;
import com.limingyi.service.UserService;
import com.sun.management.OperatingSystemMXBean;









@Controller
public class adminUserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private ReplyService replyService;
	
	// 后台登录处理
	 @RequestMapping("/toadminmain")
	    public ModelAndView toMain(HttpSession session){
	        ModelAndView indexPage=new ModelAndView("admin/adminmain");
	        //获取用户信息
	        Integer uid=(Integer) session.getAttribute("userId");
	       // System.out.println(collectTopicNum);   
	        User user=userService.getUserById(uid);
			// 查询当天新增话题
    	    indexPage.addObject("topic_count", topicService.countToday());
    	    // 查询当天新增评论
    	    indexPage.addObject("comment_count", replyService.countToday());
    	    // 查询当天新增用户
    	    indexPage.addObject("user_count", userService.countToday());
	        indexPage.addObject("user",user);                    //side.jsp中要显示积分和姓名 user.credit
	        return  indexPage;
	    }
	 /**
		      * 获取全部用户
		* @param session
		* @return
		*/
		@RequestMapping(value = "/admin/user/list",method = RequestMethod.GET)
		public ModelAndView toUser(HttpSession session){
		//获取全部评论
		List<User> users=userService.getUsersAll();
		Integer uid=(Integer) session.getAttribute("userId");
		   // System.out.println(collectTopicNum);   
		    User user=userService.getUserById(uid);
		ModelAndView topicPage=new ModelAndView("admin/user/list");
		topicPage.addObject("users",users);
		
		topicPage.addObject("user",user); 
		
		return topicPage;
		}
		
		@RequestMapping(value = "/admin/user/adminlist",method = RequestMethod.GET)
		public ModelAndView toAdmin(HttpSession session){
		//获取管理员列表
		List<User> users=userService.getAdmin();
		Integer uid=(Integer) session.getAttribute("userId");
		   // System.out.println(collectTopicNum);   
		    User user=userService.getUserById(uid);
		ModelAndView topicPage=new ModelAndView("admin/admin_user/list");
		topicPage.addObject("users",users);
		
		topicPage.addObject("user",user); 
		
		return topicPage;
		}
		
		@RequestMapping(value = "adminuser/delete")
		public ModelAndView delete(HttpSession session,@RequestParam(value = "id") Integer id) {
			ModelAndView mv;
	    	System.out.println(id);
	   	   //删除主题
	   	   boolean del =userService.deleteById(id);
	   	   if(del) {
	   		mv = new ModelAndView("admin/user/list");
	   	     //获取全部评论
		     List<User> users=userService.getUsersAll();
		     Integer uid=(Integer) session.getAttribute("userId");
			 User user=userService.getUserById(uid);
		     mv.addObject("users",users);
		     mv.addObject("user",user);              
			return mv;
	   	   }else {
	   		   mv = new ModelAndView("/admin/adminmain");
	   		   return mv;
	   	   } 
	   	   
	           }
		
		@RequestMapping(value = "adminuser/addadmin")
		public  ModelAndView addadmin(HttpSession session,HttpServletRequest request) {
			  //生成随机数，用于生成头像URL
	        Random rand=new Random();
	        int randomNum=rand.nextInt(10)+1;
	        String avatarUrl="/images/avatar/avatar-default-"+randomNum+"jpg";
			//用户类型
	        Byte type=new Byte("1");
	        Byte state=new Byte("1");
	        User user = new User();
	       user.setUsername(request.getParameter("username"));
	        user.setPassword(request.getParameter("password"));
	        user.setCreateTime(new Date());
	        user.setUpdateTime(new Date());
	        user.setAvatar(avatarUrl);
	        user.setType(type);
	        user.setState(state);
	        userService.addAdmin(user);
	      //获取管理员列表
			List<User> users=userService.getAdmin();
			Integer uid=(Integer) session.getAttribute("userId");
			 User user1=userService.getUserById(uid);
		    
	        ModelAndView mv=new ModelAndView("/admin/admin_user/list");
	        mv.addObject("users",users);
		     mv.addObject("user",user1); 
	   	     return mv;
	           }
		
		@RequestMapping(value = "/admin/user/search")
		public ModelAndView search(@RequestParam(value = "username", required = false) String username,@RequestParam(value = "email", required = false) String email,HttpSession session) {
			 if (StringUtils.isEmpty(username)) username = null;
			 if (StringUtils.isEmpty(email)) email = null;
			System.out.println(username+","+email);
			 ModelAndView mv=new ModelAndView("admin/user/list");
			 Integer uid=(Integer) session.getAttribute("userId");
			 User user=userService.getUserById(uid);
			List<User> users =  userService.selectAllForAdmin(username,email);  //匹配查找
			mv.addObject("users", users);
			 mv.addObject("user",user);
			return mv;
		}

		/**
		 * 后台用户编辑页面
		 * @param id: 评论ID
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "admin/user/edit")
		public ModelAndView edit(HttpSession session,@RequestParam(value = "id") Integer id) {
		
			 
			 Integer uid=(Integer) session.getAttribute("userId"); 
		     User user=userService.getUserById(uid);           //获取登录账户的user
			 ModelAndView mv=new ModelAndView("admin/user/edit");
		       User user1 = userService.selectById(id);            //编辑所选的user1
		        mv.addObject("user1", user1);
		        mv.addObject("user", user);
		        return mv;
		}
		@RequestMapping(value = "/admin/user/update")
		public ModelAndView update(HttpSession session,@RequestParam(value = "id") Integer id,
				@RequestParam(value = "credit") Integer credit,
				@RequestParam(value = "email") String email,
				@RequestPart("avatar") MultipartFile avatarFile) {
			    System.out.println(id+","+credit);
			    String fileName=avatarFile.getOriginalFilename();
		        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		        Long date=new Date().getTime();
		        String newFileName=date+"-"+id+"."+suffix;
		        String absolutePath=session.getServletContext().getRealPath("/static/default/images/avatar")+"/"+newFileName;
		        String relativePath="/images/avatar"+"/"+newFileName;
		        User newUser = new User();
		        newUser.setAvatar(relativePath);
		        newUser.setCredit(credit);
		        newUser.setEmail(email);
		        newUser.setId(id);
		        File file=new File(absolutePath);

		        if (!file.exists()){
		            try {
		                avatarFile.transferTo(file);
		                userService.updateUser(newUser);
		            }catch (Exception e){
		                e.printStackTrace();
		            }
		        }
			ModelAndView mv=new ModelAndView("admin/user/list");
			  //获取全部评论
		     List<User> users=userService.getUsersAll();
		     Integer uid=(Integer) session.getAttribute("userId");
		     User user=userService.getUserById(uid);  
		     mv.addObject("users", users);
		     mv.addObject("user",user); 
		     return mv;
		}


}
