package com.axa.testautomation.api.regional.RecordDocument.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordDocumentResponse {
    @SerializedName("responseFlag")
    @Expose
    private String responseFlag;

    public String getResponseFlag() {
        return responseFlag;
    }

    public void setResponseFlag(String responseFlag) {
        this.responseFlag = responseFlag;
    }
}
