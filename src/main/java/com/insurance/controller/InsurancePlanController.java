package com.insurance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.constants.AppConstants;
import com.insurance.entity.InsurancePlan;
import com.insurance.model.BindingModel;
import com.insurance.service.InsurancePlanService;

@RestController
@RequestMapping("/api/plans")
public class InsurancePlanController {

    @Autowired
    private InsurancePlanService insurancePlanService;

    // Assume that we have a way to get the username
    private String getUsername() {
        // This should be replaced with actual user retrieval logic
        return "defaultUser";
    }

    @GetMapping
    public ResponseEntity<List<InsurancePlan>> getAllPlans() {
        List<InsurancePlan> plans = insurancePlanService.getAllPlans();
        return ResponseEntity.ok(plans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlanById(@PathVariable Long id) {
        Optional<InsurancePlan> plan = insurancePlanService.getPlanById(id);
        if (plan.isPresent()) {
            return ResponseEntity.ok(plan.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AppConstants.PLAN_SAVE_FAIL);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createPlan(@RequestBody BindingModel model) {
        try {
            InsurancePlan plan = new InsurancePlan(model.getPlanname(), model.getPlanstartdate(),
                    model.getPlanenddate(), model.getPlancategorey(), getUsername(), getUsername());

            InsurancePlan savedPlan = insurancePlanService.createOrUpdatePlan(plan, getUsername());
            if (savedPlan != null) {
                return ResponseEntity.status(HttpStatus.CREATED).body(AppConstants.PLAN_SAVE_SUCC);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppConstants.PLAN_SAVE_FAIL);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppConstants.PLAN_SAVE_FAIL);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable Long id, @RequestBody BindingModel model) {
        Optional<InsurancePlan> existingPlan = insurancePlanService.getPlanById(id);
        if (!existingPlan.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AppConstants.PLAN_UPDATE_FAIL);
        }

        InsurancePlan plan = new InsurancePlan(id, model.getPlanname(), model.getPlanstartdate(),
                model.getPlanenddate(), model.getPlancategorey(), existingPlan.get().getCreatedBy(), getUsername());

        try {
            InsurancePlan updatedPlan = insurancePlanService.createOrUpdatePlan(plan, getUsername());
            if (updatedPlan != null) {
                return ResponseEntity.ok(AppConstants.PLAN_UPDATE_SUCC);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppConstants.PLAN_UPDATE_FAIL);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppConstants.PLAN_UPDATE_FAIL);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        Optional<InsurancePlan> existingPlan = insurancePlanService.getPlanById(id);
        if (!existingPlan.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AppConstants.PLAN_DELETE_FAIL);
        }

        try {
            insurancePlanService.deletePlan(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(AppConstants.PLAN_DELETE_SUCC);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(AppConstants.PLAN_DELETE_FAIL);
        }
    }
}
