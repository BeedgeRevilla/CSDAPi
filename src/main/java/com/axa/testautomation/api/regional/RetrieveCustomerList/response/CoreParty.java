package com.axa.testautomation.api.regional.RetrieveCustomerList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;
import java.util.List;

public class CoreParty {
    @SerializedName("birthDate")
    @Expose
    private String birthDate;
    @SerializedName("displayNameFormat")
    @Expose
    private String displayNameFormat;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("genderCode")
    @Expose
    private String genderCode;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("maritalStatusCode")
    @Expose
    private String maritalStatusCode;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("partyTypeCode")
    @Expose
    private String partyTypeCode;
    @SerializedName("sourceSystemCode")
    @Expose
    private String sourceSystemCode;
    @SerializedName("partyId")
    @Expose
    private String partyId;
    @SerializedName("localFirstName")
    @Expose
    private String localFirstName;
    @SerializedName("localLastName")
    @Expose
    private String localLastName;
    @SerializedName("localDisplayNameFormat")
    @Expose
    private String localDisplayNameFormat;
    @SerializedName("form60Flag")
    @Expose
    private String form60Flag;
    @SerializedName("identityProofIndicator")
    @Expose
    private String identityProofIndicator;
    @SerializedName("partyStatusCode")
    @Expose
    private String partyStatusCode;
    @SerializedName("salutationText")
    @Expose
    private String salutationText;
    @SerializedName("nationalityCode")
    @Expose
    private String nationalityCode;
    @SerializedName("geoDemographicCode")
    @Expose
    private String geoDemographicCode;
    @SerializedName("countryOfResidenceCode")
    @Expose
    private String countryOfResidenceCode;
    @SerializedName("occupationClassCode")
    @Expose
    private String occupationClassCode;
    @SerializedName("deceasedFlag")
    @Expose
    private String deceasedFlag;
    @SerializedName("deathDate")
    @Expose
    private String deathDate;
    @SerializedName("sourceofIncome")
    @Expose
    private String sourceofIncome;
    @SerializedName("annualIncomeAmount")
    @Expose
    private String annualIncomeAmount;
    @SerializedName("annualIncomeRangeCode")
    @Expose
    private String annualIncomeRangeCode;
    @SerializedName("educationLevelCode")
    @Expose
    private String educationLevelCode;
    @SerializedName("heightMtr")
    @Expose
    private String heightMtr;
    @SerializedName("weightKg")
    @Expose
    private String weightKg;
    @SerializedName("staffNumber")
    @Expose
    private String staffNumber;
    @SerializedName("staffFlag")
    @Expose
    private String staffFlag;
    @SerializedName("alertReceiverName")
    @Expose
    private String alertReceiverName;
    @SerializedName("primaryLanguageCode")
    @Expose
    private String primaryLanguageCode;
    @SerializedName("specialNeedCode")
    @Expose
    private String specialNeedCode;
    @SerializedName("preferredContactMethodCode")
    @Expose
    private String preferredContactMethodCode;
    @SerializedName("companyCode")
    @Expose
    private String companyCode;
    @SerializedName("coreDBPartyId")
    @Expose
    private String coreDBPartyId;
    @SerializedName("vipFlag")
    @Expose
    private String vipFlag;
    @SerializedName("bankruptcyFlag")
    @Expose
    private String bankruptcyFlag;
    @SerializedName("fraudCode")
    @Expose
    private String fraudCode;
    @SerializedName("smokingHabitFlag")
    @Expose
    private String smokingHabitFlag;
    @SerializedName("localMiddleName")
    @Expose
    private String localMiddleName;
    @SerializedName("specialCaseCode")
    @Expose
    private String specialCaseCode;
    @SerializedName("masterIndividualId")
    @Expose
    private String masterIndividualId;
    @SerializedName("LOBCode")
    @Expose
    private String lOBCode;
    @SerializedName("serviceTaxApplicabilityFlag")
    @Expose
    private String serviceTaxApplicabilityFlag;
    @SerializedName("telephoneContacts")
    @Expose
    private List<TelephoneContact> telephoneContacts = null;
    @SerializedName("electronicContacts")
    @Expose
    private List<ElectronicContact> electronicContacts = null;
    @SerializedName("partyIdentifiers")
    @Expose
    private List<PartyIdentifier> partyIdentifiers = null;
    @SerializedName("entityCode")
    @Expose
    private String entityCode;
    @SerializedName("physicalContacts")
    @Expose
    private List<PhysicalContact> physicalContacts = null;

