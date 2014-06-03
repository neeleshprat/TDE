package de.tableDataExtraction.Structured;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;

import de.tableDataExtraction.Configuration;
import de.tableDataExtraction.Structured.DataTypeDetector.BooleanParser;
import de.tableDataExtraction.Structured.DataTypeDetector.DateTimeParser;
import de.tableDataExtraction.Structured.DataTypeDetector.NumericParser;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;

public class TableStructured implements Serializable {

	private static final long serialVersionUID = 1L;

	private String tableId;

	private int start;
	private int end;

	private ArrayList<RowStructured> rowsStructured = new ArrayList<RowStructured>();

	private transient HashMap<Integer, ArrayList<String>> rowLabelsHashMap;
	private transient HashMap<Integer, ArrayList<String>> columnLabelsHashMap;

	private transient boolean hasrowLabels = false, hascolumnLabels = false,
			toBeConsidered = false;

	public TableStructured() {
		// do nothing
	}

	public void transform(Table table) {
		try {

			this.tableId = table.getId();

			this.start = table.getOriginalDescription().getContentTables()
					.get(Integer.parseInt(tableId)).getStart();
			this.end = table.getOriginalDescription().getContentTables()
					.get(Integer.parseInt(tableId)).getEnd();

			checkIfHasLabels(table);

			if (this.hasrowLabels == true && this.hascolumnLabels == true) {

				this.toBeConsidered = true;

				createRowHeaderLabels(table);
				createColumnHeaderLabels(table);

				for (Map.Entry<Integer, Row> entry : table.getData().getRows()
						.entrySet()) {

					Row row = entry.getValue();
					int rowIndex = entry.getKey();

					RowStructured rowStructured = new RowStructured();
					this.rowsStructured.add(rowStructured);

					int cellIndex = 0;

					for (Cell cell : row.getCells()) {

						CellStructured cellStructured = new CellStructured();
						rowStructured.addCellsStructured(cellStructured);

						String content = cell.getContent();
						// set the content
						cellStructured.setContent(content);

						// Determine the data type of the content
						cellStructured.setDataType(determineDataType(content));

						Element attr = cell.getCellHtml().select("a").first();
						// set the href link if available
						if (attr != null)
							if (attr.hasAttr(Configuration.ATTR_HREF))
								cellStructured.setHref(attr
										.attr(Configuration.ATTR_HREF));

						assignHeaders(table, cellStructured, cellIndex,
								rowIndex);

						cellIndex++;

					}

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void checkIfHasLabels(Table table) {
		// Check the Row labels
		for (Map.Entry<Integer, Boolean> entry : table.getExpectedResult()
				.getRows().entrySet()) {
			if (entry.getValue() == true) {
				this.hasrowLabels = true;
				break;
			}
		}

		// Check the column labels
		for (Map.Entry<Integer, Boolean> entry : table.getExpectedResult()
				.getColumns().entrySet()) {
			if (entry.getValue() == true) {
				this.hascolumnLabels = true;
				break;
			}
		}

	}

	private void createRowHeaderLabels(Table table) {

		rowLabelsHashMap = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < table.getData().getRows().get(0).getCells().size(); i++) {

			rowLabelsHashMap.put(i, new ArrayList<String>());
			for (Map.Entry<Integer, Boolean> entry : table.getExpectedResult()
					.getRows().entrySet()) {

				if (entry.getValue() == true) {

					if (i < table.getData().getRows().get(entry.getKey())
							.getCells().size()) {
						String cellContent = table.getData().getRows()
								.get(entry.getKey()).getCells().get(i)
								.getContent();
						rowLabelsHashMap.get(i).add(cellContent);
					}

				}
			}

		}

	}

	private void createColumnHeaderLabels(Table table) {

		columnLabelsHashMap = new HashMap<Integer, ArrayList<String>>();

		for (int i = 0; i < table.getData().getColumns().get(0).getCells()
				.size(); i++) {

			columnLabelsHashMap.put(i, new ArrayList<String>());
			for (Map.Entry<Integer, Boolean> entry : table.getExpectedResult()
					.getColumns().entrySet()) {

				if (entry.getValue() == true) {

					if (i < table.getData().getColumns().get(entry.getKey())
							.getCells().size()) {
						String cellContent = table.getData().getColumns()
								.get(entry.getKey()).getCells().get(i)
								.getContent();
						columnLabelsHashMap.get(i).add(cellContent);
					}

				}
			}

		}

	}

	private String determineDataType(String content) {

		if (BooleanParser.parseBoolean(content))
			return "boolean";
		if (DateTimeParser.parseDate(content))
			return "datetime";
		if (NumericParser.parseNumeric(content))
			return "numeric";

		return "string";
	}

	private void assignHeaders(Table table, CellStructured cellStructured,
			int indexCell, int rowIndex) {

		if (!table.getExpectedResult().getRows().containsKey(rowIndex)
				&& !table.getExpectedResult().getColumns()
						.containsKey(indexCell)) {

			cellStructured.setIsLabelCell(false);
			if (hasrowLabels)
				cellStructured.setRowLabels(rowLabelsHashMap.get(indexCell));
			if (hascolumnLabels)
				cellStructured.setColumnLabels(columnLabelsHashMap
						.get(rowIndex));

		} else
			cellStructured.setIsLabelCell(true);

	}

	public void save() {

		// only save if the table has row and column labels
		if (this.toBeConsidered == true) {
			Gson gson;
			String exportedResultString;
			Configuration configuration;

			gson = new Gson();
			exportedResultString = gson.toJson(this);
			configuration = Configuration.getInstance();

			try {
				writeFile(configuration.getTableStructuredPath() + tableId
						+ Configuration.RESULT_FILE_EXTENSION,
						exportedResultString);

			} catch (IOException e) {
				// This should not happen, as we already test for null values
				e.printStackTrace();
			}
		}

	}

	private void writeFile(String path, String content) throws IOException {

		FileUtils.writeStringToFile(new File(path), content);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public ArrayList<RowStructured> getRowsStructured() {
		return rowsStructured;
	}

	public void setRowsStructured(ArrayList<RowStructured> sRows) {
		this.rowsStructured = sRows;
	}

}