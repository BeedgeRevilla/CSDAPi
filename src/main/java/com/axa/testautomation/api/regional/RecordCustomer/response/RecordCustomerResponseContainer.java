package com.axa.testautomation.api.regional.RecordCustomer.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordCustomerResponseContainer {
	@SerializedName("RecordCustomerResponse")
	@Expose
	private RecordCustomerResponse recordCustomerResponse;

	public RecordCustomerResponse getRecordCustomerResponse() {
	return recordCustomerResponse;
	}

	public void setRecordCustomerResponse(RecordCustomerResponse recordCustomerResponse) {
	this.recordCustomerResponse = recordCustomerResponse;
	}
}
