package de.tableDataExtraction.approaches.combination;

import java.util.ArrayList;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.approaches.classifier.Feature;
import de.tableDataExtraction.model.CsvWriter;
import de.tableDataExtraction.model.Table;

public class ApproachCombination implements Approach {

	private static final String FILE_NAME = "approachCombinationFeatures.csv";

	private final SettingsCombination settings;
	private final FeatureGenerator featureGenerator;
	private final FeatureCollection featureCollection;

	public ApproachCombination(ApproachSettings settings) {

		this.settings = (SettingsCombination) settings;
		featureGenerator = new FeatureGenerator(this.settings);
		featureCollection = FeatureCollection.getInstance();
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		if (settings.isLearn()) {

			CsvWriter csvWriter;

			csvWriter = new CsvWriter();

			for (Table table : learnDataset) {

				// we have to ALWAYS overwrite the previous results, as some
				// table were not processed yet!

				Feature feature;

				feature = featureGenerator.computeFeatures(table);

				featureCollection.getFeatures().put(table.getId(), feature);
			}

			csvWriter
					.write(FILE_NAME, featureCollection.getFeatures().values());
		}
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {

		// TODO implement
	}
}
