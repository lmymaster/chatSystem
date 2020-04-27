package com.limingyi.entity;

import java.util.Date;

public class Follow {
	/**
	 * 关注
	 */
	private Integer id;

	/**
	 * 关注者Id
	 */
	private Integer uid;
	private User user;

	private boolean isDelete;

	/**
	 * 被关注者Id
	 */
	private Integer fid;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	public boolean isIsDelete() {
		return isDelete;
	}

	public void setIsDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
