package de.tableDataExtraction.approaches.tengli;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.commons.lang3.StringUtils;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.TablePart;

public class ApproachTengli implements Approach {

	private final SettingsTengli settings;

	private final HashSet<String> knownLabelsInRows;
	private final HashSet<String> knownLabelsInColumns;

	public ApproachTengli(ApproachSettings settings) {

		this.settings = (SettingsTengli) settings;

		knownLabelsInRows = new HashSet<String>();
		knownLabelsInColumns = new HashSet<String>();
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		for (Table table : learnDataset) {

			Result expectedResult;

			expectedResult = table.getExpectedResult();

			for (int rowId : expectedResult.getRows().keySet()) {

				if (expectedResult.getRows().get(rowId) != false) {

					Row row = table.getData().getRows().get(rowId);

					learnLabels(row);
				}
			}

			for (int columnId : expectedResult.getColumns().keySet()) {

				if (expectedResult.getColumns().get(columnId) != false) {

					Column column = table.getData().getColumns().get(columnId);

					learnLabels(column);
				}
			}
		}

	}

	private void learnLabels(TablePart tablePart) {

		for (Cell cell : tablePart.getCells()) {

			String content;

			content = cleanString(cell.getContent());

			if (isNotEmpty(content)) {

				if (tablePart.getClass() == Row.class) {

					knownLabelsInRows.add(content);

				} else {

					knownLabelsInColumns.add(content);
				}
			}
		}

	}

	private String cleanString(String string) {

		return string.trim().toLowerCase();
	}

	private boolean isNotEmpty(String string) {

		if (StringUtils.isNotBlank(string)
				&& string.length() >= settings.getMinLabelLength()) {

			return true;
		}

		return false;
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {

		for (Table table : testDataset) {

			Result result;

			result = new Result();

			int rowIndex = 0;
			for (Row row : table.getData().getRows().values()) {

				result.getRows().put(rowIndex, isLabel(row, true));

				rowIndex++;
			}

			int columnIndex = 0;
			for (Column column : table.getData().getColumns().values()) {

				result.getColumns().put(columnIndex, isLabel(column, false));

				columnIndex++;
			}

			table.getResults().put(settings.getName(), result);
		}
	}

	private boolean isLabel(TablePart tablePart, boolean isRow) {

		double percentage;
		int size;

		percentage = 0;
		size = tablePart.getCells().size();

		for (Cell cell : tablePart.getCells()) {

			if (isLabelCell(cell, isRow)) {

				percentage += (double) 1 / size;

				if (percentage > settings.getMinLabelCells()) {

					return true;
				}
			}
		}

		if (percentage > settings.getMinLabelCells()) {

			return true;

		} else {

			return false;
		}
	}

	private boolean isLabelCell(Cell cell, boolean isRow) {

		HashSet<String> knownLabels;

		if (isRow) {

			knownLabels = knownLabelsInRows;

		} else {

			knownLabels = knownLabelsInColumns;
		}

		if (knownLabels.contains(cleanString(cell.getContent()))) {

			return true;
		}

		return false;
	}
}