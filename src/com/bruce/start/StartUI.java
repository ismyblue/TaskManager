package com.bruce.start;

import java.util.Scanner;

import com.bruce.model.Task;

public class StartUI {

	// 扫描器，用来获取用户输入内容
	private Scanner scanner;
	private String menu;
	private Tracker myTracker;
	public input userInput;

	public void init() {
		userInput = new ConsoleInput();
		scanner = userInput.getScanner();
		myTracker = new Tracker();
		menu = "请输入要进行的操作:\n" + "１）开启一个任务．" + "２）关闭一个任务．" + "３）修改一个任务．"
				+ "４）查询任务．" + "５）查看所有任务．" + "６）退出．\n";
	}

	// 添加任务
	public void addTask() {
		String name, id, desc, comments;

		userInput.asking("请输入名称：");
		do {
			name = scanner.next();
		} while (name.equals(""));

		userInput.asking("请输入任务类型:system/user：");
		do {
			id = scanner.next();
		} while (id.equals(""));

		userInput.asking("请输入任务描述：");
		do {
			desc = scanner.next();
		} while (desc.equals(""));

		userInput.asking("请输入任务备注：");
		do {
			comments = scanner.next();
		} while (comments.equals(""));

		Task t = new Task(name, id, desc, comments, Tracker.getPosition());
		if (myTracker.addItem(t))
			userInput.asking("添加成功！\n");
		else
			userInput.asking("没有添加成功！\n");

	}

	// 删除任务
	public void deleteTask() {
		userInput.asking("请输入程序当前运行号：\n");
		int cur;
		while (true) {
			if (scanner.hasNextInt()) {
				cur = scanner.nextInt();
				break;
			}
		}
		if (myTracker.deleteItem(myTracker.findByCurrent(cur)))
			userInput.asking("删除成功！");
		else
			userInput.asking("没有删除成功!");
	}

	// 更新任务
	public void updateTask() {
		userInput.asking("请输入程序当前运行号：\n");
		int cur;
		while (true) {
			if (scanner.hasNextInt()) {
				cur = scanner.nextInt();
				break;
			}
		}

		String name, id, desc, comments;

		userInput.asking("请输入名称：");
		do {
			name = scanner.next();
		} while (name.equals(""));

		userInput.asking("请输入任务类型:system/user：");
		do {
			id = scanner.next();
		} while (id.equals(""));

		userInput.asking("请输入任务描述：");
		do {
			desc = scanner.next();
		} while (desc.equals(""));

		userInput.asking("请输入任务备注：");
		do {
			comments = scanner.next();
		} while (comments.equals(""));

		Task t = new Task(name, id, desc, comments, cur);
		if (myTracker.updateItem(t))
			userInput.asking("更新成功！");
		else
			userInput.asking("没有更新成功!");
	}

	// 查询任务
	public void queryTask() {
		String ask = "1)通过id查询：\n2)通过任务当前运行号查询:\n3)通过id和name查询:\n";
		String id, name;
		int cur;
		userInput.asking(ask);
		int an = scanner.nextInt();
		switch (an) {
		case 1:
			userInput.asking("输入任务id:\n");
			id = scanner.next();
			myTracker.displayItems(myTracker.findById(id));
			break;
		case 2:
			userInput.asking("输入任务当前运行号:\n");
			cur = scanner.nextInt();
			myTracker.displayItem(myTracker.findByCurrent(cur));
			break;
		case 3:
			userInput.asking("输入id:\n");
			id = scanner.next();
			userInput.asking("输入name:\n");
			name = scanner.next();
			myTracker.displayItems(myTracker.findByFiler(id, name));
			break;
		default:
			break;
		}
	}

	public void printAllTask() {
		this.myTracker.displayAllItem();
	}

	public void Run() {
		boolean isClose = false;
		while (true) {
			userInput.asking(menu);
			while (!scanner.hasNextInt()) {
				scanner.next();
			}
			int an = scanner.nextInt();
			switch (an) {
			case 1: {// 增加
				addTask();
				break;
			}
			case 2: {// 删除
				deleteTask();
				break;
			}
			case 3: {// 修改
				updateTask();
				break;
			}
			case 4: {// 查询
				queryTask();
				break;
			}
			case 5: {// 查看所有
				myTracker.displayAllItem();
				break;
			}
			case 6: {
				isClose = true;
				System.out.println("退出成功！");
				break;
			}
			default:
				break;
			}
			if (isClose)
				break;
		}
	}

	public static void main(String[] args) {

		StartUI desktop = new StartUI();
		desktop.init();
		desktop.Run();

	}

}
