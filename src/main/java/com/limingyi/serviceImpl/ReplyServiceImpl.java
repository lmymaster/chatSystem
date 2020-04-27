package com.limingyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.ReplyMapper;
import com.limingyi.entity.Reply;
import com.limingyi.entity.Topic;
import com.limingyi.service.ReplyService;

@Service
public class ReplyServiceImpl implements ReplyService {

	  @Autowired
	    public ReplyMapper replyDao;
	@Override
	public List<Reply> getRepliesOfTopic(Integer topicId) {
		// TODO Auto-generated method stub
        return replyDao.getRepliesOfTopic(topicId);
	}
	@Override
	public List<Reply> getRepliesAll(){
		// TODO Auto-generated method stub
        return replyDao.getRepliesAll();
	}

	@Override
	public boolean addReply(Reply reply) {
		// TODO Auto-generated method stub
        return replyDao.insert(reply)>0;
	}

	@Override
	public int repliesNum(Integer topicId) {
		// TODO Auto-generated method stub
		 return replyDao.getRepliesNum(topicId);
	}
	@Override
	public List<Reply> listTopicsByNotice(Integer uid) {

		return replyDao.listByNotice(uid);
	}

	@Override
	public int countToday() {
		// TODO Auto-generated method stub
		return replyDao.countToday();
	}
	public Reply selectById(Integer id) {
		// TODO Auto-generated method stub
		return replyDao.selectById(id);
	}
	public int updateById(Reply reply) {
		// TODO Auto-generated method stub
		return replyDao.updateByPrimaryKey(reply);
	}
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		return replyDao.deleteByPrimaryKey(id)>0;
	}
	public List<Reply> selectAllForAdmin(String username, String topic) {
		
		return replyDao.selectAllForAdmin(username, topic);
	}
	public boolean addReply1(Reply reply) {
		// TODO Auto-generated method stub
		return replyDao.insert1(reply);
	}
	//获取电影的评论
	public List<Reply> getRepliesOfMovies(Integer moviesId) {
		// TODO Auto-generated method stub
		return replyDao.getRepliesOfMovies(moviesId);
	}
	public boolean addReply2(Reply reply) {
		// TODO Auto-generated method stub
		return replyDao.insert2(reply)>0;
	}
	@Override
	//获取电影的二级评论
	public List<Reply> getRepliesOfMovieSecond(Integer moviesId) {
		// TODO Auto-generated method stub
		return replyDao.getRepliesOfMovieSecond(moviesId);
	}



}
