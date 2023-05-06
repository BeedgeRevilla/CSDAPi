package com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetForLFPPML {
    @SerializedName("TOTAL_COUNT")
    @Expose
    private Integer tOTALCOUNT;
    @SerializedName("PAYMENT_METHOD")
    @Expose
    private String pAYMENTMETHOD;

    public Integer getTOTALCOUNT() {
        return tOTALCOUNT;
    }

    public void setTOTALCOUNT(Integer tOTALCOUNT) {
        this.tOTALCOUNT = tOTALCOUNT;
    }

    public String getPAYMENTMETHOD() {
        return pAYMENTMETHOD;
    }

    public void setPAYMENTMETHOD(String pAYMENTMETHOD) {
        this.pAYMENTMETHOD = pAYMENTMETHOD;
    }
}
