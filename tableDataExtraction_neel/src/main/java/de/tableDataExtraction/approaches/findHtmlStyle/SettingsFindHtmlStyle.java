package de.tableDataExtraction.approaches.findHtmlStyle;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsFindHtmlStyle implements ApproachSettings {

	private String name;

	private boolean columnCheckStyleClass;
	private boolean columnCheckId;
	private boolean columnCheckInlineStyle;
	private boolean rowCheckStyleClass;
	private boolean rowCheckId;
	private boolean rowCheckInlineStyle;
	private double columnStyleClassThreshold;
	private double columnIdThreshold;
	private double columnInlineStyleThreshold;

	public SettingsFindHtmlStyle(boolean columnCheckStyleClass,
			boolean columnCheckId, boolean columnCheckInlineStyle,
			boolean rowCheckStyleClass, boolean rowCheckId,
			boolean rowCheckInlineStyle, double columnStyleClassThreshold,
			double columnIdThreshold, double columnInlineStyleThreshold) {
		super();
		this.columnCheckStyleClass = columnCheckStyleClass;
		this.columnCheckId = columnCheckId;
		this.columnCheckInlineStyle = columnCheckInlineStyle;
		this.rowCheckStyleClass = rowCheckStyleClass;
		this.rowCheckId = rowCheckId;
		this.rowCheckInlineStyle = rowCheckInlineStyle;
		this.columnStyleClassThreshold = columnStyleClassThreshold;
		this.columnIdThreshold = columnIdThreshold;
		this.columnInlineStyleThreshold = columnInlineStyleThreshold;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public boolean isColumnCheckStyleClass() {
		return columnCheckStyleClass;
	}

	public void setColumnCheckStyleClass(boolean columnCheckStyleClass) {
		this.columnCheckStyleClass = columnCheckStyleClass;
	}

	public boolean isColumnCheckId() {
		return columnCheckId;
	}

	public void setColumnCheckId(boolean columnCheckId) {
		this.columnCheckId = columnCheckId;
	}

	public boolean isColumnCheckInlineStyle() {
		return columnCheckInlineStyle;
	}

	public void setColumnCheckInlineStyle(boolean columnCheckInlineStyle) {
		this.columnCheckInlineStyle = columnCheckInlineStyle;
	}

	public boolean isRowCheckStyleClass() {
		return rowCheckStyleClass;
	}

	public void setRowCheckStyleClass(boolean rowCheckStyleClass) {
		this.rowCheckStyleClass = rowCheckStyleClass;
	}

	public boolean isRowCheckId() {
		return rowCheckId;
	}

	public void setRowCheckId(boolean rowCheckId) {
		this.rowCheckId = rowCheckId;
	}

	public boolean isRowCheckInlineStyle() {
		return rowCheckInlineStyle;
	}

	public void setRowCheckInlineStyle(boolean rowCheckInlineStyle) {
		this.rowCheckInlineStyle = rowCheckInlineStyle;
	}

	public double getColumnStyleClassThreshold() {
		return columnStyleClassThreshold;
	}

	public void setColumnStyleClassThreshold(double columnStyleClassThreshold) {
		this.columnStyleClassThreshold = columnStyleClassThreshold;
	}

	public double getColumnIdThreshold() {
		return columnIdThreshold;
	}

	public void setColumnIdThreshold(double columnIdThreshold) {
		this.columnIdThreshold = columnIdThreshold;
	}

	public double getColumnInlineStyleThreshold() {
		return columnInlineStyleThreshold;
	}

	public void setColumnInlineStyleThreshold(double columnInlineStyleThreshold) {
		this.columnInlineStyleThreshold = columnInlineStyleThreshold;
	}
}
