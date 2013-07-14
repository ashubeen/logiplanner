package com.tan.logistics.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name = "location")

public class Location {

	@Id
    @GeneratedValue   
    @Column(name="location_id") 
    private Integer id;
    
	@Column(name="loc_name")
    private String locName;
    
    @Column(name="loc_type")
    private String locType;

    @Column(name="loc_country")
    private String locCountry;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocName() {
		return locName;
	}

	public void setLocName(String locName) {
		this.locName = locName;
	}

	public String getLocType() {
		return locType;
	}

	public void setLocType(String locType) {
		this.locType = locType;
	}

	public String getLocCountry() {
		return locCountry;
	}

	public void setLocCountry(String locCountry) {
		this.locCountry = locCountry;
	}

}
