package com.cppsea.sante;

public class Reminder {
	private String name, description;
	private int timeInterval;
	
	public Reminder(String n, String d, int t) {
		name = n;
		description = d;
		timeInterval = t;
  }
  
	public void remind() {
		System.out.println(name + ": " + description);
	}	
	
	public int getTimeInterval() {
		return timeInterval;
	}
}
