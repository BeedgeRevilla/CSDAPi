package com.axa.testautomation.api.regional.RetrieveCustomerList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ElectronicContact {
    @SerializedName("electronicAddressTypeCode")
    @Expose
    private String electronicAddressTypeCode;
    @SerializedName("electronicAddress")
    @Expose
    private String electronicAddress;

    public String getElectronicAddressTypeCode() {
        return electronicAddressTypeCode;
    }

    public void setElectronicAddressTypeCode(String electronicAddressTypeCode) {
        this.electronicAddressTypeCode = electronicAddressTypeCode;
    }

    public String getElectronicAddress() {
        return electronicAddress;
    }

    public void setElectronicAddress(String electronicAddress) {
        this.electronicAddress = electronicAddress;
    }
}
