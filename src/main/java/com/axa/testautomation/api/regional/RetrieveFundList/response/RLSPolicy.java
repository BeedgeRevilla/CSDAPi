package com.axa.testautomation.api.regional.RetrieveFundList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RLSPolicy {
	@SerializedName("policyNumber")
	@Expose
	private String policyNumber;
	@SerializedName("investmentPolicy")
	@Expose
	private InvestmentPolicy investmentPolicy;

	public String getPolicyNumber() {
	return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
	this.policyNumber = policyNumber;
	}

	public InvestmentPolicy getInvestmentPolicy() {
	return investmentPolicy;
	}

	public void setInvestmentPolicy(InvestmentPolicy investmentPolicy) {
	this.investmentPolicy = investmentPolicy;
	}
}
