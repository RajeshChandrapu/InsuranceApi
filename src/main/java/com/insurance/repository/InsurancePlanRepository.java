package com.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.entity.InsurancePlan;

@Repository
public interface InsurancePlanRepository extends JpaRepository<InsurancePlan, Long> {
}
