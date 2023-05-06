package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveAccountDetailsResponseContainer {
    @SerializedName("RetrieveAccountDetailsResponse")
    @Expose
    private RetrieveAccountDetailsResponse retrieveAccountDetailsResponse;

    public RetrieveAccountDetailsResponse getRetrieveAccountDetailsResponse() {
        return retrieveAccountDetailsResponse;
    }

    public void setRetrieveAccountDetailsResponse(RetrieveAccountDetailsResponse retrieveAccountDetailsResponse) {
        this.retrieveAccountDetailsResponse = retrieveAccountDetailsResponse;
    }
}
