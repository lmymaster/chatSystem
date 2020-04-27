package com.limingyi.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
import com.limingyi.serviceImpl.LoginLogServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;
import com.limingyi.util.CodeUtil;
import com.limingyi.util.SendEmailUtil;









@Controller
public class UserController {
	@Autowired
	public UserServiceImpl userService;
	@Autowired
    public LoginLogServiceImpl loginLogService;
	@Autowired
	public TopicServiceImpl topicService;
	@Autowired
	public MoviesService moviesService;
	@Autowired
	public LunboService lunboService;
	@Autowired
	public FollowServiceImpl followService;
	

    /**
     * 用户注册
     */
     @RequestMapping("/register")
     @ResponseBody
     public Object addUser(HttpServletRequest request,HttpSession session){
    	 //获取邮箱验证码
    	String code=(String) session.getAttribute("code");
    	String emailvarify = request.getParameter("emailvarify");
    	System.out.println(code+","+emailvarify);
    	
      System.out.println(emailvarify.equals(code));
        HashMap<String, String> res = new HashMap<String, String>();
        if(code!=null) {
    	if(emailvarify.contentEquals(code)) {
        //新建User对象
        User user=new User();
        //处理手机号
        String phoneNum=request.getParameter("tel");
        String areaCode=request.getParameter("areaCode");
        String phone=areaCode+phoneNum;
        //用户类型
        Byte type=new Byte("0");
        //邮箱验证类型   0未验证   1：已验证
        Byte state=new Byte("1");
        //密码加密处理
      //String password= ProduceMD5.getMD5(request.getParameter("password"));
        String password = request.getParameter("password");
        //生成随机数，用于生成头像URL
        Random rand=new Random();
        int randomNum=rand.nextInt(10)+1;
        String avatarUrl="/images/avatar/avatar-default-"+randomNum+".jpg";
        //初始化User对象,封装数据
        user.setUsername(request.getParameter("username"));
        user.setPassword(password);
        user.setEmail(request.getParameter("email"));
        user.setPhoneNum(phone);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setCredit(0);
        user.setState(state);
        user.setType(type);
        user.setAvatar(avatarUrl);
        boolean ifSucc=userService.addUser(user);
        User user1 =userService.getUserByUsername(request.getParameter("username"));
        Integer userId=user1.getId();
        session.setAttribute("userId",userId);
        //发送邮件验证
       // userService.sendEmail(request.getParameter("email"));  //邮箱链接验证
        
         res.put("result", "0");      //验证成功
    	}else {
    	res.put("result", "1");   //验证失败
    	}
        }else {
        res.put("result", "2");    //未进行验证。
        }
        return res;
    }
     /**
      * 更新邮箱验证状态(链接验证)
      * @param mv
      * @param request
      * @return
      */ 
 
     @RequestMapping("emailverify")
 	public ModelAndView regconf(ModelAndView mv, HttpServletRequest request,HttpSession session) {
 		String emailcode = request.getParameter("code");
 	    Integer uid=(Integer) session.getAttribute("userId");
 	    Byte state = new Byte("1");
 		User user = new User();
 		user.setState(state);
 		user.setEmailcode("renhe");
 		user.setId(uid);
 		System.out.println(emailcode+","+uid);
 		userService.updateUser(user);    //更新邮箱激活状态
 		mv.setViewName("/user/signin");
 		return mv;
 	}
     /**
      * 更新邮箱验证状态(邮箱验证码验证)
      * @return
      */ 
     @RequestMapping("verify")
     @ResponseBody
     public Object regconf1( @RequestParam("email") String toemail,HttpSession session) {
    	 //发送邮件验证的方法
    	SendEmailUtil sendEmailUtil = new SendEmailUtil();
 		String code = null;
 		System.out.println(toemail);
 		CodeUtil codeUtil = new CodeUtil();
 		code = codeUtil.generateUniqueCode(6);
 		session.setAttribute("code", code);
 		System.out.println(code);
 	   
 		try {
 			sendEmailUtil.send_email(toemail,code);
 		}catch(IOException e) {
 			e.printStackTrace();
 		}catch(MessagingException e) {
 			e.printStackTrace();
 		}
 		
         HashMap<String, String> res = new HashMap<String, String>();
         res.put("result", "0");
         return res ;
  	}

