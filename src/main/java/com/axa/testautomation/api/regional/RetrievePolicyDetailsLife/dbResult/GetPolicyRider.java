package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPolicyRider {
    @SerializedName("PLAN_FLG")
    @Expose
    private String pLANFLG;
    @SerializedName("RIDER_POLICY")
    @Expose
    private String rIDERPOLICY;
    @SerializedName("RIDER_DESC")
    @Expose
    private String rIDERDESC;
    @SerializedName("RIDER_PLAN")
    @Expose
    private String rIDERPLAN;

    public String getPLANFLG() {
        return pLANFLG;
    }

    public void setPLANFLG(String pLANFLG) {
        this.pLANFLG = pLANFLG;
    }

    public String getRIDERPOLICY() {
        return rIDERPOLICY;
    }

    public void setRIDERPOLICY(String rIDERPOLICY) {
        this.rIDERPOLICY = rIDERPOLICY;
    }

    public String getRIDERDESC() {
        return rIDERDESC;
    }

    public void setRIDERDESC(String rIDERDESC) {
        this.rIDERDESC = rIDERDESC;
    }

    public String getRIDERPLAN() {
        return rIDERPLAN;
    }

    public void setRIDERPLAN(String rIDERPLAN) {
        this.rIDERPLAN = rIDERPLAN;
    }
}
