package com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Debtor {

    @SerializedName("lastName")
    @Expose
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
