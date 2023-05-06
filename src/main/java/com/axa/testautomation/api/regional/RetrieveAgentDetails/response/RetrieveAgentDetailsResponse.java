package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveAgentDetailsResponse {
    @SerializedName("PSEAAgent")
    @Expose
    private PSEAAgent pSEAAgent;

    public PSEAAgent getPSEAAgent() {
        return pSEAAgent;
    }

    public void setPSEAAgent(PSEAAgent pSEAAgent) {
        this.pSEAAgent = pSEAAgent;
    }
}
