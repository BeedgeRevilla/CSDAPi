package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPCS232NI_LFPSTMTR {
    @SerializedName("NO_CLAIM_BONUS_AMOUNT")
    @Expose
    private Integer NO_CLAIM_BONUS_AMOUNT;
    @SerializedName("NO_CLAIM_BONUS_DATE")
    @Expose
    private String NO_CLAIM_BONUS_DATE;

    public Integer getNO_CLAIM_BONUS_AMOUNT() {
        return NO_CLAIM_BONUS_AMOUNT;
    }

    public void setNO_CLAIM_BONUS_AMOUNT(Integer NO_CLAIM_BONUS_AMOUNT) {
        this.NO_CLAIM_BONUS_AMOUNT = NO_CLAIM_BONUS_AMOUNT;
    }

    public String getNO_CLAIM_BONUS_DATE() {
        return NO_CLAIM_BONUS_DATE;
    }

    public void setNO_CLAIM_BONUS_DATE(String NO_CLAIM_BONUS_DATE) {
        this.NO_CLAIM_BONUS_DATE = NO_CLAIM_BONUS_DATE;
    }
}
