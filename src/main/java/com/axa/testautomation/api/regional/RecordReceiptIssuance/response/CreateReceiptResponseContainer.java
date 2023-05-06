package com.axa.testautomation.api.regional.RecordReceiptIssuance.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateReceiptResponseContainer {
	@SerializedName("CreateReceiptResponse")
	@Expose
	private CreateReceiptResponse CreateReceiptResponse;

	public CreateReceiptResponse getCreateReceiptResponse() {
		return CreateReceiptResponse;
	}

	public void setCreateReceiptResponse(CreateReceiptResponse createReceiptResponse) {
		CreateReceiptResponse = createReceiptResponse;
	}
}
