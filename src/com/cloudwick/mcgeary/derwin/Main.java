package com.cloudwick.mcgeary.derwin;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
	
	public static void main(String[] args) {
//		Box b = new Box();
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
		Producer p1 = new Producer(queue);
		Producer p2 = new Producer(queue);
		Consumer c1 = new Consumer(queue);
		Consumer c2 = new Consumer(queue);
		
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		
		try {
			c2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished successfully!");
	}
	
}
