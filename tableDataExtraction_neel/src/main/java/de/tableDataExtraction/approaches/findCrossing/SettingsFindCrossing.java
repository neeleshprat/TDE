package de.tableDataExtraction.approaches.findCrossing;

import de.tableDataExtraction.approaches.ApproachSettings;

public class SettingsFindCrossing implements ApproachSettings {

	private String name;

	private int minLabelLength; // 2;
	private boolean useStringDistance; // false
	private int maxStringDistance; // 2

	public SettingsFindCrossing(int minLabelLength, boolean useStringDistance,
			int maxStringDistance) {
		super();
		this.minLabelLength = minLabelLength;
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

	public int getMinLabelLength() {
		return minLabelLength;
	}

	public void setMinLabelLength(int minLabelLength) {
		this.minLabelLength = minLabelLength;
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

}
