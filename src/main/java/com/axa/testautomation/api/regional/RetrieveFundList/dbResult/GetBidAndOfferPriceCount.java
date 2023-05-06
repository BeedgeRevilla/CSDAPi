package com.axa.testautomation.api.regional.RetrieveFundList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBidAndOfferPriceCount {

	@SerializedName("FPBIDP")
	@Expose
	private Double fPBIDP;
	@SerializedName("FPOFFP")
	@Expose
	private Double fPOFFP;
	@SerializedName("M4CODE")
	@Expose
	private String m4CODE;

	public Double getFPBIDP() {
	return fPBIDP;
	}

	public void setFPBIDP(Double fPBIDP) {
	this.fPBIDP = fPBIDP;
	}

	public Double getFPOFFP() {
	return fPOFFP;
	}

	public void setFPOFFP(Double fPOFFP) {
	this.fPOFFP = fPOFFP;
	}

	public String getM4CODE() {
	return m4CODE;
	}

	public void setM4CODE(String m4CODE) {
	this.m4CODE = m4CODE;
	}


}