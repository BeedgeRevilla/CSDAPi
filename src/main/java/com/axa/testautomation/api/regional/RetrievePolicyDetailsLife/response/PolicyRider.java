package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PolicyRider {

    @SerializedName("policyNumber")
    @Expose
    private String policyNumber;
    @SerializedName("loadingAmount")
    @Expose
    private String loadingAmount;
    @SerializedName("temporaryLoadingAmount")
    @Expose
    private String temporaryLoadingAmount;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("riderExclusions")
    @Expose
    private List<RiderExclusion> riderExclusions = null;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getLoadingAmount() {
        return loadingAmount;
    }

    public void setLoadingAmount(String loadingAmount) {
        this.loadingAmount = loadingAmount;
    }

    public String getTemporaryLoadingAmount() {
        return temporaryLoadingAmount;
    }

    public void setTemporaryLoadingAmount(String temporaryLoadingAmount) {
        this.temporaryLoadingAmount = temporaryLoadingAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<RiderExclusion> getRiderExclusions() {
        return riderExclusions;
    }

    public void setRiderExclusions(List<RiderExclusion> riderExclusions) {
        this.riderExclusions = riderExclusions;
    }
}
