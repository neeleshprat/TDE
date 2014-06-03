package de.tableDataExtraction;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import de.tableDataExtraction.Structured.TableStructured;
import de.tableDataExtraction.model.Descriptives;
import de.tableDataExtraction.model.OriginalDescription;
import de.tableDataExtraction.model.OriginalDescriptionTable;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Table;

public enum TableDataExtraction implements Serializable {

	// Singleton

	INSTANCE;

	public static TableDataExtraction getInstance() {
		return INSTANCE;
	}

	// Class variables

	private HashMap<String, Table> tables;
	private HashMap<String, Table> tablesWithoutExpectedResult;
	private CrossValidation crossValidation;

	// Constructor
	private TableDataExtraction() {

		tables = new HashMap<String, Table>();
		tablesWithoutExpectedResult = new HashMap<String, Table>();
	}

	// Methods

	public void load() throws JsonSyntaxException, IOException {

		Gson gson;
		Configuration configuration;
		File inputDescriptionFolder;
		File[] inputDescriptionFiles;
		Filter filter;

		gson = new Gson();
		configuration = Configuration.getInstance();
		inputDescriptionFolder = configuration.getDescriptionFolder();
		inputDescriptionFiles = inputDescriptionFolder.listFiles();
		filter = new Filter();

		// For all files
		for (File file : inputDescriptionFiles) {

			if (!file.getName().startsWith(".")) {

				OriginalDescription originalDescription;

				originalDescription = gson.fromJson(
						Files.toString(file, Charsets.UTF_8),
						OriginalDescription.class);

				int contentTableIndex = 0;
				for (OriginalDescriptionTable originalDescriptionTable : originalDescription
						.getContentTables()) {

					String tableId;

					tableId = originalDescription.getFilename() + "-"
							+ contentTableIndex;

					try {

						Table table;
						File inputContentFile;
						String inputContentString;

						inputContentFile = new File(
								configuration.getHtmlFilesPath()
										+ originalDescription.getFilename());
						inputContentString = Files.toString(inputContentFile,
								Charsets.UTF_8).substring(
								originalDescriptionTable.getStart(),
								originalDescriptionTable.getEnd());

						table = new Table(inputContentString, tableId);

						if (filter.isValid(table)) {

							tables.put(table.getId(), table);

							if (table.getExpectedResult() == null) {

								tablesWithoutExpectedResult.put(table.getId(),
										table);
							}
						}

					} catch (Exception e) {
						// no need to do anything, if we have a description but
						// no file we just ignore this file
						// we log it to the console anyways
						System.err
								.println("Exception occured, could not load table "
										+ tableId
										+ ". Full error message: "
										+ e.getMessage());
					}

					contentTableIndex++;
				}
			}
		}
	}

	public Table getTableWithoutExpectedResult() {

		Table result = null;

		try {

			result = tablesWithoutExpectedResult.entrySet().iterator().next()
					.getValue();

		} catch (NoSuchElementException e) {
			// We expect an exception when we reached the last table, so we
			// don't do anything
			// Let's print the exception anyways
			System.out
					.println("Could not find more tables without expected result. Full exception: "
							+ e.getMessage());
		}

		return result;
	}

	public void addTableWithoutExpectedResult(Table table) {

		tablesWithoutExpectedResult.put(table.getId(), table);
	}

	public void setExpectedResult(String tableId, Result expectedResult) {

		tablesWithoutExpectedResult.remove(tableId);
		tables.get(tableId).setExpectedResult(expectedResult);
	}

	public void crossValidation(int buckets) {

		crossValidation = new CrossValidation(new ArrayList<Table>(
				tables.values()));
		crossValidation.validate(buckets);
		crossValidation.evaluate();
	}

	public void save() {

		for (Table table : tables.values()) {

			table.save();

			// Uncomment the following if you want to get the structured tables
			// at
			// save operation

			TableStructured tableStructured = new TableStructured();
			tableStructured.transform(table);
			tableStructured.save();
		}
	}

	public HashMap<String, Table> getTables() {
		return tables;
	}

	public void setTables(HashMap<String, Table> tables) {
		this.tables = tables;
	}

	public CrossValidation getCrossValidation() {
		return crossValidation;
	}

	public void setCrossValidation(CrossValidation crossValidation) {
		this.crossValidation = crossValidation;
	}

	public HashMap<String, Table> getTablesWithoutExpectedResult() {
		return tablesWithoutExpectedResult;
	}

	public void setTablesWithoutExpectedResult(
			HashMap<String, Table> tablesWithoutExpectedResult) {
		this.tablesWithoutExpectedResult = tablesWithoutExpectedResult;
	}

	public Descriptives computeAverages(boolean isRow) {

		DescriptiveStatistics descriptiveStatistics;
		Descriptives descriptives;

		descriptiveStatistics = new DescriptiveStatistics();
		descriptives = new Descriptives();

		for (Table table : tables.values()) {

			if (isRow) {

				descriptiveStatistics
						.addValue(table.getData().getRows().size());

			} else {

				descriptiveStatistics.addValue(table.getData().getColumns()
						.size());
			}
		}

		descriptives.setAvg(descriptiveStatistics.getMean());
		descriptives.setMin(descriptiveStatistics.getMin());
		descriptives.setMax(descriptiveStatistics.getMax());
		descriptives.setSd(descriptiveStatistics.getStandardDeviation());

		return descriptives;
	}
}