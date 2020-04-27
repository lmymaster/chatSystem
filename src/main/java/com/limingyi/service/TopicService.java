package com.limingyi.service;

import java.util.List;

import com.limingyi.entity.Topic;



public interface TopicService {

    /**
     * 获取全部主题
     */
    List<Topic> getAllTopics();
	/**
	 * 导航栏搜索
	 */
    List<Topic> search(String keyword,Integer start,Integer limit);
    /**
     * 获取全部主题及用户信息 用于渲染首页
     */
     List<Topic> listTopicsAndUsers();

    /**
     * 获取最多评论主题列表
     * @return
     */
    List<Topic> listMostCommentsTopics();

    /**
     * 获取全部主题及用户信息 用于渲染板块页面
     */
    List<Topic> listTopicsAndUsersOfTab(Integer tabId);

    /**
     * 获取指定ID主题
     */
    Topic selectById(Integer id);
    /**
     * 获取个人主题
     */
    List<Topic> getOwnList(Integer userId);
    /**
     * 新建主题
     */
    boolean addTopic(Topic topic);

    /**
     * 点击量加一
     */
    boolean clickAddOne(Integer id);

    /**
     * 获取主题总数
     */
    int getTopicsNum();
    int getTopicsNumByUser(Integer uid );
    /**
     * 不同的tab主题总数
     * @return
     */
  int  getTopicsNumOfTab(Integer tabId);
  //查找话题的总数
  int getTopicsNumByserch(String keyword);
    /**
     * 删除指定ID主题
     */
   boolean deleteById(Integer id);
   /**
    * 根据分页获取全部主题
    */
   List<Topic> listTopicsBypage(int start,int limit);
   /**
    * 根据tab分页获取全部主题
    */
  List<Topic> listTopicsBypageOfTab(Integer tabId,int start,int limit);
  /**
   * 更新数据
   */
  int updateByPrimaryKeySelective(Topic topic);
  /**
   * 收藏主题
   */
  List<Topic> listTopicsByCollect(Integer uid);
  /**
   * 统计当天话题数
   * @return
   */
  int countToday();


}
