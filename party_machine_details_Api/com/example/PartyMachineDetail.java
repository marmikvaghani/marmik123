
package com.example;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class PartyMachineDetail {

    @SerializedName("_id")
    @Expose
    private String id;
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
    private List<Object> extendAmcDateArray = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
