package com.axa.testautomation.api.regional.RecordReceiptIssuance.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateReceiptResponse {

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
