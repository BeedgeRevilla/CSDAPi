package com.axa.testautomation.api.regional.RetrieveFundList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetExchangeRate {
	@SerializedName("FUND_CODE")
	@Expose
	private String FUND_CODE;
	@SerializedName("FUND_CURRENCY")
	@Expose
	private String FUND_CURRENCY;
	@SerializedName("EXCHANGE_RATE_VALUE")
	@Expose
	private Double EXCHANGE_RATE_VALUE;
	@SerializedName("EXCHANGE_RATE_DATE")
	@Expose
	private String EXCHANGE_RATE_DATE;

	public String getFUND_CODE() {
		return FUND_CODE;
	}

	public void setFUND_CODE(String FUND_CODE) {
		this.FUND_CODE = FUND_CODE;
	}

	public String getFUND_CURRENCY() {
		return FUND_CURRENCY;
	}

	public void setFUND_CURRENCY(String FUND_CURRENCY) {
		this.FUND_CURRENCY = FUND_CURRENCY;
	}

	public Double getEXCHANGE_RATE_VALUE() {
		return EXCHANGE_RATE_VALUE;
	}

	public void setEXCHANGE_RATE_VALUE(Double EXCHANGE_RATE_VALUE) {
		this.EXCHANGE_RATE_VALUE = EXCHANGE_RATE_VALUE;
	}

	public String getEXCHANGE_RATE_DATE() {
		return EXCHANGE_RATE_DATE;
	}

	public void setEXCHANGE_RATE_DATE(String EXCHANGE_RATE_DATE) {
		this.EXCHANGE_RATE_DATE = EXCHANGE_RATE_DATE;
	}
}
