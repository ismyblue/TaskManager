package com.bruce.model;

import java.util.Date;

public abstract class Item {
	//创建项目的时间戳
	private long create;
	//项目类型
	private String description;
	//存放项目类型 systemItem or userItem
	private String id ;
	//项目名称
	private String name;
	
	public Item(){
		
	}
	
	public Item(String id,String name,String description){	
		this.create = new Date().getTime();	
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public long getCreate() {
		return create;
	}
	public void setCreate(long create) {
		this.create = create;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
