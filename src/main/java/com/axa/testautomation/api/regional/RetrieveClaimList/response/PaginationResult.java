package com.axa.testautomation.api.regional.RetrieveClaimList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaginationResult {
    @SerializedName("position")
    @Expose
    private String position;
    @SerializedName("count")
    @Expose
    private String count;
    @SerializedName("totalCount")
    @Expose
    private String totalCount;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
