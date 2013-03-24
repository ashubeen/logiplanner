package com.tan.logistics.admin.dto;

import java.util.List;

import com.tan.logistics.admin.model.CompanyAddress;

public class CompanyDTO 
{

	
	private Integer id;
	
	private String companyName;
	
	private List<CompanyAddress> addresses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<CompanyAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<CompanyAddress> addresses) {
		this.addresses = addresses;
	}
	
	
}
