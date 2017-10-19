package com.bruce.model;

public class Task extends Item {// 系统程序任务

	private String comment;
	private int current;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Task(String id, String description, int current, String name,
			String comment) {
		super(id, name, description);
		this.current = current;
		this.comment = comment;
	}
}
