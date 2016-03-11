package com.cloudwick.mcgeary.derwin;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {
	private Box box;
	private BlockingQueue<String> queue;
	
	public Producer(Box box) {
		this.box = box;
	}
	
	public Producer(BlockingQueue<String> queue){
		this.queue = queue;
	}
	
	public void run() {
		String[] msgs = {"Romeo","Romeo","wherefore", "art", "thou?"};
		
		for(String message : msgs) {
			try {
				queue.put(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	try {
		queue.put("DONE");
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
}
