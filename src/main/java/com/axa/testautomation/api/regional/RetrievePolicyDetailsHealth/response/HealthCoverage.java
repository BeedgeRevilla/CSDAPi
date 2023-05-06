package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HealthCoverage {

	@SerializedName("Insured")
	@Expose
	private List<Insured> insured = null;
	
	public List<Insured> getInsured() {
	return insured;
	}
	
	public void setInsured(List<Insured> insured) {
	this.insured = insured;
	}

}
