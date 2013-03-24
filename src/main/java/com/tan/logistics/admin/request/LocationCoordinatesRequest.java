package com.tan.logistics.admin.request;

import com.tan.logistics.admin.model.LocationCoordinates;

public class LocationCoordinatesRequest 
{

	
	private LocationCoordinates record;
	
	private int id;

	public LocationCoordinates getRecord() {
		return record;
	}

	public void setRecord(LocationCoordinates record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
