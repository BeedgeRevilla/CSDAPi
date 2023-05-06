package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RLSPolicy {

    @SerializedName("entityCode")
    @Expose
    private String entityCode;
    @SerializedName("LOBCode")
    @Expose
    private String lOBCode;
    @SerializedName("policyEffectiveDate")
    @Expose
    private String policyEffectiveDate;
    @SerializedName("policyNumber")
    @Expose
    private String policyNumber;
    @SerializedName("policyStatusCode")
    @Expose
    private String policyStatusCode;
    @SerializedName("policyTerminationDate")
    @Expose
    private String policyTerminationDate;
    @SerializedName("producingAgentCode1")
    @Expose
    private String producingAgentCode1;
    @SerializedName("policyCurrencyCode")
    @Expose
    private String policyCurrencyCode;
    @SerializedName("paidToDate")
    @Expose
    private String paidToDate;
    @SerializedName("paymentModeCode")
    @Expose
    private String paymentModeCode;
    @SerializedName("modalPremiumAmount")
    @Expose
    private String modalPremiumAmount;
    @SerializedName("policyIssueDate")
    @Expose
    private String policyIssueDate;
    @SerializedName("producingAgentCode2")
    @Expose
    private String producingAgentCode2;
    @SerializedName("servicingAgentCode1")
    @Expose
    private String servicingAgentCode1;
    @SerializedName("servicingAgentCode2")
    @Expose
    private String servicingAgentCode2;
    @SerializedName("FinancialSummary")
    @Expose
    private FinancialSummary financialSummary;
    @SerializedName("partyRoles")
    @Expose
    private List<PartyRole> partyRoles = null;
    @SerializedName("actualServicingAgentCode1")
    @Expose
    private String actualServicingAgentCode1;
    @SerializedName("accumulatedDividendAmount")
    @Expose
    private String accumulatedDividendAmount;
    @SerializedName("accumulatedDividendInterestAmount")
    @Expose
    private String accumulatedDividendInterestAmount;
    @SerializedName("actualTerminationDate")
    @Expose
    private String actualTerminationDate;
    @SerializedName("additionalPaidUpAmount")
    @Expose
    private String additionalPaidUpAmount;
    @SerializedName("additionalPaidUpFaceValueAmount")
    @Expose
    private String additionalPaidUpFaceValueAmount;
    @SerializedName("annualFirstYearPremiumAmount")
    @Expose
    private String annualFirstYearPremiumAmount;
    @SerializedName("applicationSignDate")
    @Expose
    private String applicationSignDate;
    @SerializedName("assigneeChineseName")
    @Expose
    private String assigneeChineseName;
    @SerializedName("assigneeName")
    @Expose
    private String assigneeName;
    @SerializedName("assigneeType")
    @Expose
    private String assigneeType;
    @SerializedName("assigneeTypeCode")
    @Expose
    private String assigneeTypeCode;
    @SerializedName("autoReinstatementApplicabilityFlag")
    @Expose
    private String autoReinstatementApplicabilityFlag;
    @SerializedName("basicSumInsuredAmount")
    @Expose
    private String basicSumInsuredAmount;
    @SerializedName("bonusFaceValueAmount")
    @Expose
    private String bonusFaceValueAmount;
    @SerializedName("commissionRate")
    @Expose
    private String commissionRate;
    @SerializedName("communicationMean")
    @Expose
    private String communicationMean;
    @SerializedName("costOfInsuranceUpdateDate")
    @Expose
    private String costOfInsuranceUpdateDate;
    @SerializedName("couponAmount")
    @Expose
    private String couponAmount;
    @SerializedName("couponInterestAmount")
    @Expose
    private String couponInterestAmount;
    @SerializedName("dateBackPolicyFlag")
    @Expose
    private String dateBackPolicyFlag;
    @SerializedName("deathBenefitOption")
    @Expose
    private String deathBenefitOption;
    @SerializedName("dividendOptionFlag")
    @Expose
    private String dividendOptionFlag;
    @SerializedName("effectivePolicyChangeDate")
    @Expose
    private String effectivePolicyChangeDate;
    @SerializedName("eServiceFlag")
    @Expose
    private String eServiceFlag;
    @SerializedName("ETAExpiryDate")
    @Expose
    private String eTAExpiryDate;
    @SerializedName("expireDate")
    @Expose
    private String expireDate;
    @SerializedName("faceValueReversionaryBonusAmount")
    @Expose
    private String faceValueReversionaryBonusAmount;
    @SerializedName("faceValueTerminalBonusAmount")
    @Expose
    private String faceValueTerminalBonusAmount;
    @SerializedName("futurePremiumDepositAmount")
    @Expose
    private String futurePremiumDepositAmount;
    @SerializedName("futurePremiumDepositInterestAmount")
    @Expose
    private String futurePremiumDepositInterestAmount;
    @SerializedName("indexationState")
    @Expose
    private String indexationState;
    @SerializedName("initialLumpsumPremiumAmount")
    @Expose
    private String initialLumpsumPremiumAmount;
    @SerializedName("insuredIDFlag")
    @Expose
    private String insuredIDFlag;
    @SerializedName("lastModalPremiumAmount")
    @Expose
    private String lastModalPremiumAmount;
    @SerializedName("loanBalanceAmount")
    @Expose
    private String loanBalanceAmount;
    @SerializedName("loanBalanceInterestAmount")
    @Expose
    private String loanBalanceInterestAmount;
    @SerializedName("MAEOptionCode")
    @Expose
    private String mAEOptionCode;
    @SerializedName("modalCommissionAmount")
    @Expose
    private String modalCommissionAmount;
    @SerializedName("policyIndexationType")
    @Expose
    private String policyIndexationType;
    @SerializedName("policyOrphanFlag")
    @Expose
    private String policyOrphanFlag;
    @SerializedName("premiumChargeAmount")
    @Expose
    private String premiumChargeAmount;
    @SerializedName("premiumDueDate")
    @Expose
    private String premiumDueDate;
    @SerializedName("premiumHolidayFlag")
    @Expose
    private String premiumHolidayFlag;
    @SerializedName("premiumOverdueFlag")
    @Expose
    private String premiumOverdueFlag;
    @SerializedName("premiumPaymentMethod")
    @Expose
    private String premiumPaymentMethod;
    @SerializedName("pureEndowmentAmount")
    @Expose
    private String pureEndowmentAmount;
    @SerializedName("reducedPaidUpAmount")
    @Expose
    private String reducedPaidUpAmount;
    @SerializedName("regularTopUpPremiumAmount")
    @Expose
    private String regularTopUpPremiumAmount;
    @SerializedName("reinstatementEffectiveDate")
    @Expose
    private String reinstatementEffectiveDate;
    @SerializedName("requiredPremiumAmount")
    @Expose
    private String requiredPremiumAmount;
    @SerializedName("SMS")
    @Expose
    private String sMS;
    @SerializedName("staffFlag")
    @Expose
    private String staffFlag;
    @SerializedName("submissionDate")
    @Expose
    private String submissionDate;
    @SerializedName("sumInsuredAmount")
    @Expose
    private String sumInsuredAmount;
    @SerializedName("SUSEmail")
    @Expose
    private String sUSEmail;
    @SerializedName("SUSSMS")
    @Expose
    private String sUSSMS;
    @SerializedName("terminationDate")
    @Expose
    private String terminationDate;
    @SerializedName("totalAmount")
    @Expose
    private String totalAmount;
    @SerializedName("totalPremiumAmount")
    @Expose
    private String totalPremiumAmount;
    @SerializedName("totalSumInsuredAmount")
    @Expose
    private String totalSumInsuredAmount;
    @SerializedName("totalWithdrawalAmount")
    @Expose
    private String totalWithdrawalAmount;
    @SerializedName("transactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("noClaimBonusDate")
    @Expose
    private String noClaimBonusDate;
    @SerializedName("noClaimBonusAmount")
    @Expose
    private String noClaimBonusAmount;
    @SerializedName("classCode")
    @Expose
    private String classCode;
    @SerializedName("policyConversionNumber")
    @Expose
    private String policyConversionNumber;
    @SerializedName("activitySuspensionFlag")
    @Expose
    private String activitySuspensionFlag;
    @SerializedName("nonforfeitureOption")
    @Expose
    private String nonforfeitureOption;
    @SerializedName("maintenanceCode")
    @Expose
    private String maintenanceCode;
    @SerializedName("lumpSum")
    @Expose
    private String lumpSum;
    @SerializedName("modalRegularPremiumExcludeTopup")
    @Expose
    private String modalRegularPremiumExcludeTopup;
    @SerializedName("creditCardAuthorization")
    @Expose
    private CreditCardAuthorization creditCardAuthorization;
    @SerializedName("RLSProduct")
    @Expose
    private RLSProduct rLSProduct;
    @SerializedName("policyRiders")
    @Expose
    private List<PolicyRider> policyRiders = null;
    @SerializedName("Assignee")
    @Expose
    private Assignee assignee;
    @SerializedName("investmentPolicy")
    @Expose
    private InvestmentPolicy investmentPolicy;
    @SerializedName("debitAccountAuthorization")
    @Expose
    private DebitAccountAuthorization debitAccountAuthorization;

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String getLOBCode() {
        return lOBCode;
    }

    public void setLOBCode(String lOBCode) {
        this.lOBCode = lOBCode;
    }

    public String getPolicyEffectiveDate() {
        return policyEffectiveDate;
    }

    public void setPolicyEffectiveDate(String policyEffectiveDate) {
        this.policyEffectiveDate = policyEffectiveDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyStatusCode() {
        return policyStatusCode;
    }

    public void setPolicyStatusCode(String policyStatusCode) {
        this.policyStatusCode = policyStatusCode;
    }

    public String getPolicyTerminationDate() {
        return policyTerminationDate;
    }

    public void setPolicyTerminationDate(String policyTerminationDate) {
        this.policyTerminationDate = policyTerminationDate;
    }

    public String getProducingAgentCode1() {
        return producingAgentCode1;
    }

    public void setProducingAgentCode1(String producingAgentCode1) {
        this.producingAgentCode1 = producingAgentCode1;
    }

    public String getPolicyCurrencyCode() {
        return policyCurrencyCode;
    }

    public void setPolicyCurrencyCode(String policyCurrencyCode) {
        this.policyCurrencyCode = policyCurrencyCode;
    }

    public String getPaidToDate() {
        return paidToDate;
    }

    public void setPaidToDate(String paidToDate) {
        this.paidToDate = paidToDate;
    }

    public String getPaymentModeCode() {
        return paymentModeCode;
    }

    public void setPaymentModeCode(String paymentModeCode) {
        this.paymentModeCode = paymentModeCode;
    }

    public String getModalPremiumAmount() {
        return modalPremiumAmount;
    }

    public void setModalPremiumAmount(String modalPremiumAmount) {
        this.modalPremiumAmount = modalPremiumAmount;
    }

    public String getPolicyIssueDate() {
        return policyIssueDate;
    }

    public void setPolicyIssueDate(String policyIssueDate) {
        this.policyIssueDate = policyIssueDate;
    }

    public String getProducingAgentCode2() {
        return producingAgentCode2;
    }

    public void setProducingAgentCode2(String producingAgentCode2) {
        this.producingAgentCode2 = producingAgentCode2;
    }

    public String getServicingAgentCode1() {
        return servicingAgentCode1;
    }

    public void setServicingAgentCode1(String servicingAgentCode1) {
        this.servicingAgentCode1 = servicingAgentCode1;
    }

    public String getServicingAgentCode2() {
        return servicingAgentCode2;
    }

    public void setServicingAgentCode2(String servicingAgentCode2) {
        this.servicingAgentCode2 = servicingAgentCode2;
    }

    public FinancialSummary getFinancialSummary() {
        return financialSummary;
    }

    public void setFinancialSummary(FinancialSummary financialSummary) {
        this.financialSummary = financialSummary;
    }

    public List<PartyRole> getPartyRoles() {
        return partyRoles;
    }

    public void setPartyRoles(List<PartyRole> partyRoles) {
        this.partyRoles = partyRoles;
    }

    public String getActualServicingAgentCode1() {
        return actualServicingAgentCode1;
    }

    public void setActualServicingAgentCode1(String actualServicingAgentCode1) {
        this.actualServicingAgentCode1 = actualServicingAgentCode1;
    }

    public String getAccumulatedDividendAmount() {
        return accumulatedDividendAmount;
    }

    public void setAccumulatedDividendAmount(String accumulatedDividendAmount) {
        this.accumulatedDividendAmount = accumulatedDividendAmount;
    }

    public String getAccumulatedDividendInterestAmount() {
        return accumulatedDividendInterestAmount;
    }

    public void setAccumulatedDividendInterestAmount(String accumulatedDividendInterestAmount) {
        this.accumulatedDividendInterestAmount = accumulatedDividendInterestAmount;
    }

    public String getActualTerminationDate() {
        return actualTerminationDate;
    }

    public void setActualTerminationDate(String actualTerminationDate) {
        this.actualTerminationDate = actualTerminationDate;
    }

    public String getAdditionalPaidUpAmount() {
        return additionalPaidUpAmount;
    }

    public void setAdditionalPaidUpAmount(String additionalPaidUpAmount) {
        this.additionalPaidUpAmount = additionalPaidUpAmount;
    }

    public String getAdditionalPaidUpFaceValueAmount() {
        return additionalPaidUpFaceValueAmount;
    }

    public void setAdditionalPaidUpFaceValueAmount(String additionalPaidUpFaceValueAmount) {
        this.additionalPaidUpFaceValueAmount = additionalPaidUpFaceValueAmount;
    }

    public String getAnnualFirstYearPremiumAmount() {
        return annualFirstYearPremiumAmount;
    }

    public void setAnnualFirstYearPremiumAmount(String annualFirstYearPremiumAmount) {
        this.annualFirstYearPremiumAmount = annualFirstYearPremiumAmount;
    }

    public String getApplicationSignDate() {
        return applicationSignDate;
    }

    public void setApplicationSignDate(String applicationSignDate) {
        this.applicationSignDate = applicationSignDate;
    }

    public String getAssigneeChineseName() {
        return assigneeChineseName;
    }

    public void setAssigneeChineseName(String assigneeChineseName) {
        this.assigneeChineseName = assigneeChineseName;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }

    public String getAssigneeType() {
        return assigneeType;
    }

    public void setAssigneeType(String assigneeType) {
        this.assigneeType = assigneeType;
    }

    public String getAssigneeTypeCode() {
        return assigneeTypeCode;
    }

    public void setAssigneeTypeCode(String assigneeTypeCode) {
        this.assigneeTypeCode = assigneeTypeCode;
    }

    public String getAutoReinstatementApplicabilityFlag() {
        return autoReinstatementApplicabilityFlag;
    }

    public void setAutoReinstatementApplicabilityFlag(String autoReinstatementApplicabilityFlag) {
        this.autoReinstatementApplicabilityFlag = autoReinstatementApplicabilityFlag;
    }

    public String getBasicSumInsuredAmount() {
        return basicSumInsuredAmount;
    }

    public void setBasicSumInsuredAmount(String basicSumInsuredAmount) {
        this.basicSumInsuredAmount = basicSumInsuredAmount;
    }

    public String getBonusFaceValueAmount() {
        return bonusFaceValueAmount;
    }

    public void setBonusFaceValueAmount(String bonusFaceValueAmount) {
        this.bonusFaceValueAmount = bonusFaceValueAmount;
    }

    public String getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(String commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getCommunicationMean() {
        return communicationMean;
    }

    public void setCommunicationMean(String communicationMean) {
        this.communicationMean = communicationMean;
    }

    public String getCostOfInsuranceUpdateDate() {
        return costOfInsuranceUpdateDate;
    }

    public void setCostOfInsuranceUpdateDate(String costOfInsuranceUpdateDate) {
        this.costOfInsuranceUpdateDate = costOfInsuranceUpdateDate;
    }

    public String getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(String couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getCouponInterestAmount() {
        return couponInterestAmount;
    }

    public void setCouponInterestAmount(String couponInterestAmount) {
        this.couponInterestAmount = couponInterestAmount;
    }

    public String getDateBackPolicyFlag() {
        return dateBackPolicyFlag;
    }

    public void setDateBackPolicyFlag(String dateBackPolicyFlag) {
        this.dateBackPolicyFlag = dateBackPolicyFlag;
    }

    public String getDeathBenefitOption() {
        return deathBenefitOption;
    }

    public void setDeathBenefitOption(String deathBenefitOption) {
        this.deathBenefitOption = deathBenefitOption;
    }

    public String getDividendOptionFlag() {
        return dividendOptionFlag;
    }

    public void setDividendOptionFlag(String dividendOptionFlag) {
        this.dividendOptionFlag = dividendOptionFlag;
    }

    public String getEffectivePolicyChangeDate() {
        return effectivePolicyChangeDate;
    }

    public void setEffectivePolicyChangeDate(String effectivePolicyChangeDate) {
        this.effectivePolicyChangeDate = effectivePolicyChangeDate;
    }

    public String getEServiceFlag() {
        return eServiceFlag;
    }

    public void setEServiceFlag(String eServiceFlag) {
        this.eServiceFlag = eServiceFlag;
    }

    public String getETAExpiryDate() {
        return eTAExpiryDate;
    }

    public void setETAExpiryDate(String eTAExpiryDate) {
        this.eTAExpiryDate = eTAExpiryDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getFaceValueReversionaryBonusAmount() {
        return faceValueReversionaryBonusAmount;
    }

    public void setFaceValueReversionaryBonusAmount(String faceValueReversionaryBonusAmount) {
        this.faceValueReversionaryBonusAmount = faceValueReversionaryBonusAmount;
    }

    public String getFaceValueTerminalBonusAmount() {
        return faceValueTerminalBonusAmount;
    }

    public void setFaceValueTerminalBonusAmount(String faceValueTerminalBonusAmount) {
        this.faceValueTerminalBonusAmount = faceValueTerminalBonusAmount;
    }

    public String getFuturePremiumDepositAmount() {
        return futurePremiumDepositAmount;
    }

    public void setFuturePremiumDepositAmount(String futurePremiumDepositAmount) {
        this.futurePremiumDepositAmount = futurePremiumDepositAmount;
    }

    public String getFuturePremiumDepositInterestAmount() {
        return futurePremiumDepositInterestAmount;
    }

    public void setFuturePremiumDepositInterestAmount(String futurePremiumDepositInterestAmount) {
        this.futurePremiumDepositInterestAmount = futurePremiumDepositInterestAmount;
    }

    public String getIndexationState() {
        return indexationState;
    }

    public void setIndexationState(String indexationState) {
        this.indexationState = indexationState;
    }

    public String getInitialLumpsumPremiumAmount() {
        return initialLumpsumPremiumAmount;
    }

    public void setInitialLumpsumPremiumAmount(String initialLumpsumPremiumAmount) {
        this.initialLumpsumPremiumAmount = initialLumpsumPremiumAmount;
    }

    public String getInsuredIDFlag() {
        return insuredIDFlag;
    }

    public void setInsuredIDFlag(String insuredIDFlag) {
        this.insuredIDFlag = insuredIDFlag;
    }

    public String getLastModalPremiumAmount() {
        return lastModalPremiumAmount;
    }

    public void setLastModalPremiumAmount(String lastModalPremiumAmount) {
        this.lastModalPremiumAmount = lastModalPremiumAmount;
    }

    public String getLoanBalanceAmount() {
        return loanBalanceAmount;
    }

    public void setLoanBalanceAmount(String loanBalanceAmount) {
        this.loanBalanceAmount = loanBalanceAmount;
    }

    public String getLoanBalanceInterestAmount() {
        return loanBalanceInterestAmount;
    }

    public void setLoanBalanceInterestAmount(String loanBalanceInterestAmount) {
        this.loanBalanceInterestAmount = loanBalanceInterestAmount;
    }

    public String getMAEOptionCode() {
        return mAEOptionCode;
    }

    public void setMAEOptionCode(String mAEOptionCode) {
        this.mAEOptionCode = mAEOptionCode;
    }

    public String getModalCommissionAmount() {
        return modalCommissionAmount;
    }

    public void setModalCommissionAmount(String modalCommissionAmount) {
        this.modalCommissionAmount = modalCommissionAmount;
    }

    public String getPolicyIndexationType() {
        return policyIndexationType;
    }

    public void setPolicyIndexationType(String policyIndexationType) {
        this.policyIndexationType = policyIndexationType;
    }

    public String getPolicyOrphanFlag() {
        return policyOrphanFlag;
    }

    public void setPolicyOrphanFlag(String policyOrphanFlag) {
        this.policyOrphanFlag = policyOrphanFlag;
    }

    public String getPremiumChargeAmount() {
        return premiumChargeAmount;
    }

    public void setPremiumChargeAmount(String premiumChargeAmount) {
        this.premiumChargeAmount = premiumChargeAmount;
    }

    public String getPremiumDueDate() {
        return premiumDueDate;
    }

    public void setPremiumDueDate(String premiumDueDate) {
        this.premiumDueDate = premiumDueDate;
    }

    public String getPremiumHolidayFlag() {
        return premiumHolidayFlag;
    }

    public void setPremiumHolidayFlag(String premiumHolidayFlag) {
        this.premiumHolidayFlag = premiumHolidayFlag;
    }

    public String getPremiumOverdueFlag() {
        return premiumOverdueFlag;
    }

    public void setPremiumOverdueFlag(String premiumOverdueFlag) {
        this.premiumOverdueFlag = premiumOverdueFlag;
    }

    public String getPremiumPaymentMethod() {
        return premiumPaymentMethod;
    }

    public void setPremiumPaymentMethod(String premiumPaymentMethod) {
        this.premiumPaymentMethod = premiumPaymentMethod;
    }

    public String getPureEndowmentAmount() {
        return pureEndowmentAmount;
    }

    public void setPureEndowmentAmount(String pureEndowmentAmount) {
        this.pureEndowmentAmount = pureEndowmentAmount;
    }

    public String getReducedPaidUpAmount() {
        return reducedPaidUpAmount;
    }

    public void setReducedPaidUpAmount(String reducedPaidUpAmount) {
        this.reducedPaidUpAmount = reducedPaidUpAmount;
    }

    public String getRegularTopUpPremiumAmount() {
        return regularTopUpPremiumAmount;
    }

    public void setRegularTopUpPremiumAmount(String regularTopUpPremiumAmount) {
        this.regularTopUpPremiumAmount = regularTopUpPremiumAmount;
    }

    public String getReinstatementEffectiveDate() {
        return reinstatementEffectiveDate;
    }

    public void setReinstatementEffectiveDate(String reinstatementEffectiveDate) {
        this.reinstatementEffectiveDate = reinstatementEffectiveDate;
    }

    public String getRequiredPremiumAmount() {
        return requiredPremiumAmount;
    }

    public void setRequiredPremiumAmount(String requiredPremiumAmount) {
        this.requiredPremiumAmount = requiredPremiumAmount;
    }

    public String getSMS() {
        return sMS;
    }

    public void setSMS(String sMS) {
        this.sMS = sMS;
    }

    public String getStaffFlag() {
        return staffFlag;
    }

    public void setStaffFlag(String staffFlag) {
        this.staffFlag = staffFlag;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getSumInsuredAmount() {
        return sumInsuredAmount;
    }

    public void setSumInsuredAmount(String sumInsuredAmount) {
        this.sumInsuredAmount = sumInsuredAmount;
    }

    public String getSUSEmail() {
        return sUSEmail;
    }

    public void setSUSEmail(String sUSEmail) {
        this.sUSEmail = sUSEmail;
    }

    public String getSUSSMS() {
        return sUSSMS;
    }

    public void setSUSSMS(String sUSSMS) {
        this.sUSSMS = sUSSMS;
    }

    public String getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalPremiumAmount() {
        return totalPremiumAmount;
    }

    public void setTotalPremiumAmount(String totalPremiumAmount) {
        this.totalPremiumAmount = totalPremiumAmount;
    }

    public String getTotalSumInsuredAmount() {
        return totalSumInsuredAmount;
    }

    public void setTotalSumInsuredAmount(String totalSumInsuredAmount) {
        this.totalSumInsuredAmount = totalSumInsuredAmount;
    }

    public String getTotalWithdrawalAmount() {
        return totalWithdrawalAmount;
    }

    public void setTotalWithdrawalAmount(String totalWithdrawalAmount) {
        this.totalWithdrawalAmount = totalWithdrawalAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getNoClaimBonusDate() {
        return noClaimBonusDate;
    }

    public void setNoClaimBonusDate(String noClaimBonusDate) {
        this.noClaimBonusDate = noClaimBonusDate;
    }

    public String getNoClaimBonusAmount() {
        return noClaimBonusAmount;
    }

    public void setNoClaimBonusAmount(String noClaimBonusAmount) {
        this.noClaimBonusAmount = noClaimBonusAmount;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getPolicyConversionNumber() {
        return policyConversionNumber;
    }

    public void setPolicyConversionNumber(String policyConversionNumber) {
        this.policyConversionNumber = policyConversionNumber;
    }

    public String getActivitySuspensionFlag() {
        return activitySuspensionFlag;
    }

    public void setActivitySuspensionFlag(String activitySuspensionFlag) {
        this.activitySuspensionFlag = activitySuspensionFlag;
    }

    public String getNonforfeitureOption() {
        return nonforfeitureOption;
    }

    public void setNonforfeitureOption(String nonforfeitureOption) {
        this.nonforfeitureOption = nonforfeitureOption;
    }

    public String getMaintenanceCode() {
        return maintenanceCode;
    }

    public void setMaintenanceCode(String maintenanceCode) {
        this.maintenanceCode = maintenanceCode;
    }

    public String getLumpSum() {
        return lumpSum;
    }

    public void setLumpSum(String lumpSum) {
        this.lumpSum = lumpSum;
    }

    public String getModalRegularPremiumExcludeTopup() {
        return modalRegularPremiumExcludeTopup;
    }

    public void setModalRegularPremiumExcludeTopup(String modalRegularPremiumExcludeTopup) {
        this.modalRegularPremiumExcludeTopup = modalRegularPremiumExcludeTopup;
    }

    public CreditCardAuthorization getCreditCardAuthorization() {
        return creditCardAuthorization;
    }

    public void setCreditCardAuthorization(CreditCardAuthorization creditCardAuthorization) {
        this.creditCardAuthorization = creditCardAuthorization;
    }

    public RLSProduct getRLSProduct() {
        return rLSProduct;
    }

    public void setRLSProduct(RLSProduct rLSProduct) {
        this.rLSProduct = rLSProduct;
    }

    public List<PolicyRider> getPolicyRiders() {
        return policyRiders;
    }

    public void setPolicyRiders(List<PolicyRider> policyRiders) {
        this.policyRiders = policyRiders;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

    public InvestmentPolicy getInvestmentPolicy() {
        return investmentPolicy;
    }

    public void setInvestmentPolicy(InvestmentPolicy investmentPolicy) {
        this.investmentPolicy = investmentPolicy;
    }

    public DebitAccountAuthorization getDebitAccountAuthorization() {
        return debitAccountAuthorization;
    }

    public void setDebitAccountAuthorization(DebitAccountAuthorization debitAccountAuthorization) {
        this.debitAccountAuthorization = debitAccountAuthorization;
    }
}
