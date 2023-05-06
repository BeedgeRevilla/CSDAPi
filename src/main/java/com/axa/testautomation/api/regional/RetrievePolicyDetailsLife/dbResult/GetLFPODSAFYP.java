package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPODSAFYP {
    @SerializedName("ANNL_FRST_YR_PRM")
    @Expose
    private String ANNL_FRST_YR_PRM;

    public String getANNL_FRST_YR_PRM() {
        return ANNL_FRST_YR_PRM;
    }

    public void setANNL_FRST_YR_PRM(String ANNL_FRST_YR_PRM) {
        this.ANNL_FRST_YR_PRM = ANNL_FRST_YR_PRM;
    }
}
