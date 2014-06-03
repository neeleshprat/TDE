package de.tableDataExtraction.approaches.combination;

import java.util.HashMap;

import de.tableDataExtraction.approaches.classifier.Feature;

public enum FeatureCollection {

	// Singleton

	INSTANCE;

	public static FeatureCollection getInstance() {
		return INSTANCE;
	}

	// Class variables

	private HashMap<String, Feature> features;

	// Constructor

	FeatureCollection() {

		features = new HashMap<String, Feature>();
	}

	// Methods

	public HashMap<String, Feature> getFeatures() {
		return features;
	}

	public void setFeatures(HashMap<String, Feature> features) {
		this.features = features;
	}
}