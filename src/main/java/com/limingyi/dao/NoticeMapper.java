package com.limingyi.dao;

import com.limingyi.entity.Notice;

public interface NoticeMapper {
	int isRead(Integer uid);
	int updateIsRead(Integer uid);
	/**
	 * 添加通知
	 * @param notice
	 * @return
	 */
	int insert(Notice notice);

}
