
package com.example;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Example {

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

}
