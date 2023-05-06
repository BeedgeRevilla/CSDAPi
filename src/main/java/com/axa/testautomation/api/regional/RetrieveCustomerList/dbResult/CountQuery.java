package com.axa.testautomation.api.regional.RetrieveCustomerList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CountQuery {
    @SerializedName("CNTPARTY")
    @Expose
    private Integer cNTPARTY;

    public Integer getCNTPARTY() {
        return cNTPARTY;
    }

    public void setCNTPARTY(Integer cNTPARTY) {
        this.cNTPARTY = cNTPARTY;
    }
}
