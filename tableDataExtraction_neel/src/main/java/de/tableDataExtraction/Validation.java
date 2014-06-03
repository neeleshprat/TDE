package de.tableDataExtraction;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.tableDataExtraction.approaches.Approach;
import de.tableDataExtraction.approaches.ApproachInfo;
import de.tableDataExtraction.approaches.ApproachSettings;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.Timer;

public class Validation {

	private ArrayList<Table> datasetForLearning = null;
	private ArrayList<Table> datasetForTesting = null;
	private final HashMap<String, Timer> timers;
	private final int buckets;
	private final int bucket;

	public Validation(ArrayList<Table> dataset, HashMap<String, Timer> timers,
			int buckets, int bucket) {

		this.timers = timers;
		this.buckets = buckets;
		this.bucket = bucket;

		splitDataset(dataset);
	}

	private void splitDataset(ArrayList<Table> dataset) {

		int beginOfSplit;
		int endOfSplit;
		List<Table> datasetForLearningTemp1;
		List<Table> datasetForLearningTemp2;
		List<Table> datasetForTestingTemp;

		beginOfSplit = calculateBeginOfSplit(dataset.size());
		endOfSplit = calculateEndOfSplit(dataset.size());

		datasetForLearningTemp1 = dataset.subList(0, beginOfSplit);
		datasetForTestingTemp = dataset.subList(beginOfSplit, endOfSplit);
		datasetForLearningTemp2 = dataset.subList(endOfSplit, dataset.size());

		datasetForLearning = new ArrayList<Table>(datasetForLearningTemp1);
		datasetForLearning.addAll(datasetForLearningTemp2);
		datasetForTesting = new ArrayList<Table>(datasetForTestingTemp);
	}

	private int calculateBeginOfSplit(int size) {

		int result;

		result = (size / buckets) * (bucket - 1);

		return result;
	}

	private int calculateEndOfSplit(int size) {

		int result;

		result = (size / buckets) * (bucket);

		return result;
	}

	public void validate() {

		for (ApproachInfo approachInfo : ApproachList.getInstance()
				.getApproaches()) {

			try {

				Approach approach;

				if (approachInfo.getSettings() == null) {

					Class<?> myClass = Class.forName(approachInfo.getPath());
					Constructor<?> constructor = myClass.getConstructor();
					approach = (Approach) constructor
							.newInstance(new Object[] {});

				} else {

					Class<?> myClass = Class.forName(approachInfo.getPath());
					Constructor<?> constructor = myClass
							.getConstructor(ApproachSettings.class);
					approach = (Approach) constructor.newInstance(approachInfo
							.getSettings());
				}

				System.out.println("Testing bucket " + bucket + " ("
						+ datasetForLearning.size() + " tables for learning, "
						+ datasetForTesting.size()
						+ " tables for testing) with approach "
						+ approachInfo.getName());

				approach.learn(datasetForLearning);

				timers.get(approachInfo.getName()).start();
				approach.classify(datasetForTesting);

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				timers.get(approachInfo.getName()).stop();
			}
		}
	}
}