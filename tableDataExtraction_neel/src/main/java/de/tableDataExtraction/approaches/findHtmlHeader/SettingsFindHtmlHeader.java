package de.tableDataExtraction.approaches.findHtmlHeader;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsFindHtmlHeader implements ApproachSettings {

	private String name;

	private String htmlHeaderTag;
	private double headerThreshold;

	public SettingsFindHtmlHeader(String htmlHeaderTag, double headerThreshold) {
		super();
		this.htmlHeaderTag = htmlHeaderTag;
		this.headerThreshold = headerThreshold;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getHtmlHeaderTag() {
		return htmlHeaderTag;
	}

	public void setHtmlHeaderTag(String htmlHeaderTag) {
		this.htmlHeaderTag = htmlHeaderTag;
	}

	public double getHeaderThreshold() {
		return headerThreshold;
	}

	public void setHeaderThreshold(double headerThreshold) {
		this.headerThreshold = headerThreshold;
	}
}