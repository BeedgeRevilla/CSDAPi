package com.axa.testautomation.api.regional.RetrieveClaimList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoreClaim {
    @SerializedName("claimNumber")
    @Expose
    private String claimNumber;
    @SerializedName("entityCode")
    @Expose
    private String entityCode;
    @SerializedName("lossDate")
    @Expose
    private String lossDate;
    @SerializedName("sourceSystemCode")
    @Expose
    private String sourceSystemCode;
    @SerializedName("LOBCode")
    @Expose
    private String lOBCode;
    @SerializedName("claimTypeCode")
    @Expose
    private String claimTypeCode;
    @SerializedName("claimOpenDate")
    @Expose
    private String claimOpenDate;
    @SerializedName("claimCloseDate")
    @Expose
    private String claimCloseDate;
    @SerializedName("lossReportDate")
    @Expose
    private String lossReportDate;
    @SerializedName("claimStatusCode")
    @Expose
    private String claimStatusCode;
    @SerializedName("claimCurrencyCode")
    @Expose
    private String claimCurrencyCode;
    @SerializedName("totalClaimAmount")
    @Expose
    private String totalClaimAmount;
    @SerializedName("totalApprovedAmount")
    @Expose
    private String totalApprovedAmount;
    @SerializedName("totalOutstandingAmount")
    @Expose
    private String totalOutstandingAmount;
    @SerializedName("totalPaidAmount")
    @Expose
    private String totalPaidAmount;
    @SerializedName("previousClaimNumber")
    @Expose
    private String previousClaimNumber;
    @SerializedName("admissionDate")
    @Expose
    private String admissionDate;
    @SerializedName("dischargeDate")
    @Expose
    private String dischargeDate;
    @SerializedName("totalShortfallAmount")
    @Expose
    private String totalShortfallAmount;
    @SerializedName("policyNumber")
    @Expose
    private String policyNumber;
    @SerializedName("companyCode")
    @Expose
    private String companyCode;
    @SerializedName("coverageCode")
    @Expose
    private String coverageCode;
    @SerializedName("coverageNumber")
    @Expose
    private String coverageNumber;
    @SerializedName("claimPaymentDate")
    @Expose
    private String claimPaymentDate;
    @SerializedName("preAuthorizationNumber")
    @Expose
    private String preAuthorizationNumber;
    @SerializedName("claimSettlementTypeCode")
    @Expose
    private String claimSettlementTypeCode;
    @SerializedName("claimAdjustmentNumber")
    @Expose
    private String claimAdjustmentNumber;
    @SerializedName("dependentNumber")
    @Expose
    private String dependentNumber;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("claimPartyRoles")
    @Expose
    private List<ClaimPartyRole> claimPartyRoles = null;
    @SerializedName("clientClaimRefNo")
    @Expose
    private String clientClaimRefNo;
    @SerializedName("providerOrganisation")
    @Expose
    private String providerOrganisation;
    @SerializedName("totalBilledAmt")
    @Expose
    private String totalBilledAmt;
    @SerializedName("reasonCd")
    @Expose
    private String reasonCd;
    @SerializedName("reasonDesc")
    @Expose
    private String reasonDesc;
    @SerializedName("pendingDocuments")
    @Expose
    private List<PendingDocuments> pendingDocuments;

    public List<PendingDocuments> getPendingDocuments() {
        return pendingDocuments;
    }

    public void setPendingDocuments(List<PendingDocuments> pendingDocuments) {
        this.pendingDocuments = pendingDocuments;
    }

    public String getReasonDesc() {
        return reasonDesc;
    }

    public void setReasonDesc(String reasonDesc) {
        this.reasonDesc = reasonDesc;
    }

    public String getReasonCd() {
        return reasonCd;
    }

    public void setReasonCd(String reasonCd) {
        this.reasonCd = reasonCd;
    }

    public String getTotalBilledAmt() {
        return totalBilledAmt;
    }

    public void setTotalBilledAmt(String totalBilledAmt) {
        this.totalBilledAmt = totalBilledAmt;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getLossDate() {
        return lossDate;
    }

    public void setLossDate(String lossDate) {
        this.lossDate = lossDate;
    }

    public String getSourceSystemCode() {
        return sourceSystemCode;
    }

    public void setSourceSystemCode(String sourceSystemCode) {
        this.sourceSystemCode = sourceSystemCode;
    }

    public String getLOBCode() {
        return lOBCode;
    }

    public void setLOBCode(String lOBCode) {
        this.lOBCode = lOBCode;
    }

    public String getClaimTypeCode() {
        return claimTypeCode;
    }

    public void setClaimTypeCode(String claimTypeCode) {
        this.claimTypeCode = claimTypeCode;
    }

    public String getClaimOpenDate() {
        return claimOpenDate;
    }

    public void setClaimOpenDate(String claimOpenDate) {
        this.claimOpenDate = claimOpenDate;
    }

    public String getClaimCloseDate() {
        return claimCloseDate;
    }

    public void setClaimCloseDate(String claimCloseDate) {
        this.claimCloseDate = claimCloseDate;
    }

    public String getLossReportDate() {
        return lossReportDate;
    }

    public void setLossReportDate(String lossReportDate) {
        this.lossReportDate = lossReportDate;
    }

    public String getClaimStatusCode() {
        return claimStatusCode;
    }

    public void setClaimStatusCode(String claimStatusCode) {
        this.claimStatusCode = claimStatusCode;
    }

    public String getClaimCurrencyCode() {
        return claimCurrencyCode;
    }

    public void setClaimCurrencyCode(String claimCurrencyCode) {
        this.claimCurrencyCode = claimCurrencyCode;
    }

    public String getTotalClaimAmount() {
        return totalClaimAmount;
    }

    public void setTotalClaimAmount(String totalClaimAmount) {
        this.totalClaimAmount = totalClaimAmount;
    }

    public String getTotalApprovedAmount() {
        return totalApprovedAmount;
    }

    public void setTotalApprovedAmount(String totalApprovedAmount) {
        this.totalApprovedAmount = totalApprovedAmount;
    }

    public String getTotalOutstandingAmount() {
        return totalOutstandingAmount;
    }

    public void setTotalOutstandingAmount(String totalOutstandingAmount) {
        this.totalOutstandingAmount = totalOutstandingAmount;
    }

    public String getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(String totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public String getPreviousClaimNumber() {
        return previousClaimNumber;
    }

    public void setPreviousClaimNumber(String previousClaimNumber) {
        this.previousClaimNumber = previousClaimNumber;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getTotalShortfallAmount() {
        return totalShortfallAmount;
    }

    public void setTotalShortfallAmount(String totalShortfallAmount) {
        this.totalShortfallAmount = totalShortfallAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCoverageCode() {
        return coverageCode;
    }

    public void setCoverageCode(String coverageCode) {
        this.coverageCode = coverageCode;
    }

    public String getCoverageNumber() {
        return coverageNumber;
    }

    public void setCoverageNumber(String coverageNumber) {
        this.coverageNumber = coverageNumber;
    }

    public String getClaimPaymentDate() {
        return claimPaymentDate;
    }

    public void setClaimPaymentDate(String claimPaymentDate) {
        this.claimPaymentDate = claimPaymentDate;
    }

    public String getPreAuthorizationNumber() {
        return preAuthorizationNumber;
    }

    public void setPreAuthorizationNumber(String preAuthorizationNumber) {
        this.preAuthorizationNumber = preAuthorizationNumber;
    }

    public String getClaimSettlementTypeCode() {
        return claimSettlementTypeCode;
    }

    public void setClaimSettlementTypeCode(String claimSettlementTypeCode) {
        this.claimSettlementTypeCode = claimSettlementTypeCode;
    }

    public String getClaimAdjustmentNumber() {
        return claimAdjustmentNumber;
    }

    public void setClaimAdjustmentNumber(String claimAdjustmentNumber) {
        this.claimAdjustmentNumber = claimAdjustmentNumber;
    }

    public String getDependentNumber() {
        return dependentNumber;
    }

    public void setDependentNumber(String dependentNumber) {
        this.dependentNumber = dependentNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ClaimPartyRole> getClaimPartyRoles() {
        return claimPartyRoles;
    }

    public void setClaimPartyRoles(List<ClaimPartyRole> claimPartyRoles) {
        this.claimPartyRoles = claimPartyRoles;
    }

    public String getClientClaimRefNo() {
        return clientClaimRefNo;
    }

    public void setClientClaimRefNo(String clientClaimRefNo) {
        this.clientClaimRefNo = clientClaimRefNo;
    }

    public String getProviderOrganisation() {
        return providerOrganisation;
    }

    public void setProviderOrganisation(String providerOrganisation) {
        this.providerOrganisation = providerOrganisation;
    }
}
