package com.axa.testautomation.api.regional.RetrieveFundList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTotalAccountValueAmount {
    @SerializedName("TOTAL_ACCT_VAL")
    @Expose
    private Double TOTAL_ACCT_VAL;

    public Double getTOTAL_ACCT_VAL() {
        return TOTAL_ACCT_VAL;
    }

    public void setTOTAL_ACCT_VAL(Double TOTAL_ACCT_VAL) {
        this.TOTAL_ACCT_VAL = TOTAL_ACCT_VAL;
    }
}
