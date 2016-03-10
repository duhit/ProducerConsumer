package com.cloudwick.mcgeary.derwin;

public class Main {
	
	public static void main(String[] args) {
		Box b = new Box();
		Producer p = new Producer(b);
		Consumer c = new Consumer(b);
		
		p.start();
		c.start();
		
		try {
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Finished successfully!");
	}
	
}
