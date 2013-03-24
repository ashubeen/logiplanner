package com.tan.logistics.admin.response;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class LogisticsResponse<T> 
{

	@JsonProperty("Result")
	private String result;
	
	@JsonProperty("Records")
	private List<T> records;
	
	@JsonProperty("Options")
	private List<Option> options;
	

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@JsonProperty("Record")
	private T record;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public T getRecord() {
		return record;
	}

	public void setRecord(T record) {
		this.record = record;
	}

	
	
}
