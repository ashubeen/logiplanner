package com.tan.logistics.admin.request;

import com.tan.logistics.admin.model.CompanyAddress;

public class CompanyAddressRequest 
{
	
	private CompanyAddress record;
	
	private int id;

	public CompanyAddress getRecord() {
		return record;
	}

	public void setRecord(CompanyAddress record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
