package com.axa.testautomation.api.regional.RecordDocument.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordDocumentRequest {

    @SerializedName("contentData")
    @Expose
    private String contentData;
    @SerializedName("documentElement")
    @Expose
    private DocumentElement documentElement;

    public String getContentData() {
        return contentData;
    }

    public void setContentData(String contentData) {
        this.contentData = contentData;
    }

    public DocumentElement getDocumentElement() {
        return documentElement;
    }

    public void setDocumentElement(DocumentElement documentElement) {
        this.documentElement = documentElement;
    }
}
