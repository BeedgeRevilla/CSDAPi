package com.axa.testautomation.api.regional.RetrieveAccountDetails.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MANDPFF {
    @SerializedName("MAND_AMT")
    @Expose
    private String mANDAMT;
    @SerializedName("TRANSACTION_DATE")
    @Expose
    private String tRANSACTIONDATE;
    @SerializedName("DECODE(IS_DATE(TO_CHAR(ACD.EFFDATE)),1,TO_DATE(TO_CHAR(ACD.EFFDATE),'YYYY-MM-DD'),TO_DATE('19000101','YYYY-MM-DD'))")
    @Expose
    private String dECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD;
    @SerializedName("CREDIT_CARD_NUMBER")
    @Expose
    private String cREDITCARDNUMBER;
    @SerializedName("STAT_CHANGE_DATE")
    @Expose
    private String sTATCHANGEDATE;
    @SerializedName("EFFDATE")
    @Expose
    private String eFFDATE;
    @SerializedName("TIMES_USE")
    @Expose
    private String tIMESUSE;
    @SerializedName("LAST_USE_DATE")
    @Expose
    private String lASTUSEDATE;
    @SerializedName("LAST_USE_AMT")
    @Expose
    private Double lASTUSEAMT;
    @SerializedName("PAYRCOY")
    @Expose
    private String pAYRCOY;
    @SerializedName("USER")
    @Expose
    private String uSER;
    @SerializedName("FACTHOUS")
    @Expose
    private String fACTHOUS;
    @SerializedName("TERMID")
    @Expose
    private String tERMID;
    @SerializedName("MANDSTAT")
    @Expose
    private String mANDSTAT;
    @SerializedName("BANKDESC")
    @Expose
    private String bANKDESC;
    @SerializedName("DETLSUMM")
    @Expose
    private String dETLSUMM;
    @SerializedName("PAYRNUM")
    @Expose
    private String pAYRNUM;
    @SerializedName("BANKKEY")
    @Expose
    private String bANKKEY;
    @SerializedName("TRANSACTION_TIME")
    @Expose
    private String tRANSACTIONTIME;
    @SerializedName("VALIDFLAG")
    @Expose
    private String vALIDFLAG;
    @SerializedName("MANDREF")
    @Expose
    private String mANDREF;
    @SerializedName("BANK_ACC_NUMBER")
    @Expose
    private String bANK_ACC_NUMBER;

    public String getMANDAMT() {
        return mANDAMT;
    }

    public void setMANDAMT(String mANDAMT) {
        this.mANDAMT = mANDAMT;
    }

    public String getTRANSACTIONDATE() {
        return tRANSACTIONDATE;
    }

    public void setTRANSACTIONDATE(String tRANSACTIONDATE) {
        this.tRANSACTIONDATE = tRANSACTIONDATE;
    }

    public String getDECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD() {
        return dECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD;
    }

    public void setDECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD(String dECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD) {
        this.dECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD = dECODEISDATETOCHARACDEFFDATE1TODATETOCHARACDEFFDATEYYYYMMDDTODATE19000101YYYYMMDD;
    }

    public String getCREDITCARDNUMBER() {
        return cREDITCARDNUMBER;
    }

    public void setCREDITCARDNUMBER(String cREDITCARDNUMBER) {
        this.cREDITCARDNUMBER = cREDITCARDNUMBER;
    }

    public String getSTATCHANGEDATE() {
        return sTATCHANGEDATE;
    }

    public void setSTATCHANGEDATE(String sTATCHANGEDATE) {
        this.sTATCHANGEDATE = sTATCHANGEDATE;
    }

    public String getEFFDATE() {
        return eFFDATE;
    }

    public void setEFFDATE(String eFFDATE) {
        this.eFFDATE = eFFDATE;
    }

    public String getTIMESUSE() {
        return tIMESUSE;
    }

    public void setTIMESUSE(String tIMESUSE) {
        this.tIMESUSE = tIMESUSE;
    }

    public String getLASTUSEDATE() {
        return lASTUSEDATE;
    }

    public void setLASTUSEDATE(String lASTUSEDATE) {
        this.lASTUSEDATE = lASTUSEDATE;
    }

    public Double getLASTUSEAMT() {
        return lASTUSEAMT;
    }

    public void setLASTUSEAMT(Double lASTUSEAMT) {
        this.lASTUSEAMT = lASTUSEAMT;
    }

    public String getPAYRCOY() {
        return pAYRCOY;
    }

    public void setPAYRCOY(String pAYRCOY) {
        this.pAYRCOY = pAYRCOY;
    }

    public String getUSER() {
        return uSER;
    }

    public void setUSER(String uSER) {
        this.uSER = uSER;
    }

    public String getFACTHOUS() {
        return fACTHOUS;
    }

    public void setFACTHOUS(String fACTHOUS) {
        this.fACTHOUS = fACTHOUS;
    }

    public String getTERMID() {
        return tERMID;
    }

    public void setTERMID(String tERMID) {
        this.tERMID = tERMID;
    }

    public String getMANDSTAT() {
        return mANDSTAT;
    }

    public void setMANDSTAT(String mANDSTAT) {
        this.mANDSTAT = mANDSTAT;
    }

    public String getBANKDESC() {
        return bANKDESC;
    }

    public void setBANKDESC(String bANKDESC) {
        this.bANKDESC = bANKDESC;
    }

    public String getDETLSUMM() {
        return dETLSUMM;
    }

    public void setDETLSUMM(String dETLSUMM) {
        this.dETLSUMM = dETLSUMM;
    }

    public String getPAYRNUM() {
        return pAYRNUM;
    }

    public void setPAYRNUM(String pAYRNUM) {
        this.pAYRNUM = pAYRNUM;
    }

    public String getBANKKEY() {
        return bANKKEY;
    }

    public void setBANKKEY(String bANKKEY) {
        this.bANKKEY = bANKKEY;
    }

    public String getTRANSACTIONTIME() {
        return tRANSACTIONTIME;
    }

    public void setTRANSACTIONTIME(String tRANSACTIONTIME) {
        this.tRANSACTIONTIME = tRANSACTIONTIME;
    }

    public String getVALIDFLAG() {
        return vALIDFLAG;
    }

    public void setVALIDFLAG(String vALIDFLAG) {
        this.vALIDFLAG = vALIDFLAG;
    }

    public String getMANDREF() {
        return mANDREF;
    }

    public void setMANDREF(String mANDREF) {
        this.mANDREF = mANDREF;
    }

    public String getBANK_ACC_NUMBER() {
        return bANK_ACC_NUMBER;
    }

    public void setBANK_ACC_NUMBER(String bANK_ACC_NUMBER) {
        this.bANK_ACC_NUMBER = bANK_ACC_NUMBER;
    }
}
