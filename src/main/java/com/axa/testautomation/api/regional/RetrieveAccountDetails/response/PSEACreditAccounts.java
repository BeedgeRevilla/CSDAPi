package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSEACreditAccounts {
    @SerializedName("creditCardNumber")
    @Expose
    private String creditCardNumber;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
