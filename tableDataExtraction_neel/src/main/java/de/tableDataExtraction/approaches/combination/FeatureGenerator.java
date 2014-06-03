package de.tableDataExtraction.approaches.combination;

import java.util.HashSet;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.classifier.Feature;
import de.tableDataExtraction.approaches.classifier.FeatureDetermination;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.ListFactory;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.SimpleStatistics;
import de.tableDataExtraction.model.Table;

public class FeatureGenerator {

	private final SettingsCombination settings;
	private final HashSet<String> countryNames;
	private final FeatureDetermination determine;

	public FeatureGenerator(SettingsCombination settings) {

		this.settings = settings;
		countryNames = ListFactory.createHashSet(this.getClass()
				.getResource("/" + settings.getCountryNamesJsonFile())
				.getFile());
		determine = new FeatureDetermination();
	}

	public Feature computeFeatures(Table table) {

		FeatureImplementation features;

		features = new FeatureImplementation(table.getId());

		computeApproachCorrectness(table, features);
		computeBasicNumberAndRatios(table, features);

		computeSimpleStatistics(table, features);
		computeDescriptiveStatistics(table, features);

		return features;
	}

	private void computeDescriptiveStatistics(Table table,
			FeatureImplementation features) {

		DescriptiveStatistics numberOfWords = new DescriptiveStatistics();
		DescriptiveStatistics numberOfCharacters = new DescriptiveStatistics();
		DescriptiveStatistics numberOfLetters = new DescriptiveStatistics();
		DescriptiveStatistics numberOfNumbers = new DescriptiveStatistics();
		DescriptiveStatistics numberOfPunctuationMarks = new DescriptiveStatistics();
		DescriptiveStatistics colspanLength = new DescriptiveStatistics();
		DescriptiveStatistics rowspanLength = new DescriptiveStatistics();

		// one loop to rule them all
		for (Column column : table.getColumns().values()) {
			for (Cell cell : column.getCells()) {

				numberOfWords.addValue(determine.numberOfWords(cell));
				numberOfCharacters.addValue(determine.numberOfLetters(cell));
				numberOfLetters.addValue(determine.numberOfLetters(cell));
				numberOfNumbers.addValue(determine.numberOfNumbers(cell));
				numberOfPunctuationMarks.addValue(determine
						.numberOfPunctuationMarks(cell));
				colspanLength.addValue(determine.colspan(cell));
				rowspanLength.addValue(determine.rowspan(cell));
			}
		}

		features.setAvgNumberOfWords(Helper.roundToDouble(numberOfWords
				.getMean()));
		features.setSdNumberOfWords(Helper.roundToDouble(numberOfWords
				.getStandardDeviation()));
		features.setMinNumberOfWords(Helper.roundToInteger(numberOfWords
				.getMin()));
		features.setMaxNumberOfWords(Helper.roundToInteger(numberOfWords
				.getMax()));

		features.setAvgNumberOfCharacters(Helper
				.roundToDouble(numberOfCharacters.getMean()));
		features.setSdNumberOfCharacters(Helper
				.roundToDouble(numberOfCharacters.getStandardDeviation()));
		features.setMinNumberOfCharacters(Helper
				.roundToInteger(numberOfCharacters.getMin()));
		features.setMaxNumberOfCharacters(Helper
				.roundToInteger(numberOfCharacters.getMax()));

		features.setAvgNumberOfLetters(Helper.roundToDouble(numberOfLetters
				.getMean()));
		features.setSdNumberOfLetters(Helper.roundToDouble(numberOfLetters
				.getStandardDeviation()));
		features.setMinNumberOfLetters(Helper.roundToInteger(numberOfLetters
				.getMin()));
		features.setMaxNumberOfLetters(Helper.roundToInteger(numberOfLetters
				.getMax()));

		features.setAvgNumberOfNumbers(Helper.roundToDouble(numberOfNumbers
				.getMean()));
		features.setSdNumberOfNumbers(Helper.roundToDouble(numberOfNumbers
				.getStandardDeviation()));
		features.setMinNumberOfNumbers(Helper.roundToInteger(numberOfNumbers
				.getMin()));
		features.setMaxNumberOfNumbers(Helper.roundToInteger(numberOfNumbers
				.getMax()));

		features.setAvgNumberOfPunctuationMarks(Helper
				.roundToDouble(numberOfPunctuationMarks.getMean()));
		features.setSdNumberOfPunctuationMarks(Helper
				.roundToDouble(numberOfPunctuationMarks.getStandardDeviation()));
		features.setMinNumberOfPunctuationMarks(Helper
				.roundToInteger(numberOfPunctuationMarks.getMin()));
		features.setMaxNumberOfPunctuationMarks(Helper
				.roundToInteger(numberOfPunctuationMarks.getMax()));

		features.setAvgColspanLength(Helper.roundToDouble(colspanLength
				.getMean()));
		features.setSdColspanLength(Helper.roundToDouble(colspanLength
				.getStandardDeviation()));
		features.setMinColspanLength(Helper.roundToInteger(colspanLength
				.getMin()));
		features.setMaxColspanLength(Helper.roundToInteger(colspanLength
				.getMax()));

		features.setAvgRowspanLength(Helper.roundToDouble(rowspanLength
				.getMean()));
		features.setSdRowspanLength(Helper.roundToDouble(rowspanLength
				.getStandardDeviation()));
		features.setMinRowspanLength(Helper.roundToInteger(rowspanLength
				.getMin()));
		features.setMaxRowspanLength(Helper.roundToInteger(rowspanLength
				.getMax()));
	}

