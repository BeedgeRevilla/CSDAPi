package com.axa.testautomation.api.regional.RetrieveCustomerList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RetrieveCustomerListResponse {
    @SerializedName("paginationResult")
    @Expose
    private PaginationResult paginationResult;
    @SerializedName("sortResponse")
    @Expose
    private SortResponse sortResponse;
    @SerializedName("coreParty")
    @Expose
    private List<CoreParty> coreParty = null;

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

    public List<CoreParty> getCoreParty() {
        return coreParty;
    }

    public void setCoreParty(List<CoreParty> coreParty) {
        this.coreParty = coreParty;
    }
}
