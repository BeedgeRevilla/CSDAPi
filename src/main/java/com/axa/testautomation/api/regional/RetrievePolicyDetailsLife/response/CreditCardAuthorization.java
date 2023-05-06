package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditCardAuthorization {

    @SerializedName("cardStatus")
    @Expose
    private String cardStatus;
    @SerializedName("creditCardNumber")
    @Expose
    private String creditCardNumber;
    @SerializedName("processingDate")
    @Expose
    private String processingDate;
    @SerializedName("cardHolder")
    @Expose
    private CardHolder cardHolder;

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public CardHolder getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(CardHolder cardHolder) {
        this.cardHolder = cardHolder;
    }

}
