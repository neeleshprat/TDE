package de.tableDataExtraction.approaches.classifier;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import de.tableDataExtraction.Helper;
import de.tableDataExtraction.model.Cell;
import de.tableDataExtraction.model.Column;
import de.tableDataExtraction.model.Row;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.TablePart;

public class FeatureDetermination {

	public boolean labelAtIndex(HashMap<Integer, Boolean> labels, int index) {

		if (labels.containsKey(index)) {

			return labels.get(index);

		} else {

			return false;
		}
	}

	public boolean isColumn(TablePart tablePart) {

		if (tablePart.getClass() == Column.class) {

			return true;
		}
		return false;
	}

	public int length(TablePart tablePart) {

		return tablePart.getCells().size();
	}

	public int numberOfColumns(Table table) {

		return table.getData().getColumns().size();
	}

	public int numberOfRows(Table table) {

		return table.getData().getRows().size();
	}

	public int numberOfCells(Table table) {

		return numberOfColumns(table) * numberOfRows(table);
	}

	public boolean approachResultFromTable(String approachName, int index,
			Table table, TablePart tablePart) {

		if (!table.getResults().containsKey(approachName)) {

			return false;
		}

		if (isColumn(tablePart)) {

			return labelAtIndex(table.getResults().get(approachName)
					.getColumns(), index);

		} else {

			return labelAtIndex(table.getResults().get(approachName).getRows(),
					index);
		}
	}

	public boolean containsCountry(Cell cell, String countryKeyword) {

		if (cell.getContent().toLowerCase().startsWith(countryKeyword)) {

			return true;
		}

		return false;
	}

	public boolean containsCountry(TablePart tablePart, String countryKeyword) {

		for (Cell cell : tablePart.getCells()) {

			if (containsCountry(cell, countryKeyword)) {

				return true;
			}
		}

		return false;
	}

	public boolean containsCountryName(HashSet<String> countryNames, Cell cell) {

		if (!StringUtils.isNotBlank(cell.getContent())) {

			return false;
		}

		if (countryNames.contains(Helper.normaliseString(cell.getContent()))) {

			return true;
		}

		return false;
	}

	public boolean isAllLowercase(Cell cell) {

		return StringUtils.isAllLowerCase(cell.getContent());
	}

	public boolean isAllUppercase(Cell cell) {

		return StringUtils.isAllUpperCase(cell.getContent());
	}

	public boolean startsWithCapital(Cell cell) {

		return !isEmpty(cell)
				&& Character.isUpperCase(cell.getContent().charAt(0));
	}

	public int colspan(Cell cell) {

		if (cell.getCellHtml().hasAttr("colspan")) {

			return Integer.parseInt(cell.getCellHtml().attr("colspan"));
		}

		return 0;
	}

	public boolean hasColspan(Cell cell) {

		return cell.getCellHtml().hasAttr("colspan");
	}

	public int rowspan(Cell cell) {

		if (cell.getCellHtml().hasAttr("rowspan")) {

			return Integer.parseInt(cell.getCellHtml().attr("rowspan"));
		}

		return 0;
	}

	public boolean hasRowspan(Cell cell) {

		return cell.getCellHtml().hasAttr("rowspan");
	}

	public boolean hasInlineStyle(Cell cell) {

		return cell.getCellHtml().hasAttr("style");
	}

	public boolean hasInlineStyle(TablePart tablePart) {

		// We can only compute this for rows
		// So, we need to check whether we have a row and then cast

		if (!isColumn(tablePart)) {

			return ((Row) tablePart).getHtml().hasAttr("style");
		}

		return false;
	}

	public boolean hasStyleClass(Cell cell) {

		return cell.getCellHtml().hasAttr("class");
	}

	public boolean hasStyleClass(TablePart tablePart) {

		// We can only compute this for rows
		// So, we need to check whether we have a row and then cast

		if (!isColumn(tablePart)) {

			return ((Row) tablePart).getHtml().hasAttr("class");
		}

		return false;
	}

	public boolean hasId(Cell cell) {

		return cell.getCellHtml().hasAttr("id");
	}

	public boolean hasId(TablePart tablePart) {

		// We can only compute this for rows
		// So, we need to check whether we have a row and then cast

		if (!isColumn(tablePart)) {

			return ((Row) tablePart).getHtml().hasAttr("id");
		}

		return false;
	}

	public int numberOfPunctuationMarks(Cell cell) {

		return numberOfPatternMatches("\\p{Punct}", cell);
	}

	public int numberOfNumbers(Cell cell) {

		return numberOfPatternMatches("\\d", cell);
	}

	public int numberOfLetters(Cell cell) {

		return numberOfPatternMatches("\\D", cell);
	}

	private int numberOfPatternMatches(String patternString, Cell cell) {

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(cell.getContent());

		int matchCount = 0;
		while (matcher.find()) {
			matchCount++;
		}

		return matchCount;
	}

	public int numberOfCharacters(Cell cell) {

		return cell.getContent().length();
	}

	public int numberOfWords(Cell cell) {

		return cell.getContent().split("\\s+").length;
	}

	public boolean isEmpty(Cell cell) {

		return "".equals(cell.getContent());
	}

	public boolean isNumeric(Cell cell) {

		return StringUtils.isNumeric(cell.getContent());
	}
}
