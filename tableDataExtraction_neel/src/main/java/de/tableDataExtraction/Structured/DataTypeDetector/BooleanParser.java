package de.tableDataExtraction.Structured.DataTypeDetector;

public class BooleanParser {

	public static final String booleanRegex = "(yes|true|1|no|false|0)";

	public static boolean parseBoolean(String text) {

		if (text.toLowerCase().matches(booleanRegex)) {
			return true;
		}
		return false;
	}

}
