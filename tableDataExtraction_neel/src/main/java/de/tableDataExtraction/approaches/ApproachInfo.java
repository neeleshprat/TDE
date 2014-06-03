package de.tableDataExtraction.approaches;

public class ApproachInfo {

	private String name;
	private String path;
	private ApproachSettings settings;

	public ApproachInfo(String name, String path, ApproachSettings settings) {

		this.path = path;
		this.settings = settings;

		setName(name);
	}

	public String getPath() {
		return this.getClass().getPackage().getName() + "." + path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ApproachSettings getSettings() {
		return settings;
	}

	public void setSettings(ApproachSettings settings) {
		this.settings = settings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {

		this.name = name;

		if (settings != null) {

			settings.setName(name);
		}
	}
}