	private void computeSimpleStatistics(Table table,
			FeatureImplementation features) {

		SimpleStatistics cellsContainingCountry = new SimpleStatistics();
		SimpleStatistics cellsContainingCountr = new SimpleStatistics();
		SimpleStatistics numericCells = new SimpleStatistics();
		SimpleStatistics blankCells = new SimpleStatistics();
		SimpleStatistics cellsStartingWithCapitals = new SimpleStatistics();
		SimpleStatistics cellsAllCapitalized = new SimpleStatistics();
		SimpleStatistics cellsAllLowerCase = new SimpleStatistics();
		SimpleStatistics cellsWithRowspan = new SimpleStatistics();
		SimpleStatistics cellsWithColspan = new SimpleStatistics();
		SimpleStatistics cellsWithStyleClass = new SimpleStatistics();
		SimpleStatistics cellsWithInlineStyle = new SimpleStatistics();
		SimpleStatistics cellsWithId = new SimpleStatistics();
		SimpleStatistics cellsContainingCountryNames = new SimpleStatistics();

		// one loop to rule them all
		for (Column column : table.getColumns().values()) {
			for (Cell cell : column.getCells()) {

				cellsContainingCountry.addValue(determine.containsCountry(cell,
						settings.getCountryKeyword()));
				cellsContainingCountr.addValue(determine.containsCountry(cell,
						"countr"));
				numericCells.addValue(determine.isNumeric(cell));
				blankCells.addValue(determine.isEmpty(cell));
				cellsStartingWithCapitals.addValue(determine
						.startsWithCapital(cell));
				cellsAllCapitalized.addValue(determine.isAllUppercase(cell));
				cellsAllLowerCase.addValue(determine.isAllLowercase(cell));
				cellsWithRowspan.addValue(determine.hasRowspan(cell));
				cellsWithColspan.addValue(determine.hasColspan(cell));
				cellsWithStyleClass.addValue(determine.hasStyleClass(cell));
				cellsWithInlineStyle.addValue(determine.hasInlineStyle(cell));
				cellsWithId.addValue(determine.hasId(cell));
				cellsContainingCountryNames.addValue(determine
						.containsCountryName(countryNames, cell));
			}
		}

		features.setNumberOfCellsContainingCountry(cellsContainingCountry
				.getNumber());
		features.setPercentageOfCellsContainingCountry(cellsContainingCountry
				.getRoundedPercentage());
		features.setContainsCountry(cellsContainingCountry.getBoolean());

		features.setNumberOfCellsContainingCountr(cellsContainingCountr
				.getNumber());
		features.setPercentageOfCellsContainingCountr(cellsContainingCountr
				.getRoundedPercentage());
		features.setContainsCountr(cellsContainingCountr.getBoolean());

		features.setNumberOfNumericCells(numericCells.getNumber());
		features.setPercentageOfNumericCells(numericCells
				.getRoundedPercentage());

		features.setNumberOfBlankCells(blankCells.getNumber());
		features.setPercentageOfBlankCells(blankCells.getRoundedPercentage());

		features.setNumberOfCellsStartingWithCapitals(cellsStartingWithCapitals
				.getNumber());
		features.setPercentageOfCellsStartingWithCapitals(cellsStartingWithCapitals
				.getRoundedPercentage());

		features.setNumberOfCellsAllCapitalized(cellsAllCapitalized.getNumber());
		features.setPercentageOfCellsAllCapitalized(cellsAllCapitalized
				.getRoundedPercentage());

		features.setNumberOfCellsAllLowercase(cellsAllLowerCase.getNumber());
		features.setPercentageOfCellsAllLowercase(cellsAllLowerCase
				.getRoundedPercentage());

		features.setNumberOfCellsWithRowspan(cellsWithRowspan.getNumber());
		features.setPercentageOfCellsWithRowspan(cellsWithRowspan
				.getRoundedPercentage());

		features.setNumberOfCellsWithColspan(cellsWithColspan.getNumber());
		features.setPercentageOfCellsWithColspan(cellsWithColspan
				.getRoundedPercentage());

		features.setNumberOfCellsWithStyleClass(cellsWithStyleClass.getNumber());
		features.setPercentageOfCellsWithStyleClass(cellsWithStyleClass
				.getRoundedPercentage());

		features.setNumberOfCellsWithInlineStyle(cellsWithInlineStyle
				.getNumber());
		features.setPercentageOfCellsWithInlineStyle(cellsWithInlineStyle
				.getRoundedPercentage());

		features.setNumberOfCellsWithId(cellsWithId.getNumber());
		features.setPercentageOfCellsWithId(cellsWithId.getRoundedPercentage());

		features.setNumberOfCellsContainingCountryNames(cellsContainingCountryNames
				.getNumber());
		features.setPercentageOfCellsContainingCountryNames(cellsContainingCountryNames
				.getRoundedPercentage());
	}

