package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Payor {
    @SerializedName("displayNameFormat")
    @Expose
    private String displayNameFormat;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("partyId")
    @Expose
    private String partyId;
    @SerializedName("PSEAAccounts")
    @Expose
    private List<PSEAAccount> pSEAAccounts = null;

    public String getDisplayNameFormat() {
        return displayNameFormat;
    }

    public void setDisplayNameFormat(String displayNameFormat) {
        this.displayNameFormat = displayNameFormat;
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

    public List<PSEAAccount> getPSEAAccounts() {
        return pSEAAccounts;
    }

    public void setPSEAAccounts(List<PSEAAccount> pSEAAccounts) {
        this.pSEAAccounts = pSEAAccounts;
    }
}
