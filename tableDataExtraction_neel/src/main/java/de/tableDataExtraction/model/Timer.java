package de.tableDataExtraction.model;

public class Timer {

	private String name;
	private transient long startTime;
	private transient long endTime;
	private long usedTime;
	private int usedTimePercent;

	public Timer() {

		startTime = 0;
		endTime = 0;
		usedTime = 0;
	}

	public void start() {

		startTime = System.currentTimeMillis();
	}

	public long stop() {

		endTime = System.currentTimeMillis();

		if (startTime != 0) {
			usedTime = usedTime + (endTime - startTime);
		}

		computePercentages();

		return usedTime;
	}

	public long getUsedTime() {

		return usedTime;
	}

	public long getUsedTimePercent() {

		return usedTimePercent;
	}

	public void computePercentages() {

		float percent = ((((float) usedTime) / 5000) * 100);

		usedTimePercent = Math.round(percent);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
