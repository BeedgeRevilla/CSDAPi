package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import java.util.Comparator;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plan {

	@SerializedName("planCode")
	@Expose
	private String planCode;
	@SerializedName("planDescription")
	@Expose
	private String planDescription;
	@SerializedName("planEffectiveDate")
	@Expose
	private String planEffectiveDate;
	@SerializedName("originalPlanCode")
	@Expose
	private String originalPlanCode;
	@SerializedName("classOfInsured")
	@Expose
	private String classOfInsured;
	@SerializedName("whomToApplyLimit")
	@Expose
	private String whomToApplyLimit;
	@SerializedName("ProviderNetwork")
	@Expose
	private ProviderNetwork providerNetwork;
	@SerializedName("benefitCd")
	@Expose
	private String benefitCd;
	@SerializedName("healthProductRemark")
	@Expose
	private HealthProductRemark healthProductRemark;
	@SerializedName("cardType01")
	@Expose
	private String cardType01;
	
	public static Comparator<Plan> PlanComparator= new Comparator<Plan> (){
        public int compare(Plan a, Plan b){
//            String s1 = (a.getBenefitCd() == null) ?  "" : a.getBenefitCd() + a.getHealthProductRemark().getPerVisitLimit().getDayVisit();
//            String s2 = (b.getBenefitCd() == null) ?  "" : b.getBenefitCd() + b.getHealthProductRemark().getPerVisitLimit().getDayVisit();
        	String s1 = a.getBenefitCd();
            String s2 = b.getBenefitCd();
            return s1.compareTo(s2);
        }
    };
	
	public String getPlanCode() {
	return planCode;
	}
	
	public void setPlanCode(String planCode) {
	this.planCode = planCode;
	}
	
	public String getPlanDescription() {
	return planDescription;
	}
	
	public void setPlanDescription(String planDescription) {
	this.planDescription = planDescription;
	}
	
	public String getPlanEffectiveDate() {
	return planEffectiveDate;
	}
	
	public void setPlanEffectiveDate(String planEffectiveDate) {
	this.planEffectiveDate = planEffectiveDate;
	}
	
	public String getOriginalPlanCode() {
	return originalPlanCode;
	}
	
	public void setOriginalPlanCode(String originalPlanCode) {
	this.originalPlanCode = originalPlanCode;
	}
	
	public String getClassOfInsured() {
	return classOfInsured;
	}
	
	public void setClassOfInsured(String classOfInsured) {
	this.classOfInsured = classOfInsured;
	}
	
	public String getWhomToApplyLimit() {
	return whomToApplyLimit;
	}
	
	public void setWhomToApplyLimit(String whomToApplyLimit) {
	this.whomToApplyLimit = whomToApplyLimit;
	}
	
	public ProviderNetwork getProviderNetwork() {
	return providerNetwork;
	}
	
	public void setProviderNetwork(ProviderNetwork providerNetwork) {
	this.providerNetwork = providerNetwork;
	}
	
	public String getBenefitCd() {
	return benefitCd;
	}
	
	public void setBenefitCd(String benefitCd) {
	this.benefitCd = benefitCd;
	}
	
	public HealthProductRemark getHealthProductRemark() {
	return healthProductRemark;
	}
	
	public void setHealthProductRemark(HealthProductRemark healthProductRemark) {
	this.healthProductRemark = healthProductRemark;
	}
	
	public String getCardType01() {
	return cardType01;
	}
	
	public void setCardType01(String cardType01) {
	this.cardType01 = cardType01;
	}

}
