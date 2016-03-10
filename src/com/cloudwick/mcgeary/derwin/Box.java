package com.cloudwick.mcgeary.derwin;

public class Box {
	private boolean empty;
	private String message;

	
	public Box() {
		empty = true;
	}
	public synchronized void put(String message) {
			while(!empty) {
				try {
				wait();
				} catch (InterruptedException e) {}
			}
			
			empty = false;
			this.message = message;
			notifyAll();
			return;

	}

	public String take() {
		synchronized(this) {
			while(empty) {
				try {
					wait();
				} catch (InterruptedException e) {}
			}
			
			empty=true;
			notifyAll();
			return message;
		}
	}
}
