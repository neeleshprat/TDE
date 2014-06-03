package de.tableDataExtraction.approaches.baseline;

import java.util.ArrayList;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Table;

public class ApproachAlwaysEmpty implements Approach {

	private final SettingsAlwaysEmpty settings;

	public ApproachAlwaysEmpty(ApproachSettings settings) {

		this.settings = (SettingsAlwaysEmpty) settings;
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
		}
	}
}