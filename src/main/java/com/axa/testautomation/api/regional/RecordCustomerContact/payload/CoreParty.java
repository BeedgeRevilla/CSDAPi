package com.axa.testautomation.api.regional.RecordCustomerContact.payload;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoreParty {

	@SerializedName("coreDBPartyId")
	@Expose
	private String coreDBPartyId;
	@SerializedName("partyId")
	@Expose
	private String partyId;
	@SerializedName("masterIndividualId")
	@Expose
	private String masterIndividualId;
	@SerializedName("telephoneContacts")
	@Expose
	private List<TelephoneContact> telephoneContacts = null;
	@SerializedName("physicalContacts")
	@Expose
	private List<PhysicalContact> physicalContacts = null;
	@SerializedName("electronicContacts")
	@Expose
	private List<ElectronicContact> electronicContacts = null;
	
	public String getCoreDBPartyId() {
	return coreDBPartyId;
	}
	
	public void setCoreDBPartyId(String coreDBPartyId) {
	this.coreDBPartyId = coreDBPartyId;
	}
	
	public String getPartyId() {
	return partyId;
	}
	
	public void setPartyId(String partyId) {
	this.partyId = partyId;
	}
	
	public String getMasterIndividualId() {
	return masterIndividualId;
	}
	
	public void setMasterIndividualId(String masterIndividualId) {
	this.masterIndividualId = masterIndividualId;
	}
	
	public List<TelephoneContact> getTelephoneContacts() {
	return telephoneContacts;
	}
	
	public void setTelephoneContacts(List<TelephoneContact> telephoneContacts) {
	this.telephoneContacts = telephoneContacts;
	}
	
	public List<PhysicalContact> getPhysicalContacts() {
	return physicalContacts;
	}
	
	public void setPhysicalContacts(List<PhysicalContact> physicalContacts) {
	this.physicalContacts = physicalContacts;
	}
	
	public List<ElectronicContact> getElectronicContacts() {
	return electronicContacts;
	}
	
	public void setElectronicContacts(List<ElectronicContact> electronicContacts) {
	this.electronicContacts = electronicContacts;
	}

}
