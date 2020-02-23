package com.ruanko.model;

public class Collection {
	private int id;
	private int userId;
	private int topicId;
	private int del;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getDel() {
		return del;
	}
	public void setDel(int del) {
		this.del = del;
	}
	public Collection() {
		this.id=0;
		this.userId=0;
		this.topicId=0;
		this.del=0;
	}

}
