package de.tableDataExtraction.approaches.classifierStacking;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsClassifierStacking implements ApproachSettings {

	private String name;

	private boolean learn = false;

	private String countryKeyword;
	private String countryNamesJsonFile;

	private boolean rowBreakAfterFirst;
	private boolean columnBreakAfterFirst;

	private String rowClassifier;
	private String columnClassifier;

	public SettingsClassifierStacking(boolean learn, String countryKeyword,
			String countryNamesJsonFile, boolean rowBreakAfterFirst,
			boolean columnBreakAfterFirst, String rowClassifier,
			String columnClassifier) {
		super();
		this.learn = learn;
		this.countryKeyword = countryKeyword;
		this.countryNamesJsonFile = countryNamesJsonFile;
		this.rowBreakAfterFirst = rowBreakAfterFirst;
		this.columnBreakAfterFirst = columnBreakAfterFirst;
		this.rowClassifier = rowClassifier;
		this.columnClassifier = columnClassifier;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
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

	public String getRowClassifier() {
		return rowClassifier;
	}

	public void setRowClassifier(String rowClassifier) {
		this.rowClassifier = rowClassifier;
	}

	public String getColumnClassifier() {
		return columnClassifier;
	}

	public void setColumnClassifier(String columnClassifier) {
		this.columnClassifier = columnClassifier;
	}

	public boolean isLearn() {
		return learn;
	}

	public void setLearn(boolean learn) {
		this.learn = learn;
	}
}