	  /**
     * 用户登陆
     * @param request
     * @param session
     * @return 0:用户名不存在 1:密码错误 2:登录成功3:有邮箱未验证
     */
	@RequestMapping("logincheck")  
	@ResponseBody                                                   //此注解就是将java对象转为json格式的数据
	public Object signin(@RequestParam("username") String username,
			             @RequestParam("password") String password,
			             HttpServletRequest request,HttpSession session) {
		        //验证用户名密码
		        int loginVerify=userService.login(username,password);
		        
		        System.out.println(username+","+password);          //验证是否传值
		        HashMap<String, String> res = new HashMap<String, String>();

		        //登录成功
		        if(loginVerify == 2){
		        
		                User user =userService.getUserByUsername(username);
			            Integer userId=user.getId();
			            
			            //添加积分
			            boolean ifSuccAddCredit=userService.addCredit(1,userId);
			            //用户信息写入session
			            session.setAttribute("userId",userId);
			            session.setAttribute("username",username);
			            res.put("stateCode", "2");
		            
		        }
		        //邮箱是否验证
		        else if(loginVerify == 3) {
		        	res.put("stateCode","3");
		        }
		        //管理员登录
		        else if(loginVerify ==4) {
		        	User user =userService.getUserByUsername(username);
		            Integer userId=user.getId();
		            //用户信息写入session
		            session.setAttribute("userId",userId);
		            session.setAttribute("username",username);
		        	res.put("stateCode","4");
		        }
		        //密码错误
		        else if (loginVerify == 1){
		            res.put("stateCode", "1");
		        }
		     //户名不存在
		        else {
		            res.put("stateCode", "0");
		        }
		        return res;
		    }

	
    /**
     * 用户登出
     */
    @RequestMapping("/signout")
    public String signout(HttpSession session){
        session.removeAttribute("userId");
        session.removeAttribute("username");
        return "redirect:/tomain";
    }
    
    /**
     * 获取客户端IP
     */
    public String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }
    @RequestMapping("/settings")
    public ModelAndView settings(HttpServletRequest request, HttpSession session){

        Integer uid=(Integer) session.getAttribute("userId");
        User user=userService.getUserById(uid);
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        ModelAndView mv=new ModelAndView("user/settings");
        List<Follow> follows = followService.listOfFollow(uid);
        mv.addObject("follows",follows);
        mv.addObject("user",user);
        mv.addObject("topicsNumofuser",topicsNumofuser);
        mv.addObject("hotestTopics",hotestTopics);
        mv.addObject("hotestMovies",hotestMovies);
        return mv;
    }
