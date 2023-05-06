package com.axa.testautomation.api.regional.RecordDocument.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DocumentElement {

    @SerializedName("MIMEType")
    @Expose
    private String mIMEType;
    @SerializedName("documentTitle")
    @Expose
    private String documentTitle;
    @SerializedName("documentType")
    @Expose
    private String documentType;
    @SerializedName("creationDate")
    @Expose
    private String creationDate;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("lineOfBusiness")
    @Expose
    private String lineOfBusiness;
    @SerializedName("policyNumber")
    @Expose
    private String policyNumber;
    @SerializedName("documentSource")
    @Expose
    private String documentSource;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("insuredName")
    @Expose
    private String insuredName;
    @SerializedName("processType")
    @Expose
    private String processType;
    @SerializedName("cartonNumber")
    @Expose
    private String cartonNumber;
    @SerializedName("primaryDocumentFlag")
    @Expose
    private String primaryDocumentFlag;
    @SerializedName("productType")
    @Expose
    private String productType;
    @SerializedName("vipFlag")
    @Expose
    private String vipFlag;
    @SerializedName("priority")
    @Expose
    private String priority;
    @SerializedName("backFillFlag")
    @Expose
    private String backFillFlag;
    @SerializedName("entityCode")
    @Expose
    private String entityCode;
    @SerializedName("channelCode")
    @Expose
    private String channelCode;
    @SerializedName("workType")
    @Expose
    private String workType;

    public String getMIMEType() {
        return mIMEType;
    }

    public void setMIMEType(String mIMEType) {
        this.mIMEType = mIMEType;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getDocumentSource() {
        return documentSource;
    }

    public void setDocumentSource(String documentSource) {
        this.documentSource = documentSource;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getCartonNumber() {
        return cartonNumber;
    }

    public void setCartonNumber(String cartonNumber) {
        this.cartonNumber = cartonNumber;
    }

    public String getPrimaryDocumentFlag() {
        return primaryDocumentFlag;
    }

    public void setPrimaryDocumentFlag(String primaryDocumentFlag) {
        this.primaryDocumentFlag = primaryDocumentFlag;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getBackFillFlag() {
        return backFillFlag;
    }

    public void setBackFillFlag(String backFillFlag) {
        this.backFillFlag = backFillFlag;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }
}
