package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSEAPolicy {
    @SerializedName("policyInstallment")
    @Expose
    private PolicyInstallment policyInstallment;

    public PolicyInstallment getPolicyInstallment() {
        return policyInstallment;
    }

    public void setPolicyInstallment(PolicyInstallment policyInstallment) {
        this.policyInstallment = policyInstallment;
    }
}
