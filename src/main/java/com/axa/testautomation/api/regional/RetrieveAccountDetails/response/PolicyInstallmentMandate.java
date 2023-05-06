package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PolicyInstallmentMandate {
    @SerializedName("mandateStatusDescription")
    @Expose
    private String mandateStatusDescription;
    @SerializedName("mandateEffectiveDate")
    @Expose
    private String mandateEffectiveDate;
    @SerializedName("mandateStatusCode")
    @Expose
    private String mandateStatusCode;
    @SerializedName("payor")
    @Expose
    private Payor payor;

    public String getMandateStatusDescription() {
        return mandateStatusDescription;
    }

    public void setMandateStatusDescription(String mandateStatusDescription) {
        this.mandateStatusDescription = mandateStatusDescription;
    }

    public String getMandateEffectiveDate() {
        return mandateEffectiveDate;
    }

    public void setMandateEffectiveDate(String mandateEffectiveDate) {
        this.mandateEffectiveDate = mandateEffectiveDate;
    }

    public String getMandateStatusCode() {
        return mandateStatusCode;
    }

    public void setMandateStatusCode(String mandateStatusCode) {
        this.mandateStatusCode = mandateStatusCode;
    }

    public Payor getPayor() {
        return payor;
    }

    public void setPayor(Payor payor) {
        this.payor = payor;
    }
}
