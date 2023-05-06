package com.axa.testautomation.api.regional.RecordReceiptIssuance.payload;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payee {

    @SerializedName("partyTypeCode")
    @Expose
    private String partyTypeCode;
    @SerializedName("partyId")
    @Expose
    private String partyId;

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}
