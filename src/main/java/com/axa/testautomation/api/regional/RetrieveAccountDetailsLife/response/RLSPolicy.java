package com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RLSPolicy {

    @SerializedName("policyNumber")
    @Expose
    private String policyNumber;
    @SerializedName("premiumPaymentMethod")
    @Expose
    private String premiumPaymentMethod;
    @SerializedName("debitAccountAuthorization")
    @Expose
    private DebitAccountAuthorization debitAccountAuthorization;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPremiumPaymentMethod() {
        return premiumPaymentMethod;
    }

    public void setPremiumPaymentMethod(String premiumPaymentMethod) {
        this.premiumPaymentMethod = premiumPaymentMethod;
    }

    public DebitAccountAuthorization getDebitAccountAuthorization() {
        return debitAccountAuthorization;
    }

    public void setDebitAccountAuthorization(DebitAccountAuthorization debitAccountAuthorization) {
        this.debitAccountAuthorization = debitAccountAuthorization;
    }
}
