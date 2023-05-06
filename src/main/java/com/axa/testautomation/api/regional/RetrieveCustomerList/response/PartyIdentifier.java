package com.axa.testautomation.api.regional.RetrieveCustomerList.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartyIdentifier {
    @SerializedName("idDocumentNumber")
    @Expose
    private String idDocumentNumber;
    @SerializedName("idDocumentType")
    @Expose
    private String idDocumentType;

    public String getIdDocumentNumber() {
        return idDocumentNumber;
    }

    public void setIdDocumentNumber(String idDocumentNumber) {
        this.idDocumentNumber = idDocumentNumber;
    }

    public String getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(String idDocumentType) {
        this.idDocumentType = idDocumentType;
    }
}
