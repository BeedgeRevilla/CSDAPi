package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetChineseProductName {
    @SerializedName("H9DESC")
    @Expose
    private String H9DESC;

    public String getH9DESC() {
        return H9DESC;
    }

    public void setH9DESC(String h9DESC) {
        H9DESC = h9DESC;
    }
}
