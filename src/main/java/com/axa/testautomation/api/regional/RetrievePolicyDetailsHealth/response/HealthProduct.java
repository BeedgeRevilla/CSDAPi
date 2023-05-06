package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HealthProduct {

	@SerializedName("productStartDate")
	@Expose
	private String productStartDate;
	@SerializedName("productCode")
	@Expose
	private String productCode;
	@SerializedName("familyCode")
	@Expose
	private String familyCode;
	@SerializedName("underwriteringDecision")
	@Expose
	private String underwriteringDecision;
	@SerializedName("Plan")
	@Expose
	private List<Plan> plan = null;
	@SerializedName("preExistingCondStart")
	@Expose
	private String preExistingCondStart;
	@SerializedName("preExistingCondEnd")
	@Expose
	private String preExistingCondEnd;
	
	public String getProductStartDate() {
	return productStartDate;
	}
	
	public void setProductStartDate(String productStartDate) {
	this.productStartDate = productStartDate;
	}
	
	public String getProductCode() {
	return productCode;
	}
	
	public void setProductCode(String productCode) {
	this.productCode = productCode;
	}
	
	public String getFamilyCode() {
	return familyCode;
	}
	
	public void setFamilyCode(String familyCode) {
	this.familyCode = familyCode;
	}
	
	public String getUnderwriteringDecision() {
	return underwriteringDecision;
	}
	
	public void setUnderwriteringDecision(String underwriteringDecision) {
	this.underwriteringDecision = underwriteringDecision;
	}
	
	public List<Plan> getPlan() {
	return plan;
	}
	
	public void setPlan(List<Plan> plan) {
	this.plan = plan;
	}
	
	public String getPreExistingCondStart() {
	return preExistingCondStart;
	}
	
	public void setPreExistingCondStart(String preExistingCondStart) {
	this.preExistingCondStart = preExistingCondStart;
	}
	
	public String getPreExistingCondEnd() {
	return preExistingCondEnd;
	}
	
	public void setPreExistingCondEnd(String preExistingCondEnd) {
	this.preExistingCondEnd = preExistingCondEnd;
	}

}
