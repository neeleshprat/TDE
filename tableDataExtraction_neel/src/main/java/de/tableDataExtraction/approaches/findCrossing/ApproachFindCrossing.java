package de.tableDataExtraction.approaches.findCrossing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.approaches.findCountry.Coordinates;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;

public class ApproachFindCrossing implements Approach {

	private final SettingsFindCrossing settings;

	private final HashSet<String> knownCrossings;

	public ApproachFindCrossing(ApproachSettings settings) {

		this.settings = (SettingsFindCrossing) settings;
		knownCrossings = new HashSet<String>();
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		for (Table table : learnDataset) {

			int rowId;
			int columnId;
			String crossing;

			rowId = findLastLabelRow(table.getExpectedResult().getRows());
			columnId = findFirstLabelColumn(table.getExpectedResult()
					.getColumns());

			if (rowId >= 0 && columnId >= 0) {

				crossing = Helper.normaliseString(table.getData().getRows()
						.get(rowId).getCells().get(columnId).getContent());

				if (StringUtils.isNotBlank(crossing)
						&& crossing.length() >= settings.getMinLabelLength()) {

					knownCrossings.add(crossing);
				}
			}
		}
	}

	private int findFirstLabelColumn(HashMap<Integer, Boolean> columns) {

		for (int columnId : columns.keySet()) {

			if (columns.get(columnId)) {

				return columnId;
			}
		}

		return -1;
	}

	private int findLastLabelRow(HashMap<Integer, Boolean> rows) {

		int outerRowId = 0;
		for (int rowId : rows.keySet()) {

			outerRowId = rowId;

			// If the current row is not a label row, we return the id of the
			// previous row
			if (!rows.get(rowId)) {

				return rowId - 1;
			}
		}

		return outerRowId;
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

		if (settings.isUseStringDistance()) {

			for (String crossing : knownCrossings) {

				if (isLevenstheinEqual(crossing, content)) {

					return true;
				}
			}

		} else {

			if (knownCrossings.contains(content)) {

				return true;
			}
		}

		return false;
	}

	private boolean isLevenstheinEqual(String one, String two) {

		if (StringUtils.getLevenshteinDistance(one, two) < settings
				.getMaxStringDistance()) {

			return true;
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