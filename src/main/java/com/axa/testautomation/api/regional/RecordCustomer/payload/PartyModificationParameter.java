package com.axa.testautomation.api.regional.RecordCustomer.payload;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartyModificationParameter {

	@SerializedName("idTYpe")
	@Expose
	private String idTYpe;
	@SerializedName("idValue")
	@Expose
	private List<String> idValue = null;
	@SerializedName("LOB")
	@Expose
	private String lOB;
	
	public String getIdTYpe() {
	return idTYpe;
	}
	
	public void setIdTYpe(String idTYpe) {
	this.idTYpe = idTYpe;
	}
	
	public List<String> getIdValue() {
	return idValue;
	}
	
	public void setIdValue(List<String> idValue) {
	this.idValue = idValue;
	}
	
	public String getLOB() {
	return lOB;
	}
	
	public void setLOB(String lOB) {
	this.lOB = lOB;
	}

}
