package de.tableDataExtraction.converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

import com.google.gson.reflect.TypeToken;

import de.tableDataExtraction.Configuration;

public class ConverterSurfaceNames extends Converter {

	private static final String COUNTRY_URIS_FILE = "/countryURIs.json";
	private static final String SURFACE_FORMS_FILE = "/surfaceForms/pairCounts";
	private static final String COUNTRY_SURFACE_NAMES_FILE = "countrySurfaceNames.json";
	private static final int OCCURRENCES_THRESHOLD = 1000;

	HashSet<String> countryURIs;
	HashSet<String> surfaceNames;

	public ConverterSurfaceNames() {

		surfaceNames = new HashSet<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void convert() {

		countryURIs = ((HashSet<String>) loadObject(new File(this.getClass()
				.getResource(COUNTRY_URIS_FILE).getFile()),
				new TypeToken<HashSet<String>>() {
				}.getType()));

		convertSurfaceForms();

		saveAsJson(surfaceNames, Configuration.getInstance().getOutputPath()
				+ COUNTRY_SURFACE_NAMES_FILE);
	}

	private void convertSurfaceForms() {

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		String line;

		try {

			fileReader = new FileReader(this.getClass()
					.getResource(SURFACE_FORMS_FILE).getFile());
			bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {

				String[] parts;
				String countryURI;
				int occurrences;

				parts = line.split("\\t");
				countryURI = parts[1].substring(31);
				occurrences = Integer.parseInt(parts[2]);

				if (occurrences >= OCCURRENCES_THRESHOLD
						&& countryURIs.contains(countryURI)) {

					surfaceNames.add(parts[0]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				bufferedReader.close();
				fileReader.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}