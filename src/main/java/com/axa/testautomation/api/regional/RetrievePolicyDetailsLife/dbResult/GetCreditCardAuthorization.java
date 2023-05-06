package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetCreditCardAuthorization {
    @SerializedName("D7ANAM")
    @Expose
    private String D7ANAM;
    @SerializedName("D7ACNO")
    @Expose
    private String D7ACNO;
    @SerializedName("D7ASTU")
    @Expose
    private String D7ASTU;
    @SerializedName("D7ADTE")
    @Expose
    private String D7ADTE;

    public String getD7ADTE() {
        return D7ADTE;
    }

    public void setD7ADTE(String d7ADTE) {
        D7ADTE = d7ADTE;
    }

    public String getD7ANAM() {
        return D7ANAM;
    }

    public void setD7ANAM(String d7ANAM) {
        D7ANAM = d7ANAM;
    }

    public String getD7ACNO() {
        return D7ACNO;
    }

    public void setD7ACNO(String d7ACNO) {
        D7ACNO = d7ACNO;
    }

    public String getD7ASTU() {
        return D7ASTU;
    }

    public void setD7ASTU(String d7ASTU) {
        D7ASTU = d7ASTU;
    }

}
