package com.axa.testautomation.api.regional.RetrievePolicyDetailsHealth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HealthProductRemark {

	@SerializedName("aggregateLimit")
	@Expose
	private AggregateLimit aggregateLimit;
	@SerializedName("perVisitLimit")
	@Expose
	private PerVisitLimit perVisitLimit;
	
	public AggregateLimit getAggregateLimit() {
	return aggregateLimit;
	}
	
	public void setAggregateLimit(AggregateLimit aggregateLimit) {
	this.aggregateLimit = aggregateLimit;
	}
	
	public PerVisitLimit getPerVisitLimit() {
	return perVisitLimit;
	}
	
	public void setPerVisitLimit(PerVisitLimit perVisitLimit) {
	this.perVisitLimit = perVisitLimit;
	}

}
