package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetTABSTAFF {
    @SerializedName("STAFF_FLAG")
    @Expose
    private String STAFF_FLAG;

    public String getSTAFF_FLAG() {
        return STAFF_FLAG;
    }

    public void setSTAFF_FLAG(String STAFF_FLAG) {
        this.STAFF_FLAG = STAFF_FLAG;
    }
}
