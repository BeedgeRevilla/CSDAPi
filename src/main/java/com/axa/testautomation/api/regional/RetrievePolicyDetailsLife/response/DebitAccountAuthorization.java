package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DebitAccountAuthorization {

    @SerializedName("bankAccountNumber")
    @Expose
    private String bankAccountNumber;
    @SerializedName("bankAccountStatus")
    @Expose
    private String bankAccountStatus;
    @SerializedName("processingDate")
    @Expose
    private String processingDate;
    @SerializedName("debtor")
    @Expose
    private Debtor debtor;

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountStatus() {
        return bankAccountStatus;
    }

    public void setBankAccountStatus(String bankAccountStatus) {
        this.bankAccountStatus = bankAccountStatus;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }
}
