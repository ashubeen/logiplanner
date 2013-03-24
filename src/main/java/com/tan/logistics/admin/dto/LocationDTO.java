package com.tan.logistics.admin.dto;

import java.util.List;

import com.tan.logistics.admin.model.LocationCoordinates;


public class LocationDTO {

	private Integer locationId;
    
	private String locName;
    
    private String locType;

    private String locCountry;
    
    private List<LocationCoordinates> locCoordintes;

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
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

	public List<LocationCoordinates> getLocCoordintes() {
		return locCoordintes;
	}

	public void setLocCoordintes(List<LocationCoordinates> locCoordintes) {
		this.locCoordintes = locCoordintes;
	}
    
    
	
}
