package de.tableDataExtraction.approaches.combination;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsCombination implements ApproachSettings {

	private String name;

	private boolean learn;
	private String countryKeyword;
	private String countryNamesJsonFile;
	private boolean rowBreakAfterFirst;
	private boolean columnBreakAfterFirst;

	public SettingsCombination(boolean learn, String countryKeyword,
			String countryNamesJsonFile, boolean rowBreakAfterFirst,
			boolean columnBreakAfterFirst) {
		super();
		this.learn = learn;
		this.countryKeyword = countryKeyword;
		this.countryNamesJsonFile = countryNamesJsonFile;
		this.rowBreakAfterFirst = rowBreakAfterFirst;
		this.columnBreakAfterFirst = columnBreakAfterFirst;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public boolean isLearn() {
		return learn;
	}

	public void setLearn(boolean learn) {
		this.learn = learn;
	}

	public String getCountryKeyword() {
		return countryKeyword;
	}

	public void setCountryKeyword(String countryKeyword) {
		this.countryKeyword = countryKeyword;
	}

	public String getCountryNamesJsonFile() {
		return countryNamesJsonFile;
	}

	public void setCountryNamesJsonFile(String countryNamesJsonFile) {
		this.countryNamesJsonFile = countryNamesJsonFile;
	}

	public boolean isRowBreakAfterFirst() {
		return rowBreakAfterFirst;
	}

	public void setRowBreakAfterFirst(boolean rowBreakAfterFirst) {
		this.rowBreakAfterFirst = rowBreakAfterFirst;
	}

	public boolean isColumnBreakAfterFirst() {
		return columnBreakAfterFirst;
	}

	public void setColumnBreakAfterFirst(boolean columnBreakAfterFirst) {
		this.columnBreakAfterFirst = columnBreakAfterFirst;
	}
}