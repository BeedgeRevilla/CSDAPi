package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveAccountDetailsResponse {
    @SerializedName("PSEAPolicy")
    @Expose
    private PSEAPolicy pSEAPolicy;

    public PSEAPolicy getPSEAPolicy() {
        return pSEAPolicy;
    }

    public void setPSEAPolicy(PSEAPolicy pSEAPolicy) {
        this.pSEAPolicy = pSEAPolicy;
    }
}
