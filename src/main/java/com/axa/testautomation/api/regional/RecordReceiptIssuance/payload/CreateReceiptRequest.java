package com.axa.testautomation.api.regional.RecordReceiptIssuance.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateReceiptRequest {

    @SerializedName("receipt")
    @Expose
    private Receipt receipt;

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
}
