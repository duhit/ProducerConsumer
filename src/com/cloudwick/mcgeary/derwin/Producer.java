package com.cloudwick.mcgeary.derwin;

public class Producer extends Thread {
	private Box box;
	
	public Producer(Box box) {
		this.box = box;
	}
	
	public void run() {
		String[] msgs = {"Romeo","Romeo","wherefore", "art", "thou?"};
		
		for(String message : msgs) {
			box.put(message);
		}
		
		box.put("DONE");
	}
}
