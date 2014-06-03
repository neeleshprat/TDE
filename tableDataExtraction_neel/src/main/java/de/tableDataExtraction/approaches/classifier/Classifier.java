package de.tableDataExtraction.approaches.classifier;

public interface Classifier {

	public boolean classifyColumn(Feature feature);

	public boolean classifyRow(Feature feature);
}
