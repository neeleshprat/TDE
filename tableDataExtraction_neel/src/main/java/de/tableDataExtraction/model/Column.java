package de.tableDataExtraction.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Column implements TablePart, Serializable {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cell> cells;

	public Column() {

		cells = new ArrayList<Cell>();
	}

	@Override
	public ArrayList<Cell> getCells() {
		return cells;
	}

	@Override
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
}