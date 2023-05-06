package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPCDBLPIF {
    @SerializedName("Q49AUTORNS")
    @Expose
    private String Q49AUTORNS;

    public String getQ49AUTORNS() {
        return Q49AUTORNS;
    }

    public void setQ49AUTORNS(String q49AUTORNS) {
        Q49AUTORNS = q49AUTORNS;
    }
}
