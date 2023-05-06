package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Assignee {

    @SerializedName("PhysicalContact")
    @Expose
    private List<PhysicalContact> physicalContact = null;

    public List<PhysicalContact> getPhysicalContact() {
        return physicalContact;
    }

    public void setPhysicalContact(List<PhysicalContact> physicalContact) {
        this.physicalContact = physicalContact;
    }
}
