package com.tan.logistics.planner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "project")
public class Project 
{

	
	   @Id
	    @GeneratedValue   
	    @Column(name="project_id") 
	    private Integer Id;
	    
	    @Column(name="contract_id")
	    private Integer contractId;
	    
	    @Column(name="project_name")
	    private String projectName;
	       
	    @Column(name="start_date")
	    private Date startDate;
	    
	    @Column(name="end_date")
	    private Date endDate;
	    
	    @Column(name="status")
	    private Integer status;

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public Integer getContractId() {
			return contractId;
		}

		public void setContractId(Integer contractId) {
			this.contractId = contractId;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}


	    
	    
	    
}
