package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetActualServicingAgent {
    @SerializedName("ACTUALSERVICINGAGENTCODE1")
    @Expose
    private String ACTUALSERVICINGAGENTCODE1;

    public String getACTUALSERVICINGAGENTCODE1() {
        return ACTUALSERVICINGAGENTCODE1;
    }

    public void setACTUALSERVICINGAGENTCODE1(String ACTUALSERVICINGAGENTCODE1) {
        this.ACTUALSERVICINGAGENTCODE1 = ACTUALSERVICINGAGENTCODE1;
    }
}
