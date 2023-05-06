package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

	@SerializedName("productName")
	@Expose
	private String productName;
	
	public String getProductName() {
	return productName;
	}
	
	public void setProductName(String productName) {
	this.productName = productName;
	}
	
}
