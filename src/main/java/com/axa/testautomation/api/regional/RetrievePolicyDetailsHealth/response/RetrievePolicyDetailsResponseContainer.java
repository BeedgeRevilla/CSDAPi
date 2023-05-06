package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrievePolicyDetailsResponseContainer {
	@SerializedName("RetrievePolicyDetailsResponse")
	@Expose
	private RetrievePolicyDetailsResponse RetrievePolicyDetailsResponse;

    public RetrievePolicyDetailsResponse getRetrievePolicyDetailsResponse ()
    {
        return RetrievePolicyDetailsResponse;
    }

    public void setRetrievePolicyDetailsResponse (RetrievePolicyDetailsResponse RetrievePolicyDetailsResponse)
    {
        this.RetrievePolicyDetailsResponse = RetrievePolicyDetailsResponse;
    }
}
