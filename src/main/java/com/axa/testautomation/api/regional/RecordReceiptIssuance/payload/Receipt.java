package com.axa.testautomation.api.regional.RecordReceiptIssuance.payload;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Receipt {

    @SerializedName("paymentMethodCode")
    @Expose
    private String paymentMethodCode;
    @SerializedName("totalOriginalAmount")
    @Expose
    private String totalOriginalAmount;
    @SerializedName("totalOriginalCurrency")
    @Expose
    private String totalOriginalCurrency;
    @SerializedName("paymentMethodType")
    @Expose
    private String paymentMethodType;
    @SerializedName("bankCode")
    @Expose
    private String bankCode;
    @SerializedName("paymentMethodDate")
    @Expose
    private String paymentMethodDate;
    @SerializedName("receiptNumber")
    @Expose
    private String receiptNumber;
    @SerializedName("printOfficialReceiptInd")
    @Expose
    private String printOfficialReceiptInd;
    @SerializedName("bankKey")
    @Expose
    private String bankKey;
    @SerializedName("accountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("paymentLineItem")
    @Expose
    private List<PaymentLineItem> paymentLineItem = null;
    @SerializedName("payee")
    @Expose
    private Payee payee;

    public String getPaymentMethodCode() {
        return paymentMethodCode;
    }

    public void setPaymentMethodCode(String paymentMethodCode) {
        this.paymentMethodCode = paymentMethodCode;
    }

    public String getTotalOriginalAmount() {
        return totalOriginalAmount;
    }

    public void setTotalOriginalAmount(String totalOriginalAmount) {
        this.totalOriginalAmount = totalOriginalAmount;
    }

    public String getTotalOriginalCurrency() {
        return totalOriginalCurrency;
    }

    public void setTotalOriginalCurrency(String totalOriginalCurrency) {
        this.totalOriginalCurrency = totalOriginalCurrency;
    }

    public String getPaymentMethodType() {
        return paymentMethodType;
    }

    public void setPaymentMethodType(String paymentMethodType) {
        this.paymentMethodType = paymentMethodType;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPaymentMethodDate() {
        return paymentMethodDate;
    }

    public void setPaymentMethodDate(String paymentMethodDate) {
        this.paymentMethodDate = paymentMethodDate;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public String getPrintOfficialReceiptInd() {
        return printOfficialReceiptInd;
    }

    public void setPrintOfficialReceiptInd(String printOfficialReceiptInd) {
        this.printOfficialReceiptInd = printOfficialReceiptInd;
    }

    public String getBankKey() {
        return bankKey;
    }

    public void setBankKey(String bankKey) {
        this.bankKey = bankKey;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<PaymentLineItem> getPaymentLineItem() {
        return paymentLineItem;
    }

    public void setPaymentLineItem(List<PaymentLineItem> paymentLineItem) {
        this.paymentLineItem = paymentLineItem;
    }

    public Payee getPayee() {
        return payee;
    }

    public void setPayee(Payee payee) {
        this.payee = payee;
    }
}
