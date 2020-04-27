package com.limingyi.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.limingyi.entity.Reply;
import com.limingyi.entity.Topic;
import com.limingyi.entity.User;
import com.limingyi.serviceImpl.ReplyServiceImpl;
import com.limingyi.serviceImpl.TopicServiceImpl;
import com.limingyi.serviceImpl.UserServiceImpl;





@Controller
@RequestMapping("/admin")
public class adminTopicController {

    @Autowired
    public ReplyServiceImpl replyService;
    @Autowired
    public UserServiceImpl userService;
    @Autowired
    public TopicServiceImpl topicService;
    
    /**
              * 获取全部评论
     * @param session
     * @return
     */
	@RequestMapping(value = "/comment/list",method = RequestMethod.GET)
    public ModelAndView toComment(HttpSession session){
	   //获取全部评论
        List<Reply> replies=replyService.getRepliesAll();
        Integer uid=(Integer) session.getAttribute("userId");
	       // System.out.println(collectTopicNum);   
	        User user=userService.getUserById(uid);
        ModelAndView topicPage=new ModelAndView("admin/comment/list");
        topicPage.addObject("replies",replies);

        topicPage.addObject("user",user); 
        
        return topicPage;
}
	   /**
		     * 获取全部话题
		* @param session
		* @return
		*/
		@RequestMapping(value = "/topic/list",method = RequestMethod.GET)
		public ModelAndView toTopic(HttpSession session){
		
		//获取全部评论
			 List<Topic> topics=topicService.listTopicsAndUsers();
		Integer uid=(Integer) session.getAttribute("userId");
		  // System.out.println(collectTopicNum);   
		   User user=userService.getUserById(uid);
		ModelAndView topicPage=new ModelAndView("admin/topic/list");
		topicPage.addObject("topics",topics);
		
		topicPage.addObject("user",user); 
		
		return topicPage;
		}
		
