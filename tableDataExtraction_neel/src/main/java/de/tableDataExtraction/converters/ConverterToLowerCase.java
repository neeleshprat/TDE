package de.tableDataExtraction.converters;

import java.io.File;
import java.util.HashSet;

import com.google.gson.reflect.TypeToken;

import de.tableDataExtraction.Configuration;

public class ConverterToLowerCase extends Converter {

	HashSet<String> inputSet;
	HashSet<String> outputSet;

	String inputJsonFile = "/countrySurfaceNames_all.json";
	String outputJsonFile = "countrySurfaceNames_all.json";

	public ConverterToLowerCase() {

		outputSet = new HashSet<String>();
	}

	public ConverterToLowerCase(String inputJsonFile, String outputJsonFile) {

		this();

		this.inputJsonFile = inputJsonFile;
		this.outputJsonFile = outputJsonFile;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void convert() {

		inputSet = ((HashSet<String>) loadObject(new File(this.getClass()
				.getResource(inputJsonFile).getFile()),
				new TypeToken<HashSet<String>>() {
				}.getType()));

		for (String string : inputSet) {

			outputSet.add(string.toLowerCase());
		}

		saveAsJson(outputSet, Configuration.getInstance().getOutputPath()
				+ outputJsonFile);
	}
}