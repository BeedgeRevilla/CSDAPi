package com.axa.testautomation.api.regional.RecordReceiptIssuance.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentLineItem {

    @SerializedName("subAccountCode")
    @Expose
    private String subAccountCode;
    @SerializedName("subAccountType")
    @Expose
    private String subAccountType;
    @SerializedName("transactionDescription")
    @Expose
    private String transactionDescription;
    @SerializedName("originalAmount")
    @Expose
    private String originalAmount;
    @SerializedName("policyNumber")
    @Expose
    private String policyNumber;

    public String getSubAccountCode() {
        return subAccountCode;
    }

    public void setSubAccountCode(String subAccountCode) {
        this.subAccountCode = subAccountCode;
    }

    public String getSubAccountType() {
        return subAccountType;
    }

    public void setSubAccountType(String subAccountType) {
        this.subAccountType = subAccountType;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public String getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(String originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
