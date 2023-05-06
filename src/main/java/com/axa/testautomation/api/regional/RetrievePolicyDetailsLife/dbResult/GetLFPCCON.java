package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPCCON {
    @SerializedName("POLICY_CONVERSION_NUMBER")
    @Expose
    private String POLICY_CONVERSION_NUMBER;
    @SerializedName("Q3OPNO")
    @Expose
    private String Q3OPNO;
    @SerializedName("Q3TEFF")
    @Expose
    private String Q3TEFF;

    public String getPOLICY_CONVERSION_NUMBER() {
        return POLICY_CONVERSION_NUMBER;
    }

    public void setPOLICY_CONVERSION_NUMBER(String POLICY_CONVERSION_NUMBER) {
        this.POLICY_CONVERSION_NUMBER = POLICY_CONVERSION_NUMBER;
    }

    public String getQ3OPNO() {
        return Q3OPNO;
    }

    public void setQ3OPNO(String q3OPNO) {
        Q3OPNO = q3OPNO;
    }

    public String getQ3TEFF() {
        return Q3TEFF;
    }

    public void setQ3TEFF(String q3TEFF) {
        Q3TEFF = q3TEFF;
    }
}
