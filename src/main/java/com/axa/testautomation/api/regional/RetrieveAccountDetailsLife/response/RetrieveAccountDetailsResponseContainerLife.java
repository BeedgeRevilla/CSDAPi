package com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveAccountDetailsResponseContainerLife {
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
