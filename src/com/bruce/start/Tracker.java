package com.bruce.start;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import com.bruce.model.*;

public class Tracker {
	// 保存当前创建了任务的最后一个标识号码，current
	private static int position = 1;
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
	public boolean addItem(Task task) {
		if(allTask.add(task)){
			setPosition(getPosition() + 1);// 增加标号
			return true;
		}
		return false;
		
	}

	// 删除/关闭一个任务
	public boolean deleteItem(Task task) {
		if(allTask.remove(task))
			return true;
		return false;
	}

	public void deleteAllItem() {
		allTask.clear();		
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

	// 查找任务 @param: int current
	public Task findByCurrent(int cur) {
		for (Task t : allTask) {
			if (t.getCurrent() == cur) {
				return t;
			}
		}
		return null;
	}

	// 更新task
	public boolean updateItem(Task task) {
		for (int i = 0; i < allTask.size(); i++) {
			if (task.getCurrent() == allTask.get(i).getCurrent()) {
				allTask.get(i).setName(task.getName());
				allTask.get(i).setCreate(task.getCreate());
				allTask.get(i).setDescription(task.getDescription());
				allTask.get(i).setId(task.getId());
				allTask.get(i).setComment(task.getComment());
				return true;
			}
		}
		return false;
	}
	
	public void displayItem(Task task) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		System.out.println("---------------------------------");
		System.out.println("任务当前运行号Current:	" + task.getCurrent());
		System.out.println("任务名称Name:		" + task.getName());
		System.out.println("创建时间Create:		" + format.format(task.getCreate()));
		System.out.println("任务类型id:		" + task.getId());
		System.out.println("描述Description:		" + task.getDescription());
		System.out.println("备注Comment:		" + task.getComment());
		
	}

	public void displayItems(Task[] taskList) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		for (int i = 0; i < taskList.length; i++) {
			System.out.println("---------------------------------");
			System.out.println("任务当前运行号Current:	" + taskList[i].getCurrent());
			System.out.println("任务名称Name:		" + taskList[i].getName());
			System.out.println("创建时间Create:		" + format.format(taskList[i].getCreate()));
			System.out.println("任务类型id:		" + taskList[i].getId());
			System.out.println("描述Description:		" + taskList[i].getDescription());
			System.out.println("备注Comment:		" + taskList[i].getComment());
		}
	}

	public void displayAllItem() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");		
		for (Task t : allTask) {
			System.out.println("---------------------------------");
			System.out.println("任务当前运行号Current:	" + t.getCurrent());
			System.out.println("任务名称Name:		" + t.getName());
			System.out.println("创建时间Create:		" + format.format(t.getCreate()));
			System.out.println("任务类型id:		" + t.getId());
			System.out.println("描述Description:		" + t.getDescription());
			System.out.println("备注Comment:		" + t.getComment());
		}
	}

}
