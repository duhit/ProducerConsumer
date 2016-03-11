package com.cloudwick.mcgeary.derwin;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	private Box box;
	private BlockingQueue<String> queue;
	
	public Consumer(Box box) {
		this.box = box;
	}
	
	public Consumer(BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		try {
			for(String message = queue.take(); !message.equals("DONE"); message = queue.take()) {
				System.out.println(message);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
