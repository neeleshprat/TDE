package de.tableDataExtraction.approaches.findCountryNames;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.ListFactory;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Table;

public class ApproachFindCountryNames implements Approach {

	private final SettingsFindCountryNames settings;
	private final HashSet<String> countries;

	public ApproachFindCountryNames(ApproachSettings settings) {

		this.settings = (SettingsFindCountryNames) settings;
		countries = ListFactory.createHashSet(this.getClass()
				.getResource("/" + this.settings.getCountryNamesJsonFile())
				.getFile());
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		// nothing
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {

		for (Table table : testDataset) {

			Result result;
			int rowNumber;
			int columnNumber;

			result = new Result();

			columnNumber = numberOfFirstColumnWithCountries(table);

			if (columnNumber >= 0) {

				// Only the column with the finding
				result.getColumns().put(columnNumber, true);

				rowNumber = numberOfFirstCellWithCountry(table.getData()
						.getColumns().get(columnNumber));

				if (rowNumber >= 0) {

					// All rows above the finding
					for (int i = 0; i < rowNumber; i++) {

						result.getRows().put(i, true);
					}
				}
			}

			table.getResults().put(settings.getName(), result);
		}
	}

	private int numberOfFirstColumnWithCountries(Table table) {

		int columnNumber = 0;
		for (Column column : table.getData().getColumns().values()) {

			float percentageOfCountries;
			int size;

			percentageOfCountries = 0;
			size = column.getCells().size();

			for (Cell cell : column.getCells()) {

				if (isCountry(cell.getContent())) {

					percentageOfCountries += (float) 1 / size;

					if (percentageOfCountries > settings
							.getMinPercentageOfCountries()) {

						return columnNumber;
					}
				}
			}

			if (percentageOfCountries > settings.getMinPercentageOfCountries()) {

				return columnNumber;
			}

			columnNumber++;
		}

		return -1;
	}

	private boolean isCountry(String content) {

		content = Helper.normaliseString(content);

		if (settings.isUseStringDistance()) {

			for (String country : countries) {

				if (isLevenstheinEqual(country, content)) {

					return true;
				}
			}

		} else {

			if (countries.contains(content)) {

				return true;
			}
		}

		return false;
	}

	private int numberOfFirstCellWithCountry(Column column) {

		int rowNumber = 0;

		for (Cell cell : column.getCells()) {

			if (isCountry(cell.getContent())) {

				return rowNumber;
			}

			rowNumber++;
		}

		return -1;
	}

	private boolean isLevenstheinEqual(String one, String two) {

		if (StringUtils.getLevenshteinDistance(one, two) < settings
				.getMaxStringDistance()) {

			return true;
		}

		return false;
	}
}