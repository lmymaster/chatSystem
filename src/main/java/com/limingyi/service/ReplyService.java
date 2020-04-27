package com.limingyi.service;

import java.util.List;

import com.limingyi.entity.Reply;
import com.limingyi.entity.Topic;


public interface ReplyService {

    List<Reply> getRepliesOfTopic(Integer topicId);

    boolean addReply(Reply reply);
    boolean addReply1(Reply reply);

    int repliesNum(Integer topicId);
    /**
     * 评论者的通知
     * @param uid
     * @return
     */
    List<Reply> listTopicsByNotice(Integer uid);
    //统计当天的评论数
    int countToday();
    //获取全部评论
    List<Reply> getRepliesAll();
    /**
     * 根据Id查找评论
     * @param id
     * @return
     */
    Reply selectById(Integer id);
    int updateById(Reply reply);

	List<Reply> getRepliesOfMovies(Integer id);
	List<Reply> getRepliesOfMovieSecond(Integer moviesId);
}
