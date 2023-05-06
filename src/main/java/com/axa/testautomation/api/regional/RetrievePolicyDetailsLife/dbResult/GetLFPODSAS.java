package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPODSAS {
    @SerializedName("ASCOI")
    @Expose
    private Double ASCOI;
    @SerializedName("ASSURV")
    @Expose
    private Double ASSURV;
    @SerializedName("ASABAL")
    @Expose
    private Double ASABAL;
    @SerializedName("ASABALPR")
    @Expose
    private Double ASABALPR;

    public Double getASCOI() {
        return ASCOI;
    }

    public void setASCOI(Double ASCOI) {
        this.ASCOI = ASCOI;
    }

    public Double getASSURV() {
        return ASSURV;
    }

    public void setASSURV(Double ASSURV) {
        this.ASSURV = ASSURV;
    }

    public Double getASABAL() {
        return ASABAL;
    }

    public void setASABAL(Double ASABAL) {
        this.ASABAL = ASABAL;
    }

    public Double getASABALPR() {
        return ASABALPR;
    }

    public void setASABALPR(Double ASABALPR) {
        this.ASABALPR = ASABALPR;
    }
}
