package com.axa.testautomation.api.regional.RetrieveAgentDetails.dbResultSet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAgentDetailsFromPSEAByAgentCode {
    @SerializedName("TERMINATION_DATE")
    @Expose
    private String tERMINATIONDATE;
    @SerializedName("CLNTNUM")
    @Expose
    private String cLNTNUM;
    @SerializedName("CONTRACT_EFFECTIVE_DATE")
    @Expose
    private String cONTRACTEFFECTIVEDATE;
    @SerializedName("AGNTBR")
    @Expose
    private String aGNTBR;
    @SerializedName("AGNTNUM")
    @Expose
    private String aGNTNUM;
    @SerializedName("CHDRSTCDA")
    @Expose
    private String cHDRSTCDA;
    @SerializedName("AGTYPE")
    @Expose
    private String aGTYPE;
    @SerializedName("AGTLICNO")
    @Expose
    private String AGTLICNO;
    @SerializedName("ZDISTRICT")
    @Expose
    private String ZDISTRICT;
    @SerializedName("LONGDESC")
    @Expose
    private String LONGDESC;


    public String getTERMINATIONDATE() {
        return tERMINATIONDATE;
    }

    public void setTERMINATIONDATE(String tERMINATIONDATE) {
        this.tERMINATIONDATE = tERMINATIONDATE;
    }

    public String getCLNTNUM() {
        return cLNTNUM;
    }

    public void setCLNTNUM(String cLNTNUM) {
        this.cLNTNUM = cLNTNUM;
    }

    public String getCONTRACTEFFECTIVEDATE() {
        return cONTRACTEFFECTIVEDATE;
    }

    public void setCONTRACTEFFECTIVEDATE(String cONTRACTEFFECTIVEDATE) {
        this.cONTRACTEFFECTIVEDATE = cONTRACTEFFECTIVEDATE;
    }

    public String getAGNTBR() {
        return aGNTBR;
    }

    public void setAGNTBR(String aGNTBR) {
        this.aGNTBR = aGNTBR;
    }

    public String getAGNTNUM() {
        return aGNTNUM;
    }

    public void setAGNTNUM(String aGNTNUM) {
        this.aGNTNUM = aGNTNUM;
    }

    public String getCHDRSTCDA() {
        return cHDRSTCDA;
    }

    public void setCHDRSTCDA(String cHDRSTCDA) {
        this.cHDRSTCDA = cHDRSTCDA;
    }

    public String getAGTYPE() {
        return aGTYPE;
    }

    public void setAGTYPE(String aGTYPE) {
        this.aGTYPE = aGTYPE;
    }

    public String getAGTLICNO() {
        return AGTLICNO;
    }

    public void setAGTLICNO(String AGTLICNO) {
        this.AGTLICNO = AGTLICNO;
    }

    public String getZDISTRICT() {
        return ZDISTRICT;
    }

    public void setZDISTRICT(String ZDISTRICT) {
        this.ZDISTRICT = ZDISTRICT;
    }

    public String getLONGDESC() {
        return LONGDESC;
    }

    public void setLONGDESC(String LONGDESC) {
        this.LONGDESC = LONGDESC;
    }
}
