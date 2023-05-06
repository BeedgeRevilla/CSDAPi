package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrievePolicyDetailsResponse {

	@SerializedName("healthPolicy")
	@Expose
	private HealthPolicy healthPolicy;
	
	public HealthPolicy getHealthPolicy() {
	return healthPolicy;
	}
	
	public void setHealthPolicy(HealthPolicy healthPolicy) {
	this.healthPolicy = healthPolicy;
	}

}
