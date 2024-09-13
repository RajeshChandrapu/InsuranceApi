package com.insurance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.entity.InsurancePlan;
import com.insurance.repository.InsurancePlanRepository;

@Service
public class InsurancePlanService {

    @Autowired
    private InsurancePlanRepository insurancePlanRepository;

    public List<InsurancePlan> getAllPlans() {
        return insurancePlanRepository.findAll();
    }

    public Optional<InsurancePlan> getPlanById(Long id) {
        return insurancePlanRepository.findById(id);
    }

    public InsurancePlan createOrUpdatePlan(InsurancePlan plan, String username) {
        if (plan.getSno() == null) {
            // New entity
            return insurancePlanRepository.save(new InsurancePlan(
                plan.getPlanname(),
                plan.getPlanstartdate(),
                plan.getPlanenddate(),
                plan.getPlancategorey(),
                username,
                username
            ));
        } else {
            // Existing entity
            return insurancePlanRepository.save(new InsurancePlan(
                plan.getSno(),
                plan.getPlanname(),
                plan.getPlanstartdate(),
                plan.getPlanenddate(),
                plan.getPlancategorey(),
                plan.getCreatedBy(),
                username
            ));
        }
    }

    public void deletePlan(Long id) {
        insurancePlanRepository.deleteById(id);
    }
}
