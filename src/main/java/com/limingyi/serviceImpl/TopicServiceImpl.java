package com.limingyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.TopicMapper;
import com.limingyi.entity.Topic;
import com.limingyi.service.TopicService;

@Service
public class TopicServiceImpl implements TopicService {

	 @Autowired
	    public TopicMapper topicDao;

	    //获取全部主题
	    public List<Topic> getAllTopics() {
	        return topicDao.getAllTopics();
	    }

	    //获取指定id主题
	    public Topic selectById(Integer id) {
	        Topic topic=topicDao.selectById(id);
	        return topic;
	    }

	    public List<Topic> listMostCommentsTopics() {
	        return topicDao.listMostCommentsTopics();
	    }

	    public boolean addTopic(Topic topic) {
	        return topicDao.insert(topic)>0;
	    }

	    public boolean clickAddOne(Integer id) {
	        return topicDao.clickAddOne(id)>0;
	    }

	    public int getTopicsNum() {
	        return topicDao.getTopicsNum();
	    } 
			public int getTopicsNumByUser(Integer uid) {
				// TODO Auto-generated method stub
				return topicDao.getTopicsNumByUser(uid);
			}
			public int getTopicsNumByserch(String keyword) {
				return topicDao.getTopicsNumByserch(keyword);
			}
	   
	   public int  getTopicsNumOfTab(Integer tabId) {
		   return topicDao.getTopicsNumOfTab(tabId);
	   }

	    public List<Topic> listTopicsAndUsers() {
	        return topicDao.listTopicsAndUsers();
	    }

	    public List<Topic> listTopicsAndUsersOfTab(Integer tabId) {
	        return topicDao.listTopicsAndUsersOfTab(tabId);
	    }

	
		public List<Topic> search(String keyword,Integer start,Integer limit) {
			return topicDao.listBySearch(keyword,start,limit);
		}

		public List<Topic> getOwnList(Integer userId) {
			return topicDao.listByOwn(userId);
		}

		public boolean deleteById(Integer id) {
			return topicDao.deleteByPrimaryKey(id)>0;
		}

		
		public List<Topic> listTopicsBypage(int start,int limit) {
		
			return topicDao.listBypage(start,limit);
		}

	
		public List<Topic> listTopicsBypageOfTab(Integer tabId,int start, int limit) {
			
			return topicDao.listBypageOfTab(tabId,start,limit);
		}

		@Override
		public int updateByPrimaryKeySelective(Topic topic) {
	
			return topicDao.updateByPrimaryKeySelective(topic);
		}

		@Override
		public List<Topic> listTopicsByCollect(Integer uid) {
	
			return topicDao.listByCollect(uid);
		}

		@Override
		public int countToday() {
			// TODO Auto-generated method stub
			return topicDao.countToday();
		}

		public boolean updateTopic(Topic topic) {
			// TODO Auto-generated method stub
			return topicDao.updateByPrimaryKey(topic)>0;
		}

		public boolean updateTopic1(Topic topic) {
			// TODO Auto-generated method stub
			return topicDao.updateByPrimaryKeySelective(topic)>0;
		}

		public List<Topic> selectAllGood(int start, int limit) {
			// TODO Auto-generated method stub
			return topicDao.selectAllGood(start, limit);
		}

		public int getTopicsNumByGoo() {
			// TODO Auto-generated method stub
			return topicDao.getTopicsNumByGood();
		}

		

	

		

	
}
