package com.tan.logistics.admin.request;

import com.tan.logistics.admin.model.Company;

public class CompanyRequest 
{

	
	private Company record;
	
	private int id;

	public Company getRecord() {
		return record;
	}

	public void setRecord(Company record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
