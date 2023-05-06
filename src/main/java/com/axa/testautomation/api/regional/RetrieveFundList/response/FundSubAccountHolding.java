package com.axa.testautomation.api.regional.RetrieveFundList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FundSubAccountHolding {
	@SerializedName("fundAllocationPercentage")
	@Expose
	private String fundAllocationPercentage;
	@SerializedName("fundCurrencyBalanceAmount")
	@Expose
	private String fundCurrencyBalanceAmount;
	@SerializedName("numberOfUnits")
	@Expose
	private String numberOfUnits;
	@SerializedName("policyCurrencyTotalAmount")
	@Expose
	private String policyCurrencyTotalAmount;
	@SerializedName("fundMaster")
	@Expose
	private FundMaster fundMaster;
	@SerializedName("exchangeRateDate")
	@Expose
	private String exchangeRateDate;
	@SerializedName("exchangeRateValue")
	@Expose
	private String exchangeRateValue;

	public String getExchangeRateDate() {
		return exchangeRateDate;
	}

	public void setExchangeRateDate(String exchangeRateDate) {
		this.exchangeRateDate = exchangeRateDate;
	}

	public String getExchangeRateValue() {
		return exchangeRateValue;
	}

	public void setExchangeRateValue(String exchangeRateValue) {
		this.exchangeRateValue = exchangeRateValue;
	}

	public String getFundAllocationPercentage() {
	return fundAllocationPercentage;
	}

	public void setFundAllocationPercentage(String fundAllocationPercentage) {
	this.fundAllocationPercentage = fundAllocationPercentage;
	}

	public String getFundCurrencyBalanceAmount() {
	return fundCurrencyBalanceAmount;
	}

	public void setFundCurrencyBalanceAmount(String fundCurrencyBalanceAmount) {
	this.fundCurrencyBalanceAmount = fundCurrencyBalanceAmount;
	}

	public String getNumberOfUnits() {
	return numberOfUnits;
	}

	public void setNumberOfUnits(String numberOfUnits) {
	this.numberOfUnits = numberOfUnits;
	}

	public String getPolicyCurrencyTotalAmount() {
	return policyCurrencyTotalAmount;
	}

	public void setPolicyCurrencyTotalAmount(String policyCurrencyTotalAmount) {
	this.policyCurrencyTotalAmount = policyCurrencyTotalAmount;
	}

	public FundMaster getFundMaster() {
	return fundMaster;
	}

	public void setFundMaster(FundMaster fundMaster) {
	this.fundMaster = fundMaster;
	}
}
