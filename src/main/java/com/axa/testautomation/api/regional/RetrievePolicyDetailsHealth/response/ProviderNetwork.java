package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProviderNetwork {

	@SerializedName("providerNetworkCode")
	@Expose
	private String providerNetworkCode;
	
	public String getProviderNetworkCode() {
	return providerNetworkCode;
	}
	
	public void setProviderNetworkCode(String providerNetworkCode) {
	this.providerNetworkCode = providerNetworkCode;
	}

}
