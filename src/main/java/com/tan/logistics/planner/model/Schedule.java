package com.tan.logistics.planner.model;

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
	    @Column(name="schedule_Id") 
	    private Integer Id;
	    
	   
	    @Column(name="gantt_id") 
	    private String ganttId;
	    
	    
	    @Column(name="contract_id")
	    private Integer contractId;
	    
	    @Column(name="name")
	    private String name;
	    
	    @Column(name="code")
	    private String code;
	    
	    @Column(name="level")
	    private Integer level;
	    
	    
	    @Column(name="status")
	    private String status;
	    
	    
	    @Column(name="start")
	    private Integer start;
	    
	    
	    @Column(name="duration")
	    private Integer duration;
	    
	    @Column(name="end")
	    private Integer end;
	    
	    
	    @Column(name="startIsMilestone")
	    private boolean startIsMilestone;
	    
	    @Column(name="endIsMilestone")
	    private boolean endIsMilestone;
	    
	    @Column(name="depends")
	    private boolean depends;
	    
	    @Column(name="parent_id")
	    private Integer parentId;
	    
	    @Column(name="sequence_num")
	    private Integer sequenceNum;

		public Integer getId() {
			return Id;
		}

		public void setId(Integer id) {
			Id = id;
		}

		public String getGanttId() {
			return ganttId;
		}

		public void setGanttId(String ganttId) {
			this.ganttId = ganttId;
		}

		public Integer getContractId() {
			return contractId;
		}

		public void setContractId(Integer contractId) {
			this.contractId = contractId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Integer getStart() {
			return start;
		}

		public void setStart(Integer start) {
			this.start = start;
		}

		public Integer getDuration() {
			return duration;
		}

		public void setDuration(Integer duration) {
			this.duration = duration;
		}

		public Integer getEnd() {
			return end;
		}

		public void setEnd(Integer end) {
			this.end = end;
		}

		public boolean isStartIsMilestone() {
			return startIsMilestone;
		}

		public void setStartIsMilestone(boolean startIsMilestone) {
			this.startIsMilestone = startIsMilestone;
		}

		public boolean isEndIsMilestone() {
			return endIsMilestone;
		}

		public void setEndIsMilestone(boolean endIsMilestone) {
			this.endIsMilestone = endIsMilestone;
		}

		public boolean isDepends() {
			return depends;
		}

		public void setDepends(boolean depends) {
			this.depends = depends;
		}

		public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

		public Integer getSequenceNum() {
			return sequenceNum;
		}

		public void setSequenceNum(Integer sequenceNum) {
			this.sequenceNum = sequenceNum;
		}


	    
	    
	    
	    
	
}
