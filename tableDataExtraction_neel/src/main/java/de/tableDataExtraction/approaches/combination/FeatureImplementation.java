package de.tableDataExtraction.approaches.combination;

import de.tableDataExtraction.approaches.classifier.Feature;

public class FeatureImplementation implements Feature {

	// Non-attributes

	private String tableId;

	private boolean correctnessAlwaysFirst;
	private boolean correctnessAlwaysEmpty;
	private boolean correctnessChen;
	private boolean correctnessClassifierFeatures;
	private boolean correctnessClassifierStacking;
	private boolean correctnessFindCountry;
	private boolean correctnessFindCountryNames;
	private boolean correctnessFindCrossing;
	private boolean correctnessFindHtmlHeader;
	private boolean correctnessFindHtmlStyle;
	private boolean correctnessTengli;

	// Attributes for table

	private int numberOfColumns;
	private int numberOfRows;
	private int numberOfCells;

	private double columnsToRowsRatio;
	private double columnsToCellsRatio;
	private double rowsToColumnsRatio;
	private double rowsToCellsRatio;
	private double cellsToColumnsRatio;
	private double cellsToRowsRatio;

	private int numberOfCellsContainingCountry;
	private double percentageOfCellsContainingCountry;
	private boolean containsCountry;

	private int numberOfCellsContainingCountr;
	private double percentageOfCellsContainingCountr;
	private boolean containsCountr;

	private int numberOfNumericCells;
	private double percentageOfNumericCells;

	private int numberOfBlankCells;
	private double percentageOfBlankCells;

	private int numberOfCellsStartingWithCapitals;
	private double percentageOfCellsStartingWithCapitals;

	private int numberOfCellsAllCapitalized;
	private double percentageOfCellsAllCapitalized;

	private int numberOfCellsAllLowercase;
	private double percentageOfCellsAllLowercase;

	private int numberOfCellsWithRowspan;
	private double percentageOfCellsWithRowspan;

	private int numberOfCellsWithColspan;
	private double percentageOfCellsWithColspan;

	private int numberOfCellsWithStyleClass;
	private double percentageOfCellsWithStyleClass;

	private int numberOfCellsWithInlineStyle;
	private double percentageOfCellsWithInlineStyle;

	private int numberOfCellsWithId;
	private double percentageOfCellsWithId;

	private int numberOfCellsContainingCountryNames;
	private double percentageOfCellsContainingCountryNames;

	// Attributes for cells

	private double avgNumberOfWords;
	private double sdNumberOfWords;
	private int minNumberOfWords;
	private int maxNumberOfWords;
	private double avgNumberOfCharacters;
	private double sdNumberOfCharacters;
	private int minNumberOfCharacters;
	private int maxNumberOfCharacters;
	private double avgNumberOfLetters;
	private double sdNumberOfLetters;
	private int minNumberOfLetters;
	private int maxNumberOfLetters;
	private double avgNumberOfNumbers;
	private double sdNumberOfNumbers;
	private int minNumberOfNumbers;
	private int maxNumberOfNumbers;
	private double avgNumberOfPunctuationMarks;
	private double sdNumberOfPunctuationMarks;
	private int minNumberOfPunctuationMarks;
	private int maxNumberOfPunctuationMarks;
	private double avgColspanLength;
	private double sdColspanLength;
	private int minColspanLength;
	private int maxColspanLength;
	private double avgRowspanLength;
	private double sdRowspanLength;
	private int minRowspanLength;
	private int maxRowspanLength;

