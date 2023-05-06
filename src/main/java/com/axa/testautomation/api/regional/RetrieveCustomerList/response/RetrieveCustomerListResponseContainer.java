package com.axa.testautomation.api.regional.RetrieveCustomerList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveCustomerListResponseContainer {
    @SerializedName("RetrieveCustomerListResponse")
    @Expose
    private RetrieveCustomerListResponse retrieveCustomerListResponse;

    public RetrieveCustomerListResponse getRetrieveCustomerListResponse() {
        return retrieveCustomerListResponse;
    }

    public void setRetrieveCustomerListResponse(RetrieveCustomerListResponse retrieveCustomerListResponse) {
        this.retrieveCustomerListResponse = retrieveCustomerListResponse;
    }
}
