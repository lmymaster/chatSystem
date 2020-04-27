package com.limingyi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.limingyi.entity.Follow;

public interface FollowMapper {

	Follow isFollow(@Param("uid") Integer uid,@Param("fid") Integer fid);
	
	int delete(@Param("uid") Integer uid,@Param("fid") Integer fid );
	/**
	 * 添加关注
	 * @param uid
	 * @param tid
	 * @return
	 */
	int insert(Follow follow);
	/**
	 * 用户关注用户的数量
	 * 
	 */
	int countByUid(Integer uid);

	List<Follow> listOfFollow(Integer uid);

}
