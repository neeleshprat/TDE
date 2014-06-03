package de.tableDataExtraction;

import java.util.Collection;
import java.util.LinkedHashMap;

import de.tableDataExtraction.approaches.ApproachInfo;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.approaches.baseline.SettingsAlwaysEmpty;
import de.tableDataExtraction.approaches.baseline.SettingsAlwaysFirst;
import de.tableDataExtraction.approaches.chen.SettingsChen;
import de.tableDataExtraction.approaches.classifierFeatures.SettingsClassifierFeatures;
import de.tableDataExtraction.approaches.classifierStacking.SettingsClassifierStacking;
import de.tableDataExtraction.approaches.combination.SettingsCombination;
import de.tableDataExtraction.approaches.findCountry.SettingsFindCountry;
import de.tableDataExtraction.approaches.findCountryNames.SettingsFindCountryNames;
import de.tableDataExtraction.approaches.findCrossing.SettingsFindCrossing;
import de.tableDataExtraction.approaches.findHtmlHeader.SettingsFindHtmlHeader;
import de.tableDataExtraction.approaches.findHtmlStyle.SettingsFindHtmlStyle;
import de.tableDataExtraction.approaches.tengli.SettingsTengli;

public enum ApproachList {

	// Singleton

	INSTANCE;

	public static ApproachList getInstance() {
		return INSTANCE;
	}

	// Class

	private final LinkedHashMap<String, ApproachInfo> approaches;

	ApproachList() {

		approaches = new LinkedHashMap<String, ApproachInfo>();

		// TODO: Write all as config.json files, loop over files to create
		// tests!

		testAllApproachesBestValues();

		// testFindCountryNames();
		// testClassifierFeatures();
		testChen();
		// testFindHtmlStyle();
		// testFindHtmlHeader();
		// testCombinationStacking();
	}

