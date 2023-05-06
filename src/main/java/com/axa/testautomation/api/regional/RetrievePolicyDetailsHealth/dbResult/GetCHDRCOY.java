package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCHDRCOY {
	@SerializedName("PREEXIBEF")
	@Expose
	private String PREEXIBEF;
	@SerializedName("PREEXIAFT")
	@Expose
	private String PREEXIAFT;
	public String getPREEXIBEF() {
		return PREEXIBEF;
	}
	public void setPREEXIBEF(String pREEXIBEF) {
		PREEXIBEF = pREEXIBEF;
	}
	public String getPREEXIAFT() {
		return PREEXIAFT;
	}
	public void setPREEXIAFT(String pREEXIAFT) {
		PREEXIAFT = pREEXIAFT;
	}

}
