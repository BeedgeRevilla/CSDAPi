package com.axa.testautomation.api.regional.RecordCustomerContact.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordCustomerContactRequestPayload {

	@SerializedName("RecordCustomerContactRequest")
	@Expose
	private RecordCustomerContactRequest recordCustomerContactRequest;
	
	public RecordCustomerContactRequest getRecordCustomerContactRequest() {
	return recordCustomerContactRequest;
	}
	
	public void setRecordCustomerContactRequest(RecordCustomerContactRequest recordCustomerContactRequest) {
	this.recordCustomerContactRequest = recordCustomerContactRequest;
	}

}
