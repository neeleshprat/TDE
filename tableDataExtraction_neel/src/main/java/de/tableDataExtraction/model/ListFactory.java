package de.tableDataExtraction.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ListFactory {

	public static HashSet<String> createHashSet(String path) {

		File file;
		String json;
		Gson gson;
		HashSet<String> result;

		result = null;

		try {

			file = new File(path);
			json = Files.toString(file, Charsets.UTF_8);
			gson = new Gson();
			result = gson.fromJson(json, new TypeToken<HashSet<String>>() {
			}.getType());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static ArrayList<String> createArrayList(String path) {

		File file;
		String json;
		Gson gson;
		ArrayList<String> result;

		result = null;

		try {

			file = new File(path);
			json = Files.toString(file, Charsets.UTF_8);
			gson = new Gson();
			result = gson.fromJson(json, new TypeToken<HashSet<String>>() {
			}.getType());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
