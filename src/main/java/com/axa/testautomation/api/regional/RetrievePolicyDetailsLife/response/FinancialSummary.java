package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FinancialSummary {

    @SerializedName("totalDFCAmount")
    @Expose
    private String totalDFCAmount;
    @SerializedName("firstDepositAmount")
    @Expose
    private String firstDepositAmount;
    @SerializedName("firstSubmissionDate")
    @Expose
    private String firstSubmissionDate;

    public String getTotalDFCAmount() {
        return totalDFCAmount;
    }

    public void setTotalDFCAmount(String totalDFCAmount) {
        this.totalDFCAmount = totalDFCAmount;
    }

    public String getFirstDepositAmount() {
        return firstDepositAmount;
    }

    public void setFirstDepositAmount(String firstDepositAmount) {
        this.firstDepositAmount = firstDepositAmount;
    }

    public String getFirstSubmissionDate() {
        return firstSubmissionDate;
    }

    public void setFirstSubmissionDate(String firstSubmissionDate) {
        this.firstSubmissionDate = firstSubmissionDate;
    }
}
