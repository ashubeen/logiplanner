package com.tan.logistics.admin.dto;

import java.util.List;

import com.tan.logistics.admin.model.Activity;

public class ActivityDTO 
{

	
	private Integer id;
	
	private String activity;
	
	private Integer level;
	
	private Integer parentId;
	
	private List<Activity> activities;
	
	private String parentActivityName;

	
	public String getParentActivityName() {
		return parentActivityName;
	}

	public void setParentActivityName(String parentActivityName) {
		this.parentActivityName = parentActivityName;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	
	
	
}
