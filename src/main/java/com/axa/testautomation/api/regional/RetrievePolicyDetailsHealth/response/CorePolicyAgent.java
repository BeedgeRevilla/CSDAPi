package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CorePolicyAgent {

	@SerializedName("party")
	@Expose
	private Party party;
	
	public Party getParty() {
	return party;
	}
	
	public void setParty(Party party) {
	this.party = party;
	}

}
