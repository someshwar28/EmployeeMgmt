package com.yash.EmployeeMgmt.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int eid;
	@NotEmpty(message = "name should not be empty")
	private String ename;
	@JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
	private String DOJ;
	@NotNull(message = "exp should not be empty")
	private Double totalExp;
	@NotEmpty(message = "reporting field should not be empty")
	private String reportingManager;
	@NotEmpty(message = "your designation should not be empty")
	private String designation;
	@NotEmpty(message = "your skill should not be blank")
	private String skill;
	
	
	public Employee() {
		super();
	}
	public Employee(int eid, @NotEmpty(message = "name should not be empty") String ename, String dOJ,
			@NotNull(message = "exp should not be empty") Double totalExp,
			@NotEmpty(message = "reporting field should not be empty") String reportingManager,
			@NotEmpty(message = "your designation should not be empty") String designation,
			@NotEmpty(message = "your skill should not be blank") String skill) {
		super();
		this.eid = eid;
		this.ename = ename;
		DOJ = dOJ;
		this.totalExp = totalExp;
		this.reportingManager = reportingManager;
		this.designation = designation;
		this.skill = skill;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getDOJ() {
		return DOJ;
	}
	public void setDOJ(String dOJ) {
		DOJ = dOJ;
	}
	public Double getTotalExp() {
		return totalExp;
	}
	public void setTotalExp(Double totalExp) {
		this.totalExp = totalExp;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", DOJ=" + DOJ + ", totalExp=" + totalExp
				+ ", reportingManager=" + reportingManager + ", designation=" + designation + ", skill=" + skill + "]";
	} 
	
}
