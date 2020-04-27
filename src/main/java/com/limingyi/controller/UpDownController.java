 package com.limingyi.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.limingyi.entity.Topic;
import com.limingyi.entity.UpDown;
import com.limingyi.service.TopicService;
import com.limingyi.service.UpDownService;

/**
 * 点赞或者点踩
 */
@Controller
public class UpDownController {

	 
	    @Autowired
	    private UpDownService  updownService;
	 
	    @Autowired
	    private TopicService topicService;
	  
	 
	    /**
	     * 处理用户点赞行为
	     * @param niceDetail
	     * @return
	     */
	    @RequestMapping("/dianzan")
	    @ResponseBody
	    public Object niceDetail(Topic topic1,UpDown niceDetail,HttpSession session ){
	        //获取用户信息和主题Tid
	        Integer tid=(Integer) session.getAttribute("tid");
	        Integer uid=(Integer) session.getAttribute("userId");
	      //  System.out.println(tid+","+uid);
	        HashMap<String, Object> res = new HashMap<String, Object>();
	        if(uid!=null) {
	        //查询是否有该用户的点赞记录
	        UpDown niceDetail1=updownService.findNiceDetail(uid,tid);
	        if (niceDetail1!=null){
	            System.out.println("有该记录");
	            //如果找到这条记录，删除该记录，同时文章的点赞数减一
	            //删除记录
	            updownService.deleteNiceDetail(niceDetail1.getId());
	            //根据点赞id找到主题
	            Topic topic=topicService.selectById(niceDetail1.getTid());
	            //文章点赞数减一
	            topic1.setNice(topic.getNice()-1);
	            topic1.setId(niceDetail1.getTid());
	            //更新文章点赞数
	            topicService.updateByPrimaryKeySelective(topic1);
	            System.out.println(topic1.getNice());
	            res.put("result",topic1.getNice()+"");
	         
	        }else{
	            //如果没有找到这条记录，则添加这条记录，同时文章数加一；
	            //添加记录
	            System.out.println("没有记录：");
	            niceDetail.setTid(tid);
	            niceDetail.setUid(uid);
	            niceDetail.setCreateDate(new Date());
	            updownService.insertNiceDetail(niceDetail);
	            Topic topic=topicService.selectById(niceDetail.getTid());
	          //  System.out.println("nice:"+topic.getNice());
	            //文章点赞数加一
	            topic1.setNice(topic.getNice()+1);
	            topic1.setId(niceDetail.getTid());
	            //更新文章点赞数
	               topicService.updateByPrimaryKeySelective(topic1);
	               int result = topic1.getNice();
	               res.put("result", topic1.getNice()+"");
	        }
	        return res;
	        }else {
	        	//用户未登录
	        	res.put("result","-1");
	        	return res;
	        }
	    }
	 
	 
	}


