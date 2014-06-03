package de.tableDataExtraction.approaches.classifierStacking;

import de.tableDataExtraction.approaches.classifier.Classifier;
import de.tableDataExtraction.approaches.classifier.Feature;

public class ClassifierDecisionTreeAdditionalFeatures implements Classifier {

	@Override
	public boolean classifyRow(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getResultClassifier() == false
				&& features.getLength() > 7.500
				&& features.getResultFindCountry() == false) {
			return false;
		}
		if (features.getResultClassifier() == false
				&& features.getLength() > 7.500
				&& features.getResultFindCountry() == true) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getLength() <= 7.500
				&& features.getNumberOfCellsContainingCountry() > 1) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getLength() <= 7.500
				&& features.getNumberOfCellsContainingCountry() <= 1
				&& features.getResultFindCrossing() == false) {
			return false;
		}
		if (features.getResultClassifier() == false
				&& features.getLength() <= 7.500
				&& features.getNumberOfCellsContainingCountry() <= 1
				&& features.getResultFindCrossing() == true
				&& features.getLength() > 3.500) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getLength() <= 7.500
				&& features.getNumberOfCellsContainingCountry() <= 1
				&& features.getResultFindCrossing() == true
				&& features.getLength() <= 3.500) {
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
				&& features.getNumberOfCellsContainingCountry() > 1.500) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() > 181.500) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() <= 181.500
				&& features.getPercentageOfCellsContainingCountry() > 0.094) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() <= 181.500
				&& features.getPercentageOfCellsContainingCountry() <= 0.094
				&& features.getPercentageOfCellsContainingCountryNames() > 0.644
				&& features.getLength() > 18) {
			return false;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() <= 181.500
				&& features.getPercentageOfCellsContainingCountry() <= 0.094
				&& features.getPercentageOfCellsContainingCountryNames() > 0.644
				&& features.getLength() <= 18) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() <= 181.500
				&& features.getPercentageOfCellsContainingCountry() <= 0.094
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.644
				&& features.getPercentageOfCellsContainingCountry() > 0.010
				&& features.getLength() > 45) {
			return true;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() <= 181.500
				&& features.getPercentageOfCellsContainingCountry() <= 0.094
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.644
				&& features.getPercentageOfCellsContainingCountry() > 0.010
				&& features.getLength() <= 45) {
			return false;
		}
		if (features.getResultClassifier() == false
				&& features.getNumberOfCellsContainingCountry() <= 1.500
				&& features.getNumberOfCellsContainingCountryNames() <= 181.500
				&& features.getPercentageOfCellsContainingCountry() <= 0.094
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.644
				&& features.getPercentageOfCellsContainingCountry() <= 0.010) {
			return false;
		}
		if (features.getResultClassifier() == true) {
			return true;
		}

		return false;
	}
}