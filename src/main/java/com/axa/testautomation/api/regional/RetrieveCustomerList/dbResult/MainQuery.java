package com.axa.testautomation.api.regional.RetrieveCustomerList.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class MainQuery {
    @SerializedName("SOURCE_SYSTEM_PARTY_ID")
    @Expose
    private String sOURCESYSTEMPARTYID;
    /*@SerializedName("ID_DOC_XML_VALUE")
    @Expose
    private Object iDDOCXMLVALUE;*/
    @SerializedName("STD_MARITAL_STAT_CODE")
    @Expose
    private String sTDMARITALSTATCODE;
    @SerializedName("MASTER_INDIVIDUAL_ID")
    @Expose
    private String mASTERINDIVIDUALID;
    /*@SerializedName("PARTY_XML_VALUE")
    @Expose
    private Object pARTYXMLVALUE;*/
    @SerializedName("STD_NATIONALITY_CODE")
    @Expose
    private String sTDNATIONALITYCODE;
    @SerializedName("LAST_NAME")
    @Expose
    private String lASTNAME;
    @SerializedName("MIDDLE_NAME")
    @Expose
    private String mIDDLE_NAME;
    @SerializedName("SALUTATION_TEXT")
    @Expose
    private String sALUTATIONTEXT;
    @SerializedName("TELEPHONE_ADDR_TYPE_CD")
    @Expose
    private String tELEPHONEADDRTYPECD;
    @SerializedName("FIRST_NAME")
    @Expose
    private String fIRSTNAME;
    @SerializedName("COUNTRY_OF_RESIDENCE_CODE")
    @Expose
    private String cOUNTRYOFRESIDENCECODE;
    @SerializedName("STD_PRIMARY_LANGUAGE_CODE")
    @Expose
    private String sTDPRIMARYLANGUAGECODE;
    @SerializedName("STD_GENDER_CODE")
    @Expose
    private String sTDGENDERCODE;
    @SerializedName("PARTY_TYPE_CODE")
    @Expose
    private String pARTYTYPECODE;
    @SerializedName("COMPANY_CODE")
    @Expose
    private String cOMPANYCODE;
    @SerializedName("BIRTH_DATE")
    @Expose
    private String bIRTHDATE;
    @SerializedName("ENTITY_CODE")
    @Expose
    private String eNTITYCODE;
    @SerializedName("SOURCE_SYSTEM_CODE")
    @Expose
    private String sOURCESYSTEMCODE;
    @SerializedName("CORE_DB_PARTY_ID")
    @Expose
    private String cOREDBPARTYID;
    @SerializedName("ELECTRONIC_ADDR")
    @Expose
    private String eLECTRONICADDR;
    @SerializedName("PARTY_STAT_CODE")
    @Expose
    private String pARTYSTATCODE;
    @SerializedName("TELEPHONE_NO")
    @Expose
    private String tELEPHONENO;
    @SerializedName("DISPLAY_NAME_FORMAT")
    @Expose
    private String dISPLAYNAMEFORMAT;
    @SerializedName("S_TAX_APPLICABILITY_IND")
    @Expose
    private String sTAXAPPLICABILITYIND;
    @SerializedName("DEATH_DATE")
    @Expose
    private String dEATHDATE;
    @SerializedName("LOCAL_FIRST_NAME")
    @Expose
    private String lOCAL_FIRST_NAME;
    @SerializedName("LOCAL_LAST_NAME")
    @Expose
    private String lOCAL_LAST_NAME;
    @SerializedName("LOCAL_DISPLAY_NAME_FORMAT")
    @Expose
    private String lOCAL_DISPLAY_NAME_FORMAT;
    @SerializedName("FORM_60_FLAG")
    @Expose
    private String FORM_60_FLAG;
    @SerializedName("IDENTITY_PROOF_INDICATOR")
    @Expose
    private String IDENTITY_PROOF_INDICATOR;
    @SerializedName("STD_GEO_DEMOGRAPHIC_CODE")
    @Expose
    private String STD_GEO_DEMOGRAPHIC_CODE;
    @SerializedName("STD_OCCUPATION_CLASS_CODE")
    @Expose
    private String STD_OCCUPATION_CLASS_CODE;
    @SerializedName("DECEASED_FLAG")
    @Expose
    private String DECEASED_FLAG;
    @SerializedName("ALERT_RECEIVER_NAME")
    @Expose
    private String ALERT_RECEIVER_NAME;
    @SerializedName("SOURCE_OF_INCOME")
    @Expose
    private String SOURCE_OF_INCOME;
    @SerializedName("ANNUAL_INCOME_AMOUNT")
    @Expose
    private String ANNUAL_INCOME_AMOUNT;
    @SerializedName("ANNUAL_INCOME_AMNT_RANGE_CODE")
    @Expose
    private String ANNUAL_INCOME_AMNT_RANGE_CODE;
    @SerializedName("STD_EDUCATION_LEVEL_CODE")
    @Expose
    private String STD_EDUCATION_LEVEL_CODE;
    @SerializedName("HEIGHT_IN_METER")
    @Expose
    private String HEIGHT_IN_METER;
    @SerializedName("WEIGHT_IN_KILOGRAM")
    @Expose
    private String WEIGHT_IN_KILOGRAM;
    @SerializedName("STAFF_NUMBER")
    @Expose
    private String STAFF_NUMBER;
    @SerializedName("STAFF_FLAG")
    @Expose
    private String STAFF_FLAG;
    @SerializedName("STD_SPECIAL_NEED_CODE")
    @Expose
    private String STD_SPECIAL_NEED_CODE;
    @SerializedName("STD_PREFFERED_CONTACT_MTHD_CD")
    @Expose
    private String STD_PREFFERED_CONTACT_MTHD_CD;
    @SerializedName("SMOKING_HABIT")
    @Expose
    private String SMOKING_HABIT;
    @SerializedName("SPECIAL_CASE_CODE")
    @Expose
    private String SPECIAL_CASE_CODE;
    @SerializedName("BANKRUPTCY_FLAG")
    @Expose
    private String BANKRUPTCY_FLAG;
    @SerializedName("FRAUD_CODE")
    @Expose
    private String FRAUD_CODE;
    @SerializedName("LOCAL_MIDDLE_NAME")
    @Expose
    private String LOCAL_MIDDLE_NAME;
    @SerializedName("VIP_FLAG")
    @Expose
    private String VIP_FLAG;

    public String getSOURCESYSTEMPARTYID() {
        return sOURCESYSTEMPARTYID;
    }

    public void setSOURCESYSTEMPARTYID(String sOURCESYSTEMPARTYID) {
        this.sOURCESYSTEMPARTYID = sOURCESYSTEMPARTYID;
    }

    /*public Object getIDDOCXMLVALUE() {
        return iDDOCXMLVALUE;
    }

    public void setIDDOCXMLVALUE(Object iDDOCXMLVALUE) {
        this.iDDOCXMLVALUE = iDDOCXMLVALUE;
    }*/

    public String getSTDMARITALSTATCODE() {
        return sTDMARITALSTATCODE;
    }

    public void setSTDMARITALSTATCODE(String sTDMARITALSTATCODE) {
        this.sTDMARITALSTATCODE = sTDMARITALSTATCODE;
    }

    public String getMASTERINDIVIDUALID() {
        return mASTERINDIVIDUALID;
    }

    public void setMASTERINDIVIDUALID(String mASTERINDIVIDUALID) {
        this.mASTERINDIVIDUALID = mASTERINDIVIDUALID;
    }

    /*public Object getPARTYXMLVALUE() {
        return pARTYXMLVALUE;
    }

    public void setPARTYXMLVALUE(Object pARTYXMLVALUE) {
        this.pARTYXMLVALUE = pARTYXMLVALUE;
    }*/

    public String getSTDNATIONALITYCODE() {
        return sTDNATIONALITYCODE;
    }

    public void setSTDNATIONALITYCODE(String sTDNATIONALITYCODE) {
        this.sTDNATIONALITYCODE = sTDNATIONALITYCODE;
    }

    public String getLASTNAME() {
        return lASTNAME;
    }

    public void setLASTNAME(String lASTNAME) {
        this.lASTNAME = lASTNAME;
    }

    public String getSALUTATIONTEXT() {
        return sALUTATIONTEXT;
    }

    public void setSALUTATIONTEXT(String sALUTATIONTEXT) {
        this.sALUTATIONTEXT = sALUTATIONTEXT;
    }

    public String getTELEPHONEADDRTYPECD() {
        return tELEPHONEADDRTYPECD;
    }

    public void setTELEPHONEADDRTYPECD(String tELEPHONEADDRTYPECD) {
        this.tELEPHONEADDRTYPECD = tELEPHONEADDRTYPECD;
    }

    public String getFIRSTNAME() {
        return fIRSTNAME;
    }

    public void setFIRSTNAME(String fIRSTNAME) {
        this.fIRSTNAME = fIRSTNAME;
    }

    public String getCOUNTRYOFRESIDENCECODE() {
        return cOUNTRYOFRESIDENCECODE;
    }

    public void setCOUNTRYOFRESIDENCECODE(String cOUNTRYOFRESIDENCECODE) {
        this.cOUNTRYOFRESIDENCECODE = cOUNTRYOFRESIDENCECODE;
    }

    public String getSTDPRIMARYLANGUAGECODE() {
        return sTDPRIMARYLANGUAGECODE;
    }

    public void setSTDPRIMARYLANGUAGECODE(String sTDPRIMARYLANGUAGECODE) {
        this.sTDPRIMARYLANGUAGECODE = sTDPRIMARYLANGUAGECODE;
    }

    public String getSTDGENDERCODE() {
        return sTDGENDERCODE;
    }

    public void setSTDGENDERCODE(String sTDGENDERCODE) {
        this.sTDGENDERCODE = sTDGENDERCODE;
    }

    public String getPARTYTYPECODE() {
        return pARTYTYPECODE;
    }

    public void setPARTYTYPECODE(String pARTYTYPECODE) {
        this.pARTYTYPECODE = pARTYTYPECODE;
    }

    public String getCOMPANYCODE() {
        return cOMPANYCODE;
    }

    public void setCOMPANYCODE(String cOMPANYCODE) {
        this.cOMPANYCODE = cOMPANYCODE;
    }

    public String getBIRTHDATE() {
        return bIRTHDATE;
    }

    public void setBIRTHDATE(String bIRTHDATE) {
        this.bIRTHDATE = bIRTHDATE;
    }

    public String getENTITYCODE() {
        return eNTITYCODE;
    }

    public void setENTITYCODE(String eNTITYCODE) {
        this.eNTITYCODE = eNTITYCODE;
    }

    public String getSOURCESYSTEMCODE() {
        return sOURCESYSTEMCODE;
    }

    public void setSOURCESYSTEMCODE(String sOURCESYSTEMCODE) {
        this.sOURCESYSTEMCODE = sOURCESYSTEMCODE;
    }

    public String getCOREDBPARTYID() {
        return cOREDBPARTYID;
    }

    public void setCOREDBPARTYID(String cOREDBPARTYID) {
        this.cOREDBPARTYID = cOREDBPARTYID;
    }

    public String getELECTRONICADDR() {
        return eLECTRONICADDR;
    }

    public void setELECTRONICADDR(String eLECTRONICADDR) {
        this.eLECTRONICADDR = eLECTRONICADDR;
    }

    public String getPARTYSTATCODE() {
        return pARTYSTATCODE;
    }

    public void setPARTYSTATCODE(String pARTYSTATCODE) {
        this.pARTYSTATCODE = pARTYSTATCODE;
    }

    public String getTELEPHONENO() {
        return tELEPHONENO;
    }

    public void setTELEPHONENO(String tELEPHONENO) {
        this.tELEPHONENO = tELEPHONENO;
    }

    public String getDISPLAYNAMEFORMAT() {
        return dISPLAYNAMEFORMAT;
    }

    public void setDISPLAYNAMEFORMAT(String dISPLAYNAMEFORMAT) {
        this.dISPLAYNAMEFORMAT = dISPLAYNAMEFORMAT;
    }

    public String getSTAXAPPLICABILITYIND() {
        return sTAXAPPLICABILITYIND;
    }

    public void setSTAXAPPLICABILITYIND(String sTAXAPPLICABILITYIND) {
        this.sTAXAPPLICABILITYIND = sTAXAPPLICABILITYIND;
    }

    public String getDEATHDATE() {
        return dEATHDATE;
    }

    public void setDEATHDATE(String dEATHDATE) {
        this.dEATHDATE = dEATHDATE;
    }

    public String getmIDDLE_NAME() {
        return mIDDLE_NAME;
    }

    public void setmIDDLE_NAME(String mIDDLE_NAME) {
        this.mIDDLE_NAME = mIDDLE_NAME;
    }

    public String getlOCAL_FIRST_NAME() {
        return lOCAL_FIRST_NAME;
    }

    public void setlOCAL_FIRST_NAME(String lOCAL_FIRST_NAME) {
        this.lOCAL_FIRST_NAME = lOCAL_FIRST_NAME;
    }

    public String getlOCAL_LAST_NAME() {
        return lOCAL_LAST_NAME;
    }

    public void setlOCAL_LAST_NAME(String lOCAL_LAST_NAME) {
        this.lOCAL_LAST_NAME = lOCAL_LAST_NAME;
    }

    public String getlOCAL_DISPLAY_NAME_FORMAT() {
        return lOCAL_DISPLAY_NAME_FORMAT;
    }

    public void setlOCAL_DISPLAY_NAME_FORMAT(String lOCAL_DISPLAY_NAME_FORMAT) {
        this.lOCAL_DISPLAY_NAME_FORMAT = lOCAL_DISPLAY_NAME_FORMAT;
    }

    public String getFORM_60_FLAG() {
        return FORM_60_FLAG;
    }

    public void setFORM_60_FLAG(String FORM_60_FLAG) {
        this.FORM_60_FLAG = FORM_60_FLAG;
    }

    public String getIDENTITY_PROOF_INDICATOR() {
        return IDENTITY_PROOF_INDICATOR;
    }

    public void setIDENTITY_PROOF_INDICATOR(String IDENTITY_PROOF_INDICATOR) {
        this.IDENTITY_PROOF_INDICATOR = IDENTITY_PROOF_INDICATOR;
    }

    public String getSTD_GEO_DEMOGRAPHIC_CODE() {
        return STD_GEO_DEMOGRAPHIC_CODE;
    }

    public void setSTD_GEO_DEMOGRAPHIC_CODE(String STD_GEO_DEMOGRAPHIC_CODE) {
        this.STD_GEO_DEMOGRAPHIC_CODE = STD_GEO_DEMOGRAPHIC_CODE;
    }

    public String getSTD_OCCUPATION_CLASS_CODE() {
        return STD_OCCUPATION_CLASS_CODE;
    }

    public void setSTD_OCCUPATION_CLASS_CODE(String STD_OCCUPATION_CLASS_CODE) {
        this.STD_OCCUPATION_CLASS_CODE = STD_OCCUPATION_CLASS_CODE;
    }

    public String getDECEASED_FLAG() {
        return DECEASED_FLAG;
    }

    public void setDECEASED_FLAG(String DECEASED_FLAG) {
        this.DECEASED_FLAG = DECEASED_FLAG;
    }

    public String getALERT_RECEIVER_NAME() {
        return ALERT_RECEIVER_NAME;
    }

    public void setALERT_RECEIVER_NAME(String ALERT_RECEIVER_NAME) {
        this.ALERT_RECEIVER_NAME = ALERT_RECEIVER_NAME;
    }

    public String getSOURCE_OF_INCOME() {
        return SOURCE_OF_INCOME;
    }

    public void setSOURCE_OF_INCOME(String SOURCE_OF_INCOME) {
        this.SOURCE_OF_INCOME = SOURCE_OF_INCOME;
    }

    public String getANNUAL_INCOME_AMOUNT() {
        return ANNUAL_INCOME_AMOUNT;
    }

    public void setANNUAL_INCOME_AMOUNT(String ANNUAL_INCOME_AMOUNT) {
        this.ANNUAL_INCOME_AMOUNT = ANNUAL_INCOME_AMOUNT;
    }

    public String getANNUAL_INCOME_AMNT_RANGE_CODE() {
        return ANNUAL_INCOME_AMNT_RANGE_CODE;
    }

    public void setANNUAL_INCOME_AMNT_RANGE_CODE(String ANNUAL_INCOME_AMNT_RANGE_CODE) {
        this.ANNUAL_INCOME_AMNT_RANGE_CODE = ANNUAL_INCOME_AMNT_RANGE_CODE;
    }

    public String getSTD_EDUCATION_LEVEL_CODE() {
        return STD_EDUCATION_LEVEL_CODE;
    }

    public void setSTD_EDUCATION_LEVEL_CODE(String STD_EDUCATION_LEVEL_CODE) {
        this.STD_EDUCATION_LEVEL_CODE = STD_EDUCATION_LEVEL_CODE;
    }

    public String getHEIGHT_IN_METER() {
        return HEIGHT_IN_METER;
    }

    public void setHEIGHT_IN_METER(String HEIGHT_IN_METER) {
        this.HEIGHT_IN_METER = HEIGHT_IN_METER;
    }

    public String getWEIGHT_IN_KILOGRAM() {
        return WEIGHT_IN_KILOGRAM;
    }

    public void setWEIGHT_IN_KILOGRAM(String WEIGHT_IN_KILOGRAM) {
        this.WEIGHT_IN_KILOGRAM = WEIGHT_IN_KILOGRAM;
    }

    public String getSTAFF_NUMBER() {
        return STAFF_NUMBER;
    }

    public void setSTAFF_NUMBER(String STAFF_NUMBER) {
        this.STAFF_NUMBER = STAFF_NUMBER;
    }

    public String getSTAFF_FLAG() {
        return STAFF_FLAG;
    }

    public void setSTAFF_FLAG(String STAFF_FLAG) {
        this.STAFF_FLAG = STAFF_FLAG;
    }

    public String getSTD_SPECIAL_NEED_CODE() {
        return STD_SPECIAL_NEED_CODE;
    }

    public void setSTD_SPECIAL_NEED_CODE(String STD_SPECIAL_NEED_CODE) {
        this.STD_SPECIAL_NEED_CODE = STD_SPECIAL_NEED_CODE;
    }

    public String getSTD_PREFFERED_CONTACT_MTHD_CD() {
        return STD_PREFFERED_CONTACT_MTHD_CD;
    }

    public void setSTD_PREFFERED_CONTACT_MTHD_CD(String STD_PREFFERED_CONTACT_MTHD_CD) {
        this.STD_PREFFERED_CONTACT_MTHD_CD = STD_PREFFERED_CONTACT_MTHD_CD;
    }

    public String getSMOKING_HABIT() {
        return SMOKING_HABIT;
    }

    public void setSMOKING_HABIT(String SMOKING_HABIT) {
        this.SMOKING_HABIT = SMOKING_HABIT;
    }

    public String getSPECIAL_CASE_CODE() {
        return SPECIAL_CASE_CODE;
    }

    public void setSPECIAL_CASE_CODE(String SPECIAL_CASE_CODE) {
        this.SPECIAL_CASE_CODE = SPECIAL_CASE_CODE;
    }

    public String getBANKRUPTCY_FLAG() {
        return BANKRUPTCY_FLAG;
    }

    public void setBANKRUPTCY_FLAG(String BANKRUPTCY_FLAG) {
        this.BANKRUPTCY_FLAG = BANKRUPTCY_FLAG;
    }

    public String getFRAUD_CODE() {
        return FRAUD_CODE;
    }

    public void setFRAUD_CODE(String FRAUD_CODE) {
        this.FRAUD_CODE = FRAUD_CODE;
    }

    public String getLOCAL_MIDDLE_NAME() {
        return LOCAL_MIDDLE_NAME;
    }

    public void setLOCAL_MIDDLE_NAME(String LOCAL_MIDDLE_NAME) {
        this.LOCAL_MIDDLE_NAME = LOCAL_MIDDLE_NAME;
    }

    public String getVIP_FLAG() {
        return VIP_FLAG;
    }

    public void setVIP_FLAG(String VIP_FLAG) {
        this.VIP_FLAG = VIP_FLAG;
    }
}
