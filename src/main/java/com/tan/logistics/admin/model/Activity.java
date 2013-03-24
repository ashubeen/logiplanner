package com.tan.logistics.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity()
@Table(name = "ACTIVITY")


public class Activity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9206056539044428071L;

	@Id
    @GeneratedValue   
    @Column(name="ID") 
    private Integer id;
    
	@Column(name="activity")
    private String activity;

	@Column(name="level")
    private Integer level;

	@Column(name="parentid")
    private Integer parentId;
	
	
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

	
	

}
