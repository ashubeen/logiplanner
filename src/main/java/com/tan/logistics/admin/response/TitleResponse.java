package com.tan.logistics.admin.response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.tan.logistics.admin.model.Title;

public class TitleResponse 
{

	@JsonProperty("Result")
	private String result;
	
	@JsonProperty("Records")
	private List<Title> titles;

	@JsonProperty("Record")
	private Title title;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Title> getTitles() {
		return titles;
	}

	public void setTitles(List<Title> titles) {
		this.titles = titles;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
	
	
	
}
