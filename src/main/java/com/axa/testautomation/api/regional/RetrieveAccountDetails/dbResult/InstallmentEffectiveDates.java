package com.axa.testautomation.api.regional.RetrieveAccountDetails.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InstallmentEffectiveDates {
    @SerializedName("INSTFROM")
    @Expose
    private String iNSTFROM;

    public String getINSTFROM() {
        return iNSTFROM;
    }

    public void setINSTFROM(String iNSTFROM) {
        this.iNSTFROM = iNSTFROM;
    }
}
