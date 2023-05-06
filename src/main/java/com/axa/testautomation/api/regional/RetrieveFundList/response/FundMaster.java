package com.axa.testautomation.api.regional.RetrieveFundList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FundMaster {
	@SerializedName("fundCode")
	@Expose
	private String fundCode;
	@SerializedName("fundName")
	@Expose
	private String fundName;
	@SerializedName("fundCurrencyCode")
	@Expose
	private String fundCurrencyCode;
	@SerializedName("unitPriceAmount")
	@Expose
	private String unitPriceAmount;
	@SerializedName("fundBidPrice")
	@Expose
	private String fundBidPrice;
	@SerializedName("fundOfferPrice")
	@Expose
	private String fundOfferPrice;

	public String getFundCode() {
	return fundCode;
	}

	public void setFundCode(String fundCode) {
	this.fundCode = fundCode;
	}

	public String getFundName() {
	return fundName;
	}

	public void setFundName(String fundName) {
	this.fundName = fundName;
	}

	public String getFundCurrencyCode() {
	return fundCurrencyCode;
	}

	public void setFundCurrencyCode(String fundCurrencyCode) {
	this.fundCurrencyCode = fundCurrencyCode;
	}

	public String getUnitPriceAmount() {
	return unitPriceAmount;
	}

	public void setUnitPriceAmount(String unitPriceAmount) {
	this.unitPriceAmount = unitPriceAmount;
	}

	public String getFundBidPrice() {
	return fundBidPrice;
	}

	public void setFundBidPrice(String fundBidPrice) {
	this.fundBidPrice = fundBidPrice;
	}

	public String getFundOfferPrice() {
	return fundOfferPrice;
	}

	public void setFundOfferPrice(String fundOfferPrice) {
	this.fundOfferPrice = fundOfferPrice;
	}
}
