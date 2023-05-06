package com.axa.testautomation.api.regional.RetrieveDocumentDetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocumentElement {

    @SerializedName("MIMEType")
    @Expose
    private String mIMEType;
    @SerializedName("documentTitle")
    @Expose
    private String documentTitle;

    public String getMIMEType() {
        return mIMEType;
    }

    public void setMIMEType(String mIMEType) {
        this.mIMEType = mIMEType;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

}
