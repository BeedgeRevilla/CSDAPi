package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvestmentPolicy {

    @SerializedName("additionalPaidUpCashValueAmount")
    @Expose
    private String additionalPaidUpCashValueAmount;
    @SerializedName("bonusInCashValueAmount")
    @Expose
    private String bonusInCashValueAmount;
    @SerializedName("cashValueOnBasicSumInsuredAmount")
    @Expose
    private String cashValueOnBasicSumInsuredAmount;
    @SerializedName("costOfInsuranceAmount")
    @Expose
    private String costOfInsuranceAmount;
    @SerializedName("coverageSurrenderValueAmount")
    @Expose
    private String coverageSurrenderValueAmount;
    @SerializedName("specialInvestmentBonusAmount")
    @Expose
    private String specialInvestmentBonusAmount;
    @SerializedName("surrenderValueInPolicyCurrencyAmount")
    @Expose
    private String surrenderValueInPolicyCurrencyAmount;
    @SerializedName("totalAccountValueAmount")
    @Expose
    private String totalAccountValueAmount;

    public String getAdditionalPaidUpCashValueAmount() {
        return additionalPaidUpCashValueAmount;
    }

    public void setAdditionalPaidUpCashValueAmount(String additionalPaidUpCashValueAmount) {
        this.additionalPaidUpCashValueAmount = additionalPaidUpCashValueAmount;
    }

    public String getBonusInCashValueAmount() {
        return bonusInCashValueAmount;
    }

    public void setBonusInCashValueAmount(String bonusInCashValueAmount) {
        this.bonusInCashValueAmount = bonusInCashValueAmount;
    }

    public String getCashValueOnBasicSumInsuredAmount() {
        return cashValueOnBasicSumInsuredAmount;
    }

    public void setCashValueOnBasicSumInsuredAmount(String cashValueOnBasicSumInsuredAmount) {
        this.cashValueOnBasicSumInsuredAmount = cashValueOnBasicSumInsuredAmount;
    }

    public String getCostOfInsuranceAmount() {
        return costOfInsuranceAmount;
    }

    public void setCostOfInsuranceAmount(String costOfInsuranceAmount) {
        this.costOfInsuranceAmount = costOfInsuranceAmount;
    }

    public String getCoverageSurrenderValueAmount() {
        return coverageSurrenderValueAmount;
    }

    public void setCoverageSurrenderValueAmount(String coverageSurrenderValueAmount) {
        this.coverageSurrenderValueAmount = coverageSurrenderValueAmount;
    }

    public String getSpecialInvestmentBonusAmount() {
        return specialInvestmentBonusAmount;
    }

    public void setSpecialInvestmentBonusAmount(String specialInvestmentBonusAmount) {
        this.specialInvestmentBonusAmount = specialInvestmentBonusAmount;
    }

    public String getSurrenderValueInPolicyCurrencyAmount() {
        return surrenderValueInPolicyCurrencyAmount;
    }

    public void setSurrenderValueInPolicyCurrencyAmount(String surrenderValueInPolicyCurrencyAmount) {
        this.surrenderValueInPolicyCurrencyAmount = surrenderValueInPolicyCurrencyAmount;
    }

    public String getTotalAccountValueAmount() {
        return totalAccountValueAmount;
    }

    public void setTotalAccountValueAmount(String totalAccountValueAmount) {
        this.totalAccountValueAmount = totalAccountValueAmount;
    }

}
