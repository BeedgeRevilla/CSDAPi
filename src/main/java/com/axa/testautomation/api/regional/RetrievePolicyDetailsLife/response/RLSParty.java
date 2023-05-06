package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RLSParty {

    @SerializedName("birthDate")
    @Expose
    private String birthDate;
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
    @SerializedName("partyIdentifiers")
    @Expose
    private List<PartyIdentifier> partyIdentifiers = null;
    @SerializedName("physicalContacts")
    @Expose
    private List<PhysicalContact> physicalContacts = null;

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

    public List<PartyIdentifier> getPartyIdentifiers() {
        return partyIdentifiers;
    }

    public void setPartyIdentifiers(List<PartyIdentifier> partyIdentifiers) {
        this.partyIdentifiers = partyIdentifiers;
    }

    public List<PhysicalContact> getPhysicalContacts() {
        return physicalContacts;
    }

    public void setPhysicalContacts(List<PhysicalContact> physicalContacts) {
        this.physicalContacts = physicalContacts;
    }
}