	public FeatureImplementation(String tableId) {

		this.tableId = tableId;
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public boolean isCorrectnessAlwaysFirst() {
		return correctnessAlwaysFirst;
	}

	public void setCorrectnessAlwaysFirst(boolean correctnessAlwaysFirst) {
		this.correctnessAlwaysFirst = correctnessAlwaysFirst;
	}

	public boolean isCorrectnessAlwaysEmpty() {
		return correctnessAlwaysEmpty;
	}

	public void setCorrectnessAlwaysEmpty(boolean correctnessAlwaysEmpty) {
		this.correctnessAlwaysEmpty = correctnessAlwaysEmpty;
	}

	public boolean isCorrectnessChen() {
		return correctnessChen;
	}

	public void setCorrectnessChen(boolean correctnessChen) {
		this.correctnessChen = correctnessChen;
	}

	public boolean isCorrectnessClassifierFeatures() {
		return correctnessClassifierFeatures;
	}

	public void setCorrectnessClassifierFeatures(
			boolean correctnessClassifierFeatures) {
		this.correctnessClassifierFeatures = correctnessClassifierFeatures;
	}

	public boolean isCorrectnessFindCountry() {
		return correctnessFindCountry;
	}

	public void setCorrectnessFindCountry(boolean correctnessFindCountry) {
		this.correctnessFindCountry = correctnessFindCountry;
	}

	public boolean isCorrectnessFindCountryNames() {
		return correctnessFindCountryNames;
	}

	public void setCorrectnessFindCountryNames(
			boolean correctnessFindCountryNames) {
		this.correctnessFindCountryNames = correctnessFindCountryNames;
	}

	public boolean isCorrectnessFindCrossing() {
		return correctnessFindCrossing;
	}

	public void setCorrectnessFindCrossing(boolean correctnessFindCrossing) {
		this.correctnessFindCrossing = correctnessFindCrossing;
	}

	public boolean isCorrectnessFindHtmlHeader() {
		return correctnessFindHtmlHeader;
	}

	public void setCorrectnessFindHtmlHeader(boolean correctnessFindHtmlHeader) {
		this.correctnessFindHtmlHeader = correctnessFindHtmlHeader;
	}

	public boolean isCorrectnessFindHtmlStyle() {
		return correctnessFindHtmlStyle;
	}

	public void setCorrectnessFindHtmlStyle(boolean correctnessFindHtmlStyle) {
		this.correctnessFindHtmlStyle = correctnessFindHtmlStyle;
	}

	public boolean isCorrectnessTengli() {
		return correctnessTengli;
	}

	public void setCorrectnessTengli(boolean correctnessTengli) {
		this.correctnessTengli = correctnessTengli;
	}

	public int getNumberOfColumns() {
		return numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns) {
		this.numberOfColumns = numberOfColumns;
	}

	public int getNumberOfRows() {
		return numberOfRows;
	}

	public void setNumberOfRows(int numberOfRows) {
		this.numberOfRows = numberOfRows;
	}

	public int getNumberOfCells() {
		return numberOfCells;
	}

	public void setNumberOfCells(int numberOfCells) {
		this.numberOfCells = numberOfCells;
	}

	public double getColumnsToRowsRatio() {
		return columnsToRowsRatio;
	}

	public void setColumnsToRowsRatio(double columnsToRowsRatio) {
		this.columnsToRowsRatio = columnsToRowsRatio;
	}

	public double getColumnsToCellsRatio() {
		return columnsToCellsRatio;
	}

	public void setColumnsToCellsRatio(double columnsToCellsRatio) {
		this.columnsToCellsRatio = columnsToCellsRatio;
	}

	public double getRowsToColumnsRatio() {
		return rowsToColumnsRatio;
	}

	public void setRowsToColumnsRatio(double rowsToColumnsRatio) {
		this.rowsToColumnsRatio = rowsToColumnsRatio;
	}

	public double getRowsToCellsRatio() {
		return rowsToCellsRatio;
	}

	public void setRowsToCellsRatio(double rowsToCellsRatio) {
		this.rowsToCellsRatio = rowsToCellsRatio;
	}

	public double getCellsToColumnsRatio() {
		return cellsToColumnsRatio;
	}

	public void setCellsToColumnsRatio(double cellsToColumnsRatio) {
		this.cellsToColumnsRatio = cellsToColumnsRatio;
	}

	public double getCellsToRowsRatio() {
		return cellsToRowsRatio;
	}

	public void setCellsToRowsRatio(double cellsToRowsRatio) {
		this.cellsToRowsRatio = cellsToRowsRatio;
	}

	public int getNumberOfCellsContainingCountry() {
		return numberOfCellsContainingCountry;
	}

	public void setNumberOfCellsContainingCountry(
			int numberOfCellsContainingCountry) {
		this.numberOfCellsContainingCountry = numberOfCellsContainingCountry;
	}

	public int getNumberOfNumericCells() {
		return numberOfNumericCells;
	}

	public void setNumberOfNumericCells(int numberOfNumericCells) {
		this.numberOfNumericCells = numberOfNumericCells;
	}

	public int getNumberOfBlankCells() {
		return numberOfBlankCells;
	}

	public void setNumberOfBlankCells(int numberOfBlankCells) {
		this.numberOfBlankCells = numberOfBlankCells;
	}

	public int getNumberOfCellsStartingWithCapitals() {
		return numberOfCellsStartingWithCapitals;
	}

	public void setNumberOfCellsStartingWithCapitals(
			int numberOfCellsStartingWithCapitals) {
		this.numberOfCellsStartingWithCapitals = numberOfCellsStartingWithCapitals;
	}

	public int getNumberOfCellsAllCapitalized() {
		return numberOfCellsAllCapitalized;
	}

	public void setNumberOfCellsAllCapitalized(int numberOfCellsAllCapitalized) {
		this.numberOfCellsAllCapitalized = numberOfCellsAllCapitalized;
	}

	public int getNumberOfCellsAllLowercase() {
		return numberOfCellsAllLowercase;
	}

	public void setNumberOfCellsAllLowercase(int numberOfCellsAllLowercase) {
		this.numberOfCellsAllLowercase = numberOfCellsAllLowercase;
	}

	public int getNumberOfCellsWithRowspan() {
		return numberOfCellsWithRowspan;
	}

	public void setNumberOfCellsWithRowspan(int numberOfCellsWithRowspan) {
		this.numberOfCellsWithRowspan = numberOfCellsWithRowspan;
	}

	public int getNumberOfCellsWithColspan() {
		return numberOfCellsWithColspan;
	}

	public void setNumberOfCellsWithColspan(int numberOfCellsWithColspan) {
		this.numberOfCellsWithColspan = numberOfCellsWithColspan;
	}

	public int getNumberOfCellsWithStyleClass() {
		return numberOfCellsWithStyleClass;
	}

	public void setNumberOfCellsWithStyleClass(int numberOfCellsWithStyleClass) {
		this.numberOfCellsWithStyleClass = numberOfCellsWithStyleClass;
	}

	public int getNumberOfCellsWithInlineStyle() {
		return numberOfCellsWithInlineStyle;
	}

	public void setNumberOfCellsWithInlineStyle(int numberOfCellsWithInlineStyle) {
		this.numberOfCellsWithInlineStyle = numberOfCellsWithInlineStyle;
	}

	public int getNumberOfCellsContainingCountryNames() {
		return numberOfCellsContainingCountryNames;
	}

	public void setNumberOfCellsContainingCountryNames(
			int numberOfCellsContainingCountryNames) {
		this.numberOfCellsContainingCountryNames = numberOfCellsContainingCountryNames;
	}

	public double getPercentageOfCellsContainingCountry() {
		return percentageOfCellsContainingCountry;
	}

	public void setPercentageOfCellsContainingCountry(
			double percentageOfCellsContainingCountry) {
		this.percentageOfCellsContainingCountry = percentageOfCellsContainingCountry;
	}

	public double getPercentageOfCellsContainingCountr() {
		return percentageOfCellsContainingCountr;
	}

	public void setPercentageOfCellsContainingCountr(
			double percentageOfCellsContainingCountr) {
		this.percentageOfCellsContainingCountr = percentageOfCellsContainingCountr;
	}

	public double getPercentageOfNumericCells() {
		return percentageOfNumericCells;
	}

	public void setPercentageOfNumericCells(double percentageOfNumericCells) {
		this.percentageOfNumericCells = percentageOfNumericCells;
	}

	public double getPercentageOfBlankCells() {
		return percentageOfBlankCells;
	}

	public void setPercentageOfBlankCells(double percentageOfBlankCells) {
		this.percentageOfBlankCells = percentageOfBlankCells;
	}

	public double getPercentageOfCellsStartingWithCapitals() {
		return percentageOfCellsStartingWithCapitals;
	}

	public void setPercentageOfCellsStartingWithCapitals(
			double percentageOfCellsStartingWithCapitals) {
		this.percentageOfCellsStartingWithCapitals = percentageOfCellsStartingWithCapitals;
	}

	public double getPercentageOfCellsAllCapitalized() {
		return percentageOfCellsAllCapitalized;
	}

	public void setPercentageOfCellsAllCapitalized(
			double percentageOfCellsAllCapitalized) {
		this.percentageOfCellsAllCapitalized = percentageOfCellsAllCapitalized;
	}

	public double getPercentageOfCellsAllLowercase() {
		return percentageOfCellsAllLowercase;
	}

	public void setPercentageOfCellsAllLowercase(
			double percentageOfCellsAllLowercase) {
		this.percentageOfCellsAllLowercase = percentageOfCellsAllLowercase;
	}

	public double getPercentageOfCellsWithRowspan() {
		return percentageOfCellsWithRowspan;
	}

	public void setPercentageOfCellsWithRowspan(
			double percentageOfCellsWithRowspan) {
		this.percentageOfCellsWithRowspan = percentageOfCellsWithRowspan;
	}

	public double getPercentageOfCellsWithColspan() {
		return percentageOfCellsWithColspan;
	}

	public void setPercentageOfCellsWithColspan(
			double percentageOfCellsWithColspan) {
		this.percentageOfCellsWithColspan = percentageOfCellsWithColspan;
	}

	public double getPercentageOfCellsWithStyleClass() {
		return percentageOfCellsWithStyleClass;
	}

	public void setPercentageOfCellsWithStyleClass(
			double percentageOfCellsWithStyleClass) {
		this.percentageOfCellsWithStyleClass = percentageOfCellsWithStyleClass;
	}

	public double getPercentageOfCellsWithInlineStyle() {
		return percentageOfCellsWithInlineStyle;
	}

	public void setPercentageOfCellsWithInlineStyle(
			double percentageOfCellsWithInlineStyle) {
		this.percentageOfCellsWithInlineStyle = percentageOfCellsWithInlineStyle;
	}

	public double getPercentageOfCellsContainingCountryNames() {
		return percentageOfCellsContainingCountryNames;
	}

	public void setPercentageOfCellsContainingCountryNames(
			double percentageOfCellsContainingCountryNames) {
		this.percentageOfCellsContainingCountryNames = percentageOfCellsContainingCountryNames;
	}

	public boolean isContainsCountry() {
		return containsCountry;
	}

	public void setContainsCountry(boolean containsCountry) {
		this.containsCountry = containsCountry;
	}

	public boolean isContainsCountr() {
		return containsCountr;
	}

	public void setContainsCountr(boolean containsCountr) {
		this.containsCountr = containsCountr;
	}

	public double getAvgNumberOfWords() {
		return avgNumberOfWords;
	}

	public void setAvgNumberOfWords(double avgNumberOfWords) {
		this.avgNumberOfWords = avgNumberOfWords;
	}

	public double getSdNumberOfWords() {
		return sdNumberOfWords;
	}

	public void setSdNumberOfWords(double sdNumberOfWords) {
		this.sdNumberOfWords = sdNumberOfWords;
	}

	public int getMinNumberOfWords() {
		return minNumberOfWords;
	}

	public void setMinNumberOfWords(int minNumberOfWords) {
		this.minNumberOfWords = minNumberOfWords;
	}

	public int getMaxNumberOfWords() {
		return maxNumberOfWords;
	}

	public void setMaxNumberOfWords(int maxNumberOfWords) {
		this.maxNumberOfWords = maxNumberOfWords;
	}

	public double getAvgNumberOfCharacters() {
		return avgNumberOfCharacters;
	}

	public void setAvgNumberOfCharacters(double avgNumberOfCharacters) {
		this.avgNumberOfCharacters = avgNumberOfCharacters;
	}

	public double getSdNumberOfCharacters() {
		return sdNumberOfCharacters;
	}

	public void setSdNumberOfCharacters(double sdNumberOfCharacters) {
		this.sdNumberOfCharacters = sdNumberOfCharacters;
	}

	public int getMinNumberOfCharacters() {
		return minNumberOfCharacters;
	}

	public void setMinNumberOfCharacters(int minNumberOfCharacters) {
		this.minNumberOfCharacters = minNumberOfCharacters;
	}

	public int getMaxNumberOfCharacters() {
		return maxNumberOfCharacters;
	}

	public void setMaxNumberOfCharacters(int maxNumberOfCharacters) {
		this.maxNumberOfCharacters = maxNumberOfCharacters;
	}

	public double getAvgNumberOfLetters() {
		return avgNumberOfLetters;
	}

	public void setAvgNumberOfLetters(double avgNumberOfLetters) {
		this.avgNumberOfLetters = avgNumberOfLetters;
	}

	public double getSdNumberOfLetters() {
		return sdNumberOfLetters;
	}

	public void setSdNumberOfLetters(double sdNumberOfLetters) {
		this.sdNumberOfLetters = sdNumberOfLetters;
	}

	public int getMinNumberOfLetters() {
		return minNumberOfLetters;
	}

	public void setMinNumberOfLetters(int minNumberOfLetters) {
		this.minNumberOfLetters = minNumberOfLetters;
	}

	public int getMaxNumberOfLetters() {
		return maxNumberOfLetters;
	}

	public void setMaxNumberOfLetters(int maxNumberOfLetters) {
		this.maxNumberOfLetters = maxNumberOfLetters;
	}

	public double getAvgNumberOfNumbers() {
		return avgNumberOfNumbers;
	}

	public void setAvgNumberOfNumbers(double avgNumberOfNumbers) {
		this.avgNumberOfNumbers = avgNumberOfNumbers;
	}

	public double getSdNumberOfNumbers() {
		return sdNumberOfNumbers;
	}

	public void setSdNumberOfNumbers(double sdNumberOfNumbers) {
		this.sdNumberOfNumbers = sdNumberOfNumbers;
	}

	public int getMinNumberOfNumbers() {
		return minNumberOfNumbers;
	}

	public void setMinNumberOfNumbers(int minNumberOfNumbers) {
		this.minNumberOfNumbers = minNumberOfNumbers;
	}

	public int getMaxNumberOfNumbers() {
		return maxNumberOfNumbers;
	}

	public void setMaxNumberOfNumbers(int maxNumberOfNumbers) {
		this.maxNumberOfNumbers = maxNumberOfNumbers;
	}

	public double getAvgNumberOfPunctuationMarks() {
		return avgNumberOfPunctuationMarks;
	}

	public void setAvgNumberOfPunctuationMarks(
			double avgNumberOfPunctuationMarks) {
		this.avgNumberOfPunctuationMarks = avgNumberOfPunctuationMarks;
	}

	public double getSdNumberOfPunctuationMarks() {
		return sdNumberOfPunctuationMarks;
	}

	public void setSdNumberOfPunctuationMarks(double sdNumberOfPunctuationMarks) {
		this.sdNumberOfPunctuationMarks = sdNumberOfPunctuationMarks;
	}

	public int getMinNumberOfPunctuationMarks() {
		return minNumberOfPunctuationMarks;
	}

	public void setMinNumberOfPunctuationMarks(int minNumberOfPunctuationMarks) {
		this.minNumberOfPunctuationMarks = minNumberOfPunctuationMarks;
	}

	public int getMaxNumberOfPunctuationMarks() {
		return maxNumberOfPunctuationMarks;
	}

	public void setMaxNumberOfPunctuationMarks(int maxNumberOfPunctuationMarks) {
		this.maxNumberOfPunctuationMarks = maxNumberOfPunctuationMarks;
	}

	public boolean isCorrectnessClassifierStacking() {
		return correctnessClassifierStacking;
	}

	public void setCorrectnessClassifierStacking(
			boolean correctnessClassifierStacking) {
		this.correctnessClassifierStacking = correctnessClassifierStacking;
	}

	public int getNumberOfCellsWithId() {
		return numberOfCellsWithId;
	}

	public void setNumberOfCellsWithId(int numberOfCellsWithId) {
		this.numberOfCellsWithId = numberOfCellsWithId;
	}

	public double getPercentageOfCellsWithId() {
		return percentageOfCellsWithId;
	}

	public void setPercentageOfCellsWithId(double percentageOfCellsWithId) {
		this.percentageOfCellsWithId = percentageOfCellsWithId;
	}

	public double getAvgColspanLength() {
		return avgColspanLength;
	}

	public void setAvgColspanLength(double avgColspanLength) {
		this.avgColspanLength = avgColspanLength;
	}

	public double getSdColspanLength() {
		return sdColspanLength;
	}

	public void setSdColspanLength(double sdColspanLength) {
		this.sdColspanLength = sdColspanLength;
	}

	public int getMinColspanLength() {
		return minColspanLength;
	}

	public void setMinColspanLength(int minColspanLength) {
		this.minColspanLength = minColspanLength;
	}

	public int getMaxColspanLength() {
		return maxColspanLength;
	}

	public void setMaxColspanLength(int maxColspanLength) {
		this.maxColspanLength = maxColspanLength;
	}

	public double getAvgRowspanLength() {
		return avgRowspanLength;
	}

	public void setAvgRowspanLength(double avgRowspanLength) {
		this.avgRowspanLength = avgRowspanLength;
	}

	public double getSdRowspanLength() {
		return sdRowspanLength;
	}

	public void setSdRowspanLength(double sdRowspanLength) {
		this.sdRowspanLength = sdRowspanLength;
	}

	public int getMinRowspanLength() {
		return minRowspanLength;
	}

	public void setMinRowspanLength(int minRowspanLength) {
		this.minRowspanLength = minRowspanLength;
	}

	public int getMaxRowspanLength() {
		return maxRowspanLength;
	}

	public void setMaxRowspanLength(int maxRowspanLength) {
		this.maxRowspanLength = maxRowspanLength;
	}

	public int getNumberOfCellsContainingCountr() {
		return numberOfCellsContainingCountr;
	}

	public void setNumberOfCellsContainingCountr(
			int numberOfCellsContainingCountr) {
		this.numberOfCellsContainingCountr = numberOfCellsContainingCountr;
	}
}