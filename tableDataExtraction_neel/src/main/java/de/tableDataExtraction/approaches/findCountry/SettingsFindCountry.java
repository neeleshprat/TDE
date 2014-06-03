package de.tableDataExtraction.approaches.findCountry;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsFindCountry implements ApproachSettings {

	private String name;

	private String keyword; // country
	private boolean useSynonyms; // false
	private String synonymsFile; // countrySynonyms.json

	public SettingsFindCountry(String keyword, boolean useSynonyms,
			String synonymsFile) {
		super();
		this.keyword = keyword;
		this.useSynonyms = useSynonyms;
		this.synonymsFile = synonymsFile;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean isUseSynonyms() {
		return useSynonyms;
	}

	public void setUseSynonyms(boolean useSynonyms) {
		this.useSynonyms = useSynonyms;
	}

	public String getSynonymsFile() {
		return synonymsFile;
	}

	public void setSynonymsFile(String synonymsFile) {
		this.synonymsFile = synonymsFile;
	}
}
