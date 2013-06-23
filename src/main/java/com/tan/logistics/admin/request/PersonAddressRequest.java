package com.tan.logistics.admin.request;

import com.tan.logistics.admin.model.PersonAddress;

public class PersonAddressRequest 
{
	
	private PersonAddress record;
	
	private int id;

	public PersonAddress getRecord() {
		return record;
	}

	public void setRecord(PersonAddress record) {
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
