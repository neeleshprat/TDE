package de.tableDataExtraction.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;

import de.tableDataExtraction.Configuration;

public class Table implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String TAG_TABLE = "table";
	public static final String TAG_TR = "tr";
	public static final String TAG_TH = "th";
	public static final String TAG_TD = "td";

	private Data data;
	private String tableId;
	private HashMap<String, Result> results;
	private Result expectedResult;
	private OriginalDescription originalDescription;

	public Table() {

		data = new Data();
		results = new HashMap<String, Result>();
		expectedResult = new Result();
		originalDescription = new OriginalDescription();
	}

	public Table(String inputContentString, String tableId) {

		this();

		this.tableId = tableId;

		loadData(inputContentString);
		loadExpectedResult();
	}

	private void loadData(String inputContentString) {

		data = new Data(inputContentString);
	}

	private void loadExpectedResult() {

		Gson gson;
		Configuration configuration;
		String expectedResultString;

		expectedResultString = null;
		gson = new Gson();
		configuration = Configuration.getInstance();

		try {

			expectedResultString = readFile(configuration
					.getExpectedResultsPath()
					+ tableId
					+ Configuration.RESULT_FILE_EXTENSION);

			expectedResult = gson.fromJson(expectedResultString, Result.class);

		} catch (IOException e) {

			// This can happen if we do not have an expected result

			expectedResult = null;
		}
	}

	public void save() {

		saveExpectedResult();
		saveResult();
	}

	private void saveExpectedResult() {

		if (expectedResult != null) {

			String expectedResultString;
			Gson gson;

			gson = new Gson();
			expectedResultString = gson.toJson(expectedResult);

			try {
				writeFile(Configuration.getInstance().getExpectedResultsPath()
						+ tableId + Configuration.RESULT_FILE_EXTENSION,
						expectedResultString);

			} catch (IOException e) {
				// This should not happen, as we already test for null values
				e.printStackTrace();
			}
		}
	}

	private void saveResult() {

		// ExportedResult exportedResult;
		// Result result;
		Gson gson;
		String exportedResultString;
		Configuration configuration;

		// Change in final version to use best result
		// result = expectedResult;

		// if (result != null) {
		// exportedResult = new ExportedResult(tableId, data, result,
		// originalDescription);
		gson = new Gson();
		exportedResultString = gson.toJson(this);
		configuration = Configuration.getInstance();

		try {
			writeFile(configuration.getResultsPath() + tableId
					+ Configuration.RESULT_FILE_EXTENSION, exportedResultString);

		} catch (IOException e) {
			// This should not happen, as we already test for null values
			e.printStackTrace();
		}
		// }
	}

	private void writeFile(String path, String content) throws IOException {

		FileUtils.writeStringToFile(new File(path), content);
	}

	private String readFile(String path) throws IOException {

		String result = "";

		File file = new File(path);
		result = FileUtils.readFileToString(file);

		return result;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public HashMap<Integer, Row> getRows() {
		return data.getRows();
	}

	public void setRows(HashMap<Integer, Row> rows) {
		data.setRows(rows);
	}

	public HashMap<Integer, Column> getColumns() {
		return data.getColumns();
	}

	public void setColumns(HashMap<Integer, Column> columns) {
		data.setColumns(columns);
	}

	public HashMap<String, Result> getResults() {
		return results;
	}

	public void setResults(HashMap<String, Result> results) {
		this.results = results;
	}

	public Result getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(Result expectedResult) {
		this.expectedResult = expectedResult;
	}

	public OriginalDescription getOriginalDescription() {
		return originalDescription;
	}

	public void setOriginalDescription(OriginalDescription originalDescription) {
		this.originalDescription = originalDescription;
	}

	public String getId() {
		return tableId;
	}

	public void setId(String tableId) {
		this.tableId = tableId;
	}
}