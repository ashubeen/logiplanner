package com.tan.logistics.admin.request;

import com.tan.logistics.planner.model.Project;

public class ProjectRequest 
{

	
	private Project record;
	
	private int id;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project getRecord() {
		return record;
	}

	public void setRecord(Project record) {
		this.record = record;
	}
	
	
	
}
