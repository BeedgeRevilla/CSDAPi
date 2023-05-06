package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AggregateLimit {

	@SerializedName("amtLife")
	@Expose
	private String amtLife;
	@SerializedName("amtMonth")
	@Expose
	private String amtMonth;
	@SerializedName("amtYear")
	@Expose
	private String amtYear;
	@SerializedName("visitLife")
	@Expose
	private String visitLife;
	@SerializedName("visitMonth")
	@Expose
	private String visitMonth;
	@SerializedName("visitYear")
	@Expose
	private String visitYear;
	
	public String getAmtLife() {
	return amtLife;
	}
	
	public void setAmtLife(String amtLife) {
	this.amtLife = amtLife;
	}
	
	public String getAmtMonth() {
	return amtMonth;
	}
	
	public void setAmtMonth(String amtMonth) {
	this.amtMonth = amtMonth;
	}
	
	public String getAmtYear() {
	return amtYear;
	}
	
	public void setAmtYear(String amtYear) {
	this.amtYear = amtYear;
	}
	
	public String getVisitLife() {
	return visitLife;
	}
	
	public void setVisitLife(String visitLife) {
	this.visitLife = visitLife;
	}
	
	public String getVisitMonth() {
	return visitMonth;
	}
	
	public void setVisitMonth(String visitMonth) {
	this.visitMonth = visitMonth;
	}
	
	public String getVisitYear() {
	return visitYear;
	}
	
	public void setVisitYear(String visitYear) {
	this.visitYear = visitYear;
	}

}
