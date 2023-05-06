package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Party {

	@SerializedName("firstName")
	@Expose
	private String firstName;
	@SerializedName("lastName")
	@Expose
	private String lastName;
	@SerializedName("partyId")
	@Expose
	private String partyId;
	@SerializedName("birthDate")
	@Expose
	private String birthDate;

	@SerializedName("genderCode")
	@Expose
	private String genderCode;

	@SerializedName("maritalStatusCode")
	@Expose
	private String maritalStatusCode;

	@SerializedName("passportNumber")
	@Expose
	private String passportNumber;
	@SerializedName("occupationClassCode")
	@Expose
	private String occupationClassCode;
	@SerializedName("age")
	@Expose
	private String age;

	public String getBirthDate() {
	return birthDate;
	}

	public void setBirthDate(String birthDate) {
	this.birthDate = birthDate;
	}


	public String getGenderCode() {
	return genderCode;
	}

	public void setGenderCode(String genderCode) {
	this.genderCode = genderCode;
	}

	public String getMaritalStatusCode() {
	return maritalStatusCode;
	}

	public void setMaritalStatusCode(String maritalStatusCode) {
	this.maritalStatusCode = maritalStatusCode;
	}

	public String getPassportNumber() {
	return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
	this.passportNumber = passportNumber;
	}

	public String getOccupationClassCode() {
	return occupationClassCode;
	}

	public void setOccupationClassCode(String occupationClassCode) {
	this.occupationClassCode = occupationClassCode;
	}

	public String getAge() {
	return age;
	}

	public void setAge(String age) {
	this.age = age;
	}
	
	public String getFirstName() {
	return firstName;
	}
	
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	
	public String getLastName() {
	return lastName;
	}
	
	public void setLastName(String lastName) {
	this.lastName = lastName;
	}
	
	public String getPartyId() {
	return partyId;
	}
	
	public void setPartyId(String partyId) {
	this.partyId = partyId;
	}

}
