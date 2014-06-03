package de.tableDataExtraction.approaches.classifierFeatures;

import java.util.ArrayList;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.approaches.classifier.Classifier;
import de.tableDataExtraction.approaches.classifier.ClassifierFactory;
import de.tableDataExtraction.approaches.classifier.Feature;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.CsvWriter;
import de.tableDataExtraction.model.Result;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;

public class ApproachClassifierFeatures implements Approach {

	private static final String COLUMN_FILE_NAME = "approachClassifierFeaturesColumnFeatures.csv";
	private static final String ROW_FILE_NAME = "approachClassifierFeaturesRowFeatures.csv";

	private final SettingsClassifierFeatures settings;
	private final FeatureGenerator featureGenerator;
	private final FeatureCollection featureCollection;

	private final Classifier rowClassifier;
	private final Classifier columnClassifier;

	public ApproachClassifierFeatures(ApproachSettings settings) {

		this.settings = (SettingsClassifierFeatures) settings;

		featureGenerator = new FeatureGenerator(this.settings);
		featureCollection = FeatureCollection.getInstance();

		columnClassifier = ClassifierFactory
				.create(getFullClassPath(this.settings.getColumnClassifier()));
		rowClassifier = ClassifierFactory.create(getFullClassPath(this.settings
				.getRowClassifier()));
	}

	private String getFullClassPath(String className) {

		return this.getClass().getPackage().getName() + "." + className;
	}

	@Override
	public void learn(ArrayList<Table> learnDataset) {

		if (settings.isLearn()) {

			CsvWriter csvWriter;

			csvWriter = new CsvWriter();

			for (Table table : learnDataset) {

				learnColumns(table);
				learnRows(table);
			}

			csvWriter.write(COLUMN_FILE_NAME, featureCollection
					.getColumnFeatures().values());
			csvWriter.write(ROW_FILE_NAME, featureCollection.getRowFeatures()
					.values());
		}
	}

	private void learnColumns(Table table) {

		int columnIndex = 0;
		for (Column column : table.getData().getColumns().values()) {

			String columnId;

			columnId = table.getId() + columnIndex;

			if (!featureCollection.getColumnFeatures().containsKey(columnId)) {

				Feature columnFeatures;

				columnFeatures = featureGenerator.computeFeatures(table,
						columnIndex, column);

				featureCollection.getColumnFeatures().put(columnId,
						columnFeatures);
			}

			columnIndex++;
		}
	}

	private void learnRows(Table table) {

		int rowIndex = 0;

		for (Row row : table.getData().getRows().values()) {

			String rowId;

			rowId = table.getId() + rowIndex;

			if (!featureCollection.getColumnFeatures().containsKey(rowId)) {

				Feature rowFeatures;

				rowFeatures = featureGenerator.computeFeatures(table, rowIndex,
						row);

				featureCollection.getRowFeatures().put(rowId, rowFeatures);
			}

			rowIndex++;
		}
	}

	@Override
	public void classify(ArrayList<Table> testDataset) {

		for (Table table : testDataset) {

			Result result;

			result = new Result();
			table.getResults().put(settings.getName(), result);

			findHeaderColumns(table);
			findHeaderRows(table);
		}
	}

	private boolean findHeaderColumns(Table table) {

		boolean foundHeader;

		foundHeader = false;

		int columnIndex = 0;
		for (Column column : table.getData().getColumns().values()) {

			Feature features;
			boolean isHeaderColumn;

			features = featureGenerator.computeFeatures(table, columnIndex,
					column);
			isHeaderColumn = columnClassifier.classifyColumn(features);

			table.getResults().get(settings.getName()).getColumns()
					.put(columnIndex, isHeaderColumn);

			if (settings.isColumnBreakAfterFirst() && !isHeaderColumn
					&& foundHeader) {

				return true;
			}

			if (isHeaderColumn) {

				foundHeader = true;
			}

			columnIndex++;
		}

		return true;
	}

	private boolean findHeaderRows(Table table) {

		boolean foundHeader;

		foundHeader = false;

		int rowIndex = 0;
		for (Row row : table.getData().getRows().values()) {

			Feature features;
			boolean isHeaderRow;

			features = featureGenerator.computeFeatures(table, rowIndex, row);
			isHeaderRow = rowClassifier.classifyRow(features);

			table.getResults().get(settings.getName()).getRows()
					.put(rowIndex, isHeaderRow);

			if (settings.isRowBreakAfterFirst() && !isHeaderRow && foundHeader) {

				return true;
			}

			if (isHeaderRow) {

				foundHeader = true;
			}

			rowIndex++;
		}

		return true;
	}
}
