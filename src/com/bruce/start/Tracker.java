package com.bruce.start;

import java.util.ArrayList;
import java.util.Iterator;

import com.bruce.model.*;

public class Tracker {
	// 保存当前创建了任务的最后一个标识号码，current
	private static int position = 0;
	// 任务管理器当前管理的所有任务
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

	// 增加一个运行任务
	public void addItem(Task task) {
		allTask.add(task);
		setPosition(getPosition() + 1);// 增加标号
	}

	// 删除/关闭一个任务
	public void deleteItem(Task task) {
		allTask.remove(task);
	}

	public void deleteAllItem() {
		this.allTask.clear();
	}

	// 搜索运行中的任务 @param: String id , String name
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

	// 查找任务 @param: String id
	public Task[] findById(String id) {
		ArrayList<Task> list = new ArrayList<Task>();
		for (Task t : allTask) {
			if (t.getId().equals(id)) {
				list.add(t);
			}
		}
		Task[] r = new Task[list.size()];
		list.toArray(r);
		return r;
	}

	// 更新task
	public void updateItem(Task task) {
		for (int i = 0; i < allTask.size(); i++) {
			if (task.getCurrent() == allTask.get(i).getCurrent()) {
				allTask.set(i, task);
			}
		}
	}

	public void displayItems(Task[] taskList) {
		for (int i = 0; i < taskList.length; i++) {
			System.out.println("---------------------------------");
			System.out.println("任务当前运行号Current:	" + taskList[i].getCurrent());
			System.out.println("任务名称Name:		" + taskList[i].getName());
			System.out.println("创建时间Create:		" + taskList[i].getCreate());
			System.out.println("任务类型id:		" + taskList[i].getId());
			System.out.println("描述Description:		"
					+ taskList[i].getDescription());
			System.out.println("备注Comment:		" + taskList[i].getComment());
		}
	}

	public void displayAllItem() {
		for (Task t : allTask) {
			System.out.println("---------------------------------");
			System.out.println("任务当前运行号Current:	" + t.getCurrent());
			System.out.println("任务名称Name:		" + t.getName());
			System.out.println("创建时间Create:		" + t.getCreate());
			System.out.println("任务类型id:		" + t.getId());
			System.out.println("描述Description:		" + t.getDescription());
			System.out.println("备注Comment:		" + t.getComment());
		}
	}

}
