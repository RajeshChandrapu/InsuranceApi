package com.insurance.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class InsurancePlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String planname;
    private LocalDate planstartdate;
    private LocalDate planenddate;
    private InsuranceCategory plancategorey;
    
    private String createdBy;
    private String updatedBy;

    // No-argument constructor
    public InsurancePlan() {
    }

    // Parameterized constructor
    public InsurancePlan(String planname, LocalDate planstartdate, LocalDate planenddate, InsuranceCategory plancategorey, String createdBy, String updatedBy) {
        this.planname = planname;
        this.planstartdate = planstartdate;
        this.planenddate = planenddate;
        this.plancategorey = plancategorey;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    // Parameterized constructor without ID (useful for creating new entities)
    public InsurancePlan(Long sno, String planname, LocalDate planstartdate, LocalDate planenddate, InsuranceCategory plancategorey, String createdBy, String updatedBy) {
        this.sno = sno;
        this.planname = planname;
        this.planstartdate = planstartdate;
        this.planenddate = planenddate;
        this.plancategorey = plancategorey;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    // Getters and setters
    public Long getSno() {
        return sno;
    }

    public void setSno(Long sno) {
        this.sno = sno;
    }

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
