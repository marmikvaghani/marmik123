
package com.example.cms.rating_put;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("partyCompaintDetails")
    @Expose
    private List<PartyCompaintDetail> partyCompaintDetails;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<PartyCompaintDetail> getPartyCompaintDetails() {
        return partyCompaintDetails;
    }

    public void setPartyCompaintDetails(List<PartyCompaintDetail> partyCompaintDetails) {
        this.partyCompaintDetails = partyCompaintDetails;
    }

}
