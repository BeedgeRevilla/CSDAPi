package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PolicyCoverage {

	@SerializedName("HealthCoverage")
	@Expose
	private HealthCoverage healthCoverage;
	
	public HealthCoverage getHealthCoverage() {
	return healthCoverage;
	}
	
	public void setHealthCoverage(HealthCoverage healthCoverage) {
	this.healthCoverage = healthCoverage;
	}

}
