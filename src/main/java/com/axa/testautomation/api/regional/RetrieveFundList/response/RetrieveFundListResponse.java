package com.axa.testautomation.api.regional.RetrieveFundList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveFundListResponse {
	@SerializedName("RLSPolicy")
	@Expose
	private RLSPolicy rLSPolicy;
	@SerializedName("paginationResult")
	@Expose
	private PaginationResult paginationResult;
	@SerializedName("sortResult")
	@Expose
	private SortResult sortResult;

	public RLSPolicy getRLSPolicy() {
	return rLSPolicy;
	}

	public void setRLSPolicy(RLSPolicy rLSPolicy) {
	this.rLSPolicy = rLSPolicy;
	}

	public PaginationResult getPaginationResult() {
	return paginationResult;
	}

	public void setPaginationResult(PaginationResult paginationResult) {
	this.paginationResult = paginationResult;
	}

	public SortResult getSortResult() {
	return sortResult;
	}

	public void setSortResult(SortResult sortResult) {
	this.sortResult = sortResult;
	}
}
