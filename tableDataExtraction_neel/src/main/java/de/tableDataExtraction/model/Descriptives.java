package de.tableDataExtraction.model;

public class Descriptives {

	private float avg;
	private int min;
	private int max;
	private float sd;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public void setMin(double min) {
		this.min = (int) Math.round(min);
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public void setMax(double max) {
		this.max = (int) Math.round(max);
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	public void setAvg(double avg) {
		this.avg = (float) avg;
	}

	public float getSd() {
		return sd;
	}

	public void setSd(float sd) {
		this.sd = sd;
	}

	public void setSd(double sd) {
		this.sd = (float) sd;
	}
}