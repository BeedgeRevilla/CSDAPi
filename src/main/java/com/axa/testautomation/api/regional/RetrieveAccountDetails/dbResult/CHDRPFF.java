package com.axa.testautomation.api.regional.RetrieveAccountDetails.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CHDRPFF {
    @SerializedName("CHDRNUM")
    @Expose
    private String cHDRNUM;
    @SerializedName("COWNNUM")
    @Expose
    private String cOWNNUM;
    @SerializedName("MANDREF")
    @Expose
    private String mANDREF;

    public String getCHDRNUM() {
        return cHDRNUM;
    }

    public void setCHDRNUM(String cHDRNUM) {
        this.cHDRNUM = cHDRNUM;
    }

    public String getCOWNNUM() {
        return cOWNNUM;
    }

    public void setCOWNNUM(String cOWNNUM) {
        this.cOWNNUM = cOWNNUM;
    }

    public String getMANDREF() {
        return mANDREF;
    }

    public void setMANDREF(String mANDREF) {
        this.mANDREF = mANDREF;
    }
}
