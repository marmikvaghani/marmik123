
package com.example.cms.party_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MDExample {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("partyMachineDetails")
    @Expose
    private List<PartyMachineDetail> partyMachineDetails = null;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<PartyMachineDetail> getPartyMachineDetails() {
        return partyMachineDetails;
    }

    public void setPartyMachineDetails(List<PartyMachineDetail> partyMachineDetails) {
        this.partyMachineDetails = partyMachineDetails;
    }


    @Override
    public String toString() {
        return "MDExample{" +
                "statusCode=" + statusCode +
                ", partyMachineDetails=" + partyMachineDetails +
                '}';
    }
}
