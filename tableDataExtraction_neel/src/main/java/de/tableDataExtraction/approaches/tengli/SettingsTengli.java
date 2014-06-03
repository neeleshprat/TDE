package de.tableDataExtraction.approaches.tengli;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsTengli implements ApproachSettings {

	private String name;

	private double minLabelCells = 0.5;
	private int minLabelLength = 2;

	public SettingsTengli(double minLabelCells, int minLabelLength) {

		this.minLabelCells = minLabelCells;
		this.minLabelLength = minLabelLength;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public double getMinLabelCells() {
		return minLabelCells;
	}

	public void setMinLabelCells(double minLabelCells) {
		this.minLabelCells = minLabelCells;
	}

	public int getMinLabelLength() {
		return minLabelLength;
	}

	public void setMinLabelLength(int minLabelLength) {
		this.minLabelLength = minLabelLength;
	}
}
