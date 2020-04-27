package com.limingyi.dao;

import com.limingyi.entity.Reply;
import com.limingyi.entity.Topic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);
    
    boolean insert1(Reply reply);   //电影评论添加
    
    int insertSelective(Reply record);

    Reply selectById(Integer id);

    List<Reply> getRepliesOfTopic(Integer topicId);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);

    int getRepliesNum(Integer topicId);
    //获取评论者的主题和评论
    List<Reply> listByNotice(@Param("uid") Integer uid);
    //统计当天评论数

	int countToday();

	List<Reply> getRepliesAll();
	// 后台评论列表
		List<Reply> selectAllForAdmin(@Param("username") String username, @Param("topic") String topic);

		List<Reply> getRepliesOfMovies(Integer moviesId);

		int insert2(Reply reply);
		
		//二级回复评论列表
	List<Reply>	getRepliesOfMovieSecond( @Param("moviesId") Integer moviesId);

		
       
}