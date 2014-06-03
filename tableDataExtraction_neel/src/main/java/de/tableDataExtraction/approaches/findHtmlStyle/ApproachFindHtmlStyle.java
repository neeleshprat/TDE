package de.tableDataExtraction.approaches.findHtmlStyle;

import java.util.ArrayList;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;

public class ApproachFindHtmlStyle implements Approach {

	private final SettingsFindHtmlStyle settings;

	public ApproachFindHtmlStyle(ApproachSettings settings) {

		this.settings = (SettingsFindHtmlStyle) settings;
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		// nothing
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {

		for (Table table : testDataset) {

			Result result;

			result = new Result();
			table.getResults().put(settings.getName(), result);

			int columnNumber = 0;
			for (Column column : table.getData().getColumns().values()) {

				if ((settings.isColumnCheckStyleClass() && hasStyleClass(column))
						|| (settings.isColumnCheckId() && hasId(column))
						|| (settings.isColumnCheckInlineStyle() && hasInlineStyle(column))) {

					table.getResults().get(settings.getName()).getColumns()
							.put(columnNumber, true);
				}

				columnNumber++;
			}

			int rowNumber = 0;
			for (Row row : table.getData().getRows().values()) {

				if ((settings.isRowCheckStyleClass() && hasStyleClass(row))
						|| (settings.isRowCheckId() && hasId(row))
						|| (settings.isRowCheckInlineStyle() && hasInlineStyle(row))) {

					table.getResults().get(settings.getName()).getRows()
							.put(rowNumber, true);
				}

				rowNumber++;
			}
		}
	}

	private boolean hasStyleClass(Row row) {

		if (row.getHtml().hasAttr("class")) {

			return true;
		}

		return false;
	}

	private boolean hasId(Row row) {

		if (row.getHtml().hasAttr("id")) {

			return true;
		}

		return false;
	}

	private boolean hasInlineStyle(Row row) {

		if (row.getHtml().hasAttr("style")) {

			return true;
		}

		return false;
	}

	private boolean hasStyleClass(Column column) {

		double percentage = 0;

		for (Cell cell : column.getCells()) {

			if (cell.getCellHtml().hasAttr("class")) {

				percentage += (double) 1 / column.getCells().size();

				if (percentage >= settings.getColumnStyleClassThreshold()) {

					return true;
				}
			}
		}

		return false;
	}

	private boolean hasId(Column column) {

		double percentage = 0;

		for (Cell cell : column.getCells()) {

			if (cell.getCellHtml().hasAttr("id")) {

				percentage += (double) 1 / column.getCells().size();

				if (percentage >= settings.getColumnIdThreshold()) {

					return true;
				}
			}
		}

		return false;
	}

	private boolean hasInlineStyle(Column column) {

		double percentage = 0;

		for (Cell cell : column.getCells()) {

			if (cell.getCellHtml().hasAttr("style")) {

				percentage += (double) 1 / column.getCells().size();

				if (percentage >= settings.getColumnInlineStyleThreshold()) {

					return true;
				}
			}
		}

		return false;
	}
}