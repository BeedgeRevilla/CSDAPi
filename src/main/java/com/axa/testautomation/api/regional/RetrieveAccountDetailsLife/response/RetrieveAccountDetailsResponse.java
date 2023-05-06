package com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveAccountDetailsResponse {

    @SerializedName("RLSPolicy")
    @Expose
    private RLSPolicy rLSPolicy;

    public RLSPolicy getRLSPolicy() {
        return rLSPolicy;
    }

    public void setRLSPolicy(RLSPolicy rLSPolicy) {
        this.rLSPolicy = rLSPolicy;
    }
}
