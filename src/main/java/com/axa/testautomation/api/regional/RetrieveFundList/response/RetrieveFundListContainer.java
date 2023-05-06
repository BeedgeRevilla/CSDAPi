package com.axa.testautomation.api.regional.RetrieveFundList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetrieveFundListContainer {
	@SerializedName("RetrieveFundListResponse")
	@Expose
	private RetrieveFundListResponse retrieveFundListResponse;

	public RetrieveFundListResponse getRetrieveFundListResponse() {
	return retrieveFundListResponse;
	}

	public void setRetrieveFundListResponse(RetrieveFundListResponse retrieveFundListResponse) {
	this.retrieveFundListResponse = retrieveFundListResponse;
	}
}
