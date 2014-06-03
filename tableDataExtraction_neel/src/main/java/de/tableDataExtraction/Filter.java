package de.tableDataExtraction;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;

public class Filter {

	public static final boolean USE_IS_NORMALISED = true;
	public static final boolean USE_CONTAINS_COUNTRY = false;
	public static final boolean USE_NOT_CONTAINS_COUNTRY = false;
	public static final boolean USE_CONTAINS_COUNTRY_NAMES = true;
	public static final boolean USE_HAS_EXPECTED_RESULT = false;
	public static final boolean USE_IS_FROM_COMMON_CRAWL = false;

	private final HashSet<String> countries;

	public Filter() {

		countries = loadCountries();
	}

	public boolean isValid(Table table) {

		// Material implication:
		// http://en.wikipedia.org/wiki/Material_conditional

		if (!(USE_IS_NORMALISED && !isNormalised(table))) {
			if (!(USE_CONTAINS_COUNTRY && !containsCountry(table))) {
				if (!(USE_NOT_CONTAINS_COUNTRY && containsCountry(table))) {
					if (!(USE_CONTAINS_COUNTRY_NAMES && !containsCountryName(table))) {
						if (!(USE_HAS_EXPECTED_RESULT && !hasExpectedResult(table))) {
							if (!(USE_IS_FROM_COMMON_CRAWL && !isFromCommonCrawl(table))) {
								return true;
							}
						}
					}
				}
			}
		}

		return false;
	}

	private boolean isFromCommonCrawl(Table table) {

		if (table.getId().matches("\\d{8}_\\d{19}.*")) {

			return true;
		}

		return false;
	}

	private boolean hasExpectedResult(Table table) {

		if (table.getExpectedResult() != null) {

			return true;
		}

		return false;
	}

	private boolean isNormalised(Table table) {

		int previousLength = -1;

		for (Row row : table.getData().getRows().values()) {

			if (previousLength >= 0) {

				if (row.getCells().size() != previousLength) {

					return false;
				}
			}

			previousLength = row.getCells().size();
		}

		return true;
	}

	private boolean containsCountry(Table table) {

		for (Row row : table.getData().getRows().values()) {

			for (Cell cell : row.getCells()) {

				if (cell.getContent().toLowerCase().contains("country")) {

					return true;
				}
			}
		}

		return false;
	}

	private boolean containsCountryName(Table table) {

		for (Row row : table.getData().getRows().values()) {

			for (Cell cell : row.getCells()) {

				if (countries
						.contains(Helper.normaliseString(cell.getContent()))) {

					return true;
				}
			}
		}

		return false;
	}

	private HashSet<String> loadCountries() {

		HashSet<String> countries;
		File countriesAsFile;
		String countriesAsJson;
		Gson gson;

		countriesAsJson = "";
		countriesAsFile = new File(this.getClass()
				.getResource("/countrySurfaceNames_all.json").getFile());

		try {

			countriesAsJson = Files.toString(countriesAsFile, Charsets.UTF_8);

		} catch (IOException e) {
			e.printStackTrace();
		}

		gson = new Gson();
		countries = gson.fromJson(countriesAsJson,
				new TypeToken<HashSet<String>>() {
				}.getType());

		return countries;
	}
}
