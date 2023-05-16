
package com.pending_bills;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("billId")
    @Expose
    private String billId;
    @SerializedName("comId")
    @Expose
    private String comId;
    @SerializedName("partyName")
    @Expose
    private String partyName;
    @SerializedName("partyCity")
    @Expose
    private String partyCity;
    @SerializedName("machineNumber")
    @Expose
    private Integer machineNumber;
    @SerializedName("machineType")
    @Expose
    private String machineType;
    @SerializedName("isMachineWarranty")
    @Expose
    private Boolean isMachineWarranty;
    @SerializedName("isAdmin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("partsDetails")
    @Expose
    private List<PartsDetail> partsDetails;
    @SerializedName("isPaymentsStatus")
    @Expose
    private Boolean isPaymentsStatus;
    @SerializedName("createAt")
    @Expose
    private String createAt;
    @SerializedName("upadateAt")
    @Expose
    private String upadateAt;
    @SerializedName("mainTotal")
    @Expose
    private Integer mainTotal;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
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

    public Integer getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(Integer machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public Boolean getIsMachineWarranty() {
        return isMachineWarranty;
    }

    public void setIsMachineWarranty(Boolean isMachineWarranty) {
        this.isMachineWarranty = isMachineWarranty;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<PartsDetail> getPartsDetails() {
        return partsDetails;
    }

    public void setPartsDetails(List<PartsDetail> partsDetails) {
        this.partsDetails = partsDetails;
    }

    public Boolean getIsPaymentsStatus() {
        return isPaymentsStatus;
    }

    public void setIsPaymentsStatus(Boolean isPaymentsStatus) {
        this.isPaymentsStatus = isPaymentsStatus;
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

    public Integer getMainTotal() {
        return mainTotal;
    }

    public void setMainTotal(Integer mainTotal) {
        this.mainTotal = mainTotal;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
