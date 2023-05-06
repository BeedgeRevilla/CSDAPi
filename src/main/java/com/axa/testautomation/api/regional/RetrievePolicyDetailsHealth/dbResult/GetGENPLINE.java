package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetGENPLINE {
	@SerializedName("GENPKEY")
	@Expose
	private String GENPKEY;
	@SerializedName("GENPLINE")
	@Expose
	private String GENPLINE;
	public String getGENPKEY() {
		return GENPKEY;
	}
	public void setGENPKEY(String gENPKEY) {
		GENPKEY = gENPKEY;
	}
	public String getGENPLINE() {
		return GENPLINE;
	}
	public void setGENPLINE(String gENPLINE) {
		GENPLINE = gENPLINE;
	}

}
