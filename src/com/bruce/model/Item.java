package com.bruce.model;

import java.util.Date;

public  class Item {
	private long create;
	private String description;
	private String id ;//存放项目类型 systemItem or userItem
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
