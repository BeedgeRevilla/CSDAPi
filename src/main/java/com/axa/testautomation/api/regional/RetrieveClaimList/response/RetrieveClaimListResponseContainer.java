package com.axa.testautomation.api.regional.RetrieveClaimList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveClaimListResponseContainer {
    @SerializedName("RetrieveClaimListResponse")
    @Expose
    private RetrieveClaimListResponse retrieveClaimListResponse;

    public RetrieveClaimListResponse getRetrieveClaimListResponse() {
        return retrieveClaimListResponse;
    }

    public void setRetrieveClaimListResponse(RetrieveClaimListResponse retrieveClaimListResponse) {
        this.retrieveClaimListResponse = retrieveClaimListResponse;
    }

}
