package de.tableDataExtraction.approaches.classifierFeatures;

import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.classifier.Feature;
import de.tableDataExtraction.approaches.classifier.FeatureDetermination;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.ListFactory;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.TablePart;

public class FeatureGenerator {

	private final SettingsClassifierFeatures settings;
	private final HashSet<String> countryNames;
	private final FeatureDetermination determine;

	public FeatureGenerator(SettingsClassifierFeatures settings) {

		this.settings = settings;
		countryNames = ListFactory.createHashSet(this.getClass()
				.getResource("/" + settings.getCountryNamesJsonFile())
				.getFile());
		determine = new FeatureDetermination();
	}

	public Feature computeFeatures(Table table, int index, TablePart tablePart) {

		FeatureImplementation features;

		features = createFeatures(table, index, tablePart);

		// Do not need loop over all cells
		// Set number, percentage
		computeIndex(index, tablePart, features);
		computeHasStyleClass(tablePart, features);
		computeHasInlineStyle(tablePart, features);

		// Need loop oder all cells
		// Set number, percentage
		computeNumericCells(tablePart, features);
		computeBlankCells(tablePart, features);
		computeCellsStartingWithCapitals(tablePart, features);
		computeCellsAllCapitalised(tablePart, features);
		computeCellsAllLowercase(tablePart, features);
		computeCellsContainingCountry(tablePart, features);
		computeCellsContainingCountryNames(tablePart, features);
		computeCellsWithStyleClass(tablePart, features);
		computeCellsWithInlineStyle(tablePart, features);

		// Need loop oder all cells
		// Set avg, sd, min, max
		computeNumberOfWords(tablePart, features);
		computeNumberOfCharacters(tablePart, features);
		computeNumberOfLetters(tablePart, features);
		computeNumberOfNumbers(tablePart, features);
		computeNumberOfPunctuationMarks(tablePart, features);

		// Various
		computeRowspan(tablePart, features);
		computeColspan(tablePart, features);
		computeLength(tablePart, features);

		return features;
	}

	private FeatureImplementation createFeatures(Table table, int index,
			TablePart tablePart) {

		FeatureImplementation features;
		boolean label;

		label = getLabelFromTable(table, index, tablePart);
		features = new FeatureImplementation(table.getId(), label);

		return features;
	}

	private boolean getLabelFromTable(Table table, int index,
			TablePart tablePart) {

		if (determine.isColumn(tablePart)) {

			return getLabel(table.getExpectedResult().getColumns(), index);

		} else {

			return getLabel(table.getExpectedResult().getRows(), index);
		}
	}

	private boolean getLabel(HashMap<Integer, Boolean> labels, int index) {

		if (labels.containsKey(index)) {

			return labels.get(index);

		} else {

			return false;
		}
	}

	private void computeLength(TablePart tablePart,
			FeatureImplementation features) {

		features.setLength(determine.length(tablePart));
	}

	private void computeColspan(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		int count = 0;

		for (Cell cell : tablePart.getCells()) {

			int length = 0;

			if (determine.hasColspan(cell)) {

				count++;
				length = determine.colspan(cell);
			}

			statistics.addValue(length);
		}

		features.setNumberOfCellsWithColspan(count);
		features.setPercentageOfCellsWithColspan(Helper.percentage(count,
				tablePart.getCells().size()));
		features.setAvgColspan(Helper.roundToDouble(statistics.getMean()));
		features.setMinColspan(Helper.roundToInteger(statistics.getMin()));
		features.setMaxColspan(Helper.roundToInteger(statistics.getMax()));
		features.setSdColspan(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeRowspan(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		int count = 0;

		for (Cell cell : tablePart.getCells()) {

			int length = 0;

			if (determine.hasRowspan(cell)) {

				count++;
				length = determine.rowspan(cell);
			}

			statistics.addValue(length);
		}

		features.setNumberOfCellsWithRowspan(count);
		features.setPercentageOfCellsWithRowspan(Helper.percentage(count,
				tablePart.getCells().size()));
		features.setAvgRowspan(Helper.roundToDouble(statistics.getMean()));
		features.setMinRowspan(Helper.roundToInteger(statistics.getMin()));
		features.setMaxRowspan(Helper.roundToInteger(statistics.getMax()));
		features.setSdRowspan(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeCellsWithInlineStyle(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.hasInlineStyle(cell)) {
				number++;
			}
		}

		features.setNumberOfCellsWithInlineStyle(number);
		features.setPercentageOfCellsWithInlineStyle(Helper.percentage(number,
				tablePart.getCells().size()));
	}

	private void computeCellsWithStyleClass(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.hasStyleClass(cell)) {
				number++;
			}
		}

		features.setNumberOfCellsWithStyleClass(number);
		features.setPercentageOfCellsWithStyleClass(Helper.percentage(number,
				tablePart.getCells().size()));
	}

