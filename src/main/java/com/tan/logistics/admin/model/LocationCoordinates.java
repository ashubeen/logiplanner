package com.tan.logistics.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity()
@Table( name = "location_Coordinates")

public class LocationCoordinates {

	@Id
    @GeneratedValue   
    @Column(name="id") 
    private Integer id;
    
	@Column(name="loc_longitude")
    private String locLongitute;
    
    @Column(name="loc_latitude")
    private String locLatitude;

    @Column(name="loc_decimalX")
    private String locDecimalX;
    
    @Column(name="loc_decimalY")
    private String locDecimalY;

	@ManyToOne
	private Location location;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocLongitute() {
		return locLongitute;
	}

	public void setLocLongitute(String locLongitute) {
		this.locLongitute = locLongitute;
	}

	public String getLocLatitude() {
		return locLatitude;
	}

	public void setLocLatitude(String locLatitude) {
		this.locLatitude = locLatitude;
	}

	public String getLocDecimalX() {
		return locDecimalX;
	}

	public void setLocDecimalX(String locDecimalX) {
		this.locDecimalX = locDecimalX;
	}

	public String getLocDecimalY() {
		return locDecimalY;
	}

	public void setLocDecimalY(String locDecimalY) {
		this.locDecimalY = locDecimalY;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}        
    
}
