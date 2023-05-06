package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PolicyInstallment {

	@SerializedName("billingFrequencyCode")
	@Expose
	private String billingFrequencyCode;
	
	public String getBillingFrequencyCode() {
	return billingFrequencyCode;
	}
	
	public void setBillingFrequencyCode(String billingFrequencyCode) {
	this.billingFrequencyCode = billingFrequencyCode;
	}

}