	private void computeNumberOfPunctuationMarks(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		for (Cell cell : tablePart.getCells()) {

			statistics.addValue(determine.numberOfPunctuationMarks(cell));
		}

		features.setAvgNumberOfPunctuationMarks(Helper.roundToDouble(statistics
				.getMean()));
		features.setMinNumberOfPunctuationMarks(Helper
				.roundToInteger(statistics.getMin()));
		features.setMaxNumberOfPunctuationMarks(Helper
				.roundToInteger(statistics.getMax()));
		features.setSdNumberOfPunctuationMarks(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeNumberOfNumbers(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		for (Cell cell : tablePart.getCells()) {

			statistics.addValue(determine.numberOfNumbers(cell));
		}

		features.setAvgNumberOfNumbers(Helper.roundToDouble(statistics
				.getMean()));
		features.setMinNumberOfNumbers(Helper.roundToInteger(statistics
				.getMin()));
		features.setMaxNumberOfNumbers(Helper.roundToInteger(statistics
				.getMax()));
		features.setSdNumberOfNumbers(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeNumberOfLetters(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		for (Cell cell : tablePart.getCells()) {

			statistics.addValue(determine.numberOfLetters(cell));
		}

		features.setAvgNumberOfLetters(Helper.roundToDouble(statistics
				.getMean()));
		features.setMinNumberOfLetters(Helper.roundToInteger(statistics
				.getMin()));
		features.setMaxNumberOfLetters(Helper.roundToInteger(statistics
				.getMax()));
		features.setSdNumberOfLetters(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeNumberOfCharacters(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		for (Cell cell : tablePart.getCells()) {

			statistics.addValue(determine.numberOfCharacters(cell));
		}

		features.setAvgNumberOfCharacters(Helper.roundToDouble(statistics
				.getMean()));
		features.setMinNumberOfCharacters(Helper.roundToInteger(statistics
				.getMin()));
		features.setMaxNumberOfCharacters(Helper.roundToInteger(statistics
				.getMax()));
		features.setSdNumberOfCharacters(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeNumberOfWords(TablePart tablePart,
			FeatureImplementation features) {

		DescriptiveStatistics statistics = new DescriptiveStatistics();

		for (Cell cell : tablePart.getCells()) {

			statistics.addValue(determine.numberOfWords(cell));
		}

		features.setAvgNumberOfWords(Helper.roundToDouble(statistics.getMean()));
		features.setMinNumberOfWords(Helper.roundToInteger(statistics.getMin()));
		features.setMaxNumberOfWords(Helper.roundToInteger(statistics.getMax()));
		features.setSdNumberOfWords(Helper.roundToInteger(statistics
				.getStandardDeviation()));
	}

	private void computeHasInlineStyle(TablePart tablePart,
			FeatureImplementation features) {

		features.setHasInlineStyle(determine.hasInlineStyle(tablePart));
	}

	private void computeHasStyleClass(TablePart tablePart,
			FeatureImplementation features) {

		features.setHasStyleClass(determine.hasStyleClass(tablePart));
	}

	private void computeIndex(int index, TablePart tablePart,
			FeatureImplementation features) {

		features.setNumberOfIndex(index);
		features.setPercentageOfIndex(Helper.percentage(index, tablePart
				.getCells().size()));
	}

	private void computeCellsContainingCountryNames(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.containsCountryName(countryNames, cell)) {

				number++;
			}
		}

		features.setNumberOfCellsContainingCountryNames(number);
		features.setPercentageOfCellsContainingCountryNames(Helper.percentage(
				number, tablePart.getCells().size()));
	}

	private void computeCellsContainingCountry(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.containsCountry(cell, settings.getCountryKeyword())) {

				number++;
			}
		}

		features.setNumberOfCellsContainingCountry(number);
		features.setPercentageOfCellsContainingCountry(Helper.percentage(
				number, tablePart.getCells().size()));
	}

	private void computeCellsAllLowercase(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.isAllLowercase(cell)) {

				number++;
			}
		}

		features.setNumberOfCellsAllLowercase(number);
		features.setPercentageOfCellsAllLowercase(Helper.percentage(number,
				tablePart.getCells().size()));
	}

	private void computeCellsAllCapitalised(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.isAllUppercase(cell)) {

				number++;
			}
		}

		features.setNumberOfCellsAllCapitalised(number);
		features.setPercentageOfCellsAllCapitalised(Helper.percentage(number,
				tablePart.getCells().size()));
	}

	private void computeCellsStartingWithCapitals(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.startsWithCapital(cell)) {

				number++;
			}
		}

		features.setNumberOfCellsStartingWithCapitals(number);
		features.setPercentageOfCellsStartingWithCapitals(Helper.percentage(
				number, tablePart.getCells().size()));
	}

	private void computeBlankCells(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.isEmpty(cell)) {

				number++;
			}
		}

		features.setNumberOfBlankCells(number);
		features.setPercentageOfBlankCells(Helper.percentage(number, tablePart
				.getCells().size()));
	}

	private void computeNumericCells(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (determine.isNumeric(cell)) {

				number++;
			}
		}

		features.setNumberOfNumericCells(number);
		features.setPercentageOfNumericCells(Helper.percentage(number,
				tablePart.getCells().size()));
	}
}
