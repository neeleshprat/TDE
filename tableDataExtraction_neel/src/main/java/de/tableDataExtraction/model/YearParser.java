package de.tableDataExtraction.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class YearParser {

	public static String prefix = "";
	public static String postfix = "";

	public static final Map<String, Integer> era = new HashMap<String, Integer>() {
		{
			put("BCE", 1);
			put("BC", 1);
			put("CE", 1);
			put("AD", 1);
			put("AC", 1);
			put("CE", 1);

		}
	};

	public static String eraRegex = mkString(era.keySet(), "|");

	public static String YearRegex = ("(?iu)" + prefix
			+ "(?<![\\d\\pL\\w])(-?\\d{1,4})(?!\\d)\\s*(" + eraRegex + ")?" + postfix);

	public static String mkString(Set<String> list, String separator) {
		StringBuilder s = new StringBuilder();
		Iterator<String> it = list.iterator();
		if (it.hasNext()) {
			s.append(it.next());
		}
		while (it.hasNext()) {
			s.append(separator).append(it.next());
		}
		return s.toString();
	}

	public static boolean parseDate(String date) {
		if (date.length() < 4) {
			if (parseNumeric(date))
				return false;
		}

		if (date.toLowerCase().matches(YearRegex))
			return true;
		else
			return false;
	}

	public static boolean parseNumeric(String text) {

		try {
			Double.parseDouble(text);

			return true;
		} catch (NumberFormatException e) {
		}

		// go char by char and see if it is code or some other number
		// this should be changed with units
		int nmNumbers = 0;
		int nmChars = 0;

		for (char ch : text.toCharArray()) {
			if (Character.isDigit(ch))
				nmNumbers++;
			else if (!Character.isSpace(ch))
				nmChars++;
		}
		if (nmNumbers >= 1.5 * nmChars)
			return true;
		return false;
	}

}