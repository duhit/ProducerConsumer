package com.cloudwick.mcgeary.derwin;

public class Consumer extends Thread {
	private Box box;
	
	public Consumer(Box box) {
		this.box = box;
	}
	
	public void run() {
		for(String message = box.take(); !message.equals("DONE"); message = box.take()) {
			System.out.println(message);
		}
	}
}
