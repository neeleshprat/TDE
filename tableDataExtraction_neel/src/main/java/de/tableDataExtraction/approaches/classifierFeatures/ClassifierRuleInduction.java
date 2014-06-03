package de.tableDataExtraction.approaches.classifierFeatures;

import de.tableDataExtraction.approaches.classifier.Classifier;
import de.tableDataExtraction.approaches.classifier.Feature;

public class ClassifierRuleInduction implements Classifier {

	@Override
	public boolean classifyRow(Feature feature) {

		FeatureImplementation features = (FeatureImplementation) feature;

		if (features.getPercentageOfIndex() > 0.441
				&& features.getPercentageOfIndex() > 6.382) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.354
				&& features.getPercentageOfIndex() <= 0.073) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.441
				&& features.getSdNumberOfNumbers() > 1.419
				&& features.getSdNumberOfNumbers() > 2.464) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.441
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getSdNumberOfNumbers() > 0.481
				&& features.getAvgNumberOfWords() <= 1.236) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.829) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.441
				&& features.getSdNumberOfWords() > 0.358
				&& features.getAvgNumberOfCharacters() > 6.792
				&& features.getSdNumberOfNumbers() <= 2.440) {
			return false;
		}
		if (features.getPercentageOfBlankCells() > 0.118
				&& features.getPercentageOfIndex() <= 0.550
				&& features.getLength() > 15.500) {
			return true;
		}
		if (features.getAvgNumberOfWords() > 1.414
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.036
				&& features.getPercentageOfIndex() <= 0.545
				&& features.getAvgNumberOfPunctuationMarks() <= 0.500) {
			return true;
		}
		if (features.getPercentageOfCellsAllCapitalised() <= 0.208
				&& features.getAvgNumberOfWords() <= 1.732
				&& features.getAvgNumberOfLetters() > 2.586
				&& features.getHasInlineStyle() == false) {
			return false;
		}
		if (features.getAvgNumberOfCharacters() > 3.612
				&& features.getLength() > 7.500
				&& features.getLength() <= 9.500
				&& features.getAvgNumberOfCharacters() > 6.312
				&& features.getPercentageOfIndex() <= 5.938) {
			return true;
		}
		if (features.getPercentageOfIndex() > 2.062
				&& features.getSdNumberOfNumbers() > 1.171
				&& features.getAvgNumberOfWords() > 1.062
				&& features.getSdNumberOfCharacters() <= 5.192) {
			return true;
		}
		if (features.getPercentageOfCellsStartingWithCapitals() <= 0.646
				&& features.getPercentageOfIndex() > 2.062
				&& features.getAvgNumberOfCharacters() > 3.562
				&& features.getPercentageOfIndex() <= 4.312
				&& features.getAvgNumberOfCharacters() <= 6.062
				&& features.getPercentageOfIndex() > 2.938) {
			return true;
		}
		if (features.getPercentageOfCellsStartingWithCapitals() > 0.646) {
			return false;
		}
		if (features.getSdNumberOfCharacters() <= 2.630
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getSdNumberOfLetters() > 2.267
				&& features.getSdNumberOfLetters() <= 2.575) {
			return true;
		}
		if (features.getAvgNumberOfPunctuationMarks() > 0.268) {
			return false;
		}
		if (features.getPercentageOfCellsStartingWithCapitals() > 0.612
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfIndex() > 2.188) {
			return true;
		}
		if (features.getPercentageOfCellsWithInlineStyle() <= 0.071
				&& features.getHasInlineStyle() == false) {
			return false;
		}
		if (features.getPercentageOfNumericCells() <= 0.333) {
			return true;
		}

		return false;
	}

	@Override
	public boolean classifyColumn(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getPercentageOfCellsContainingCountryNames() <= 0.066
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getAvgNumberOfNumbers() > 0.020) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.146
				&& features.getPercentageOfCellsContainingCountryNames() > 0.681) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getPercentageOfCellsContainingCountryNames() > 0.010) {
			return true;
		}
		if (features.getAvgNumberOfLetters() <= 4.780
				&& features.getAvgNumberOfLetters() <= 2.947) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.002
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() <= 0.651
				&& features.getAvgNumberOfWords() > 1.343) {
			return false;
		}
		if (features.getAvgNumberOfLetters() > 8.239
				&& features.getAvgNumberOfCharacters() <= 13.036
				&& features.getPercentageOfIndex() <= 0.005
				&& features.getLength() > 38.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getPercentageOfIndex() > 0.134
				&& features.getPercentageOfIndex() <= 0.232) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountry() <= 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.240
				&& features.getPercentageOfCellsAllCapitalised() <= 0.651
				&& features.getAvgNumberOfCharacters() <= 6.734) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountry() > 0.001
				&& features.getSdNumberOfPunctuationMarks() > 0.429) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountry() > 0.003
				&& features.getAvgNumberOfPunctuationMarks() <= 0.098
				&& features.getSdNumberOfCharacters() > 3.164) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.203
				&& features.getLength() <= 30.500
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.614
				&& features.getAvgNumberOfWords() <= 1.326) {
			return true;
		}
		if (features.getLength() > 169.500) {
			return false;
		}
		if (features.getAvgNumberOfCharacters() > 11.906
				&& features.getLength() <= 65) {
			return false;
		}
		if (features.getAvgNumberOfCharacters() > 9.690
				&& features.getLength() <= 35
				&& features.getSdNumberOfCharacters() > 2.884) {
			return true;
		}
		if (features.getLength() <= 63
				&& features.getAvgNumberOfCharacters() > 6.808) {
			return false;
		}
		if (features.getSdNumberOfCharacters() <= 1.832
				&& features.getAvgNumberOfCharacters() <= 3.849
				&& features.getPercentageOfCellsAllCapitalised() <= 0.978) {
			return true;
		}
		if (features.getPercentageOfCellsAllCapitalised() <= 0.015
				&& features.getPercentageOfCellsAllCapitalised() > 0.003) {
			return true;
		}
		if (features.getAvgNumberOfCharacters() <= 6.688) {
			return false;
		}
		if (features.getLength() <= 82
				&& features.getPercentageOfIndex() > 0.098) {
			return true;
		}
		if (features.getLength() <= 82
				&& features.getPercentageOfIndex() <= 0.015
				&& features.getHasStyleClass() == false) {
			return true;
		}
		if (features.getHasStyleClass() == false) {
			return false;
		}

		return false;
	}
}