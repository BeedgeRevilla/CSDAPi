package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Party {
    @SerializedName("genderCode")
    @Expose
    private String genderCode;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("partyTypeCode")
    @Expose
    private String partyTypeCode;
    @SerializedName("partyId")
    @Expose
    private String partyId;
    @SerializedName("telephoneContacts")
    @Expose
    private List<TelephoneContact> telephoneContacts = null;
    @SerializedName("physicalContacts")
    @Expose
    private List<PhysicalContact> physicalContacts = null;
    @SerializedName("electronicContacts")
    @Expose
    private List<ElectronicContact> electronicContacts = null;

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
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
