package com.ruanko.model;

public class ReplyVO {
	private int id;//帖子id
	private String content;//回帖内容
	private String nickName;//回帖人昵称
	private String createTime;//回帖时间
	private String imgUrl;//回帖人图像路径
	
	public ReplyVO() {
		this.id=0;
		this.content="";
		this.nickName="";
		this.createTime="";
		this.imgUrl="";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "ReplyVO [id=" + id + ", content=" + content + ", nickName=" + nickName + ", createTime=" + createTime
				+ ", imgUrl=" + imgUrl + "]";
	}
	

}
