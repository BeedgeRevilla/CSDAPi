package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetDebitAccountAuthorization {
    @SerializedName("ANAME")
    @Expose
    private String ANAME;
    @SerializedName("AAC")
    @Expose
    private String AAC;
    @SerializedName("ASTATU")
    @Expose
    private String ASTATU;
    @SerializedName("ADATE")
    @Expose
    private String ADATE;

    public String getANAME() {
        return ANAME;
    }

    public void setANAME(String ANAME) {
        this.ANAME = ANAME;
    }

    public String getAAC() {
        return AAC;
    }

    public void setAAC(String AAC) {
        this.AAC = AAC;
    }

    public String getASTATU() {
        return ASTATU;
    }

    public void setASTATU(String ASTATU) {
        this.ASTATU = ASTATU;
    }

    public String getADATE() {
        return ADATE;
    }

    public void setADATE(String ADATE) {
        this.ADATE = ADATE;
    }
}
