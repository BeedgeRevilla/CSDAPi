package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PSEAParty {
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("PSEAAccounts")
    @Expose
    private List<PSEAAccount> pSEAAccounts = null;

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

    public List<PSEAAccount> getPSEAAccounts() {
        return pSEAAccounts;
    }

    public void setPSEAAccounts(List<PSEAAccount> pSEAAccounts) {
        this.pSEAAccounts = pSEAAccounts;
    }
}
