package de.uni_mannheim.informatik.webTables.tableDataExtraction;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import de.tableDataExtraction.model.Result;

@RunWith(JUnit4.class)
public class ResultTest {

	private Result result;
	private Result expectedResult;

	@Before
	public void initialize() {
		result = new Result();
		expectedResult = new Result();
	}

	@Test
	public void row1WithOnlyTrue() {

		result.getRows().put(0, true);
		expectedResult.getRows().put(0, true);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void row1WithOnlyFalse() {

		result.getRows().put(0, false);
		expectedResult.getRows().put(0, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void row1WithFalseAndNull() {

		result.getRows().put(0, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void row1WithTrueAndNull() {

		result.getRows().put(0, true);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void row1WithTrueAndFalse() {

		result.getRows().put(0, true);
		expectedResult.getRows().put(0, false);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void colum1WithOnlyTrue() {

		result.getColumns().put(0, true);
		expectedResult.getColumns().put(0, true);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void colum1WithOnlyFalse() {

		result.getColumns().put(0, false);
		expectedResult.getColumns().put(0, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void colum1WithFalseAndNull() {

		result.getColumns().put(0, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void colum1WithTrueAndNull() {

		result.getColumns().put(0, true);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void colum1WithTrueAndFalse() {

		result.getColumns().put(0, true);
		expectedResult.getColumns().put(0, false);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void row6WithOnlyTrue() {

		result.getRows().put(6, true);
		expectedResult.getRows().put(6, true);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void row6WithOnlyFalse() {

		result.getRows().put(6, false);
		expectedResult.getRows().put(6, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void row6WithFalseAndNull() {

		result.getRows().put(6, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void row6WithTrueAndNull() {

		result.getRows().put(6, true);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void row6WithTrueAndFalse() {

		result.getRows().put(6, true);
		expectedResult.getRows().put(6, false);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void colum6WithOnlyTrue() {

		result.getColumns().put(6, true);
		expectedResult.getColumns().put(6, true);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void colum6WithOnlyFalse() {

		result.getColumns().put(6, false);
		expectedResult.getColumns().put(6, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void colum6WithFalseAndNull() {

		result.getColumns().put(0, false);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void colum6WithTrueAndNull() {

		result.getColumns().put(6, true);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void colum6WithTrueAndFalse() {

		result.getColumns().put(6, true);
		expectedResult.getColumns().put(6, false);

		assertFalse(expectedResult.equals(result));
		assertFalse(result.equals(expectedResult));
	}

	@Test
	public void columnsAndRowsNull() {

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}

	@Test
	public void resultNull() {

		assertFalse(expectedResult.equals(null));
	}

	@Test
	public void complexTest() {

		result.getColumns().put(0, true);
		result.getColumns().put(1, false);
		result.getColumns().put(2, true);
		result.getColumns().put(3, false);
		result.getColumns().put(4, true);
		result.getColumns().put(5, false);

		expectedResult.getColumns().put(0, true);
		expectedResult.getColumns().put(1, false);
		expectedResult.getColumns().put(2, true);
		expectedResult.getColumns().put(3, false);
		expectedResult.getColumns().put(4, true);

		assertTrue(expectedResult.equals(result));
		assertTrue(result.equals(expectedResult));
	}
}