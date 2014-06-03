package de.tableDataExtraction.approaches.findCountryNames;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsFindCountryNames implements ApproachSettings {

	private String name;

	private boolean useStringDistance;
	private int maxStringDistance;
	private double minPercentageOfCountries;
	private String countryNamesJsonFile;

	public SettingsFindCountryNames(boolean useStringDistance,
			int maxStringDistance, double minPercentageOfCountries,
			String countryNamesJsonFile) {

		this.useStringDistance = useStringDistance;
		this.maxStringDistance = maxStringDistance;
		this.minPercentageOfCountries = minPercentageOfCountries;
		this.countryNamesJsonFile = countryNamesJsonFile;
	}

	public boolean isUseStringDistance() {
		return useStringDistance;
	}

	public void setUseStringDistance(boolean useStringDistance) {
		this.useStringDistance = useStringDistance;
	}

	public int getMaxStringDistance() {
		return maxStringDistance;
	}

	public void setMaxStringDistance(int maxStringDistance) {
		this.maxStringDistance = maxStringDistance;
	}

	public double getMinPercentageOfCountries() {
		return minPercentageOfCountries;
	}

	public void setMinPercentageOfCountries(double minPercentageOfCountries) {
		this.minPercentageOfCountries = minPercentageOfCountries;
	}

	public String getCountryNamesJsonFile() {
		return countryNamesJsonFile;
	}

	public void setCountryNamesJsonFile(String countryNamesJsonFile) {
		this.countryNamesJsonFile = countryNamesJsonFile;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
}
