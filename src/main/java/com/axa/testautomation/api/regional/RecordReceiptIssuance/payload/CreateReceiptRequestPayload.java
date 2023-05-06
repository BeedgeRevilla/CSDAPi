package com.axa.testautomation.api.regional.RecordReceiptIssuance.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateReceiptRequestPayload {
    @SerializedName("CreateReceiptRequest")
    @Expose
    private CreateReceiptRequest createReceiptRequest;

    public CreateReceiptRequest getCreateReceiptRequest() {
        return createReceiptRequest;
    }

    public void setCreateReceiptRequest(CreateReceiptRequest createReceiptRequest) {
        this.createReceiptRequest = createReceiptRequest;
    }
}
