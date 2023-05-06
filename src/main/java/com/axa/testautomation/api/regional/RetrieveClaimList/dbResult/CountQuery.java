package com.axa.testautomation.api.regional.RetrieveClaimList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountQuery {
    @SerializedName("TOTAL_REC_COUNT")
    @Expose
    private Integer tOTALRECCOUNT;

    public Integer getTOTALRECCOUNT() {
        return tOTALRECCOUNT;
    }

    public void setTOTALRECCOUNT(Integer tOTALRECCOUNT) {
        this.tOTALRECCOUNT = tOTALRECCOUNT;
    }
}
