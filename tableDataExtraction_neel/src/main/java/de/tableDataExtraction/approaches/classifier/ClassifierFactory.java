package de.tableDataExtraction.approaches.classifier;

import java.lang.reflect.Constructor;

public class ClassifierFactory {

	public static Classifier create(String classUri) {

		Classifier classifier;

		classifier = null;

		try {

			Class<?> myClass;
			myClass = Class.forName(classUri);
			Constructor<?> constructor = myClass.getConstructor();
			classifier = (Classifier) constructor.newInstance(new Object[] {});

		} catch (Exception e) {
			e.printStackTrace();
		}

		return classifier;
	}
}
