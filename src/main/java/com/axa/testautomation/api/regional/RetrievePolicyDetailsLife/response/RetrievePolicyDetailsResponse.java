package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrievePolicyDetailsResponse {
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
