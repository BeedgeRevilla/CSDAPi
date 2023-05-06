package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPDCRD {
    @SerializedName("FIRST_SUBMISSION_DATE")
    @Expose
    private String FIRST_SUBMISSION_DATE;
    @SerializedName("FIRST_DEPOSITE_AMOUNT")
    @Expose
    private Integer FIRST_DEPOSITE_AMOUNT;
    @SerializedName("TOTAL_DFC_AMT")
    @Expose
    private Integer TOTAL_DFC_AMT;

    public String getFIRST_SUBMISSION_DATE() {
        return FIRST_SUBMISSION_DATE;
    }

    public void setFIRST_SUBMISSION_DATE(String FIRST_SUBMISSION_DATE) {
        this.FIRST_SUBMISSION_DATE = FIRST_SUBMISSION_DATE;
    }

    public Integer getFIRST_DEPOSITE_AMOUNT() {
        return FIRST_DEPOSITE_AMOUNT;
    }

    public void setFIRST_DEPOSITE_AMOUNT(Integer FIRST_DEPOSITE_AMOUNT) {
        this.FIRST_DEPOSITE_AMOUNT = FIRST_DEPOSITE_AMOUNT;
    }

    public Integer getTOTAL_DFC_AMT() {
        return TOTAL_DFC_AMT;
    }

    public void setTOTAL_DFC_AMT(Integer TOTAL_DFC_AMT) {
        this.TOTAL_DFC_AMT = TOTAL_DFC_AMT;
    }
}
