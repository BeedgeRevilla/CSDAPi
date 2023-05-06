package com.axa.testautomation.api.regional.RetrieveAccountDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSEAAccount {
    @SerializedName("cardTypeDescription")
    @Expose
    private String cardTypeDescription;
    @SerializedName("cardTypeCode")
    @Expose
    private String cardTypeCode;
    @SerializedName("PSEADebitAccounts")
    @Expose
    private PSEADebitAccounts pSEADebitAccounts;
    @SerializedName("PSEACreditAccounts")
    @Expose
    private PSEACreditAccounts pSEACreditAccounts;

    public String getCardTypeDescription() {
        return cardTypeDescription;
    }

    public void setCardTypeDescription(String cardTypeDescription) {
        this.cardTypeDescription = cardTypeDescription;
    }

    public String getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(String cardTypeCode) {
        this.cardTypeCode = cardTypeCode;
    }

    public PSEADebitAccounts getPSEADebitAccounts() {
        return pSEADebitAccounts;
    }

    public void setPSEADebitAccounts(PSEADebitAccounts pSEADebitAccounts) {
        this.pSEADebitAccounts = pSEADebitAccounts;
    }

    public PSEACreditAccounts getPSEACreditAccounts() {
        return pSEACreditAccounts;
    }

    public void setPSEACreditAccounts(PSEACreditAccounts pSEACreditAccounts) {
        this.pSEACreditAccounts = pSEACreditAccounts;
    }
}
