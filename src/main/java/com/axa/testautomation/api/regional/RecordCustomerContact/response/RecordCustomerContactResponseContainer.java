package com.axa.testautomation.api.regional.RecordCustomerContact.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordCustomerContactResponseContainer {
	@SerializedName("RecordCustomerContactResponse")
	@Expose
	private RecordCustomerContactResponse recordCustomerContactResponse;

	public RecordCustomerContactResponse getRecordCustomerContactResponse() {
	return recordCustomerContactResponse;
	}

	public void setRecordCustomerContactResponse(RecordCustomerContactResponse recordCustomerContactResponse) {
	this.recordCustomerContactResponse = recordCustomerContactResponse;
	}
}
