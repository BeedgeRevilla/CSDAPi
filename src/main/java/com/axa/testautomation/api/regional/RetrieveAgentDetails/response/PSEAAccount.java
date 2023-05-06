package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSEAAccount {
    @SerializedName("PSEADebitAccounts")
    @Expose
    private PSEADebitAccounts pSEADebitAccounts;

    public PSEADebitAccounts getPSEADebitAccounts() {
        return pSEADebitAccounts;
    }

    public void setPSEADebitAccounts(PSEADebitAccounts pSEADebitAccounts) {
        this.pSEADebitAccounts = pSEADebitAccounts;
    }
}
