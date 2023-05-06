package com.axa.testautomation.api.regional.RecordCustomer.payload;

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
	@SerializedName("birthDate")
	@Expose
	private String birthDate;
	@SerializedName("firstName")
	@Expose
	private String firstName;
	@SerializedName("genderCode")
	@Expose
	private String genderCode;
	@SerializedName("idDocumentNumber")
	@Expose
	private String idDocumentNumber;
	@SerializedName("idDocumentTypeCode")
	@Expose
	private String idDocumentTypeCode;
	@SerializedName("lastName")
	@Expose
	private String lastName;
	@SerializedName("middleName")
	@Expose
	private String middleName;
	@SerializedName("localFirstName")
	@Expose
	private String localFirstName;
	@SerializedName("localLastName")
	@Expose
	private String localLastName;
	@SerializedName("salutationText")
	@Expose
	private String salutationText;
	@SerializedName("primaryLanguageCode")
	@Expose
	private String primaryLanguageCode;
	@SerializedName("marketableFlag")
	@Expose
	private String marketableFlag;
	
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
	
	public String getBirthDate() {
	return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
	}
	
	public String getFirstName() {
	return firstName;
	}
	
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	
	public String getGenderCode() {
	return genderCode;
	}
	
	public void setGenderCode(String genderCode) {
	this.genderCode = genderCode;
	}
	
	public String getIdDocumentNumber() {
	return idDocumentNumber;
	}
	
	public void setIdDocumentNumber(String idDocumentNumber) {
	this.idDocumentNumber = idDocumentNumber;
	}
	
	public String getIdDocumentTypeCode() {
	return idDocumentTypeCode;
	}
	
	public void setIdDocumentTypeCode(String idDocumentTypeCode) {
	this.idDocumentTypeCode = idDocumentTypeCode;
	}
	
	public String getLastName() {
	return lastName;
	}
	
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	
	public String getMiddleName() {
	return middleName;
	}
	
	public void setMiddleName(String middleName) {
	this.middleName = middleName;
	}
	
	public String getLocalFirstName() {
	return localFirstName;
	}
	
	public void setLocalFirstName(String localFirstName) {
	this.localFirstName = localFirstName;
	}
	
	public String getLocalLastName() {
	return localLastName;
	}
	
	public void setLocalLastName(String localLastName) {
	this.localLastName = localLastName;
	}
	
	public String getSalutationText() {
	return salutationText;
	}
	
	public void setSalutationText(String salutationText) {
	this.salutationText = salutationText;
	}
	
	public String getPrimaryLanguageCode() {
	return primaryLanguageCode;
	}
	
	public void setPrimaryLanguageCode(String primaryLanguageCode) {
	this.primaryLanguageCode = primaryLanguageCode;
	}
	
	public String getMarketableFlag() {
	return marketableFlag;
	}
	
	public void setMarketableFlag(String marketableFlag) {
	this.marketableFlag = marketableFlag;
	}

}
