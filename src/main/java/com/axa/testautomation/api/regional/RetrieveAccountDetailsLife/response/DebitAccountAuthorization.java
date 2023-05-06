package com.axa.testautomation.api.regional.RetrieveAccountDetailsLife.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DebitAccountAuthorization {

    @SerializedName("bankAccountNumber")
    @Expose
    private String bankAccountNumber;
    @SerializedName("bankAccountStatus")
    @Expose
    private String bankAccountStatus;
    @SerializedName("accountCurrencyCode")
    @Expose
    private String accountCurrencyCode;
    @SerializedName("premiumEffectiveDate")
    @Expose
    private String premiumEffectiveDate;
    @SerializedName("processingDate")
    @Expose
    private String processingDate;
    @SerializedName("rejectionCode")
    @Expose
    private String rejectionCode;
    @SerializedName("rejectionDescription")
    @Expose
    private String rejectionDescription;
    @SerializedName("debtor")
    @Expose
    private Debtor debtor;
    @SerializedName("depositBankBranch")
    @Expose
    private DepositBankBranch depositBankBranch;
    @SerializedName("collectionBankBranch")
    @Expose
    private CollectionBankBranch collectionBankBranch;

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankAccountStatus() {
        return bankAccountStatus;
    }

    public void setBankAccountStatus(String bankAccountStatus) {
        this.bankAccountStatus = bankAccountStatus;
    }

    public String getAccountCurrencyCode() {
        return accountCurrencyCode;
    }

    public void setAccountCurrencyCode(String accountCurrencyCode) {
        this.accountCurrencyCode = accountCurrencyCode;
    }

    public String getPremiumEffectiveDate() {
        return premiumEffectiveDate;
    }

    public void setPremiumEffectiveDate(String premiumEffectiveDate) {
        this.premiumEffectiveDate = premiumEffectiveDate;
    }

    public String getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(String processingDate) {
        this.processingDate = processingDate;
    }

    public String getRejectionCode() {
        return rejectionCode;
    }

    public void setRejectionCode(String rejectionCode) {
        this.rejectionCode = rejectionCode;
    }

    public String getRejectionDescription() {
        return rejectionDescription;
    }

    public void setRejectionDescription(String rejectionDescription) {
        this.rejectionDescription = rejectionDescription;
    }

    public Debtor getDebtor() {
        return debtor;
    }

    public void setDebtor(Debtor debtor) {
        this.debtor = debtor;
    }

    public DepositBankBranch getDepositBankBranch() {
        return depositBankBranch;
    }

    public void setDepositBankBranch(DepositBankBranch depositBankBranch) {
        this.depositBankBranch = depositBankBranch;
    }

    public CollectionBankBranch getCollectionBankBranch() {
        return collectionBankBranch;
    }

    public void setCollectionBankBranch(CollectionBankBranch collectionBankBranch) {
        this.collectionBankBranch = collectionBankBranch;
    }
}
