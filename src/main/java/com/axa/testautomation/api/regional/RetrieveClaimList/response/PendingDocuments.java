package com.axa.testautomation.api.regional.RetrieveClaimList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PendingDocuments {
    @SerializedName("followUpCd")
    @Expose
    private String followUpCd;
    @SerializedName("followUpStatus")
    @Expose
    private String followUpStatus;
    @SerializedName("reqDt")
    @Expose
    private String reqDt;
    @SerializedName("docRemarks")
    @Expose
    private String docRemarks;

    public String getFollowUpCd() {
        return followUpCd;
    }

    public void setFollowUpCd(String followUpCd) {
        this.followUpCd = followUpCd;
    }

    public String getFollowUpStatus() {
        return followUpStatus;
    }

    public void setFollowUpStatus(String followUpStatus) {
        this.followUpStatus = followUpStatus;
    }

    public String getReqDt() {
        return reqDt;
    }

    public void setReqDt(String reqDt) {
        this.reqDt = reqDt;
    }

    public String getDocRemarks() {
        return docRemarks;
    }

    public void setDocRemarks(String docRemarks) {
        this.docRemarks = docRemarks;
    }
}
