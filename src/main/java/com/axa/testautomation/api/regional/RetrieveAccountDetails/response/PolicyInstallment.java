package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PolicyInstallment {
    @SerializedName("installmentEffectiveDates")
    @Expose
    private List<String> installmentEffectiveDates = null;
    @SerializedName("installmentFrequency")
    @Expose
    private String installmentFrequency;
    @SerializedName("policyInstallmentMandate")
    @Expose
    private PolicyInstallmentMandate policyInstallmentMandate;

    public List<String> getInstallmentEffectiveDates() {
        return installmentEffectiveDates;
    }

    public void setInstallmentEffectiveDates(List<String> installmentEffectiveDates) {
        this.installmentEffectiveDates = installmentEffectiveDates;
    }

    public String getInstallmentFrequency() {
        return installmentFrequency;
    }

    public void setInstallmentFrequency(String installmentFrequency) {
        this.installmentFrequency = installmentFrequency;
    }

    public PolicyInstallmentMandate getPolicyInstallmentMandate() {
        return policyInstallmentMandate;
    }

    public void setPolicyInstallmentMandate(PolicyInstallmentMandate policyInstallmentMandate) {
        this.policyInstallmentMandate = policyInstallmentMandate;
    }
}
