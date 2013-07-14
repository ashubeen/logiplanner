package com.tan.logistics.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity()
@Table(name = "vessel")
public class Vessel {

	@Id
    @GeneratedValue   
    @Column(name="vessel_id") 
    private Integer id;
    
	@Column(name="imo_num")
    private Integer imoNum;

	@Column(name="vessel_name")
    private String vesselName;

	@Column(name="owner_company")
    private String ownerCompany;

	@Column(name="type")
    private String type;

	@Column(name="base_location")
    private Integer baseLocation;
	
	@Column(name="specs")
    private String specs;
	
	@Column(name="classification")
    private String classification;

	@Column(name="certifier")
    private String certifier;
	
	@Column(name="comments")
    private String comments;
	
	@Column(name="quarters")
    private Integer quarters;
	
	@Column(name="gross_tonnage")
    private Integer grossTonnage;
	
	@Column(name="uom")
    private String uom;
	
	@Column(name="length")
    private Integer length;
	
	@Column(name="beam")
    private Integer beam;
	
	@Column(name="draft")
    private Integer draft;
	
	@Column(name="max_water_depth")
    private Integer maxWaterDepth;
	
	@Column(name="max_drilling_depth")
    private Integer maxDrillingDepth;
	
	@Column(name="vessel_flag")
    private String vesselFlag;
	
	@Column(name="drilling_hp")
    private Integer drillingHp;
	
	@Column(name="year_built")
    private Integer yearBuilt;
	
	@Column(name="company_built")
    private String companyBuilt;
	
	@Column(name="other_names")
    private String otherNames;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getImoNum() {
		return imoNum;
	}

	public void setImoNum(Integer imoNum) {
		this.imoNum = imoNum;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public String getOwnerCompany() {
		return ownerCompany;
	}

	public void setOwnerCompany(String ownerCompany) {
		this.ownerCompany = ownerCompany;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(Integer baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getSpecs() {
		return specs;
	}

	public void setSpecs(String specs) {
		this.specs = specs;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getCertifier() {
		return certifier;
	}

	public void setCertifier(String certifier) {
		this.certifier = certifier;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getQuarters() {
		return quarters;
	}

	public void setQuarters(Integer quarters) {
		this.quarters = quarters;
	}

	public Integer getGrossTonnage() {
		return grossTonnage;
	}

	public void setGrossTonnage(Integer grossTonnage) {
		this.grossTonnage = grossTonnage;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getBeam() {
		return beam;
	}

	public void setBeam(Integer beam) {
		this.beam = beam;
	}

	public Integer getDraft() {
		return draft;
	}

	public void setDraft(Integer draft) {
		this.draft = draft;
	}

	public Integer getMaxWaterDepth() {
		return maxWaterDepth;
	}

	public void setMaxWaterDepth(Integer maxWaterDepth) {
		this.maxWaterDepth = maxWaterDepth;
	}

	public Integer getMaxDrillingDepth() {
		return maxDrillingDepth;
	}

	public void setMaxDrillingDepth(Integer maxDrillingDepth) {
		this.maxDrillingDepth = maxDrillingDepth;
	}

	public String getVesselFlag() {
		return vesselFlag;
	}

	public void setVesselFlag(String vesselFlag) {
		this.vesselFlag = vesselFlag;
	}

	public Integer getDrillingHp() {
		return drillingHp;
	}

	public void setDrillingHp(Integer drillingHp) {
		this.drillingHp = drillingHp;
	}

	public Integer getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public String getCompanyBuilt() {
		return companyBuilt;
	}

	public void setCompanyBuilt(String companyBuilt) {
		this.companyBuilt = companyBuilt;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}


}
