package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PerVisitLimit {

	@SerializedName("amtDay")
	@Expose
	private String amtDay;
	@SerializedName("amtProcedure")
	@Expose
	private String amtProcedure;
	@SerializedName("amtProcedureAsRelative")
	@Expose
	private String amtProcedureAsRelative;
	@SerializedName("amtVisit")
	@Expose
	private String amtVisit;
	@SerializedName("consecutiveDays")
	@Expose
	private String consecutiveDays;
	@SerializedName("coPaymentVisit")
	@Expose
	private String coPaymentVisit;
	@SerializedName("dayVisit")
	@Expose
	private String dayVisit;
	
	public String getAmtDay() {
	return amtDay;
	}
	
	public void setAmtDay(String amtDay) {
	this.amtDay = amtDay;
	}
	
	public String getAmtProcedure() {
	return amtProcedure;
	}
	
	public void setAmtProcedure(String amtProcedure) {
	this.amtProcedure = amtProcedure;
	}
	
	public String getAmtProcedureAsRelative() {
	return amtProcedureAsRelative;
	}
	
	public void setAmtProcedureAsRelative(String amtProcedureAsRelative) {
	this.amtProcedureAsRelative = amtProcedureAsRelative;
	}
	
	public String getAmtVisit() {
	return amtVisit;
	}
	
	public void setAmtVisit(String amtVisit) {
	this.amtVisit = amtVisit;
	}
	
	public String getConsecutiveDays() {
	return consecutiveDays;
	}
	
	public void setConsecutiveDays(String consecutiveDays) {
	this.consecutiveDays = consecutiveDays;
	}
	
	public String getCoPaymentVisit() {
	return coPaymentVisit;
	}
	
	public void setCoPaymentVisit(String coPaymentVisit) {
	this.coPaymentVisit = coPaymentVisit;
	}
	
	public String getDayVisit() {
	return dayVisit;
	}
	
	public void setDayVisit(String dayVisit) {
	this.dayVisit = dayVisit;
	}

}
