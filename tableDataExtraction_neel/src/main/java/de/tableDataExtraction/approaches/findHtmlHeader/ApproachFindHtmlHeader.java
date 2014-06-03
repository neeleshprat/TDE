package de.tableDataExtraction.approaches.findHtmlHeader;

import java.util.ArrayList;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.TablePart;

public class ApproachFindHtmlHeader implements Approach {

	private final SettingsFindHtmlHeader settings;

	public ApproachFindHtmlHeader(ApproachSettings settings) {

		this.settings = (SettingsFindHtmlHeader) settings;
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

				if (isHtmlHeader(column)) {

					table.getResults().get(settings.getName()).getColumns()
							.put(columnNumber, true);
				}

				columnNumber++;
			}

			int rowNumber = 0;
			for (Row row : table.getData().getRows().values()) {

				if (isHtmlHeader(row)) {

					table.getResults().get(settings.getName()).getRows()
							.put(rowNumber, true);
				}

				rowNumber++;
			}
		}
	}

	private boolean isHtmlHeader(TablePart tablePart) {

		double percentage = 0;

		for (Cell cell : tablePart.getCells()) {

			if (cell.getCellHtml().tag().getName() == settings
					.getHtmlHeaderTag()) {

				percentage += (double) 1 / tablePart.getCells().size();

				if (percentage > settings.getHeaderThreshold()) {

					return true;
				}
			}
		}

		return false;
	}
}