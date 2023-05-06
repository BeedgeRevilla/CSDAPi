package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTABPLAN {
    @SerializedName("PLAND")
    @Expose
    private String PLAND;

    public String getPLAND() {
        return PLAND;
    }

    public void setPLAND(String PLAND) {
        this.PLAND = PLAND;
    }
}
