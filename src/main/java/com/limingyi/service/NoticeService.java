package com.limingyi.service;

import com.limingyi.entity.Notice;

public interface NoticeService {
	/**
	 * 判断是否有未读通知
	 * @param uid
	 * @return
	 */
  int isRead(Integer uid);
  /**
   * 更新消息已读
   * @param uid
   * @return
   */
  int updateIsRead(Integer uid);
  /**
   * 添加通知
   * @param notice
   * @return
   */
  int addNotice(Notice notice);
  
}
