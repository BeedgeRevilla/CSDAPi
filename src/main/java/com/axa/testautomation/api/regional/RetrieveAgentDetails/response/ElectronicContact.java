package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElectronicContact {
    @SerializedName("electronicAddress")
    @Expose
    private String electronicAddress;

    public String getElectronicAddress() {
        return electronicAddress;
    }

    public void setElectronicAddress(String electronicAddress) {
        this.electronicAddress = electronicAddress;
    }
}
