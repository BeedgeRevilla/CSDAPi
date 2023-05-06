package com.axa.testautomation.api.regional.RecordDocument.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordDocumentResponseContainer {
    @SerializedName("RecordDocumentResponse")
    @Expose
    private RecordDocumentResponse RecordDocumentResponse;

    public RecordDocumentResponse getRecordDocumentResponse() {
        return RecordDocumentResponse;
    }

    public void setRecordDocumentResponse(RecordDocumentResponse recordDocumentResponse) {
        RecordDocumentResponse = recordDocumentResponse;
    }
}
