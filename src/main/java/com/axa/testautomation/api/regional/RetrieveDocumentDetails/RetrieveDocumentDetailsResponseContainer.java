package com.axa.testautomation.api.regional.RetrieveDocumentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveDocumentDetailsResponseContainer {
    @SerializedName("RetrieveDocumentDetailsResponse")
    @Expose
    private RetrieveDocumentDetailsResponse retrieveDocumentDetailsResponse;

    public RetrieveDocumentDetailsResponse getRetrieveDocumentDetailsResponse() {
        return retrieveDocumentDetailsResponse;
    }

    public void setRetrieveDocumentDetailsResponse(RetrieveDocumentDetailsResponse retrieveDocumentDetailsResponse) {
        this.retrieveDocumentDetailsResponse = retrieveDocumentDetailsResponse;
    }
}
