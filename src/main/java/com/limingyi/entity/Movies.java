package com.limingyi.entity;

import java.util.Date;

public class Movies {
	private Integer id;

	private String moviename;
	private String area;
	private String director;
	private String actor;
	private String introduce;
	private Integer click;   //浏览量
	private String avatar;  //电影介绍图
	private String address;  //电影资源URL
	private Date createTime;
	private String upTime;
	private Integer countReplies;

	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Movies [id=" + id + ", moviename=" + moviename + ", area=" + area + ", director=" + director
				+ ", actor=" + actor + ", introduce=" + introduce + ", click=" + click + ", avatar=" + avatar
				+ ", address=" + address + ", createTime=" + createTime + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getClick() {
		return click;
	}
	public void setClick(int click) {
		this.click = click;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public Integer getCountReplies() {
		return countReplies;
	}
	public void setCountReplies(Integer countReplies) {
		this.countReplies = countReplies;
	}

}
