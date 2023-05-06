package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartyRole {

	@SerializedName("partyRoleCode")
	@Expose
	private String partyRoleCode;
	@SerializedName("party")
	@Expose
	private Party party;
	
	public String getPartyRoleCode() {
	return partyRoleCode;
	}
	
	public void setPartyRoleCode(String partyRoleCode) {
	this.partyRoleCode = partyRoleCode;
	}
	
	public Party getParty() {
	return party;
	}
	
	public void setParty(Party party) {
	this.party = party;
	}

}
