package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveAgentDetailsResponseContainer {
    @SerializedName("RetrieveAgentDetailsResponse")
    @Expose
    private RetrieveAgentDetailsResponse retrieveAgentDetailsResponse;

    public RetrieveAgentDetailsResponse getRetrieveAgentDetailsResponse() {
        return retrieveAgentDetailsResponse;
    }

    public void setRetrieveAgentDetailsResponse(RetrieveAgentDetailsResponse retrieveAgentDetailsResponse) {
        this.retrieveAgentDetailsResponse = retrieveAgentDetailsResponse;
    }
}
