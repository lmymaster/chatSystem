package com.limingyi.entity;

import java.text.SimpleDateFormat;
import java.util.Date;



//收藏实体
public class Collect {
	/**
	 * 收藏ID
	 */
	private Integer id;

	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 主题ID
	 */
	private Integer titleId;
	
	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	public Integer getCollectId() {
		return id;
	}

	public void setCollectId(Integer Id) {
		this.id = Id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTopicId() {
		return titleId;
	}

	public void setTopicId(Integer titleId) {
		this.titleId = titleId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	 public String getLocalCreateTime() {
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
	        String date = df.format(this.createDate);
	        return date;
	    }
	    public String getLocalUpdateTime() {
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
	        String date = df.format(createDate);
	        return date;
	    }

}
