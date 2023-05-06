package com.axa.testautomation.api.regional.RetrieveClaimList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveClaimListResponse {
    @SerializedName("coreClaim")
    @Expose
    private List<CoreClaim> coreClaim = null;
    @SerializedName("paginationResult")
    @Expose
    private PaginationResult paginationResult;
    @SerializedName("sortResponse")
    @Expose
    private SortResponse sortResponse;
    @SerializedName("totalCount")
    @Expose
    private String totalCount;

    public List<CoreClaim> getCoreClaim() {
        return coreClaim;
    }

    public void setCoreClaim(List<CoreClaim> coreClaim) {
        this.coreClaim = coreClaim;
    }

    public PaginationResult getPaginationResult() {
        return paginationResult;
    }

    public void setPaginationResult(PaginationResult paginationResult) {
        this.paginationResult = paginationResult;
    }

    public SortResponse getSortResponse() {
        return sortResponse;
    }

    public void setSortResponse(SortResponse sortResponse) {
        this.sortResponse = sortResponse;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
