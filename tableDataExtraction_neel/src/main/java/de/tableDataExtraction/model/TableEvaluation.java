package de.tableDataExtraction.model;

public class TableEvaluation {

	private String name;
	private boolean result;

	public TableEvaluation() {

		// nothing
	}

	public TableEvaluation(String name, boolean result) {

		this.name = name;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
}