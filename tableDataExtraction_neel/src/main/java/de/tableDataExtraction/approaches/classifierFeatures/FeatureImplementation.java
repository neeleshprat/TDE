package de.tableDataExtraction.approaches.classifierFeatures;

import de.tableDataExtraction.approaches.classifier.Feature;

public class FeatureImplementation implements Feature {

	private String tableId;
	private boolean label;

	// either number of rows or number of columns
	private int length;

	private int numberOfIndex;
	private double percentageOfIndex;
	private int numberOfNumericCells;
	private double percentageOfNumericCells;
	private int numberOfBlankCells;
	private double percentageOfBlankCells;
	private int numberOfCellsStartingWithCapitals;
	private double percentageOfCellsStartingWithCapitals;
	private int numberOfCellsAllCapitalised;
	private double percentageOfCellsAllCapitalised;
	private int numberOfCellsAllLowercase;
	private double percentageOfCellsAllLowercase;
	private int numberOfCellsContainingCountry;
	private double percentageOfCellsContainingCountry;
	private int numberOfCellsContainingCountryNames;
	private double percentageOfCellsContainingCountryNames;
	private int numberOfCellsWithRowspan;
	private double percentageOfCellsWithRowspan;
	private int numberOfCellsWithColspan;
	private double percentageOfCellsWithColspan;
	private int numberOfCellsWithStyleClass;
	private double percentageOfCellsWithStyleClass;
	private int numberOfCellsWithInlineStyle;
	private double percentageOfCellsWithInlineStyle;

	private boolean hasStyleClass;
	private boolean hasInlineStyle;

	private double avgNumberOfWords;
	private int minNumberOfWords;
	private int maxNumberOfWords;
	private double sdNumberOfWords;
	private double avgNumberOfCharacters;
	private int minNumberOfCharacters;
	private int maxNumberOfCharacters;
	private double sdNumberOfCharacters;
	private double avgNumberOfLetters;
	private int minNumberOfLetters;
	private int maxNumberOfLetters;
	private double sdNumberOfLetters;
	private double avgNumberOfNumbers;
	private int minNumberOfNumbers;
	private int maxNumberOfNumbers;
	private double sdNumberOfNumbers;
	private double avgNumberOfPunctuationMarks;
	private int minNumberOfPunctuationMarks;
	private int maxNumberOfPunctuationMarks;
	private double sdNumberOfPunctuationMarks;
	private double avgRowspan;
	private int minRowspan;
	private int maxRowspan;
	private double sdRowspan;
	private double avgColspan;
	private int minColspan;
	private int maxColspan;
	private double sdColspan;

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

