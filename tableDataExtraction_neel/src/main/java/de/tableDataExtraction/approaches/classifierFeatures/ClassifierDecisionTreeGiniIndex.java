package de.tableDataExtraction.approaches.classifierFeatures;

import de.tableDataExtraction.approaches.classifier.Classifier;
import de.tableDataExtraction.approaches.classifier.Feature;

public class ClassifierDecisionTreeGiniIndex implements Classifier {

	@Override
	public boolean classifyRow(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() > 6.562) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 1.625
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfBlankCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.375
				&& features.getPercentageOfIndex() > 3.750
				&& features.getPercentageOfIndex() > 5.812) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 1.625
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfBlankCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.375
				&& features.getPercentageOfIndex() > 3.750
				&& features.getPercentageOfIndex() <= 5.812) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 1.625
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfBlankCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.375
				&& features.getPercentageOfIndex() <= 3.750) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 1.625
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfBlankCells() > 0.062
				&& features.getAvgNumberOfCharacters() <= 3.375) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 1.625
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfBlankCells() <= 0.062) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 1.625
				&& features.getSdNumberOfCharacters() <= 1.206) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() > 3.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() <= 1.625) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() > 0.062
				&& features.getAvgNumberOfCharacters() <= 3.062) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfNumericCells() <= 0.062) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() <= 7.500) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() > 0.090
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfIndex() > 3.750) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() > 0.090
				&& features.getHasStyleClass() == false
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfIndex() <= 3.750) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getSdNumberOfNumbers() > 2.260
				&& features.getHasStyleClass() == false
				&& features.getAvgNumberOfNumbers() > 3.125) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getSdNumberOfNumbers() > 2.260
				&& features.getHasStyleClass() == false
				&& features.getAvgNumberOfNumbers() <= 3.125
				&& features.getHasInlineStyle() == false
				&& features.getAvgNumberOfCharacters() > 12.750) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getSdNumberOfNumbers() > 2.260
				&& features.getHasStyleClass() == false
				&& features.getAvgNumberOfNumbers() <= 3.125
				&& features.getHasInlineStyle() == false
				&& features.getAvgNumberOfCharacters() <= 12.750) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getSdNumberOfNumbers() <= 2.260
				&& features.getPercentageOfIndex() > 2.325) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getSdNumberOfNumbers() <= 2.260
				&& features.getPercentageOfIndex() <= 2.325
				&& features.getPercentageOfIndex() > 2.188) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getSdNumberOfNumbers() <= 2.260
				&& features.getPercentageOfIndex() <= 2.325
				&& features.getPercentageOfIndex() <= 2.188) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() > 0.477
				&& features.getHasInlineStyle() == false
				&& features.getAvgNumberOfNumbers() > 1.386
				&& features.getHasStyleClass() == false
				&& features.getPercentageOfNumericCells() > 0.125) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() > 0.477
				&& features.getHasInlineStyle() == false
				&& features.getAvgNumberOfNumbers() > 1.386
				&& features.getHasStyleClass() == false
				&& features.getPercentageOfNumericCells() <= 0.125) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() > 0.477
				&& features.getHasInlineStyle() == false
				&& features.getAvgNumberOfNumbers() <= 1.386) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() <= 0.477
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.028) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() <= 0.477
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.028
				&& features.getPercentageOfBlankCells() > 0.225) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() <= 0.477
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.028
				&& features.getPercentageOfBlankCells() <= 0.225) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() > 0.033
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfIndex() > 0.062) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() > 0.033
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfIndex() <= 0.062
				&& features.getHasStyleClass() == false
				&& features.getPercentageOfBlankCells() > 0.083) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() > 0.033
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfIndex() <= 0.062
				&& features.getHasStyleClass() == false
				&& features.getPercentageOfBlankCells() <= 0.083) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() > 5.323) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() > 0.268) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsAllCapitalised() > 0.417) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsAllCapitalised() <= 0.417
				&& features.getAvgNumberOfWords() > 1.310
				&& features.getHasStyleClass() == false) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsAllCapitalised() <= 0.417
				&& features.getAvgNumberOfWords() > 1.310
				&& features.getHasStyleClass() == true
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.875) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsAllCapitalised() <= 0.417
				&& features.getAvgNumberOfWords() > 1.310
				&& features.getHasStyleClass() == true
				&& features.getHasInlineStyle() == false
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.875) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsAllCapitalised() <= 0.417
				&& features.getAvgNumberOfWords() <= 1.310
				&& features.getHasInlineStyle() == false
				&& features.getSdNumberOfLetters() > 3.994) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.211
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsAllCapitalised() <= 0.417
				&& features.getAvgNumberOfWords() <= 1.310
				&& features.getHasInlineStyle() == false
				&& features.getSdNumberOfLetters() <= 3.994) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() <= 0.211
				&& features.getPercentageOfIndex() > 0.101
				&& features.getLength() > 17) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() <= 0.211
				&& features.getPercentageOfIndex() > 0.101
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() > 0.214
				&& features.getHasInlineStyle() == false
				&& features.getLength() > 8) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() <= 0.211
				&& features.getPercentageOfIndex() > 0.101
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() > 0.214
				&& features.getHasInlineStyle() == false
				&& features.getLength() <= 8) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() <= 0.211
				&& features.getPercentageOfIndex() > 0.101
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() <= 0.214) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() <= 0.211
				&& features.getPercentageOfIndex() <= 0.101) {
			return true;
		}

		return false;
	}

	@Override
	public boolean classifyColumn(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() > 1.541) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() > 463.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() > 0.833) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() > 0.825) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() > 4.864
				&& features.getLength() > 27.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() > 4.864
				&& features.getLength() <= 27.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() > 0.022
				&& features.getPercentageOfCellsWithStyleClass() > 0.042
				&& features.getPercentageOfCellsWithColspan() > 0.020) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() > 0.022
				&& features.getPercentageOfCellsWithStyleClass() > 0.042
				&& features.getPercentageOfCellsWithColspan() <= 0.020
				&& features.getPercentageOfCellsWithStyleClass() > 0.973) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() > 0.022
				&& features.getPercentageOfCellsWithStyleClass() > 0.042
				&& features.getPercentageOfCellsWithColspan() <= 0.020
				&& features.getPercentageOfCellsWithStyleClass() <= 0.973
				&& features.getLength() > 25.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() > 0.022
				&& features.getPercentageOfCellsWithStyleClass() > 0.042
				&& features.getPercentageOfCellsWithColspan() <= 0.020
				&& features.getPercentageOfCellsWithStyleClass() <= 0.973
				&& features.getLength() <= 25.500
				&& features.getPercentageOfBlankCells() > 0.033) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() > 0.022
				&& features.getPercentageOfCellsWithStyleClass() > 0.042
				&& features.getPercentageOfCellsWithColspan() <= 0.020
				&& features.getPercentageOfCellsWithStyleClass() <= 0.973
				&& features.getLength() <= 25.500
				&& features.getPercentageOfBlankCells() <= 0.033) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() > 0.022
				&& features.getPercentageOfCellsWithStyleClass() <= 0.042) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() > 0.021) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() > 0.021) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() > 0.655
				&& features.getPercentageOfIndex() > 0.006
				&& features.getAvgNumberOfLetters() > 8.995
				&& features.getSdNumberOfWords() > 0.547) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() > 0.655
				&& features.getPercentageOfIndex() > 0.006
				&& features.getAvgNumberOfLetters() > 8.995
				&& features.getSdNumberOfWords() <= 0.547) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() > 0.655
				&& features.getPercentageOfIndex() > 0.006
				&& features.getAvgNumberOfLetters() <= 8.995) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() > 0.655
				&& features.getPercentageOfIndex() <= 0.006
				&& features.getLength() > 173.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() > 0.655
				&& features.getPercentageOfIndex() <= 0.006
				&& features.getLength() <= 173.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.655
				&& features.getPercentageOfCellsContainingCountryNames() > 0.620) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.655
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.620
				&& features.getLength() > 28.500
				&& features.getLength() > 67.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.655
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.620
				&& features.getLength() > 28.500
				&& features.getLength() <= 67.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.655
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.620
				&& features.getLength() <= 28.500
				&& features.getPercentageOfIndex() > 0.119) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.655
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.620
				&& features.getLength() <= 28.500
				&& features.getPercentageOfIndex() <= 0.119
				&& features.getPercentageOfIndex() > 0.072) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() > 0.004
				&& features.getPercentageOfCellsWithStyleClass() <= 0.022
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountry() <= 0.021
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.655
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.620
				&& features.getLength() <= 28.500
				&& features.getPercentageOfIndex() <= 0.119
				&& features.getPercentageOfIndex() <= 0.072) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() > 3.500
				&& features.getPercentageOfIndex() <= 0.004) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() > 0.004
				&& features.getLength() <= 3.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() <= 0.004
				&& features.getPercentageOfCellsContainingCountryNames() > 0.464) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() <= 0.004
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.464
				&& features.getPercentageOfCellsContainingCountryNames() > 0.417) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() > 0.137
				&& features.getLength() <= 463.500
				&& features.getPercentageOfCellsWithRowspan() <= 0.833
				&& features.getPercentageOfIndex() <= 0.825
				&& features.getAvgNumberOfWords() <= 4.864
				&& features.getPercentageOfIndex() <= 0.004
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.464
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.417) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getLength() > 43.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getLength() <= 43.500
				&& features.getLength() > 10.500
				&& features.getSdNumberOfCharacters() > 1.397
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.976) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getLength() <= 43.500
				&& features.getLength() > 10.500
				&& features.getSdNumberOfCharacters() > 1.397
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.976) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getLength() <= 43.500
				&& features.getLength() > 10.500
				&& features.getSdNumberOfCharacters() <= 1.397) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.468
				&& features.getAvgNumberOfPunctuationMarks() <= 1.541
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getLength() <= 43.500
				&& features.getLength() <= 10.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() > 0.073
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.468) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() > 2.551
				&& features.getLength() > 17.500
				&& features.getAvgNumberOfNumbers() > 1.501
				&& features.getLength() > 65) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() > 2.551
				&& features.getLength() > 17.500
				&& features.getAvgNumberOfNumbers() > 1.501
				&& features.getLength() <= 65) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() > 2.551
				&& features.getLength() > 17.500
				&& features.getAvgNumberOfNumbers() <= 1.501) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() > 2.551
				&& features.getLength() <= 17.500
				&& features.getLength() > 3.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() > 2.551
				&& features.getLength() <= 17.500
				&& features.getLength() <= 3.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() <= 2.551) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() > 0.042
				&& features.getAvgNumberOfCharacters() > 2.832
				&& features.getLength() > 40.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() > 0.042
				&& features.getAvgNumberOfCharacters() > 2.832
				&& features.getLength() <= 40.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() > 0.042
				&& features.getAvgNumberOfCharacters() <= 2.832) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() <= 0.042) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() > 1.002) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() <= 1.002
				&& features.getSdNumberOfCharacters() > 2.016
				&& features.getSdNumberOfCharacters() > 2.302) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() <= 1.002
				&& features.getSdNumberOfCharacters() > 2.016
				&& features.getSdNumberOfCharacters() <= 2.302) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() <= 1.002
				&& features.getSdNumberOfCharacters() <= 2.016) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() > 48.500
				&& features.getSdNumberOfPunctuationMarks() > 0.473
				&& features.getAvgNumberOfWords() > 2.695) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() > 48.500
				&& features.getSdNumberOfPunctuationMarks() > 0.473
				&& features.getAvgNumberOfWords() <= 2.695) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() > 48.500
				&& features.getSdNumberOfPunctuationMarks() <= 0.473) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() <= 48.500
				&& features.getAvgNumberOfWords() > 1.011) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() <= 48.500
				&& features.getAvgNumberOfWords() <= 1.011) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.073
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.998) {
			return false;
		}

		return false;
	}
}