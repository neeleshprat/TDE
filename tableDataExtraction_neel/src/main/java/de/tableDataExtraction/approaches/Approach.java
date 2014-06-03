package de.tableDataExtraction.approaches;

import java.util.ArrayList;

import de.tableDataExtraction.model.Table;

public interface Approach {

	public void learn(ArrayList<Table> learnDataset);

	public void classify(ArrayList<Table> testDataset);
}