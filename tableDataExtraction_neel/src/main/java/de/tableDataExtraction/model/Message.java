package de.tableDataExtraction.model;

public class Message {

	private String type;
	private String title;
	private String text;
	private Object results;
	private Object combinations;
	private Object timers;

	public Message() {
		// nothing
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Object getResults() {
		return results;
	}

	public void setResults(Object results) {
		this.results = results;
	}

	public Object getTimers() {
		return timers;
	}

	public void setTimers(Object timers) {
		this.timers = timers;
	}

	public Object getCombinations() {
		return combinations;
	}

	public void setCombinations(Object combinations) {
		this.combinations = combinations;
	}
}