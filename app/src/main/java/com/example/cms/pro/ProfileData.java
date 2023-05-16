
package com.example.cms.pro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileData {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("partyProfile")
    @Expose
    private PartyProfile partyProfile;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public PartyProfile getPartyProfile() {
        return partyProfile;
    }

    public void setPartyProfile(PartyProfile partyProfile) {
        this.partyProfile = partyProfile;
    }


    @Override
    public String toString() {
        return "ProfileData{" +
                "statusCode=" + statusCode +
                ", partyProfile=" + partyProfile +
                '}';
    }
}