/**
 * 跳转到修改密码界面
 */
    @RequestMapping("/updatePsswd")
    public ModelAndView updatepsswd(HttpServletRequest request, HttpSession session){

        Integer uid=(Integer) session.getAttribute("userId");
        Integer collectTopicNum = (Integer)session.getAttribute("collectTopicNum");
        //登录账户话题的数目
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        User user=userService.getUserById(uid);

        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        ModelAndView mv=new ModelAndView("user/updatePsswd");
        List<Follow> follows = followService.listOfFollow(uid);
        mv.addObject("follows",follows);
        mv.addObject("user",user);
        mv.addObject("topicsNumofuser",topicsNumofuser);
        mv.addObject("collectTopicNum",collectTopicNum);
        mv.addObject("hotestTopics",hotestTopics);
        mv.addObject("hotestMovies",hotestMovies);
        return mv;
    }

    /**
     * 用户个人主页
     */
    @RequestMapping("/member/{username}")
    public ModelAndView personalCenter(@PathVariable("username")String username,HttpSession session){
        boolean ifExistUser=userService.existUsername(username);
        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();

        //获取用户信息
        Integer uid=(Integer) session.getAttribute("userId");
        User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        ModelAndView mv=new ModelAndView("./user/user_info");
        List<Follow> follows = followService.listOfFollow(uid);
        mv.addObject("follows",follows);
        mv.addObject("hotestTopics",hotestTopics);
        mv.addObject("hotestMovies",hotestMovies);
        if (ifExistUser){
            User resultUser=userService.getUserByUsername(username);
            session.setAttribute("fid", resultUser.getId());   //获取是否被关注的用户id, 到FollowController
            mv.addObject("userInfo",resultUser);
            mv.addObject("topicsNum",topicsNum);
            mv.addObject("usersNum",usersNum);
            mv.addObject("user",user);
            return mv;
        }else {
            String errorInfo=new String("会员未找到");
            mv.addObject("errorInfo",errorInfo);
            return mv;
        }
    }
    
    /*
     * 更改头像
     */
    @RequestMapping(value = "/settings/avatar",method = RequestMethod.GET)
    public ModelAndView updateAvatar(HttpServletRequest request, HttpSession session){

        Integer uid=(Integer) session.getAttribute("userId");
        User user=userService.getUserById(uid);

        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //登录账户话题的数目
        int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
      //特别关注的用户
        List<Follow> follows = followService.listOfFollow(uid);
 
        ModelAndView mv=new ModelAndView("user/update_avatar");
        mv.addObject("follows",follows);
        mv.addObject("user",user);
        mv.addObject("hotestTopics",hotestTopics);
        mv.addObject("topicsNumofuser",topicsNumofuser);
        mv.addObject("hotestMovies",hotestMovies);
        return mv;
    }
    /*
     * 上传头像
     */
    @RequestMapping(value = "/settings/avatar/update",method = RequestMethod.POST)
    @ResponseBody
    public Object updateAvatarDo(@RequestPart("avatar") MultipartFile avatarFile, HttpServletRequest request, HttpSession session){
        Integer uid=(Integer) session.getAttribute("userId");

        String fileName=avatarFile.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
        Long date=new Date().getTime();
        String newFileName=date+"-"+uid+"."+suffix;
        String absolutePath=session.getServletContext().getRealPath("/static/default/images/avatar")+"/"+newFileName;
        String relativePath="/images/avatar"+"/"+newFileName;
        User newUser=new User();
        newUser.setAvatar(relativePath);
        newUser.setId(uid);
        File file=new File(absolutePath);

        if (!file.exists()){
            try {
                avatarFile.transferTo(file);
                userService.updateUser(newUser);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
       /* User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        ModelAndView mv=new ModelAndView("user/update_avatar");
        mv.addObject("user",user);
        mv.addObject("hotestMovies",hotestMovies);
        mv.addObject("hotestTopics",hotestTopics);*/
        HashMap<String, String> res = new HashMap<String, String>();
        res.put("result", "0");
        return res;
    }
    /*
     * 搜索
     */
    @RequestMapping("/search")
    public ModelAndView search(@RequestParam("keyword") String keyword,HttpSession session){
    	 ModelAndView mv=new ModelAndView("common/main");
    	// Integer currentPage = (Integer) session.getAttribute("currentpage");
    	 Integer collectTopicNum = (Integer)session.getAttribute("collectTopicNum");
        
    	 //获取寻找的主题信息
    	//List<Topic> topics = topicService.search(keyword);
    	 System.out.println(keyword);                    //验证keyword值是否传值成功
    	 int currentPage=1;
    	 System.out.println(currentPage);
    	 //获取统计信息
         int topicsNum=topicService.getTopicsNum();
         int usersNum=userService.getUserCount();
         int topicsNumBySearch = topicService.getTopicsNumByserch(keyword);
         System.out.println(topicsNumBySearch);
         int pageSize =10;
         //根据页面全部主题
         List<Topic> topicBypage=topicService.search(keyword,(currentPage-1)*pageSize, pageSize);
         System.out.println(topicBypage);
         Page topics = new Page(topicBypage,currentPage,pageSize,topicsNumBySearch);
         //获取用户信息
         Integer uid=(Integer) session.getAttribute("userId");
         //登录账户话题的数目
         int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
         User user=userService.getUserById(uid);
       //最热主题
         List<Topic> hotestTopics=topicService.listMostCommentsTopics();
         //最热影片
         List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
         //获取全部轮播
     	List<Lunbo> lunbolist = lunboService.getAllLunbo();
     	List<Follow> follows = followService.listOfFollow(uid);
        mv.addObject("follows",follows);
     	 mv.addObject("lunbolist", lunbolist);
    	 mv.addObject("topics",topics);
         mv.addObject("hotestTopics",hotestTopics);
         mv.addObject("collectTopicNum",collectTopicNum);
         mv.addObject("topicsNumofuser",topicsNumofuser);
         mv.addObject("topicsNum",topicsNum);
         mv.addObject("hotestMovies",hotestMovies);
         mv.addObject("usersNum",usersNum);
         mv.addObject("user",user);             
		return mv;
    	}
    
    /**
     * 用户信息修改
     */
    @RequestMapping("/update")
    public ModelAndView Updateuser(@RequestParam("phonenum") String phonenum,@RequestParam("username") String username,@RequestParam("email") String email,HttpSession session){
    	Integer uid=(Integer) session.getAttribute("userId");
    	 Integer collectTopicNum = (Integer)session.getAttribute("collectTopicNum");
    	   //登录账户话题的数目
         int  topicsNumofuser = topicService.getTopicsNumByUser(uid);
        
    	//封装数据
   	 User updateUser=new User();
        updateUser.setUsername(username);
        updateUser.setEmail(email);
        updateUser.setPhoneNum(phonenum);
        updateUser.setId(uid);
        boolean ifSuc = userService.updateUser(updateUser);
        if(ifSuc) {
        ModelAndView indexPage=new ModelAndView("common/main");
        //全部主题
        List<Topic> topics=topicService.listTopicsAndUsers();

        //获取统计信息
        int topicsNum=topicService.getTopicsNum();
        int usersNum=userService.getUserCount();
        //获取用户信息
        User user=userService.getUserById(uid);
        //最热主题
        List<Topic> hotestTopics=topicService.listMostCommentsTopics();
        //最热影片
        List<Movies> hotestMovies = moviesService.listMostCommentsMovies();
        //获取分页全部主题
        Page topic = (Page)session.getAttribute("topics");
        //获取全部轮播
      	List<Lunbo> lunbolist = lunboService.getAllLunbo();
      	List<Follow> follows = followService.listOfFollow(uid);
        indexPage.addObject("follows",follows);
      	 indexPage.addObject("lunbolist", lunbolist);
        indexPage.addObject("topics",topic);
        indexPage.addObject("hotestTopics",hotestTopics);
        
        indexPage.addObject("hotestMovies",hotestMovies);
        indexPage.addObject("collectTopicNum",collectTopicNum);
        indexPage.addObject("topicsNumofuser",topicsNumofuser);
        indexPage.addObject("topicsNum",topicsNum);
        indexPage.addObject("usersNum",usersNum);
        indexPage.addObject("user",user);                   
        return  indexPage;
        }else {
        	 ModelAndView indexPage=new ModelAndView("/");
        	 return indexPage;
        }
    	}
 
    /**
     *密码修改
     */
    @RequestMapping("/update1")
	@ResponseBody
    public Object Updateuser(@RequestParam("password") String password,HttpSession session){
    	Integer uid=(Integer) session.getAttribute("userId");

    	System.out.println(password);
    	 HashMap<String, String> res = new HashMap<String, String>();
     	//封装数据
   	    User updateUser=new User();
   		updateUser.setPassword(password);
        updateUser.setId(uid);
        userService.updateUser(updateUser);
        res.put("result", "0");
       return res;
    	}
	 
}
	