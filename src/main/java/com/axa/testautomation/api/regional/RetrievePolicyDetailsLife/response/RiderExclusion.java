package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RiderExclusion {

    @SerializedName("exclusionCode")
    @Expose
    private String exclusionCode;

    public String getExclusionCode() {
        return exclusionCode;
    }

    public void setExclusionCode(String exclusionCode) {
        this.exclusionCode = exclusionCode;
    }
}
