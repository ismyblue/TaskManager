package com.bruce.start;

import java.util.Scanner;
import java.util.regex.Pattern;

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

	public void deleteTask() {
		this.myTracker.deleteAllItem();
	}

	public void printAllTask() {
		this.myTracker.displayAllItem();
	}

	public void printByFilter() {

	}

	public void updateTask() {
		
	}
	
	public void addTask(){
		String name,id,desc,comments;
		
		userInput.asking("请输入名称：");
		do{
			name = scanner.next();			
			System.out.println("*" + name + "*");
			System.out.println(name.getClass().getName());
		}while(name.equals(""));
		
		userInput.asking("请输入任务类型:system/user：");		
		do{
			id = scanner.next();			
		}while(id.equals(""));
		
		userInput.asking("请输入任务描述：");
		do{
			desc = scanner.next();
			System.out.println(desc);
		}while(desc.equals(""));

		userInput.asking("请输入任务备注：");
		do{
			comments = scanner.next();
		}while(comments.equals(""));
		
		Task t = new Task(name, id, desc, comments, Tracker.getPosition());
		myTracker.addItem(t);
	}

	public void Run() {
		boolean isClose = false;
		while (true) {
			userInput.asking(menu);			
			while(!scanner.hasNextInt()){
				scanner.next();
			}
			int an = scanner.nextInt();			
			switch (an) {
			case 1: {//增加
				addTask();				
				break;
			}
			case 2: {
				break;
			}
			case 3: {
				break;
			}
			case 4: {
				break;
			}
			case 5: {
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
