package com.tan.logistics.admin.request;

import com.tan.logistics.admin.model.Vessel;

public class VesselRequest 
{
	
	private Vessel record;
	
	private int id;

	public Vessel getRecord() {
		return record;
	}

	public void setRecord(Vessel record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
