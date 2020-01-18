package com.phani.learnSpring.firstSpring.todoModel;

import java.util.Date;

public class Todo {
	private int id;
	private String user;
	private String desc;
	private Date date;
	private boolean isDone;
	
	public Todo(int id, String user, String desc, Date date, boolean isDone) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.date = date;
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", desc=" + desc + ", date=" + date + ", isDone=" + isDone
				+ ", getId()=" + getId() + ", getUser()=" + getUser() + ", getDesc()=" + getDesc() + ", getDate()="
				+ getDate() + ", isDone()=" + isDone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
