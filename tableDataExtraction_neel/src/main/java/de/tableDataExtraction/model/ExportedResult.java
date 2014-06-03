package de.tableDataExtraction.model;

import java.io.Serializable;

public class ExportedResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Data data;
	private Result result;
	private OriginalDescription originalDescription;

	public ExportedResult() {
		// nothing
	}

	public ExportedResult(String name, Data data, Result result,
			OriginalDescription originalDescription) {

		setName(name);
		setData(data);
		setResult(result);
		setOriginalDescription(originalDescription);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public OriginalDescription getOriginalDescription() {
		return originalDescription;
	}

	public void setOriginalDescription(OriginalDescription originalDescription) {
		this.originalDescription = originalDescription;
	}
}
