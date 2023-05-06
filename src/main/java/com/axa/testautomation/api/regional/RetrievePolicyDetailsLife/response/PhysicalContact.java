package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicalContact {

    @SerializedName("addressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("addressLine2")
    @Expose
    private String addressLine2;
    @SerializedName("addressLine3")
    @Expose
    private String addressLine3;
    @SerializedName("addressLine4")
    @Expose
    private String addressLine4;
    @SerializedName("cityName")
    @Expose
    private String cityName;
    @SerializedName("physicalAddressTypeCode")
    @Expose
    private String physicalAddressTypeCode;


    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPhysicalAddressTypeCode() {
        return physicalAddressTypeCode;
    }

    public void setPhysicalAddressTypeCode(String physicalAddressTypeCode) {
        this.physicalAddressTypeCode = physicalAddressTypeCode;
    }

    public String getAddressLine4() {
        return addressLine4;
    }

    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }
}
