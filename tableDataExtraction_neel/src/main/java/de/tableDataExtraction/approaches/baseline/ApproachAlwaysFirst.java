package de.tableDataExtraction.approaches.baseline;

import java.util.ArrayList;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Table;

public class ApproachAlwaysFirst implements Approach {

	private final SettingsAlwaysFirst settings;

	public ApproachAlwaysFirst(ApproachSettings settings) {

		this.settings = (SettingsAlwaysFirst) settings;
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
			result.getColumns().put(0, true);
			result.getRows().put(0, true);

			table.getResults().put(settings.getName(), result);
		}
	}
}