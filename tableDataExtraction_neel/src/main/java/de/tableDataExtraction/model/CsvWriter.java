package de.tableDataExtraction.model;

import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import de.tableDataExtraction.Configuration;
import de.tableDataExtraction.approaches.classifier.Feature;

public class CsvWriter {

	public void write(String fileName, Collection<Feature> featuresList) {

		ICsvBeanWriter beanWriter;
		Field[] fields;
		ArrayList<String> mappingAsArrayList;
		String[] mappingAsArray;

		try {

			beanWriter = new CsvBeanWriter(new FileWriter(Configuration
					.getInstance().getOutputFolder() + "/" + fileName),
					CsvPreference.STANDARD_PREFERENCE);

			try {

				fields = featuresList.toArray()[0].getClass()
						.getDeclaredFields();

				mappingAsArrayList = new ArrayList<String>();

				for (Field field : fields) {

					mappingAsArrayList.add(field.getName());
				}

				mappingAsArray = mappingAsArrayList
						.toArray(new String[mappingAsArrayList.size()]);

				beanWriter.writeHeader(mappingAsArray);

				for (Feature features : featuresList) {
					beanWriter.write(features, mappingAsArray);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				beanWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
