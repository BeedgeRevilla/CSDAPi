package com.axa.testautomation.api.regional.RetrieveAgentDetails.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgentUnit {
    @SerializedName("assistantBranchCode")
    @Expose
    private String assistantBranchCode;
    @SerializedName("territoryCode")
    @Expose
    private String territoryCode;
    @SerializedName("branchCode")
    @Expose
    private String branchCode;
    @SerializedName("territoryDescription")
    @Expose
    private String territoryDescription;

    public String getAssistantBranchCode() {
        return assistantBranchCode;
    }

    public void setAssistantBranchCode(String assistantBranchCode) {
        this.assistantBranchCode = assistantBranchCode;
    }

    public String getTerritoryCode() {
        return territoryCode;
    }

    public void setTerritoryCode(String territoryCode) {
        this.territoryCode = territoryCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }
}
