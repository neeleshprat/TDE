package de.tableDataExtraction.approaches.classifierStacking;

import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.classifier.Feature;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.ListFactory;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.TablePart;

public class FeatureGenerator {

	private final SettingsClassifierStacking settings;
	private final HashSet<String> countryNames;

	public FeatureGenerator(SettingsClassifierStacking settings) {

		this.settings = settings;
		countryNames = ListFactory.createHashSet(this.getClass()
				.getResource("/" + settings.getCountryNamesJsonFile())
				.getFile());
	}

	public Feature computeFeatures(Table table, int index, TablePart tablePart) {

		FeatureImplementation features;

		features = createFeatures(table, index, tablePart);

		computeLength(tablePart, features);
		computeCellsContainingCountry(tablePart, features);
		computeCellsContainingCountryNames(tablePart, features);
		computeApproachResults(table, index, tablePart, features);

		return features;
	}

	private FeatureImplementation createFeatures(Table table, int index,
			TablePart tablePart) {

		FeatureImplementation features;
		boolean label;

		label = getLabelFromTablePart(table, index, tablePart);
		features = new FeatureImplementation(table.getId(), label);

		return features;
	}

	private boolean getLabelFromTablePart(Table table, int index,
			TablePart tablePart) {

		if (isRow(tablePart)) {

			return getLabel(table.getExpectedResult().getRows(), index);

		} else {

			return getLabel(table.getExpectedResult().getColumns(), index);
		}
	}

	private boolean getLabel(HashMap<Integer, Boolean> labels, int index) {

		if (labels.containsKey(index)) {

			return labels.get(index);

		} else {

			return false;
		}
	}

	private boolean isRow(TablePart tablePart) {

		if (tablePart.getClass() == Row.class) {

			return true;
		}
		return false;
	}

	private void computeLength(TablePart tablePart,
			FeatureImplementation features) {

		features.setLength(tablePart.getCells().size());
	}

	private void computeApproachResults(Table table, int index,
			TablePart tablePart, FeatureImplementation features) {

		features.setResultAlwaysFirst(getApproachResultFromTable("AlwaysFirst",
				index, table, tablePart));
		features.setResultAlwaysEmpty(getApproachResultFromTable("AlwaysEmpty",
				index, table, tablePart));
		features.setResultTengli(getApproachResultFromTable("Tengli", index,
				table, tablePart));
		features.setResultChen(getApproachResultFromTable("Chen", index, table,
				tablePart));
		features.setResultFindCrossing(getApproachResultFromTable(
				"FindCrossing", index, table, tablePart));
		features.setResultFindCountry(getApproachResultFromTable("FindCountry",
				index, table, tablePart));
		features.setResultFindCountryNames(getApproachResultFromTable(
				"FindCountryNames", index, table, tablePart));
		features.setResultClassifier(getApproachResultFromTable("Classifier",
				index, table, tablePart));
	}

	private boolean getApproachResultFromTable(String name, int index,
			Table table, TablePart tablePart) {

		if (!table.getResults().containsKey(name)) {

			return false;
		}

		if (isRow(tablePart)) {

			return getLabel(table.getResults().get(name).getRows(), index);

		} else {

			return getLabel(table.getResults().get(name).getColumns(), index);
		}
	}

	private void computeCellsContainingCountry(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (cell.getContent().toLowerCase()
					.startsWith(settings.getCountryKeyword())) {

				number++;
			}
		}

		features.setNumberOfCellsContainingCountry(number);
		features.setPercentageOfCellsContainingCountry(Helper.percentage(
				number, tablePart.getCells().size()));
	}

	private void computeCellsContainingCountryNames(TablePart tablePart,
			FeatureImplementation features) {

		int number = 0;

		for (Cell cell : tablePart.getCells()) {

			if (containsCountry(cell.getContent())) {
				number++;
			}
		}

		features.setNumberOfCellsContainingCountryNames(number);
		features.setPercentageOfCellsContainingCountryNames(Helper.percentage(
				number, tablePart.getCells().size()));
	}

	private boolean containsCountry(String string) {

		if (!StringUtils.isNotBlank(string)) {

			return false;
		}

		if (countryNames.contains(Helper.normaliseString(string))) {

			return true;
		}

		return false;
	}
}
