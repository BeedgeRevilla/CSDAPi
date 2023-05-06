package com.axa.testautomation.api.regional.RetrieveClaimList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClaimPartyRole {
    @SerializedName("party")
    @Expose
    private Party party;

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }
}
