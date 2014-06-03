package de.tableDataExtraction;

import java.util.ArrayList;

import de.tableDataExtraction.model.TableEvaluation;

public class Evaluation {

	private String name;

	private int correctTables;
	private int wrongTables;

	private int correctTablesPercent;
	private int wrongTablesPercent;

	private ArrayList<TableEvaluation> perTableEvaluation;

	public Evaluation() {

		perTableEvaluation = new ArrayList<TableEvaluation>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCorrectTables() {
		return correctTables;
	}

	public void setCorrectTables(int correctTables) {
		this.correctTables = correctTables;
	}

	public int getWrongTables() {
		return wrongTables;
	}

	public void setWrongTables(int wrongTables) {
		this.wrongTables = wrongTables;
	}

	public int getCorrectTablesPercent() {
		return correctTablesPercent;
	}

	public int getWrongTablesPercent() {
		return wrongTablesPercent;
	}

	private void computePercentages() {

		float wrong = (((float) wrongTables) / (wrongTables + correctTables)) * 100;
		float correct = (((float) correctTables) / (wrongTables + correctTables)) * 100;

		wrongTablesPercent = Math.round(wrong);
		correctTablesPercent = Math.round(correct);
	}

	public void add(String tableId, boolean result) {

		perTableEvaluation.add(new TableEvaluation(tableId, result));

		if (result) {

			correctTables++;

		} else {

			wrongTables++;
		}

		computePercentages();
	}

	public ArrayList<TableEvaluation> getPerTableEvaluation() {
		return perTableEvaluation;
	}

	public void setPerTableEvaluation(
			ArrayList<TableEvaluation> perTableEvaluation) {
		this.perTableEvaluation = perTableEvaluation;
	}
}