package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PSEAAgent {
    @SerializedName("agentCode")
    @Expose
    private String agentCode;
    @SerializedName("agentContractEffectiveDate")
    @Expose
    private String agentContractEffectiveDate;
    @SerializedName("agentIARBRegistrationNumber")
    @Expose
    private String agentIARBRegistrationNumber;
    @SerializedName("agentTerminationDate")
    @Expose
    private String agentTerminationDate;
    @SerializedName("agentTypeCode")
    @Expose
    private String agentTypeCode;
    @SerializedName("agentUnitCode")
    @Expose
    private String agentUnitCode;
    @SerializedName("party")
    @Expose
    private Party party;
    @SerializedName("agentUnit")
    @Expose
    private AgentUnit agentUnit;
    @SerializedName("PSEAParty")
    @Expose
    private PSEAParty pSEAParty;

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public String getAgentContractEffectiveDate() {
        return agentContractEffectiveDate;
    }

    public void setAgentContractEffectiveDate(String agentContractEffectiveDate) {
        this.agentContractEffectiveDate = agentContractEffectiveDate;
    }

    public String getAgentIARBRegistrationNumber() {
        return agentIARBRegistrationNumber;
    }

    public void setAgentIARBRegistrationNumber(String agentIARBRegistrationNumber) {
        this.agentIARBRegistrationNumber = agentIARBRegistrationNumber;
    }

    public String getAgentTerminationDate() {
        return agentTerminationDate;
    }

    public void setAgentTerminationDate(String agentTerminationDate) {
        this.agentTerminationDate = agentTerminationDate;
    }

    public String getAgentTypeCode() {
        return agentTypeCode;
    }

    public void setAgentTypeCode(String agentTypeCode) {
        this.agentTypeCode = agentTypeCode;
    }

    public String getAgentUnitCode() {
        return agentUnitCode;
    }

    public void setAgentUnitCode(String agentUnitCode) {
        this.agentUnitCode = agentUnitCode;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public AgentUnit getAgentUnit() {
        return agentUnit;
    }

    public void setAgentUnit(AgentUnit agentUnit) {
        this.agentUnit = agentUnit;
    }

    public PSEAParty getPSEAParty() {
        return pSEAParty;
    }

    public void setPSEAParty(PSEAParty pSEAParty) {
        this.pSEAParty = pSEAParty;
    }
}
