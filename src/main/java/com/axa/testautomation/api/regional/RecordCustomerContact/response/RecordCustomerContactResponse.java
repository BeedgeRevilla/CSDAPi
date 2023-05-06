package com.axa.testautomation.api.regional.RecordCustomerContact.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RecordCustomerContactResponse {

	@SerializedName("ackResponse")
	@Expose
	private AckResponse ackResponse;
	
	public AckResponse getAckResponse() {
	return ackResponse;
	}
	
	public void setAckResponse(AckResponse ackResponse) {
	this.ackResponse = ackResponse;
	}

}
