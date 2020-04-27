package com.limingyi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.limingyi.dao.NoticeMapper;
import com.limingyi.entity.Notice;
import com.limingyi.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService{
	 @Autowired
	 private NoticeMapper noticeDao;
	
	 @Override
	public int isRead(Integer uid) {
		
		return noticeDao.isRead(uid);
	}

	public int updateIsRead(Integer uid) {

		return noticeDao.updateIsRead(uid);
	}

	@Override
	public int addNotice(Notice notice) {
		
		return noticeDao.insert(notice);
	}

}
