package de.tableDataExtraction.Structured;

import java.io.Serializable;
import java.util.ArrayList;

import de.tableDataExtraction.model.Cell;

public class CellStructured extends Cell implements Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<String> columnLabels;
	private ArrayList<String> rowLabels;
	private String href;

	private Boolean isLabelCell;

	private String dataType;

	public CellStructured() {
		// TODO Auto-generated constructor stub
	}

	public CellStructured(Cell cell) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> getColumnLabels() {
		return columnLabels;
	}

	public void setColumnLabels(ArrayList<String> columnLabels) {
		this.columnLabels = columnLabels;
	}

	public ArrayList<String> getRowLabels() {
		return rowLabels;
	}

	public void setRowLabels(ArrayList<String> rowLabels) {
		this.rowLabels = rowLabels;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getIsLabelCell() {
		return isLabelCell;
	}

	public void setIsLabelCell(Boolean isLabelCell) {
		this.isLabelCell = isLabelCell;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

}