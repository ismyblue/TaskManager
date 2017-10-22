package com.bruce.model;

//系统程序任务
public class Task extends Item {

	// 任务备注
	private String comment;
	// 任务当前运行号
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

	public Task(String name, String id, String description, String comment,
			int current) {
		super(id, name, description);
		this.current = current;
		this.comment = comment;
	}
}
