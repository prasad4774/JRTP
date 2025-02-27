package com.example.jrtp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jrtp.entity.CitizenPlan;

@Repository
public interface CitizenPlanRepository extends  JpaRepository<CitizenPlan, Integer>{
	
	
	
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanName();
	
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getplanStatus();
	

}
