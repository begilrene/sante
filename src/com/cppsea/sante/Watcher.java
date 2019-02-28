package com.cppsea.sante;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Watcher {
	private HashMap<Reminder, ScheduledFuture<?>> activeReminders;
	private final ScheduledExecutorService scheduler;

	public Watcher() {
		scheduler = Executors.newScheduledThreadPool(10);
		activeReminders = new HashMap<>();
	}

	public void schedule(Reminder reminder) {
		int timeBetween = reminder.getTimeInterval();

		final Runnable remind = createRunnableFor(reminder);
		final ScheduledFuture<?> scheduledReminder;
		
		scheduledReminder = scheduler.scheduleAtFixedRate(remind, timeBetween, timeBetween, TimeUnit.SECONDS);
		activeReminders.put(reminder, scheduledReminder);
	}

	public Runnable createRunnableFor(Reminder reminder) {
		return new Runnable() {
			public void run() {
				reminder.remind();
			}
		};
	}

	public Runnable createRunnableCancelFor(ScheduledFuture<?> eventToCancel) {
		return new Runnable() {
			public void run() {
				eventToCancel.cancel(true);
			}
		};
	}
}