	public boolean getLabel() {
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

	public int getNumberOfIndex() {
		return numberOfIndex;
	}

	public void setNumberOfIndex(int numberOfIndex) {
		this.numberOfIndex = numberOfIndex;
	}

	public double getPercentageOfIndex() {
		return percentageOfIndex;
	}

	public void setPercentageOfIndex(double percentageOfIndex) {
		this.percentageOfIndex = percentageOfIndex;
	}

	public int getNumberOfNumericCells() {
		return numberOfNumericCells;
	}

	public void setNumberOfNumericCells(int numberOfNumericCells) {
		this.numberOfNumericCells = numberOfNumericCells;
	}

	public double getPercentageOfNumericCells() {
		return percentageOfNumericCells;
	}

	public void setPercentageOfNumericCells(double percentageOfNumericCells) {
		this.percentageOfNumericCells = percentageOfNumericCells;
	}

	public int getNumberOfBlankCells() {
		return numberOfBlankCells;
	}

	public void setNumberOfBlankCells(int numberOfBlankCells) {
		this.numberOfBlankCells = numberOfBlankCells;
	}

	public double getPercentageOfBlankCells() {
		return percentageOfBlankCells;
	}

	public void setPercentageOfBlankCells(double percentageOfBlankCells) {
		this.percentageOfBlankCells = percentageOfBlankCells;
	}

	public int getNumberOfCellsStartingWithCapitals() {
		return numberOfCellsStartingWithCapitals;
	}

	public void setNumberOfCellsStartingWithCapitals(
			int numberOfCellsStartingWithCapitals) {
		this.numberOfCellsStartingWithCapitals = numberOfCellsStartingWithCapitals;
	}

	public double getPercentageOfCellsStartingWithCapitals() {
		return percentageOfCellsStartingWithCapitals;
	}

	public void setPercentageOfCellsStartingWithCapitals(
			double percentageOfCellsStartingWithCapitals) {
		this.percentageOfCellsStartingWithCapitals = percentageOfCellsStartingWithCapitals;
	}

	public int getNumberOfCellsAllCapitalised() {
		return numberOfCellsAllCapitalised;
	}

	public void setNumberOfCellsAllCapitalised(int numberOfCellsAllCapitalised) {
		this.numberOfCellsAllCapitalised = numberOfCellsAllCapitalised;
	}

	public double getPercentageOfCellsAllCapitalised() {
		return percentageOfCellsAllCapitalised;
	}

	public void setPercentageOfCellsAllCapitalised(
			double percentageOfCellsAllCapitalised) {
		this.percentageOfCellsAllCapitalised = percentageOfCellsAllCapitalised;
	}

	public int getNumberOfCellsAllLowercase() {
		return numberOfCellsAllLowercase;
	}

	public void setNumberOfCellsAllLowercase(int numberOfCellsAllLowercase) {
		this.numberOfCellsAllLowercase = numberOfCellsAllLowercase;
	}

	public double getPercentageOfCellsAllLowercase() {
		return percentageOfCellsAllLowercase;
	}

	public void setPercentageOfCellsAllLowercase(
			double percentageOfCellsAllLowercase) {
		this.percentageOfCellsAllLowercase = percentageOfCellsAllLowercase;
	}

	public int getNumberOfCellsContainingCountry() {
		return numberOfCellsContainingCountry;
	}

	public void setNumberOfCellsContainingCountry(
			int numberOfCellsContainingCountry) {
		this.numberOfCellsContainingCountry = numberOfCellsContainingCountry;
	}

	public double getPercentageOfCellsContainingCountry() {
		return percentageOfCellsContainingCountry;
	}

	public void setPercentageOfCellsContainingCountry(
			double percentageOfCellsContainingCountry) {
		this.percentageOfCellsContainingCountry = percentageOfCellsContainingCountry;
	}

	public int getNumberOfCellsContainingCountryNames() {
		return numberOfCellsContainingCountryNames;
	}

	public void setNumberOfCellsContainingCountryNames(
			int numberOfCellsContainingCountryNames) {
		this.numberOfCellsContainingCountryNames = numberOfCellsContainingCountryNames;
	}

	public double getPercentageOfCellsContainingCountryNames() {
		return percentageOfCellsContainingCountryNames;
	}

	public void setPercentageOfCellsContainingCountryNames(
			double percentageOfCellsContainingCountryNames) {
		this.percentageOfCellsContainingCountryNames = percentageOfCellsContainingCountryNames;
	}

	public int getNumberOfCellsWithRowspan() {
		return numberOfCellsWithRowspan;
	}

	public void setNumberOfCellsWithRowspan(int numberOfCellsWithRowspan) {
		this.numberOfCellsWithRowspan = numberOfCellsWithRowspan;
	}

	public double getPercentageOfCellsWithRowspan() {
		return percentageOfCellsWithRowspan;
	}

	public void setPercentageOfCellsWithRowspan(
			double percentageOfCellsWithRowspan) {
		this.percentageOfCellsWithRowspan = percentageOfCellsWithRowspan;
	}

	public int getNumberOfCellsWithColspan() {
		return numberOfCellsWithColspan;
	}

	public void setNumberOfCellsWithColspan(int numberOfCellsWithColspan) {
		this.numberOfCellsWithColspan = numberOfCellsWithColspan;
	}

	public double getPercentageOfCellsWithColspan() {
		return percentageOfCellsWithColspan;
	}

	public void setPercentageOfCellsWithColspan(
			double percentageOfCellsWithColspan) {
		this.percentageOfCellsWithColspan = percentageOfCellsWithColspan;
	}

	public int getNumberOfCellsWithStyleClass() {
		return numberOfCellsWithStyleClass;
	}

	public void setNumberOfCellsWithStyleClass(int numberOfCellsWithStyleClass) {
		this.numberOfCellsWithStyleClass = numberOfCellsWithStyleClass;
	}

	public double getPercentageOfCellsWithStyleClass() {
		return percentageOfCellsWithStyleClass;
	}

	public void setPercentageOfCellsWithStyleClass(
			double percentageOfCellsWithStyleClass) {
		this.percentageOfCellsWithStyleClass = percentageOfCellsWithStyleClass;
	}

	public int getNumberOfCellsWithInlineStyle() {
		return numberOfCellsWithInlineStyle;
	}

	public void setNumberOfCellsWithInlineStyle(int numberOfCellsWithInlineStyle) {
		this.numberOfCellsWithInlineStyle = numberOfCellsWithInlineStyle;
	}

	public double getPercentageOfCellsWithInlineStyle() {
		return percentageOfCellsWithInlineStyle;
	}

	public void setPercentageOfCellsWithInlineStyle(
			double percentageOfCellsWithInlineStyle) {
		this.percentageOfCellsWithInlineStyle = percentageOfCellsWithInlineStyle;
	}

	public boolean getHasStyleClass() {
		return hasStyleClass;
	}

	public void setHasStyleClass(boolean hasStyleClass) {
		this.hasStyleClass = hasStyleClass;
	}

	public boolean getHasInlineStyle() {
		return hasInlineStyle;
	}

	public void setHasInlineStyle(boolean hasInlineStyle) {
		this.hasInlineStyle = hasInlineStyle;
	}

	public double getAvgNumberOfWords() {
		return avgNumberOfWords;
	}

	public void setAvgNumberOfWords(double avgNumberOfWords) {
		this.avgNumberOfWords = avgNumberOfWords;
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

	public double getSdNumberOfWords() {
		return sdNumberOfWords;
	}

	public void setSdNumberOfWords(double sdNumberOfWords) {
		this.sdNumberOfWords = sdNumberOfWords;
	}

	public double getAvgNumberOfCharacters() {
		return avgNumberOfCharacters;
	}

	public void setAvgNumberOfCharacters(double avgNumberOfCharacters) {
		this.avgNumberOfCharacters = avgNumberOfCharacters;
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

	public double getSdNumberOfCharacters() {
		return sdNumberOfCharacters;
	}

	public void setSdNumberOfCharacters(double sdNumberOfCharacters) {
		this.sdNumberOfCharacters = sdNumberOfCharacters;
	}

	public double getAvgNumberOfLetters() {
		return avgNumberOfLetters;
	}

	public void setAvgNumberOfLetters(double avgNumberOfLetters) {
		this.avgNumberOfLetters = avgNumberOfLetters;
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

	public double getSdNumberOfLetters() {
		return sdNumberOfLetters;
	}

	public void setSdNumberOfLetters(double sdNumberOfLetters) {
		this.sdNumberOfLetters = sdNumberOfLetters;
	}

	public double getAvgNumberOfNumbers() {
		return avgNumberOfNumbers;
	}

	public void setAvgNumberOfNumbers(double avgNumberOfNumbers) {
		this.avgNumberOfNumbers = avgNumberOfNumbers;
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

	public double getSdNumberOfNumbers() {
		return sdNumberOfNumbers;
	}

	public void setSdNumberOfNumbers(double sdNumberOfNumbers) {
		this.sdNumberOfNumbers = sdNumberOfNumbers;
	}

	public double getAvgNumberOfPunctuationMarks() {
		return avgNumberOfPunctuationMarks;
	}

	public void setAvgNumberOfPunctuationMarks(
			double avgNumberOfPunctuationMarks) {
		this.avgNumberOfPunctuationMarks = avgNumberOfPunctuationMarks;
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

	public double getSdNumberOfPunctuationMarks() {
		return sdNumberOfPunctuationMarks;
	}

	public void setSdNumberOfPunctuationMarks(double sdNumberOfPunctuationMarks) {
		this.sdNumberOfPunctuationMarks = sdNumberOfPunctuationMarks;
	}

	public double getAvgRowspan() {
		return avgRowspan;
	}

	public void setAvgRowspan(double avgRowspan) {
		this.avgRowspan = avgRowspan;
	}

	public int getMinRowspan() {
		return minRowspan;
	}

	public void setMinRowspan(int minRowspan) {
		this.minRowspan = minRowspan;
	}

	public int getMaxRowspan() {
		return maxRowspan;
	}

	public void setMaxRowspan(int maxRowspan) {
		this.maxRowspan = maxRowspan;
	}

	public double getSdRowspan() {
		return sdRowspan;
	}

	public void setSdRowspan(double sdRowspan) {
		this.sdRowspan = sdRowspan;
	}

	public double getAvgColspan() {
		return avgColspan;
	}

	public void setAvgColspan(double avgColspan) {
		this.avgColspan = avgColspan;
	}

	public int getMinColspan() {
		return minColspan;
	}

	public void setMinColspan(int minColspan) {
		this.minColspan = minColspan;
	}

	public int getMaxColspan() {
		return maxColspan;
	}

	public void setMaxColspan(int maxColspan) {
		this.maxColspan = maxColspan;
	}

	public double getSdColspan() {
		return sdColspan;
	}

	public void setSdColspan(double sdColspan) {
		this.sdColspan = sdColspan;
	}

}