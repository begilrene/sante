package com.cppsea.sante;

public class Reminder {
	private String name, description;
	private float timeInterval;
	
	public Reminder(String n, String d) {
		name = n;
		description = d;
	}
	
	public void remind() {
		System.out.println(name + ": " + description);
	}	
}
