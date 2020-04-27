package com.limingyi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.CollectMapper;
import com.limingyi.entity.Collect;
import com.limingyi.service.CollectService;
@Service
public class CollectServiceImpl implements CollectService{
	 @Autowired
	 private CollectMapper collectDao;
	
	 public Collect isCollect(Integer uid, Integer tid) {
		
		return collectDao.isCollect(uid,tid);
	}


	public Integer delete(Integer uid,Integer tid) {

		return collectDao.delete(uid,tid);
	}


	@Override
	public Integer insert(Collect collect) {
	
		return collectDao.insert(collect);
	}


	@Override
	public int countByUid(Integer uid) {
	
		return collectDao.countByUid(uid);
	}

}
