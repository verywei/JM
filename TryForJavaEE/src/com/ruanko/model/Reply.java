package com.ruanko.model;

public class Reply {
	private int id;
	private int topicId;
	private int userId;
	private int del;
	private String content;
	private String createtime;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public Reply() {
		this.id=0;
		this.topicId=0;
		this.userId=0;
		this.createtime="";
		this.content="";
		this.del=0;
		
	}

}
