package de.tableDataExtraction.approaches.classifierFeatures;

import de.tableDataExtraction.approaches.classifier.Classifier;
import de.tableDataExtraction.approaches.classifier.Feature;

public class ClassifierDecisionTreeGainRatio implements Classifier {

	@Override
	public boolean classifyRow(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() > 0.125
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfIndex() > 2.062
				&& features.getPercentageOfIndex() > 6.562) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() > 0.125
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfIndex() > 2.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() > 5.500) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() > 0.125
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfIndex() > 2.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() <= 5.500
				&& features.getPercentageOfIndex() > 2.625) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() > 0.125
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfIndex() > 2.062
				&& features.getPercentageOfIndex() <= 6.562
				&& features.getPercentageOfIndex() <= 5.500
				&& features.getPercentageOfIndex() <= 2.625) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() > 0.125
				&& features.getSdNumberOfCharacters() > 1.206
				&& features.getPercentageOfIndex() <= 2.062) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() > 0.125
				&& features.getSdNumberOfCharacters() <= 1.206) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.612
				&& features.getPercentageOfNumericCells() <= 0.125) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() > 0.090
				&& features.getPercentageOfIndex() > 3.750) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() > 0.090
				&& features.getPercentageOfIndex() <= 3.750) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() > 12.523) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getSdNumberOfLetters() > 4.296) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() > 7.500
				&& features.getSdNumberOfLetters() <= 4.296) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() > 0.225
				&& features.getLength() <= 7.500) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() > 13.250) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() <= 13.250
				&& features.getPercentageOfCellsWithStyleClass() > 0.500
				&& features.getSdNumberOfCharacters() > 11.750) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() <= 13.250
				&& features.getPercentageOfCellsWithStyleClass() > 0.500
				&& features.getSdNumberOfCharacters() <= 11.750
				&& features.getAvgNumberOfNumbers() > 3.125) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() <= 13.250
				&& features.getPercentageOfCellsWithStyleClass() > 0.500
				&& features.getSdNumberOfCharacters() <= 11.750
				&& features.getAvgNumberOfNumbers() <= 3.125
				&& features.getAvgNumberOfCharacters() > 12.750) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() <= 13.250
				&& features.getPercentageOfCellsWithStyleClass() > 0.500
				&& features.getSdNumberOfCharacters() <= 11.750
				&& features.getAvgNumberOfNumbers() <= 3.125
				&& features.getAvgNumberOfCharacters() <= 12.750
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.375) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() <= 13.250
				&& features.getPercentageOfCellsWithStyleClass() > 0.500
				&& features.getSdNumberOfCharacters() <= 11.750
				&& features.getAvgNumberOfNumbers() <= 3.125
				&& features.getAvgNumberOfCharacters() <= 12.750
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.375) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() > 6.625
				&& features.getAvgNumberOfCharacters() <= 13.250
				&& features.getPercentageOfCellsWithStyleClass() <= 0.500) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() > 0.944
				&& features.getAvgNumberOfLetters() <= 6.625) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() > 0.477
				&& features.getAvgNumberOfWords() > 1.929) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() > 0.477
				&& features.getAvgNumberOfWords() <= 1.929) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() <= 0.477
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.028) {
			return false;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() <= 0.477
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.028
				&& features.getPercentageOfBlankCells() > 0.225) {
			return true;
		}
		if (features.getPercentageOfIndex() > 0.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.612
				&& features.getPercentageOfCellsContainingCountry() <= 0.090
				&& features.getPercentageOfIndex() <= 12.523
				&& features.getPercentageOfCellsAllCapitalised() <= 0.225
				&& features.getPercentageOfCellsWithInlineStyle() <= 0.944
				&& features.getPercentageOfBlankCells() <= 0.477
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.028
				&& features.getPercentageOfBlankCells() <= 0.225) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() > 0.033
				&& features.getPercentageOfIndex() > 0.062) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() > 0.033
				&& features.getPercentageOfIndex() <= 0.062
				&& features.getPercentageOfBlankCells() > 0.083) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() > 0.033
				&& features.getPercentageOfIndex() <= 0.062
				&& features.getPercentageOfBlankCells() <= 0.083) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() > 0.388
				&& features.getSdNumberOfNumbers() > 0.436) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() > 0.388
				&& features.getSdNumberOfNumbers() <= 0.436
				&& features.getAvgNumberOfWords() > 1.250) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() > 0.388
				&& features.getSdNumberOfNumbers() <= 0.436
				&& features.getAvgNumberOfWords() <= 1.250
				&& features.getLength() > 12) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() > 0.388
				&& features.getSdNumberOfNumbers() <= 0.436
				&& features.getAvgNumberOfWords() <= 1.250
				&& features.getLength() <= 12) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() > 5.323) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() > 2.446) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() > 17) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() > 0.268
				&& features.getLength() > 8) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() > 0.268
				&& features.getLength() <= 8) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.804) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.804
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.675) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.804
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.675
				&& features.getSdNumberOfWords() > 0.517) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.804
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.675
				&& features.getSdNumberOfWords() <= 0.517
				&& features.getAvgNumberOfCharacters() > 3.625) {
			return false;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() > 0.101
				&& features.getSdNumberOfNumbers() <= 2.446
				&& features.getLength() <= 17
				&& features.getPercentageOfNumericCells() <= 0.268
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.804
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.675
				&& features.getSdNumberOfWords() <= 0.517
				&& features.getAvgNumberOfCharacters() <= 3.625) {
			return true;
		}
		if (features.getPercentageOfIndex() <= 0.523
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.033
				&& features.getPercentageOfIndex() <= 0.388
				&& features.getSdNumberOfNumbers() <= 5.323
				&& features.getPercentageOfIndex() <= 0.101) {
			return true;
		}

		return false;
	}

	@Override
	public boolean classifyColumn(Feature featuresInterface) {

		FeatureImplementation features = (FeatureImplementation) featuresInterface;

		if (features.getPercentageOfCellsContainingCountryNames() > 0.137) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() > 2.551) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() > 0.004
				&& features.getAvgNumberOfLetters() <= 2.551) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() > 0.068
				&& features.getPercentageOfCellsContainingCountryNames() > 0.092) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() > 0.068
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.092) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() > 0.042
				&& features.getAvgNumberOfCharacters() > 2.832
				&& features.getLength() > 40.500) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() > 0.042
				&& features.getAvgNumberOfCharacters() > 2.832
				&& features.getLength() <= 40.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() > 0.042
				&& features.getAvgNumberOfCharacters() <= 2.832) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() > 0.894
				&& features.getAvgNumberOfPunctuationMarks() <= 0.042) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() > 1.002) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() <= 1.002
				&& features.getSdNumberOfCharacters() > 2.016
				&& features.getSdNumberOfCharacters() > 2.302) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() <= 1.002
				&& features.getSdNumberOfCharacters() > 2.016
				&& features.getSdNumberOfCharacters() <= 2.302) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() > 0.001
				&& features.getPercentageOfCellsContainingCountryNames() <= 0.068
				&& features.getPercentageOfCellsAllCapitalised() <= 0.894
				&& features.getAvgNumberOfWords() <= 1.002
				&& features.getSdNumberOfCharacters() <= 2.016) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() > 48.500) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() <= 48.500
				&& features.getAvgNumberOfWords() > 1.011) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() <= 48.500
				&& features.getAvgNumberOfWords() <= 1.011
				&& features.getLength() > 14) {
			return false;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() > 0.998
				&& features.getPercentageOfIndex() <= 0.001
				&& features.getLength() <= 48.500
				&& features.getAvgNumberOfWords() <= 1.011
				&& features.getLength() <= 14) {
			return true;
		}
		if (features.getPercentageOfCellsContainingCountryNames() <= 0.137
				&& features.getPercentageOfCellsContainingCountry() <= 0.004
				&& features.getPercentageOfCellsStartingWithCapitals() <= 0.998) {
			return false;
		}

		return false;
	}
}