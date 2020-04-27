package com.limingyi.entity;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Reply {
	private User user;
	private Topic topic;

    private Integer moviesId;

	private Integer id;

    private Integer topicId;

    private Integer replyUserId;

    private Date createTime;

    private Date updateTime;

    private String device;

    private String content;
    
    
    //二级回复的
    private Integer secondreplyUserId;
   
	private Integer targetuserId;



	public Topic getTopic() {
 		return topic;
 	}

 	public void setTopic(Topic topic) {
 		this.topic = topic;
 	}

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device == null ? null : device.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
	public Integer getMoviesId() {
		return moviesId;
	}

	public void setMoviesId(Integer moviesId) {
		this.moviesId = moviesId;
	}
	

		public Integer getSecondreplyUserId() {
		return secondreplyUserId;
	}



		public void setSecondreplyUserId(Integer secondreplyUserId) {
			this.secondreplyUserId = secondreplyUserId;
		}

		public Integer getTargetuserId() {
			return targetuserId;
		}

		public void setTargetuserId(Integer targetuserId) {
			this.targetuserId = targetuserId;
		}

    public String getLocalCreateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
        String date = df.format(this.createTime);
        return date;
    }
    public String getLocalUpdateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");//设置日期格式
        String date = df.format(updateTime);
        return date;
    }
}