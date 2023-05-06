package com.axa.testautomation.api.regional.RecordCustomerContact.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AckResponse {

	@SerializedName("sourceMsgID")
	@Expose
	private String sourceMsgID;
	@SerializedName("contextID")
	@Expose
	private String contextID;
	@SerializedName("status")
	@Expose
	private String status;
	
	public String getSourceMsgID() {
	return sourceMsgID;
	}
	
	public void setSourceMsgID(String sourceMsgID) {
	this.sourceMsgID = sourceMsgID;
	}
	
	public String getContextID() {
	return contextID;
	}
	
	public void setContextID(String contextID) {
	this.contextID = contextID;
	}
	
	public String getStatus() {
	return status;
	}
	
	public void setStatus(String status) {
	this.status = status;
	}

}
