package com.axa.testautomation.api.regional.RetrieveFundList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFundListCount {
	@SerializedName("POLICY_CNT")
	@Expose
	private Integer pOLICYCNT;

	public Integer getPOLICYCNT() {
	return pOLICYCNT;
	}

	public void setPOLICYCNT(Integer pOLICYCNT) {
	this.pOLICYCNT = pOLICYCNT;
	}
}
