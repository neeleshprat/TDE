package de.tableDataExtraction.approaches.chen;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsChen implements ApproachSettings {

	private String name;

	private String knownHeaders;

	private double minPercentageOfCountries;
	private String countryNamesJsonFile;
	private boolean useStringDistance;
	private int maxStringDistance;

	public SettingsChen(String knownHeaders, double minPercentageOfCountries,
			String countryNamesJsonFile, boolean useStringDistance,
			int maxStringDistance) {
		super();
		this.knownHeaders = knownHeaders;
		this.minPercentageOfCountries = minPercentageOfCountries;
		this.countryNamesJsonFile = countryNamesJsonFile;
		this.useStringDistance = useStringDistance;
		this.maxStringDistance = maxStringDistance;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
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

	public String getKnownHeaders() {
		return knownHeaders;
	}

	public void setKnownHeaders(String knownHeaders) {
		this.knownHeaders = knownHeaders;
	}
}
