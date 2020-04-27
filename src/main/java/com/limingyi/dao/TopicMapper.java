package com.limingyi.dao;

import com.limingyi.entity.Topic;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TopicMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectById(Integer id);

    List<Topic> listTopicsAndUsers();

    List<Topic> listTopicsAndUsersOfTab(Integer tabId);

    List<Topic>  listMostCommentsTopics();

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> getAllTopics();

    int clickAddOne(Integer id);

    //获取主题总数
    int getTopicsNum();
    //获取我的主题的数量
   int getTopicsNumByUser(Integer uid);
    //根据不同的tab主题总数
    int getTopicsNumOfTab(Integer tabId);
    //查找话题的总数
   int getTopicsNumByserch(@Param("keyword")String keyword);
    //查找
    List<Topic> listBySearch(@Param("keyword")String keyword,@Param("start") Integer start, @Param("limit") Integer limit);
    //获取我的主题
    List<Topic> listByOwn(Integer userId);
    //分页获取主题
    List<Topic> listBypage( @Param("start") Integer start, @Param("limit") Integer limit);
    List<Topic> selectAllGood( @Param("start") Integer start, @Param("limit") Integer limit);
    List<Topic> listBypageOfTab(@Param("tabId")  Integer tabId,@Param("start") Integer start, @Param("limit") Integer limit);
   //收藏主题
    List<Topic> listByCollect(@Param("uid") Integer uid);
    //统计当天话题
    int  countToday();

	int getTopicsNumByGood();


}