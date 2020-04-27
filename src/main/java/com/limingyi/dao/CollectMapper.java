package com.limingyi.dao;

import org.apache.ibatis.annotations.Param;

import com.limingyi.entity.Collect;

public interface CollectMapper {
	
	Collect isCollect(@Param("uid") Integer uid,@Param("tid") Integer tid);
	
	int delete(@Param("uid") Integer uid,@Param("tid") Integer tid );
	/**
	 * 添加收藏
	 * @param uid
	 * @param tid
	 * @return
	 */
	int insert(Collect collect);
	/**
	 * 用户收藏话题的数量
	 * 
	 */
	int countByUid(Integer uid);
}
