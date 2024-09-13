package com.insurance.model;

import java.time.LocalDate;

import com.insurance.entity.InsuranceCategory;

public class BindingModel {

	private String planname;
	private LocalDate planstartdate;
	private LocalDate planenddate;
	private InsuranceCategory plancategorey;
	private String createdBy; // Add this if needed
	private String updatedBy; // Add this if needed

	// Constructor
	public BindingModel(String planname, LocalDate planstartdate, LocalDate planenddate,
			InsuranceCategory plancategorey, String createdBy, String updatedBy) {
		this.planname = planname;
		this.planstartdate = planstartdate;
		this.planenddate = planenddate;
		this.plancategorey = plancategorey;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	// Getters and Setters
	public String getPlanname() {
		return planname;
	}

	public void setPlanname(String planname) {
		this.planname = planname;
	}

	public LocalDate getPlanstartdate() {
		return planstartdate;
	}

	public void setPlanstartdate(LocalDate planstartdate) {
		this.planstartdate = planstartdate;
	}

	public LocalDate getPlanenddate() {
		return planenddate;
	}

	public void setPlanenddate(LocalDate planenddate) {
		this.planenddate = planenddate;
	}

	public InsuranceCategory getPlancategorey() {
		return plancategorey;
	}

	public void setPlancategorey(InsuranceCategory plancategorey) {
		this.plancategorey = plancategorey;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
