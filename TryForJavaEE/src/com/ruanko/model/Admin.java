package com.ruanko.model;

public class Admin {
	private int id;
	private String username;
	private String password;
	private String nickname;
	private int del;
	

	public Admin() {
		this.id=0;
		this.username="";
		this.password="";
		this.nickname="";
		this.del=0;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getDel() {
		return del;
	}


	public void setDel(int del) {
		this.del = del;
	}

}
