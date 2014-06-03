package de.tableDataExtraction.approaches.classifierFeatures;

import java.util.HashMap;

import de.tableDataExtraction.approaches.classifier.Feature;

public enum FeatureCollection {

	// Singleton

	INSTANCE;

	public static FeatureCollection getInstance() {
		return INSTANCE;
	}

	// Class variables

	private HashMap<String, Feature> rowFeatures;
	private HashMap<String, Feature> columnFeatures;

	// Constructor

	FeatureCollection() {

		rowFeatures = new HashMap<String, Feature>();
		columnFeatures = new HashMap<String, Feature>();
	}

	// Methods

	public HashMap<String, Feature> getRowFeatures() {
		return rowFeatures;
	}

	public void setRowFeatures(HashMap<String, Feature> rowFeatures) {
		this.rowFeatures = rowFeatures;
	}

	public HashMap<String, Feature> getColumnFeatures() {
		return columnFeatures;
	}

	public void setColumnFeatures(HashMap<String, Feature> columnFeatures) {
		this.columnFeatures = columnFeatures;
	}
}