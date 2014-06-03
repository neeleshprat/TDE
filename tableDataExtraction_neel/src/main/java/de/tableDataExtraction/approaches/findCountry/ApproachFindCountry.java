package de.tableDataExtraction.approaches.findCountry;

import java.util.ArrayList;
import java.util.HashSet;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.ListFactory;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;

public class ApproachFindCountry implements Approach {

	private final SettingsFindCountry settings;

	private final HashSet<String> synonyms;

	public ApproachFindCountry(ApproachSettings settings) {

		this.settings = (SettingsFindCountry) settings;
		synonyms = ListFactory.createHashSet(this.getClass()
				.getResource("/" + this.settings.getSynonymsFile()).getFile());
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		// nothing
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {

		for (Table table : testDataset) {

			Result result;
			Coordinates coordinates;

			result = new Result();
			coordinates = getCoordinatesOfKeyword(table);

			if (coordinates != null) {

				// All rows above the finding
				for (int i = 0; i <= coordinates.getRow(); i++) {
					result.getRows().put(i, true);
				}
				// Only the column with the finding
				result.getColumns().put(coordinates.getColumn(), true);
			}

			table.getResults().put(settings.getName(), result);
		}
	}

	private boolean isKeyword(String content) {

		content = Helper.normaliseString(content);

		if (settings.isUseSynonyms()) {

			if (synonyms.contains(content)) {

				return true;
			}

		} else {

			if (content.contains(settings.getKeyword())) {

				return true;
			}
		}

		return false;
	}

	private Coordinates getCoordinatesOfKeyword(Table table) {

		int rowIndex = 0;
		for (Row row : table.getData().getRows().values()) {

			int cellIndex = 0;
			for (Cell cell : row.getCells()) {

				if (isKeyword(cell.getContent())) {

					return new Coordinates(rowIndex, cellIndex);
				}

				cellIndex++;
			}

			rowIndex++;
		}

		return null;
	}
}