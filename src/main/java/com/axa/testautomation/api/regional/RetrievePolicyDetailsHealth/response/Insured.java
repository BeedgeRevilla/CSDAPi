package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Insured {

	@SerializedName("HealthProduct")
	@Expose
	private List<HealthProduct> healthProduct = null;
	@SerializedName("Party")
	@Expose
	private Party party;
	@SerializedName("dependentNumber")
	@Expose
	private String dependentNumber;
	@SerializedName("exclusionDesc")
	@Expose
	private String exclusionDesc;
	
	public List<HealthProduct> getHealthProduct() {
	return healthProduct;
	}
	
	public void setHealthProduct(List<HealthProduct> healthProduct) {
	this.healthProduct = healthProduct;
	}
	
	public Party getParty() {
	return party;
	}
	
	public void setParty(Party party) {
	this.party = party;
	}
	
	public String getDependentNumber() {
	return dependentNumber;
	}
	
	public void setDependentNumber(String dependentNumber) {
	this.dependentNumber = dependentNumber;
	}
	
	public String getExclusionDesc() {
	return exclusionDesc;
	}
	
	public void setExclusionDesc(String exclusionDesc) {
	this.exclusionDesc = exclusionDesc;
	}

}
