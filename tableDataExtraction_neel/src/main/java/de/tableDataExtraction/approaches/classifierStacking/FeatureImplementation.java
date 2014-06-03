package de.tableDataExtraction.approaches.classifierStacking;

import de.tableDataExtraction.approaches.classifier.Feature;

public class FeatureImplementation implements Feature {

	private String tableId;
	private boolean label;

	private int length;
	private int numberOfCellsContainingCountry;
	private float percentageOfCellsContainingCountry;
	private int numberOfCellsContainingCountryNames;
	private float percentageOfCellsContainingCountryNames;

	private boolean resultAlwaysFirst;
	private boolean resultAlwaysEmpty;
	private boolean resultTengli;
	private boolean resultChen;
	private boolean resultFindCrossing;
	private boolean resultFindCountry;
	private boolean resultFindCountryNames;
	private boolean resultClassifier;

	public FeatureImplementation(String tableId, boolean label) {

		this.tableId = tableId;
		this.label = label;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public boolean isLabel() {
		return label;
	}

	public void setLabel(boolean label) {
		this.label = label;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getNumberOfCellsContainingCountry() {
		return numberOfCellsContainingCountry;
	}

	public void setNumberOfCellsContainingCountry(
			int numberOfCellsContainingCountry) {
		this.numberOfCellsContainingCountry = numberOfCellsContainingCountry;
	}

	public float getPercentageOfCellsContainingCountry() {
		return percentageOfCellsContainingCountry;
	}

	public void setPercentageOfCellsContainingCountry(
			float percentageOfCellsContainingCountry) {
		this.percentageOfCellsContainingCountry = percentageOfCellsContainingCountry;
	}

	public int getNumberOfCellsContainingCountryNames() {
		return numberOfCellsContainingCountryNames;
	}

	public void setNumberOfCellsContainingCountryNames(
			int numberOfCellsContainingCountryNames) {
		this.numberOfCellsContainingCountryNames = numberOfCellsContainingCountryNames;
	}

	public float getPercentageOfCellsContainingCountryNames() {
		return percentageOfCellsContainingCountryNames;
	}

	public void setPercentageOfCellsContainingCountryNames(
			float percentageOfCellsContainingCountryNames) {
		this.percentageOfCellsContainingCountryNames = percentageOfCellsContainingCountryNames;
	}

	public boolean getResultAlwaysFirst() {
		return resultAlwaysFirst;
	}

	public void setResultAlwaysFirst(boolean resultAlwaysFirst) {
		this.resultAlwaysFirst = resultAlwaysFirst;
	}

	public boolean getResultAlwaysEmpty() {
		return resultAlwaysEmpty;
	}

	public void setResultAlwaysEmpty(boolean resultAlwaysEmpty) {
		this.resultAlwaysEmpty = resultAlwaysEmpty;
	}

	public boolean getResultTengli() {
		return resultTengli;
	}

	public void setResultTengli(boolean resultTengli) {
		this.resultTengli = resultTengli;
	}

	public boolean getResultChen() {
		return resultChen;
	}

	public void setResultChen(boolean resultChen) {
		this.resultChen = resultChen;
	}

	public boolean getResultFindCrossing() {
		return resultFindCrossing;
	}

	public void setResultFindCrossing(boolean resultFindCrossing) {
		this.resultFindCrossing = resultFindCrossing;
	}

	public boolean getResultFindCountry() {
		return resultFindCountry;
	}

	public void setResultFindCountry(boolean resultFindCountry) {
		this.resultFindCountry = resultFindCountry;
	}

	public boolean getResultClassifier() {
		return resultClassifier;
	}

	public void setResultClassifier(boolean resultClassifier) {
		this.resultClassifier = resultClassifier;
	}

	public boolean getResultFindCountryNames() {
		return resultFindCountryNames;
	}

	public void setResultFindCountryNames(boolean resultFindCountryNames) {
		this.resultFindCountryNames = resultFindCountryNames;
	}

}
