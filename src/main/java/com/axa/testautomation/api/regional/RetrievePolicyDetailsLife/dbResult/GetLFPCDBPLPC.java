package com.axa.testautomation.api.regional.RetrievePolicyDetailsLife.dbResult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLFPCDBPLPC {
    @SerializedName("Q46MPREM")
    @Expose
    private Double Q46MPREM;
    @SerializedName("Q46LMPREM")
    @Expose
    private Double Q46LMPREM;
    @SerializedName("Q46PRMCHG")
    @Expose
    private Double Q46PRMCHG;
    @SerializedName("Q49AUTORNS")
    @Expose
    private Double Q49AUTORNS;

    public Double getQ46MPREM() {
        return Q46MPREM;
    }

    public void setQ46MPREM(Double q46MPREM) {
        Q46MPREM = q46MPREM;
    }

    public Double getQ46LMPREM() {
        return Q46LMPREM;
    }

    public void setQ46LMPREM(Double q46LMPREM) {
        Q46LMPREM = q46LMPREM;
    }

    public Double getQ46PRMCHG() {
        return Q46PRMCHG;
    }

    public void setQ46PRMCHG(Double q46PRMCHG) {
        Q46PRMCHG = q46PRMCHG;
    }

    public Double getQ49AUTORNS() {
        return Q49AUTORNS;
    }

    public void setQ49AUTORNS(Double q49AUTORNS) {
        Q49AUTORNS = q49AUTORNS;
    }
}
