package com.axa.testautomation.api.regional.RetrieveFundList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SortResult {
	@SerializedName("sortKey")
	@Expose
	private String sortKey;
	@SerializedName("order")
	@Expose
	private String order;

	public String getSortKey() {
	return sortKey;
	}

	public void setSortKey(String sortKey) {
	this.sortKey = sortKey;
	}

	public String getOrder() {
	return order;
	}

	public void setOrder(String order) {
	this.order = order;
	}

}
