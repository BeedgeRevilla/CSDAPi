package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrievePolicyDetailsResponseContainer {
    @SerializedName("RetrievePolicyDetailsResponse")
    @Expose
    private RetrievePolicyDetailsResponse retrievePolicyDetailsResponse;

    public RetrievePolicyDetailsResponse getRetrievePolicyDetailsResponse() {
        return retrievePolicyDetailsResponse;
    }

    public void setRetrievePolicyDetailsResponse(RetrievePolicyDetailsResponse retrievePolicyDetailsResponse) {
        this.retrievePolicyDetailsResponse = retrievePolicyDetailsResponse;
    }
}
