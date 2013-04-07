package com.tan.logistics.planner.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "schedule")
public class Schedule 
{

	
	   @Id
	    @GeneratedValue   
	    @Column(name="schedule_id") 
	    private Integer Id;
	    
	    @Column(name="vessel_id")
	    private Integer vesselId;
	    
	    @Column(name="schedule_name")
	    private String scheduleName;
	       
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

		public Integer getVesselId() {
			return vesselId;
		}

		public void setVesselId(Integer vesselId) {
			this.vesselId = vesselId;
		}

		public String getScheduleName() {
			return scheduleName;
		}

		public void setScheduleName(String scheduleName) {
			this.scheduleName = scheduleName;
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
