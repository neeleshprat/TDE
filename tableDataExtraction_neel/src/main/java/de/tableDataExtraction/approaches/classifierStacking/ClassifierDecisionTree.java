package de.tableDataExtraction.approaches.classifierStacking;

import de.tableDataExtraction.approaches.classifier.Classifier;
import de.tableDataExtraction.approaches.classifier.Feature;

public class ClassifierDecisionTree implements Classifier {

	@Override
	public boolean classifyRow(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getResultClassifier() == false) {
			return false;
		}
		if (features.getResultClassifier() == true) {
			return true;
		}

		return false;
	}

	@Override
	public boolean classifyColumn(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getResultClassifier() == false
				&& features.getResultFindCountry() == false) {
			return false;
		}
		if (features.getResultClassifier() == false
				&& features.getResultFindCountry() == true
				&& features.getResultTengli() == false) {
			return false;
		}
		if (features.getResultClassifier() == false
				&& features.getResultFindCountry() == true
				&& features.getResultTengli() == true) {
			return true;
		}
		if (features.getResultClassifier() == true) {
			return true;
		}

		return false;
	}
}