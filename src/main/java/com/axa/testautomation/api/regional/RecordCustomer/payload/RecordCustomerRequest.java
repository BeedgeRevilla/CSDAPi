package com.axa.testautomation.api.regional.RecordCustomer.payload;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordCustomerRequest {

	@SerializedName("coreParty")
	@Expose
	private CoreParty coreParty;
	@SerializedName("partyModificationParameter")
	@Expose
	private List<PartyModificationParameter> partyModificationParameter = null;
	
	public CoreParty getCoreParty() {
	return coreParty;
	}
	
	public void setCoreParty(CoreParty coreParty) {
	this.coreParty = coreParty;
	}
	
	public List<PartyModificationParameter> getPartyModificationParameter() {
	return partyModificationParameter;
	}
	
	public void setPartyModificationParameter(List<PartyModificationParameter> partyModificationParameter) {
	this.partyModificationParameter = partyModificationParameter;
	}

}
