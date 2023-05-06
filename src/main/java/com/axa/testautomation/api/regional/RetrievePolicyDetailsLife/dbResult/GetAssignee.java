package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAssignee {
    @SerializedName("ADDRESS_TYPE_CODE")
    @Expose
    private String ADDRESS_TYPE_CODE;
    @SerializedName("LASSA1")
    @Expose
    private String LASSA1;
    @SerializedName("LASSA2")
    @Expose
    private String LASSA2;
    @SerializedName("LASSA3")
    @Expose
    private String LASSA3;
    @SerializedName("LASSA4")
    @Expose
    private String LASSA4;
    @SerializedName("LASCTY")
    @Expose
    private String LASCTY;

    public String getADDRESS_TYPE_CODE() {
        return ADDRESS_TYPE_CODE;
    }

    public void setADDRESS_TYPE_CODE(String ADDRESS_TYPE_CODE) {
        this.ADDRESS_TYPE_CODE = ADDRESS_TYPE_CODE;
    }

    public String getLASSA1() {
        return LASSA1;
    }

    public void setLASSA1(String LASSA1) {
        this.LASSA1 = LASSA1;
    }

    public String getLASSA2() {
        return LASSA2;
    }

    public void setLASSA2(String LASSA2) {
        this.LASSA2 = LASSA2;
    }

    public String getLASSA3() {
        return LASSA3;
    }

    public void setLASSA3(String LASSA3) {
        this.LASSA3 = LASSA3;
    }

    public String getLASSA4() {
        return LASSA4;
    }

    public void setLASSA4(String LASSA4) {
        this.LASSA4 = LASSA4;
    }

    public String getLASCTY() {
        return LASCTY;
    }

    public void setLASCTY(String LASCTY) {
        this.LASCTY = LASCTY;
    }
}
