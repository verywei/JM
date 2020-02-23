package com.ruanko.model;

public class Tag {
	private int id;
	private String name;
	private String description;
	private int del;

	public Tag() {
		this.id=0;
		this.name="";
		this.description="";
		this.del=0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

}
