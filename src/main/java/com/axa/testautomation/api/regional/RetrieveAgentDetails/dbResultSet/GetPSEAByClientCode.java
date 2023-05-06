package com.axa.testautomation.api.regional.RetrieveAgentDetails.dbResultSet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPSEAByClientCode {
    @SerializedName("CLTDOB")
    @Expose
    private String cLTDOB;
    @SerializedName("PARTY_XML_VALUE")
    @Expose
    private String pARTYXMLVALUE;
    @SerializedName("PARTY_NAME")
    @Expose
    private String pARTYNAME;
    @SerializedName("LGIVNAME")
    @Expose
    private String LGIVNAME;
    @SerializedName("LSURNAME")
    @Expose
    private String lSURNAME;
    @SerializedName("CLTSEX")
    @Expose
    private String cLTSEX;
    @SerializedName("RINTERNET")
    @Expose
    private String RINTERNET;


    public String getCLTDOB() {
        return cLTDOB;
    }

    public void setCLTDOB(String cLTDOB) {
        this.cLTDOB = cLTDOB;
    }

    public String getPARTYXMLVALUE() {
        return pARTYXMLVALUE;
    }

    public void setPARTYXMLVALUE(String pARTYXMLVALUE) {
        this.pARTYXMLVALUE = pARTYXMLVALUE;
    }

    public String getPARTYNAME() {
        return pARTYNAME;
    }

    public void setPARTYNAME(String pARTYNAME) {
        this.pARTYNAME = pARTYNAME;
    }

    public String getLSURNAME() {
        return lSURNAME;
    }

    public void setLSURNAME(String lSURNAME) {
        this.lSURNAME = lSURNAME;
    }

    public String getCLTSEX() {
        return cLTSEX;
    }

    public void setCLTSEX(String cLTSEX) {
        this.cLTSEX = cLTSEX;
    }

    public String getRINTERNET() {
        return RINTERNET;
    }

    public void setRINTERNET(String RINTERNET) {
        this.RINTERNET = RINTERNET;
    }

    public String getLGIVNAME() {
        return LGIVNAME;
    }

    public void setLGIVNAME(String LGIVNAME) {
        this.LGIVNAME = LGIVNAME;
    }
}
