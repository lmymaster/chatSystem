package com.limingyi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.FollowMapper;
import com.limingyi.entity.Follow;
@Service
public class FollowServiceImpl {
@Autowired
	public FollowMapper followDao;
	public Follow isFollow(Integer uid, Integer fid) {
		// TODO Auto-generated method stub
		return followDao.isFollow(uid,fid);
	}
	public Integer delete(Integer uid,Integer fid) {

		return followDao.delete(uid,fid);
	}
	public Integer insert(Follow follow) {
		// TODO Auto-generated method stub
		return followDao.insert(follow);
	}
	public int countByUid(Integer uid) {
		// TODO Auto-generated method stub
		return followDao.countByUid(uid);
	}
	public List<Follow> listOfFollow(Integer uid) {
		// TODO Auto-generated method stub
		return followDao.listOfFollow(uid);
	}
	

}
