package com.tan.logistics.admin.request;

import com.tan.logistics.admin.model.Contract;

public class ContractRequest 
{

	
	private Contract record;
	
	private int id;

	public Contract getRecord() {
		return record;
	}

	public void setRecord(Contract record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
