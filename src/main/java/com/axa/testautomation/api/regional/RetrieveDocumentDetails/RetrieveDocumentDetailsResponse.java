package com.axa.testautomation.api.regional.RetrieveDocumentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveDocumentDetailsResponse {

    @SerializedName("documentContent")
    @Expose
    private String documentContent;
    @SerializedName("documentURL")
    @Expose
    private String documentURL;
    @SerializedName("documentElement")
    @Expose
    private DocumentElement documentElement;

    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public String getDocumentURL() {
        return documentURL;
    }

    public void setDocumentURL(String documentURL) {
        this.documentURL = documentURL;
    }

    public DocumentElement getDocumentElement() {
        return documentElement;
    }

    public void setDocumentElement(DocumentElement documentElement) {
        this.documentElement = documentElement;
    }
}
