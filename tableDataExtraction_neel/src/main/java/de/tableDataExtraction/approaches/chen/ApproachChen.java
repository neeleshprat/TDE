package de.tableDataExtraction.approaches.chen;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.tableDataExtraction.Configuration;
import de.tableDataExtraction.Helper;
import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.ListFactory;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.YearParser;

public class ApproachChen implements Approach {

	private final SettingsChen settings;
	private final HashSet<String> countries;
	private final HashSet<String> knownLabels;

	private Integer previousRowKey = null;

	public ApproachChen(ApproachSettings settings) {

		this.settings = (SettingsChen) settings;

		countries = ListFactory.createHashSet(this.getClass()
				.getResource("/" + this.settings.getCountryNamesJsonFile())
				.getFile());

		knownLabels = ListFactory.createHashSet(this.getClass()
				.getResource("/" + this.settings.getKnownHeaders()).getFile());
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		// nothing
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {
		try {

			// for each table, for each row
			for (Table table : testDataset) {

				Result result = new Result();
				table.getResults().put(settings.getName(), result);

				// this.rowHeaders = new ArrayList<Row>();
				// this.rowData = new ArrayList<Row>();

				this.previousRowKey = null;

				for (Map.Entry<Integer, Row> entry : table.getData().getRows()
						.entrySet()) {

					int noOfLabelCell = 0;
					int indexCell = 0;

					Row row = entry.getValue();
					Integer rowKey = entry.getKey();

					Boolean isLabelRow = null;

					// check header tag, if header tag then header row
					// TODO what if all the cells have th tag - have some
					// threshold
					if (checkHeaderTag(row)) {
						isLabelRow = true;
						setCellLabels(true, row);
					}

					if (isLabelRow == null) {

						// check if the previous row is data row, if yes then
						// the
						// current row is likely to be a data row
						Boolean b = checkPreviousRowIsDataRow(result, rowKey);
						if (b == true) {
							isLabelRow = false;
							setCellLabels(false, row);
						}
					}

					if (isLabelRow == null) {

						// for each cell
						for (Cell cell : row.getCells()) {

							String cellContent = cell.getContent();

							// check if the cell content is in the bag of words
							cell.chenSetIsLabelCell(search(cellContent));

							// check if previous row is header row and has
							// bigger
							// colspan , if yes this is a label cell
							if (checkColSpanPreviousRow(indexCell, cell, table))

								cell.chenSetIsLabelCell(true);

							// check if the cell is numeric and doesn't
							// represent
							// year,
							// if so then it is most probably a data cell
							if (checkIfNumeric(cellContent)) {
								if (!checkIfYear(cellContent))
									cell.chenSetIsLabelCell(false);
								else if (previousRowKey == null)
									cell.chenSetIsLabelCell(true);
								else if (result.getRows().containsKey(
										previousRowKey)
										&& result.getRows().get(previousRowKey) == true)

									cell.chenSetIsLabelCell(true);
							}

							if (cell.chenGetIsLabelCell() == true)
								noOfLabelCell++;

							indexCell++;

						} // End of for loop for Cells
					}

					if (noOfLabelCell > 0)
						isLabelRow = true;

					// only if row is label row
					if (isLabelRow == Boolean.TRUE)
						result.getRows().put(rowKey, isLabelRow);

				} // End of loop for Rows

				determineColumnHeader(table);

			} // End of for loop for a table
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	} // end of classify

	public void determineColumnHeader(Table table) {

		int columnNumber;

		columnNumber = numberOfFirstColumnWithCountries(table);

		if (columnNumber >= 0) {

			table.getResults().get(settings.getName()).getColumns()
					.put(columnNumber, true);
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

		if (countries.contains(content)) {

			return true;
		}

		return false;
	}

	private boolean checkHeaderTag(Row row) {
		Elements sHeaderCells = row.getHtml().select(
				Configuration.TAG_TABLE_HEADER);

		// set the row as the label row. check size to confirm the number of
		// header cells are same as number of cells
		if (sHeaderCells.size() > 0)
			return true;
		else
			return false;

	}

	private Boolean checkPreviousRowIsDataRow(Result result, Integer keyRow) {
		if (previousRowKey != null) {
			if (result.getRows().containsKey(previousRowKey)) {
				if (result.getRows().get(previousRowKey) == false)
					return true;
			} else
				return true;

			previousRowKey = keyRow;
		} else {

			previousRowKey = keyRow;
		}

		return false;

	}

	private void setCellLabels(boolean b, Row row) {

		for (Cell cell : row.getCells()) {

			cell.chenSetIsLabelCell(b);
		}
	}

	private boolean checkColSpanPreviousRow(int indexCell, Cell cell,
			Table table) {

		if (previousRowKey != null) {

			String sPreviousColspan = "";
			int previouColspan = 0;
			String sColspan = "";
			int colspan = 0;

			Row previousRow = table.getData().getRows().get(previousRowKey);
			Cell previousCell = previousRow.getCells().get(indexCell);
			Element previousCellElement = previousCell.getCellHtml();

			if (previousCellElement.hasAttr(Configuration.TAG_TABLE_COLSPAN))
				sPreviousColspan = previousCellElement
						.attr(Configuration.TAG_TABLE_COLSPAN);

			if (!sPreviousColspan.isEmpty())
				previouColspan = Integer.parseInt(sPreviousColspan);

			Element cellElement = cell.getCellHtml();
			if (cellElement.hasAttr(Configuration.TAG_TABLE_COLSPAN))
				sColspan = cellElement.attr(Configuration.TAG_TABLE_COLSPAN);

			if (!sColspan.isEmpty())
				colspan = Integer.parseInt(sColspan);

			if (previouColspan > colspan)
				return true;
			else
				return false;
		}
		return false;

	}

	private boolean search(String content) {

		content = Helper.normaliseString(content);

		if (settings.isUseStringDistance()) {

			for (String country : knownLabels) {

				if (isLevenstheinEqual(country, content)) {

					return true;
				}
			}

		} else {

			if (knownLabels.contains(content)) {

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

	private boolean checkIfNumeric(String string) {
		int nmNumbers = 0;
		for (char ch : string.toCharArray()) {
			if (Character.isDigit(ch))
				nmNumbers++;
		}
		if (nmNumbers > 0)
			return true;
		else
			return false;
	}

	private boolean checkIfYear(String string) {

		return YearParser.parseDate(string);
	}
}