package com.limingyi.service;

import com.limingyi.entity.Follow;

public interface FollowService {
	Follow isFollow(Integer uid,Integer fid);
	Integer delete(Integer uid,Integer fid);
	Integer insert(Follow follow);
	int countByUid(Integer uid);
}
