
package com.example.cms.pro;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PartyProfile {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("partyId")
    @Expose
    private String partyId;
    @SerializedName("partyName")
    @Expose
    private String partyName;
    @SerializedName("mobileNumber")
    @Expose
    private Long mobileNumber;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("passWord")
    @Expose
    private String passWord;
    @SerializedName("partyCity")
    @Expose
    private String partyCity;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("upadateAt")
    @Expose
    private String upadateAt;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPartyCity() {
        return partyCity;
    }

    public void setPartyCity(String partyCity) {
        this.partyCity = partyCity;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpadateAt() {
        return upadateAt;
    }

    public void setUpadateAt(String upadateAt) {
        this.upadateAt = upadateAt;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }


    @Override
    public String toString() {
        return "PartyProfile{" +
                "id='" + id + '\'' +
                ", partyId='" + partyId + '\'' +
                ", partyName='" + partyName + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", address='" + address + '\'' +
                ", passWord='" + passWord + '\'' +
                ", partyCity='" + partyCity + '\'' +
                ", createAt='" + createAt + '\'' +
                ", upadateAt='" + upadateAt + '\'' +
                ", v=" + v +
                '}';
    }
}
