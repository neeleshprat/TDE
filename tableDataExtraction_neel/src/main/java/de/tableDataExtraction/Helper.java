package de.tableDataExtraction;

import java.math.BigDecimal;

public class Helper {

	private static final String BASE_PACKAGE_PATH = "de.uni_mannheim.tableDataExtraction.";

	public static String normaliseString(String string) {

		return string.trim().toLowerCase();
	}

	public static float percentage(int one, int two) {

		float result = 0;

		if (two != 0) {
			result = (float) one / two;
		}

		return result;
	}

	public static String getFullPackagePath(String string) {

		return BASE_PACKAGE_PATH + string;
	}

	public static int roundToInteger(double number) {

		return (int) Math.round(number);
	}

	public static double roundToDouble(double number) {

		BigDecimal bigDecimal;

		bigDecimal = new BigDecimal(number);

		return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
