package de.tableDataExtraction.model;

import de.tableDataExtraction.Helper;

public class SimpleStatistics {

	private int numberOfTrue;
	private int numberOfFalse;

	public void addValue(boolean value) {

		if (value == true) {

			numberOfTrue++;

		} else {

			numberOfFalse++;
		}
	}

	public int getNumber() {

		return numberOfTrue;
	}

	public double getPercentage() {

		return (double) numberOfTrue / (numberOfTrue + numberOfFalse);
	}

	public double getRoundedPercentage() {

		return Helper.roundToDouble(getPercentage());
	}

	public boolean getBoolean() {

		return numberOfTrue > 0;
	}
}