    public static Comparator<CoreParty> CorePartyComparator= new Comparator<CoreParty> (){
        public int compare(CoreParty a, CoreParty b){
            String s1 = a.getCoreDBPartyId()+a.getTelephoneContacts().get(0).getTelephoneAddressTypeCode();
            String s2 = b.getCoreDBPartyId()+b.getTelephoneContacts().get(0).getTelephoneAddressTypeCode();
            return s1.compareTo(s2);
        }
    };

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDisplayNameFormat() {
        return displayNameFormat;
    }

    public void setDisplayNameFormat(String displayNameFormat) {
        this.displayNameFormat = displayNameFormat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPartyTypeCode() {
        return partyTypeCode;
    }

    public void setPartyTypeCode(String partyTypeCode) {
        this.partyTypeCode = partyTypeCode;
    }

    public String getSourceSystemCode() {
        return sourceSystemCode;
    }

    public void setSourceSystemCode(String sourceSystemCode) {
        this.sourceSystemCode = sourceSystemCode;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getLocalFirstName() {
        return localFirstName;
    }

    public void setLocalFirstName(String localFirstName) {
        this.localFirstName = localFirstName;
    }

    public String getLocalLastName() {
        return localLastName;
    }

    public void setLocalLastName(String localLastName) {
        this.localLastName = localLastName;
    }

    public String getLocalDisplayNameFormat() {
        return localDisplayNameFormat;
    }

    public void setLocalDisplayNameFormat(String localDisplayNameFormat) {
        this.localDisplayNameFormat = localDisplayNameFormat;
    }

    public String getForm60Flag() {
        return form60Flag;
    }

    public void setForm60Flag(String form60Flag) {
        this.form60Flag = form60Flag;
    }

    public String getIdentityProofIndicator() {
        return identityProofIndicator;
    }

    public void setIdentityProofIndicator(String identityProofIndicator) {
        this.identityProofIndicator = identityProofIndicator;
    }

    public String getPartyStatusCode() {
        return partyStatusCode;
    }

    public void setPartyStatusCode(String partyStatusCode) {
        this.partyStatusCode = partyStatusCode;
    }

    public String getSalutationText() {
        return salutationText;
    }

    public void setSalutationText(String salutationText) {
        this.salutationText = salutationText;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getGeoDemographicCode() {
        return geoDemographicCode;
    }

    public void setGeoDemographicCode(String geoDemographicCode) {
        this.geoDemographicCode = geoDemographicCode;
    }

    public String getCountryOfResidenceCode() {
        return countryOfResidenceCode;
    }

    public void setCountryOfResidenceCode(String countryOfResidenceCode) {
        this.countryOfResidenceCode = countryOfResidenceCode;
    }

    public String getOccupationClassCode() {
        return occupationClassCode;
    }

    public void setOccupationClassCode(String occupationClassCode) {
        this.occupationClassCode = occupationClassCode;
    }

    public String getDeceasedFlag() {
        return deceasedFlag;
    }

    public void setDeceasedFlag(String deceasedFlag) {
        this.deceasedFlag = deceasedFlag;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getSourceofIncome() {
        return sourceofIncome;
    }

    public void setSourceofIncome(String sourceofIncome) {
        this.sourceofIncome = sourceofIncome;
    }

    public String getAnnualIncomeAmount() {
        return annualIncomeAmount;
    }

    public void setAnnualIncomeAmount(String annualIncomeAmount) {
        this.annualIncomeAmount = annualIncomeAmount;
    }

    public String getAnnualIncomeRangeCode() {
        return annualIncomeRangeCode;
    }

    public void setAnnualIncomeRangeCode(String annualIncomeRangeCode) {
        this.annualIncomeRangeCode = annualIncomeRangeCode;
    }

    public String getEducationLevelCode() {
        return educationLevelCode;
    }

    public void setEducationLevelCode(String educationLevelCode) {
        this.educationLevelCode = educationLevelCode;
    }

    public String getHeightMtr() {
        return heightMtr;
    }

    public void setHeightMtr(String heightMtr) {
        this.heightMtr = heightMtr;
    }

    public String getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(String weightKg) {
        this.weightKg = weightKg;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public String getStaffFlag() {
        return staffFlag;
    }

    public void setStaffFlag(String staffFlag) {
        this.staffFlag = staffFlag;
    }

    public String getAlertReceiverName() {
        return alertReceiverName;
    }

    public void setAlertReceiverName(String alertReceiverName) {
        this.alertReceiverName = alertReceiverName;
    }

    public String getPrimaryLanguageCode() {
        return primaryLanguageCode;
    }

    public void setPrimaryLanguageCode(String primaryLanguageCode) {
        this.primaryLanguageCode = primaryLanguageCode;
    }

    public String getSpecialNeedCode() {
        return specialNeedCode;
    }

    public void setSpecialNeedCode(String specialNeedCode) {
        this.specialNeedCode = specialNeedCode;
    }

    public String getPreferredContactMethodCode() {
        return preferredContactMethodCode;
    }

    public void setPreferredContactMethodCode(String preferredContactMethodCode) {
        this.preferredContactMethodCode = preferredContactMethodCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCoreDBPartyId() {
        return coreDBPartyId;
    }

    public void setCoreDBPartyId(String coreDBPartyId) {
        this.coreDBPartyId = coreDBPartyId;
    }

    public String getVipFlag() {
        return vipFlag;
    }

    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    public String getBankruptcyFlag() {
        return bankruptcyFlag;
    }

    public void setBankruptcyFlag(String bankruptcyFlag) {
        this.bankruptcyFlag = bankruptcyFlag;
    }

    public String getFraudCode() {
        return fraudCode;
    }

    public void setFraudCode(String fraudCode) {
        this.fraudCode = fraudCode;
    }

    public String getSmokingHabitFlag() {
        return smokingHabitFlag;
    }

    public void setSmokingHabitFlag(String smokingHabitFlag) {
        this.smokingHabitFlag = smokingHabitFlag;
    }

    public String getLocalMiddleName() {
        return localMiddleName;
    }

    public void setLocalMiddleName(String localMiddleName) {
        this.localMiddleName = localMiddleName;
    }

    public String getSpecialCaseCode() {
        return specialCaseCode;
    }

    public void setSpecialCaseCode(String specialCaseCode) {
        this.specialCaseCode = specialCaseCode;
    }

    public String getMasterIndividualId() {
        return masterIndividualId;
    }

    public void setMasterIndividualId(String masterIndividualId) {
        this.masterIndividualId = masterIndividualId;
    }

    public String getLOBCode() {
        return lOBCode;
    }

    public void setLOBCode(String lOBCode) {
        this.lOBCode = lOBCode;
    }

    public String getServiceTaxApplicabilityFlag() {
        return serviceTaxApplicabilityFlag;
    }

    public void setServiceTaxApplicabilityFlag(String serviceTaxApplicabilityFlag) {
        this.serviceTaxApplicabilityFlag = serviceTaxApplicabilityFlag;
    }

    public List<TelephoneContact> getTelephoneContacts() {
        return telephoneContacts;
    }

    public void setTelephoneContacts(List<TelephoneContact> telephoneContacts) {
        this.telephoneContacts = telephoneContacts;
    }

    public List<ElectronicContact> getElectronicContacts() {
        return electronicContacts;
    }

    public void setElectronicContacts(List<ElectronicContact> electronicContacts) {
        this.electronicContacts = electronicContacts;
    }

    public List<PartyIdentifier> getPartyIdentifiers() {
        return partyIdentifiers;
    }

    public void setPartyIdentifiers(List<PartyIdentifier> partyIdentifiers) {
        this.partyIdentifiers = partyIdentifiers;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public List<PhysicalContact> getPhysicalContacts() {
        return physicalContacts;
    }

    public void setPhysicalContacts(List<PhysicalContact> physicalContacts) {
        this.physicalContacts = physicalContacts;
    }
}
