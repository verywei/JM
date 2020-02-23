package com.ruanko.model;

public class TopicVO {
	private int id;//帖子id
	private int userId;//用户id
	private String nickname;//用户昵称
	private int tagId;//标签id
	private String tagName;//标签名
	private String title;//标题
	private String createTime;//创建时间
	private String content;//帖子内容
	private String imgUrl;//用户头像
	private int replyCount;//帖子回复数量
	public TopicVO() {
		this.id=0;
		this.userId=0;
		this.nickname="";
		this.tagId=0;
		this.tagName="";
		this.title="";
		this.createTime="";
		this.content="";
		this.imgUrl="";
		this.replyCount=0;
	}
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getReplyCount() {
		return replyCount;
	}
	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}
	@Override
	public String toString() {
		return "TopicVO [id=" + id + ", userId=" + userId + ", nickname=" + nickname + ", tagId=" + tagId + ", tagName="
				+ tagName + ", title=" + title + ", createTime=" + createTime + ", content=" + content + ", imgUrl="
				+ imgUrl + ", replyCount=" + replyCount + "]";
	}

}
