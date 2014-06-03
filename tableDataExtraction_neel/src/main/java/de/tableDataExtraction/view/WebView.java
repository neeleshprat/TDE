package de.tableDataExtraction.view;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.sun.jersey.api.view.Viewable;

import de.tableDataExtraction.TableDataExtraction;
import de.tableDataExtraction.model.Message;
import de.tableDataExtraction.model.Table;
import de.tableDataExtraction.model.Timer;

@Path("app")
public class WebView {

	public WebView() {
		// nothing
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public Viewable index() {

		return new Viewable("/index");
	}

	// @GET
	// @Path("convert")
	// @Produces(MediaType.APPLICATION_JSON)
	// public String convertCountryURIs() {
	//
	// ConverterCountryURIs converter;
	//
	// converter = new ConverterCountryURIs();
	// converter.convert();
	//
	// return "{\"Done\": \"yup.\"}";
	// }

	@GET
	@Path("averages")
	@Produces(MediaType.APPLICATION_JSON)
	public String averages() {

		Message message;
		Gson gson;
		TableDataExtraction tableDataExtraction;

		tableDataExtraction = TableDataExtraction.getInstance();
		message = new Message();
		gson = new Gson();

		try {

			tableDataExtraction.load();

			message.setType("success");
			message.setTitle("Success!");
			message.setText("Computed averages for "
					+ tableDataExtraction.getTables().size() + " tables.");

			message.setResults(tableDataExtraction.computeAverages(true));
			message.setTimers(tableDataExtraction.computeAverages(false));

		} catch (Exception e) {
			e.printStackTrace();
			message.setType("danger");
			message.setTitle("Error!");
			message.setText("Exception " + e.getMessage() + " occured.");
		}

		return gson.toJson(message);
	}

	@GET
	@Path("load")
	@Produces(MediaType.APPLICATION_JSON)
	public String load() {

		Message message;
		Gson gson;
		TableDataExtraction tableDataExtraction;
		Timer timer;

		tableDataExtraction = TableDataExtraction.getInstance();
		message = new Message();
		gson = new Gson();
		timer = new Timer();

		try {
			timer.start();
			tableDataExtraction.load();
			timer.stop();

			message.setType("success");
			message.setTitle("Success!");
			message.setText("Loaded " + tableDataExtraction.getTables().size()
					+ " tables in " + timer.getUsedTime() + " ms.");

		} catch (Exception e) {

			e.printStackTrace();

			message.setType("danger");
			message.setTitle("Error!");
			message.setText("Exception " + e.getMessage() + " occured.");
		}

		return gson.toJson(message);
	}

	@GET
	@Path("validate")
	@Produces(MediaType.APPLICATION_JSON)
	public String validate() {

		Message message;
		Gson gson;
		TableDataExtraction tableDataExtraction;
		Timer timer;

		tableDataExtraction = TableDataExtraction.getInstance();
		message = new Message();
		gson = new Gson();
		timer = new Timer();

		try {
			timer.start();
			tableDataExtraction.crossValidation(10);
			timer.stop();

			message.setType("success");
			message.setTitle("Success!");
			message.setText("Validated "
					+ tableDataExtraction.getTables().size()
					+ " tables with "
					+ tableDataExtraction.getCrossValidation().getEvaluations()
							.size() + " evaluations in " + timer.getUsedTime()
					+ " ms.");

			message.setResults(tableDataExtraction.getCrossValidation()
					.getEvaluations().values());
			message.setCombinations(tableDataExtraction.getCrossValidation()
					.getCombinations());
			message.setTimers(tableDataExtraction.getCrossValidation()
					.getTimers());

		} catch (Exception e) {

			e.printStackTrace();

			message.setType("danger");
			message.setTitle("Error!");
			message.setText("Exception " + e.getMessage() + " occured.");
		}

		return gson.toJson(message);
	}

	@GET
	@Path("save")
	@Produces(MediaType.APPLICATION_JSON)
	public String save() {

		Message message;
		Gson gson;
		TableDataExtraction tableDataExtraction;
		Timer timer;

		message = new Message();
		gson = new Gson();
		tableDataExtraction = TableDataExtraction.getInstance();
		timer = new Timer();

		try {
			timer.start();
			tableDataExtraction.save();
			timer.stop();

			message.setType("success");
			message.setTitle("Success!");
			message.setText("Saved " + tableDataExtraction.getTables().size()
					+ " tables in " + timer.getUsedTime() + " ms.");

		} catch (Exception e) {

			e.printStackTrace();

			message.setType("danger");
			message.setTitle("Error!");
			message.setText("Exception " + e.getMessage() + " occured.");
		}

		return gson.toJson(message);
	}

	@GET
	@Path("table")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTableWithoutExpectedResult() {

		String result;
		Table table;
		TableDataExtraction tableDataExtraction;
		Gson gson;

		tableDataExtraction = TableDataExtraction.getInstance();
		table = tableDataExtraction.getTableWithoutExpectedResult();
		gson = new Gson();

		result = gson.toJson(table);

		return result;
	}

	@POST
	@Path("table")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setExpectedResult(String tableAsString) {

		Message message;
		Gson gson;
		Table table;
		TableDataExtraction tableDataExtraction;
		Timer timer;

		message = new Message();
		gson = new Gson();
		table = gson.fromJson(tableAsString, Table.class);
		tableDataExtraction = TableDataExtraction.getInstance();
		timer = new Timer();

		try {
			timer.start();
			tableDataExtraction.setExpectedResult(table.getId(),
					table.getExpectedResult());
			timer.stop();

			message.setType("success");
			message.setTitle("Success!");
			message.setText("Saved expected result for table "
					+ table.getId()
					+ " in "
					+ timer.getUsedTime()
					+ " ms. "
					+ tableDataExtraction.getTablesWithoutExpectedResult()
							.size() + " tables remaining.");

		} catch (Exception e) {

			e.printStackTrace();

			message.setType("danger");
			message.setTitle("Error!");
			message.setText("Exception " + e.getMessage() + " occured.");
		}

		return gson.toJson(message);
	}
}