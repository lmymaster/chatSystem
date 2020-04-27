package com.limingyi.entity;

import java.util.Date;

/**
 * 通知实体类
 * @author 李明义
 *
 */
public class Notice {
	private int id;     
	private int noticeuserId;     //发送通知的用户Id
	private int isRead;     //默认0未读  ，1 已读
	private int topicId;
	private Date createDate;
	private int targetuserId;
	public int getTargetuserId() {
		return targetuserId;
	}

	public void setTargetuserId(int targetuserId) {
		this.targetuserId = targetuserId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getNoticeuserId() {
		return noticeuserId;
	}
	public void setNoticeuserId(int noticeuserId) {
		this.noticeuserId = noticeuserId;
	}
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