	private void testFindHtmlHeader() {

		put("FindHtmlHeader - Threshold 0.1",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.1//
				));
		put("FindHtmlHeader - Threshold 0.2",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.2//
				));
		put("FindHtmlHeader - Threshold 0.4",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.4//
				));
		put("FindHtmlHeader - Threshold 0.5",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.5//
				));
		put("FindHtmlHeader - Threshold 0.6",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.6//
				));
		put("FindHtmlHeader - Threshold 0.8",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.8//
				));
		put("FindHtmlHeader - Threshold 0.8",
				"findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.8//
				));
	}

	private void testFindHtmlStyle() {

		put("FindHtmlStyle - Column: class, id, style; Row: class, id, style",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						true,//
						true,//
						true,//
						true,//
						true,//
						true,//
						0.9,//
						0.9,//
						0.9//
				));
		put("FindHtmlStyle - Column: class, id; Row: class, id",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						true,//
						true,//
						false,//
						true,//
						true,//
						false,//
						0.9,//
						0.9,//
						0.9//
				));
		put("FindHtmlStyle - Column: class, style; Row: class, style",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						true,//
						false,//
						true,//
						false,//
						true,//
						true,//
						0.9,//
						0.9,//
						0.9//
				));
		put("FindHtmlStyle - Column: id, style; Row: id, style",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						true,//
						false,//
						true,//
						true,//
						0.9,//
						0.9,//
						0.9//
				));
		put("FindHtmlStyle - Column: class; Row: class",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						true,//
						false,//
						false,//
						true,//
						false,//
						false,//
						0.9,//
						0.9,//
						0.9//
				));
		put("FindHtmlStyle - Column: id; Row: id",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.9,//
						0.9,//
						0.9//
				));
		put("FindHtmlStyle - Column: style; Row: style",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.9,//
						0.9,//
						0.9//
				));

		put("FindHtmlStyle - id, threshold = 0.4",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.4,//
						0.4,//
						0.4//
				));
		put("FindHtmlStyle - id, threshold = 0.5",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.5,//
						0.5,//
						0.5//
				));
		put("FindHtmlStyle - id, threshold = 0.6",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.6,//
						0.6,//
						0.6//
				));
		put("FindHtmlStyle - id, threshold = 0.7",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.7,//
						0.7,//
						0.7//
				));
		put("FindHtmlStyle - id, threshold = 0.8",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.8,//
						0.8,//
						0.8//
				));
		put("FindHtmlStyle - id, threshold = 0.9",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						true,//
						false,//
						false,//
						true,//
						false,//
						0.9,//
						0.9,//
						0.9//
				));

		put("FindHtmlStyle - style, theshold = 0.4",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.4,//
						0.4,//
						0.4//
				));
		put("FindHtmlStyle - style, theshold = 0.5",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.5,//
						0.5,//
						0.5//
				));
		put("FindHtmlStyle - style, theshold = 0.6",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.6,//
						0.6,//
						0.6//
				));
		put("FindHtmlStyle - style, theshold = 0.7",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.7,//
						0.7,//
						0.7//
				));
		put("FindHtmlStyle - style, theshold = 0.8",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.8,//
						0.8,//
						0.8//
				));
		put("FindHtmlStyle - style, theshold = 0.9",
				"findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.9,//
						0.9,//
						0.9//
				));
	}

	private void testChen() {

		put("Chen - CountryNames HashSet", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.6,//
						"countryNames.json",//
						false,//
						4//
				));
		put("Chen - CountryNames Levensthein > 4", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.6,//
						"countryNames.json",//
						true,//
						4//
				));
		put("Chen - SurfaceNames > 1000", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.6,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));

		put("Chen - minPercentageOfCountries = 0.1", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.1,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.2", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.2,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.3", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.3,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.4", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.4,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.5", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.5,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.6", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.6,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.7", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.7,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
		put("Chen - minPercentageOfCountries = 0.8", "chen.ApproachChen",
				new SettingsChen(//
						"chenKnownLabels.json",//
						0.8,//
						"countrySurfaceNames_over100.json",//
						false,//
						4//
				));
	}

	private void testAllApproachesBestValues() {

		put("AlwaysFirst", "baseline.ApproachAlwaysFirst",
				new SettingsAlwaysFirst());
		put("AlwaysEmpty", "baseline.ApproachAlwaysEmpty",
				new SettingsAlwaysEmpty());
		put("FindHtmlHeader", "findHtmlHeader.ApproachFindHtmlHeader",
				new SettingsFindHtmlHeader(//
						"th",//
						0.5//
				));
		put("FindHtmlStyle", "findHtmlStyle.ApproachFindHtmlStyle",
				new SettingsFindHtmlStyle(//
						false,//
						false,//
						true,//
						false,//
						false,//
						true,//
						0.9,//
						0.9,//
						0.9//
				));
		put("Tengli", "tengli.ApproachTengli", new SettingsTengli(//
				0.5,//
				2//
				));
		put("Chen", "chen.ApproachChen", new SettingsChen(//
				"chenKnownLabels.json",//
				0.4,//
				"countrySurfaceNames_over100.json",//
				false,//
				4//
				));
		put("FindCrossing", "findCrossing.ApproachFindCrossing",
				new SettingsFindCrossing(//
						2,//
						false,//
						4//
				));
		put("FindCountry", "findCountry.ApproachFindCountry",
				new SettingsFindCountry(//
						"country",//
						false,//
						"countrySynonyms.json"//
				));
		put("FindCountryNames", "findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_over100.json"//
				));
		put("ClassifierFeatures",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true,//
						"ClassifierDecisionTreeGainRatio",//
						"ClassifierDecisionTreeGainRatio"//
				));

		put("ClassifierStacking",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true,//
						"ClassifierDecisionTree",//
						"ClassifierDecisionTree"//
				));
		put("Combination", "combination.ApproachCombination",
				new SettingsCombination(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true//
				));
	}

	private void testCombinationStacking() {

		put("Stacking - DefaultTree - Stop after first non-header for rows and columns",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countryNames.json",//
						true,//
						true,//
						"ClassifierDecisionTree",//
						"ClassifierDecisionTree"//
				));
		put("Stacking - DefaultTree - Stop after first non-header for rows",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countryNames.json",//
						true,//
						false,//
						"ClassifierDecisionTree",//
						"ClassifierDecisionTree"//
				));
		put("Stacking - DefaultTree - Stop after first non-header for columns",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countryNames.json",//
						false,//
						true,//
						"ClassifierDecisionTree",//
						"ClassifierDecisionTree"//
				));
		put("Stacking - DefaultTree - Evaluate all rows and columns",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countryNames.json",//
						false,//
						false,//
						"ClassifierDecisionTree",//
						"ClassifierDecisionTree"//
				));

		put("Stacking - DefaultTreeAdditionalFeatures - Stop after first non-header for rows and columns",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countryNames.json",//
						true,//
						true,//
						"ClassifierDecisionTreeAdditionalFeatures",//
						"ClassifierDecisionTreeAdditionalFeatures"//
				));
		put("Stacking - DefaultTreeAdditionalFeatures - Stop after first non-header for rows",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"countryNames.json",//
						true,//
						false,//
						"ClassifierDecisionTreeAdditionalFeatures",//
						"ClassifierDecisionTreeAdditionalFeatures"//
				));
		put("Stacking - DefaultTreeAdditionalFeatures - Stop after first non-header for columns",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"/countryNames.json",//
						false,//
						true,//
						"ClassifierDecisionTreeAdditionalFeatures",//
						"ClassifierDecisionTreeAdditionalFeatures"//
				));
		put("Stacking - DefaultTreeAdditionalFeatures - Evaluate all rows and columns",
				"classifierStacking.ApproachClassifierStacking",
				new SettingsClassifierStacking(//
						false,//
						"country",//
						"/countryNames.json",//
						false,//
						false,//
						"ClassifierDecisionTreeAdditionalFeatures",//
						"ClassifierDecisionTreeAdditionalFeatures"//
				));
	}

	private void testFindCountryNames() {

		put("FindCountryNames - CountryNames with HashSet",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countryNames.json"//
				));

		put("FindCountryNames - CountryNames Levensthein > 4",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						true,//
						4,//
						0.6,//
						"countryNames.json"));

		put("FindCountryNames - SurfaceNames > 0",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_all.json"//
				));
		put("FindCountryNames - SurfaceNames > 10",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_over10.json"//
				));
		put("FindCountryNames - SurfaceNames > 50",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_over50.json"//
				));
		put("FindCountryNames - SurfaceNames > 100",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_over100.json"//
				));
		put("FindCountryNames - SurfaceNames > 500",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_over500.json"//
				));
		put("FindCountryNames - SurfaceNames > 1000",
				"findCountryNames.ApproachFindCountryNames",
				new SettingsFindCountryNames(//
						false,//
						4,//
						0.6,//
						"countrySurfaceNames_over1000.json"//
				));
	}

	private void testClassifierFeatures() {

		put("ClassifierFeatures - DecisionTree using gain_ratio",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true,//
						"ClassifierDecisionTreeGainRatio",//
						"ClassifierDecisionTreeGainRatio"//
				));
		put("ClassifierFeatures - DecisionTree using gini_index",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true,//
						"ClassifierDecisionTreeGiniIndex",//
						"ClassifierDecisionTreeGiniIndex"//
				));
		put("ClassifierFeatures - RuleInduction",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true,//
						"ClassifierRuleInduction",//
						"ClassifierRuleInduction"//
				));

		put("ClassifierFeatures - Stop after first non-header for rows and columns",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						true,//
						"ClassifierDecisionTreeGainRatio",//
						"ClassifierDecisionTreeGainRatio"//
				));
		put("ClassifierFeatures - Stop after first non-header for rows",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						true,//
						false,//
						"ClassifierDecisionTreeGainRatio",//
						"ClassifierDecisionTreeGainRatio"//
				));
		put("ClassifierFeatures - Stop after first non-header for columns",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						false,//
						true,//
						"ClassifierDecisionTreeGainRatio",//
						"ClassifierDecisionTreeGainRatio"//
				));
		put("ClassifierFeatures - Evaluate all rows and columns",
				"classifierFeatures.ApproachClassifierFeatures",
				new SettingsClassifierFeatures(//
						false,//
						"country",//
						"countrySurfaceNames_over100.json",//
						false,//
						false,//
						"ClassifierDecisionTreeGainRatio",//
						"ClassifierDecisionTreeGainRatio"//
				));
	}

	private void put(String name, String path, ApproachSettings settings) {

		approaches.put(name, new ApproachInfo(name, path, settings));
	}

	public Collection<ApproachInfo> getApproaches() {

		return approaches.values();
	}
}
