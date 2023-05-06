package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TelephoneContact {
    @SerializedName("telephoneAddressTypeCode")
    @Expose
    private String telephoneAddressTypeCode;
    @SerializedName("telephoneNumber")
    @Expose
    private String telephoneNumber;

    public String getTelephoneAddressTypeCode() {
        return telephoneAddressTypeCode;
    }

    public void setTelephoneAddressTypeCode(String telephoneAddressTypeCode) {
        this.telephoneAddressTypeCode = telephoneAddressTypeCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