		/**
		 * 置顶主题
		 */
		@RequestMapping(value = "/topic/top",method = RequestMethod.GET)
		public ModelAndView top(HttpSession session,@RequestParam(value = "id") Integer id){
			Topic topic = topicService.selectById(id);
			topic.setUpdateTime(new Date());
			topic.setTop(!topic.getTop());
			topicService.updateTopic(topic);
			Integer uid=(Integer) session.getAttribute("userId");
			  // System.out.println(collectTopicNum);   
			   User user=userService.getUserById(uid);
			ModelAndView topicPage=new ModelAndView("admin/topic/list");
			//获取全部评论
			 List<Topic> topics=topicService.listTopicsAndUsers();
			topicPage.addObject("user",user); 
			topicPage.addObject("topics",topics); 
			return topicPage;
			}
		/**
		 * 取精和嘉奖
		 * @param session
		 * @param id
		 * @return
		 */
		@RequestMapping(value = "/topic/good",method = RequestMethod.GET)
		public ModelAndView good(HttpSession session,@RequestParam(value = "id") Integer id){
			Topic topic = topicService.selectById(id);
			topic.setUpdateTime(new Date());
			topic.setGood(!topic.getGood());
			topicService.updateTopic(topic);
			Integer uid=(Integer) session.getAttribute("userId");
			  // System.out.println(collectTopicNum);   
			   User user=userService.getUserById(uid);
			ModelAndView topicPage=new ModelAndView("admin/topic/list");
			//获取全部评论
			 List<Topic> topics=topicService.listTopicsAndUsers();
			topicPage.addObject("user",user); 
			topicPage.addObject("topics",topics); 
			return topicPage;
			}
		@RequestMapping(value = "/topic/delete")
		public ModelAndView deleteTopic(HttpSession session,@RequestParam(value = "id") Integer id) {
			ModelAndView mv;
	   	   //删除主题
	   	   boolean del =topicService.deleteById(id);
	   	   if(del) {
	   		mv = new ModelAndView("admin/topic/list");
	   		//获取全部主题
			 List<Topic> topics=topicService.listTopicsAndUsers();
		     Integer uid=(Integer) session.getAttribute("userId");
			 User user=userService.getUserById(uid);
		     mv.addObject("topics",topics);
		     mv.addObject("user",user);              
			return mv;
	   	   }else {
	   		   mv = new ModelAndView("/admin/adminmain");
	   		   return mv;
	   	   } 
	   	   
	           }
		@RequestMapping(value = "/topic/edit",method = RequestMethod.GET)
		public ModelAndView edittopic(HttpSession session,@RequestParam(value = "id") Integer id) {
			 Integer uid=(Integer) session.getAttribute("userId"); 
		     User user=userService.getUserById(uid);
			 ModelAndView mv=new ModelAndView("admin/topic/edit");
		       Topic topic = topicService.selectById(id);
		        mv.addObject("content", topic.getContent());
		        mv.addObject("title", topic.getTitle());
		        mv.addObject("id", topic.getId());
		        mv.addObject("user", user);
		        return mv;
		}
		@RequestMapping(value = "/topic/update")
		public ModelAndView updatetopic(HttpSession session,@RequestParam(value = "id") Integer id,@RequestParam(value = "content") String content,@RequestParam(value = "title") String title) {
			 ModelAndView mv=new ModelAndView("admin/topic/list");
			 System.out.println(content);
			 System.out.println(title);
			 Topic topic = new Topic();
			 topic.setContent(content);
			 topic.setTitle(title);
			 topic.setId(id);
		     topicService.updateTopic1(topic);
		   //获取全部主题
			 List<Topic> topics=topicService.listTopicsAndUsers();
		     Integer uid=(Integer) session.getAttribute("userId");
			 User user=userService.getUserById(uid);
		     mv.addObject("topics",topics);
		     mv.addObject("user",user); 
		     return mv;
		}
	/**
	 * 后台评论编辑页面
	 * @param id: 评论ID
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/comment/edit",method = RequestMethod.GET)
	public ModelAndView edit(HttpSession session,@RequestParam(value = "id") Integer id) {
		 Integer uid=(Integer) session.getAttribute("userId"); 
	     User user=userService.getUserById(uid);
		 ModelAndView mv=new ModelAndView("admin/comment/edit");
	       Reply reply = replyService.selectById(id);
	        mv.addObject("content", reply.getContent());
	        mv.addObject("id", reply.getId());
	        mv.addObject("user", user);
	        return mv;
	}
	@RequestMapping(value = "/comment/update")
	public ModelAndView update(HttpSession session,@RequestParam(value = "id") Integer id,@RequestParam(value = "content") String content) {
		 ModelAndView mv=new ModelAndView("admin/comment/list");
		 System.out.println(content);
		 Reply reply = new Reply();
		 reply.setContent(content);
		 reply.setId(id);
	     replyService.updateById(reply);
	      //获取全部评论
	     List<Reply> replies=replyService.getRepliesAll();
	     Integer uid=(Integer) session.getAttribute("userId");
		 User user=userService.getUserById(uid);
	     mv.addObject("replies",replies);
	     mv.addObject("user",user); 
	     return mv;
	}
	@RequestMapping(value = "/comment/delete")
	public ModelAndView delete(HttpSession session,@RequestParam(value = "id") Integer id) {
		ModelAndView mv;
    	System.out.println(id);
   	   //删除主题
   	   boolean del =replyService.deleteById(id);
   	   if(del) {
   		mv = new ModelAndView("admin/comment/list");
   	     //获取全部评论
	     List<Reply> replies=replyService.getRepliesAll();
	     Integer uid=(Integer) session.getAttribute("userId");
		 User user=userService.getUserById(uid);
	     mv.addObject("replies",replies);
	     mv.addObject("user",user);              
		return mv;
   	   }else {
   		   mv = new ModelAndView("/admin/adminmain");
   		   return mv;
   	   } 
   	   
           }
	
	@RequestMapping(value = "/comment/search")
	public ModelAndView search(@RequestParam(value = "username", required = false) String username,@RequestParam(value = "topic", required = false) String topic,HttpSession session) {
		 if (StringUtils.isEmpty(username)) username = null;
		 if (StringUtils.isEmpty(topic)) topic = null;
		System.out.println(username+","+topic);
		 ModelAndView mv=new ModelAndView("admin/comment/list");
		 Integer uid=(Integer) session.getAttribute("userId");
		 User user=userService.getUserById(uid);
		List<Reply> replies =  replyService.selectAllForAdmin(username,topic);
		mv.addObject("replies", replies);
		 mv.addObject("user",user);
		return mv;
	}
	
	}
	