	private void computeBasicNumberAndRatios(Table table,
			FeatureImplementation features) {

		int numberOfColumns;
		int numberOfRows;
		int numberOfCells;

		numberOfColumns = determine.numberOfColumns(table);
		numberOfRows = determine.numberOfRows(table);
		numberOfCells = determine.numberOfCells(table);

		features.setNumberOfColumns(numberOfColumns);
		features.setNumberOfRows(numberOfRows);
		features.setNumberOfCells(numberOfCells);

		features.setColumnsToRowsRatio(Helper.percentage(numberOfColumns,
				numberOfRows));
		features.setColumnsToCellsRatio(Helper.percentage(numberOfColumns,
				numberOfCells));
		features.setRowsToColumnsRatio(Helper.percentage(numberOfRows,
				numberOfColumns));
		features.setRowsToCellsRatio(Helper.percentage(numberOfRows,
				numberOfCells));
		features.setCellsToColumnsRatio(Helper.percentage(numberOfCells,
				numberOfColumns));
		features.setCellsToRowsRatio(Helper.percentage(numberOfCells,
				numberOfRows));
	}

	private void computeApproachCorrectness(Table table,
			FeatureImplementation features) {

		// TODO Warum andere Ergebnisse als CrossValidation?

		Result expectedResult = table.getExpectedResult();

		features.setCorrectnessAlwaysFirst(expectedResult.equals(table
				.getResults().get("AlwaysFirst")));
		features.setCorrectnessAlwaysEmpty(expectedResult.equals(table
				.getResults().get("AlwaysEmpty")));
		features.setCorrectnessFindHtmlHeader(expectedResult.equals(table
				.getResults().get("FindHtmlHeader")));
		features.setCorrectnessFindHtmlStyle(expectedResult.equals(table
				.getResults().get("FindHtmlStyle")));
		features.setCorrectnessTengli(expectedResult.equals(table.getResults()
				.get("Tengli")));
		features.setCorrectnessChen(expectedResult.equals(table.getResults()
				.get("Chen")));
		features.setCorrectnessFindCrossing(expectedResult.equals(table
				.getResults().get("FindCrossing")));
		features.setCorrectnessFindCountry(expectedResult.equals(table
				.getResults().get("FindCountry")));
		features.setCorrectnessFindCountryNames(expectedResult.equals(table
				.getResults().get("FindCountryNames")));
		features.setCorrectnessClassifierFeatures(expectedResult.equals(table
				.getResults().get("ClassifierFeatures")));
		features.setCorrectnessClassifierStacking(expectedResult.equals(table
				.getResults().get("ClassifierStacking")));
	}
}
