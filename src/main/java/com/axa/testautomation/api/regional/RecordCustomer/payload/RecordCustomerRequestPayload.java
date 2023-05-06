package com.axa.testautomation.api.regional.RecordCustomer.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordCustomerRequestPayload {
	@SerializedName("RecordCustomerRequest")
	@Expose
	private RecordCustomerRequest RecordCustomerRequest;

	public RecordCustomerRequest getRecordCustomerRequest() {
		return RecordCustomerRequest;
	}

	public void setRecordCustomerRequest(RecordCustomerRequest recordCustomerRequest) {
		RecordCustomerRequest = recordCustomerRequest;
	}
}
