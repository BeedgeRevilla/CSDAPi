package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPPOLUS {
    @SerializedName("USDBK")
    @Expose
    private String USDBK;
    @SerializedName("USORP")
    @Expose
    private String USORP;
    @SerializedName("USIDINC")
    @Expose
    private String USIDINC;
    @SerializedName("USDAPP")
    @Expose
    private String USDAPP;

    public String getUSDBK() {
        return USDBK;
    }

    public void setUSDBK(String USDBK) {
        this.USDBK = USDBK;
    }

    public String getUSORP() {
        return USORP;
    }

    public void setUSORP(String USORP) {
        this.USORP = USORP;
    }

    public String getUSIDINC() {
        return USIDINC;
    }

    public void setUSIDINC(String USIDINC) {
        this.USIDINC = USIDINC;
    }

    public String getUSDAPP() {
        return USDAPP;
    }

    public void setUSDAPP(String USDAPP) {
        this.USDAPP = USDAPP;
    }
}
