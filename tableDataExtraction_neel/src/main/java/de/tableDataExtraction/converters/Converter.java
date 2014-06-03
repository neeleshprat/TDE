package de.tableDataExtraction.converters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.commons.io.FileUtils;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;

public class Converter {

	public void convert() {

		// nothing
	}

	protected void saveAsJson(Object object, String path) {

		String jsonString;
		Gson gson;

		gson = new Gson();
		jsonString = gson.toJson(object);

		try {
			FileUtils.writeStringToFile(new File(path), jsonString);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected Object loadObject(File file, Type type) {

		String jsonString = "";
		Gson gson;

		try {

			jsonString = Files.toString(file, Charsets.UTF_8);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		gson = new Gson();

		return gson.fromJson(jsonString, type);
	}
}
