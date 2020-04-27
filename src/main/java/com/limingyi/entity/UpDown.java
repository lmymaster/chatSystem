package com.limingyi.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 点赞实体
 * TODO
 */
public class UpDown {

	/**
	 * 主键ID
	 */
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer uid;
	

	/**
	 * 话题ID
	 */
	private Integer tid;
	

	/**
	 * 创建时间
	 */
	private Date createDate;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLocalCreateTime() {
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
	        String date = df.format(this.createDate);
	        return date;
	    }
	@Override
	public String toString() {
		return "UpDown [id=" + id + ", uid=" + uid + ", tid=" + tid + ", createDate=" + createDate + "]";
	}



}
