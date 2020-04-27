package com.limingyi.test;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.limingyi.entity.Topic;
import com.limingyi.service.TopicService;
import com.limingyi.service.UserService;



public class UserDaoTest extends BaseTest {
	

@Autowired
	private UserService userService;
@Autowired
private TopicService topicService;

	@Test
	public void Test(){
	/*	String name="limingyi";
		User user = userService.getUserByUsername(name);
		System.out.println(user.getEmail());
		 List<Topic> topics=topicService.listTopicsAndUsers();

	        //获取统计信息
	        int topicsNum=topicService.getTopicsNum();
	        int usersNum=userService.getUserCount();
	        System.out.println(topicsNum+","+usersNum);
	        for(int  i=0;  i<topics.size();  i++)  {  
	        	   Topic  a  =  topics.get(i);  
	        System.out.println(a);
	        	 }*/
		 List<Topic> topics=topicService.search("地方",0,10);
		  for(int  i=0;  i<topics.size();  i++)  {  
       	   Topic  a  =  topics.get(i);  
            System.out.println(a);
	     }
/*
	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}*/
	}
}
