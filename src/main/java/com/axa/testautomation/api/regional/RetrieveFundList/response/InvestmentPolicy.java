package com.axa.testautomation.api.regional.RetrieveFundList.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvestmentPolicy {
	@SerializedName("subAccountFlag")
	@Expose
	private String subAccountFlag;
	@SerializedName("totalAccountValueAmount")
	@Expose
	private String totalAccountValueAmount;
	@SerializedName("fundSubAccountHoldings")
	@Expose
	private List<FundSubAccountHolding> fundSubAccountHoldings = null;

	public String getSubAccountFlag() {
	return subAccountFlag;
	}

	public void setSubAccountFlag(String subAccountFlag) {
	this.subAccountFlag = subAccountFlag;
	}

	public String getTotalAccountValueAmount() {
		return totalAccountValueAmount;
	}

	public void setTotalAccountValueAmount(String totalAccountValueAmount) {
		this.totalAccountValueAmount = totalAccountValueAmount;
	}

	public List<FundSubAccountHolding> getFundSubAccountHoldings() {
	return fundSubAccountHoldings;
	}

	public void setFundSubAccountHoldings(List<FundSubAccountHolding> fundSubAccountHoldings) {
	this.fundSubAccountHoldings = fundSubAccountHoldings;
	}
}
