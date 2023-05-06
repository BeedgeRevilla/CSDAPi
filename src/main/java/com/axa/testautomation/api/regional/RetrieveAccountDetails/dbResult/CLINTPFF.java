package com.axa.testautomation.api.regional.RetrieveAccountDetails.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CLINTPFF {
    @SerializedName("SURNAME")
    @Expose
    private String sURNAME;
    @SerializedName("CLNTNUM")
    @Expose
    private String cLNTNUM;
    @SerializedName("GIVNAME")
    @Expose
    private String gIVNAME;
    @SerializedName("LGIVNAME")
    @Expose
    private String lGIVNAME;
    @SerializedName("ETHORIG")
    @Expose
    private String eTHORIG;
    @SerializedName("LSURNAME")
    @Expose
    private String lSURNAME;

    public String getSURNAME() {
        return sURNAME;
    }

    public void setSURNAME(String sURNAME) {
        this.sURNAME = sURNAME;
    }

    public String getCLNTNUM() {
        return cLNTNUM;
    }

    public void setCLNTNUM(String cLNTNUM) {
        this.cLNTNUM = cLNTNUM;
    }

    public String getGIVNAME() {
        return gIVNAME;
    }

    public void setGIVNAME(String gIVNAME) {
        this.gIVNAME = gIVNAME;
    }

    public String getLGIVNAME() {
        return lGIVNAME;
    }

    public void setLGIVNAME(String lGIVNAME) {
        this.lGIVNAME = lGIVNAME;
    }

    public String getETHORIG() {
        return eTHORIG;
    }

    public void setETHORIG(String eTHORIG) {
        this.eTHORIG = eTHORIG;
    }

    public String getLSURNAME() {
        return lSURNAME;
    }

    public void setLSURNAME(String lSURNAME) {
        this.lSURNAME = lSURNAME;
    }
}
