package com.axa.testautomation.api.regional.RecordDocument.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordDocumentRequestPayload {
    @SerializedName("RecordDocumentRequest")
    @Expose
    private RecordDocumentRequest recordDocumentRequest;

    public RecordDocumentRequest getRecordDocumentRequest() {
        return recordDocumentRequest;
    }

    public void setRecordDocumentRequest(RecordDocumentRequest recordDocumentRequest) {
        this.recordDocumentRequest = recordDocumentRequest;
    }
}
