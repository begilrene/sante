package com.cppsea.sante;

public class TemporaryDriver {
	public static void main(String[] args) {
		Reminder r = new Reminder("Walk Around", "Step away from the computer and go for a walk.", 1);
		Reminder r2 = new Reminder("Drink water", "Go drink some water.", 2);
		Reminder r3 = new Reminder("Do 10 jumping jacks", "Stand up and while looking away from the screen, do 10 jumping jacks.", 4);
		Watcher w = new Watcher();
		
		w.schedule(r);
		w.schedule(r2);
		w.schedule(r3);
	}
}