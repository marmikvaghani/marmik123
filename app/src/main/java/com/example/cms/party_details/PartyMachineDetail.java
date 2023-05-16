
package com.example.cms.party_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PartyMachineDetail {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("machineId")
    @Expose
    private String machineId;
    @SerializedName("partyName")
    @Expose
    private String partyName;
    @SerializedName("partyCity")
    @Expose
    private String partyCity;
    @SerializedName("machineNumber")
    @Expose
    private String machineNumber;
    @SerializedName("machineType")
    @Expose
    private String machineType;
    @SerializedName("installationDate")
    @Expose
    private String installationDate;
    @SerializedName("amcFromDate")
    @Expose
    private String amcFromDate;
    @SerializedName("amcToDate")
    @Expose
    private String amcToDate;
    @SerializedName("extendAmcDateArray")
    @Expose
    private List<Object> extendAmcDateArray;
    @SerializedName("warrantyFromDate")
    @Expose
    private String warrantyFromDate;
    @SerializedName("warrantyToDate")
    @Expose
    private String warrantyToDate;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("updatedAt")
    @Expose
    private String updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyCity() {
        return partyCity;
    }

    public void setPartyCity(String partyCity) {
        this.partyCity = partyCity;
    }

    public String getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(String installationDate) {
        this.installationDate = installationDate;
    }

    public String getAmcFromDate() {
        return amcFromDate;
    }

    public void setAmcFromDate(String amcFromDate) {
        this.amcFromDate = amcFromDate;
    }

    public String getAmcToDate() {
        return amcToDate;
    }

    public void setAmcToDate(String amcToDate) {
        this.amcToDate = amcToDate;
    }

    public List<Object> getExtendAmcDateArray() {
        return extendAmcDateArray;
    }

    public void setExtendAmcDateArray(List<Object> extendAmcDateArray) {
        this.extendAmcDateArray = extendAmcDateArray;
    }

    public String getWarrantyFromDate() {
        return warrantyFromDate;
    }

    public void setWarrantyFromDate(String warrantyFromDate) {
        this.warrantyFromDate = warrantyFromDate;
    }

    public String getWarrantyToDate() {
        return warrantyToDate;
    }

    public void setWarrantyToDate(String warrantyToDate) {
        this.warrantyToDate = warrantyToDate;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "PartyMachineDetail{" +
                "id='" + id + '\'' +
                ", partyName='" + partyName + '\'' +
                ", partyCity='" + partyCity + '\'' +
                ", machineNumber='" + machineNumber + '\'' +
                ", machineType='" + machineType + '\'' +
                ", installationDate='" + installationDate + '\'' +
                ", amcFromDate='" + amcFromDate + '\'' +
                ", amcToDate='" + amcToDate + '\'' +
                ", extendAmcDateArray=" + extendAmcDateArray +
                ", v=" + v +
                '}';
    }
}
