package com.tan.logistics.admin.request;

import org.codehaus.jackson.annotate.JsonProperty;

public class LogiRequest<T> 
{

	@JsonProperty("record")
	private T record;
	
	@JsonProperty("id")
	private Integer Id;

	public T getRecord() {
		return record;
	}

	public void setRecord(T record) {
		this.record = record;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	
	

	
	
}
