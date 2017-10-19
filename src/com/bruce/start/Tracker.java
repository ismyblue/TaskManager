package com.bruce.start;

import java.util.ArrayList;
import java.util.Iterator;

import com.bruce.model.*;

public class Tracker {
	private static int position = 0;// 保存当前创建了任务的最后一个标识号码，current

	private ArrayList<Task> allTask;

	public static int getPosition() {
		return position;
	}

	public static void setPosition(int position) {
		Tracker.position = position;
	}

	public Tracker() {
		allTask = new ArrayList<Task>();
	}
	
	public void addItem(Task task) {
		allTask.add(task);
		setPosition(getPosition() + 1);//增加标号
	}

	public void deleteItem(Task task) {
		allTask.remove(task);
	}

	public Task[] findByFiler(String id, String name) {// 通过任务类型或者任务名字找到所要找的Task;
		ArrayList<Task> list = new ArrayList<Task>();
		Iterator<Task> it = allTask.iterator();
		while (it.hasNext()) {
			Task t = it.next();
			if (t.getId().equals(id) || t.getName().equals(name)) {
				list.add(t);
			}
		}
		Task[] r = new Task[list.size()];
		list.toArray(r);
		return r;
	}

	public Task findById(String id) {
		for (Task t : allTask) {
			if (t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}

	public void updateItem(Task task) {
		for (int i = 0; i < allTask.size(); i++) {
			if (task.getId().equals(allTask.get(i))) {
				allTask.set(i, task);
			}
		}
	}
	
	public void display(){
		for(Task t : allTask){
			System.out.println(t.getCreate() + t.getId() + t.getName() + t.getCurrent() + t.getComment() + t.getDescription());
		}
	}

}
