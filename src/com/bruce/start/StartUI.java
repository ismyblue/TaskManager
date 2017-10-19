package com.bruce.start;

import com.bruce.model.*;


public class StartUI {

	public static void main(String[] args) {
		
		Tracker myTrack = new Tracker();
		Task myTask1 = new Task("system", "mspaint", Tracker.getPosition(), "this is a mspaint process", "first created");
		Task myTask2 = new Task("system", "mspaint", Tracker.getPosition(), "this is a mspaint process", "first created");
		Task myTask3 = new Task("system", "mspaint", Tracker.getPosition(), "this is a mspaint process", "first created");
		myTrack.addItem(myTask1);
		myTrack.addItem(myTask2);
		myTrack.addItem(myTask3);
		myTrack.display();
		
	}

}
