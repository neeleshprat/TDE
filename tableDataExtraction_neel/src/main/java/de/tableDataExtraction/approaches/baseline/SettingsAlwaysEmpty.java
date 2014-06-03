package de.tableDataExtraction.approaches.baseline;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsAlwaysEmpty implements ApproachSettings {

	private String name;

	public SettingsAlwaysEmpty() {
		// nothing
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
