package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartyRole {

    @SerializedName("partyRoleCode")
    @Expose
    private String partyRoleCode;
    @SerializedName("RLSParty")
    @Expose
    private RLSParty rLSParty;

    public String getPartyRoleCode() {
        return partyRoleCode;
    }

    public void setPartyRoleCode(String partyRoleCode) {
        this.partyRoleCode = partyRoleCode;
    }

    public RLSParty getRLSParty() {
        return rLSParty;
    }

    public void setRLSParty(RLSParty rLSParty) {
        this.rLSParty = rLSParty;
    }
}
