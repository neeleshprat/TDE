package de.tableDataExtraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import de.tableDataExtraction.approaches.ApproachInfo;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.Timer;

public class CrossValidation {

	private ArrayList<Table> tables;
	private ArrayList<Validation> validations;
	private LinkedHashMap<String, Evaluation> evaluations;
	private ArrayList<Evaluation> perfectCombinations;
	private LinkedHashMap<String, Timer> timers;

	public CrossValidation(ArrayList<Table> tables) {

		this.tables = tables;

		validations = new ArrayList<Validation>();
		evaluations = new LinkedHashMap<String, Evaluation>();
		perfectCombinations = new ArrayList<Evaluation>();
		timers = new LinkedHashMap<String, Timer>();
	}

	public void validate(int buckets) {

		for (ApproachInfo approach : ApproachList.getInstance().getApproaches()) {

			Timer timer;

			timer = new Timer();

			timer.setName(approach.getName());
			timers.put(approach.getName(), timer);
		}

		for (int bucket = 1; bucket <= buckets; bucket++) {

			Validation validation = new Validation(tables, timers, buckets,
					bucket);
			validations.add(validation);
		}

		for (Validation validation : validations) {

			validation.validate();
		}
	}

	public void evaluate() {

		// Evaluate all simple approaches

		for (ApproachInfo approachInfo : ApproachList.getInstance()
				.getApproaches()) {

			Evaluation evaluation;
			HashMap<String, Table> tables;

			evaluation = new Evaluation();
			evaluation.setName(approachInfo.getName());

			tables = TableDataExtraction.getInstance().getTables();

			// go over all tables
			for (Table table : tables.values()) {

				Result expectedResult;
				Result result;

				expectedResult = table.getExpectedResult();
				result = table.getResults().get(approachInfo.getName());

				evaluation.add(table.getId(), expectedResult.equals(result));
			}

			evaluations.put(approachInfo.getName(), evaluation);
		}

		// computePerfectPairCombinations();

		computeAllPerfectCombinations();
	}

	private void computeAllPerfectCombinations() {

		// Compute results for combinations of all approaches

		ArrayList<String> combinations = new ArrayList<String>();

		for (ApproachInfo approachInfo : ApproachList.getInstance()
				.getApproaches()) {

			combinations.add(approachInfo.getName());
		}

		computeCombinations("All", combinations);
	}

	private void computePerfectPairCombinations() {

		// Compute results for all combinations of two approaches

		for (ApproachInfo approachToCombine : ApproachList.getInstance()
				.getApproaches()) {

			for (ApproachInfo approachToCombineWith : ApproachList
					.getInstance().getApproaches()) {

				if (!approachToCombine.equals(approachToCombineWith)) {

					ArrayList<String> combinations = new ArrayList<String>();

					combinations.add(approachToCombine.getName());
					combinations.add(approachToCombineWith.getName());

					computeCombinations(approachToCombine.getName() + " and "
							+ approachToCombineWith.getName(), combinations);
				}
			}
		}
	}

	private void computeCombinations(String name, ArrayList<String> approaches) {

		Evaluation evaluation;
		HashMap<String, Table> tables;

		evaluation = new Evaluation();
		evaluation.setName(name);
		tables = TableDataExtraction.getInstance().getTables();

		for (String tableId : tables.keySet()) {

			Table table;
			Boolean resultIsAsExpected;
			Result expectedResult;

			table = tables.get(tableId);
			expectedResult = table.getExpectedResult();

			resultIsAsExpected = isAnyResultAsExpected(table, expectedResult,
					approaches);

			evaluation.add(tableId, resultIsAsExpected);
		}

		perfectCombinations.add(evaluation);
	}

	private Boolean isAnyResultAsExpected(Table table, Result expectedResult,
			ArrayList<String> approaches) {

		for (String approachName : approaches) {

			Result result;

			result = table.getResults().get(approachName);

			if (expectedResult != null) {

				if (expectedResult.equals(result)) {

					return true;
				}
			}
		}

		return false;
	}

	public ArrayList<Table> getTables() {
		return tables;
	}

	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}

	public ArrayList<Validation> getValidations() {
		return validations;
	}

	public void setValidations(ArrayList<Validation> validations) {
		this.validations = validations;
	}

	public LinkedHashMap<String, Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(LinkedHashMap<String, Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public LinkedHashMap<String, Timer> getTimers() {
		return timers;
	}

	public ArrayList<Evaluation> getCombinations() {
		return perfectCombinations;
	}

	public void setCombinations(ArrayList<Evaluation> combinations) {
		this.perfectCombinations = combinations;
	}

	public void setTimers(LinkedHashMap<String, Timer> timers) {
		this.timers = timers;
	}
}