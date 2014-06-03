package de.tableDataExtraction.converters;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import com.google.gson.reflect.TypeToken;

import de.tableDataExtraction.Configuration;

public class ConverterCountryURIs extends Converter {

	ArrayList<String> inputURIs;
	HashSet<String> countryURIs;

	public ConverterCountryURIs() {

		countryURIs = new HashSet<String>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void convert() {

		inputURIs = ((ArrayList<String>) loadObject(new File(this.getClass()
				.getResource("/countryURIsFromWikipedia.json").getFile()),
				new TypeToken<ArrayList<String>>() {
				}.getType()));

		for (String string : inputURIs) {

			countryURIs.add(string.substring(29));
		}

		saveAsJson(countryURIs, Configuration.getInstance().getOutputPath()
				+ "countryURIs.json");
	}
}
