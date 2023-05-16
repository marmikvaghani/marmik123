
package com.addcomplaint_example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Data {

    @SerializedName("cmp_id")
    @Expose
    private String cmpId;
    @SerializedName("partyName")
    @Expose
    private String partyName;
    @SerializedName("machineNo")
    @Expose
    private String machineNo;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("createDateAt")
    @Expose
    private String createDateAt;
    @SerializedName("createTimeAt")
    @Expose
    private String createTimeAt;
    @SerializedName("repeatComplaintNumber")
    @Expose
    private Integer repeatComplaintNumber;
    @SerializedName("machineType")
    @Expose
    private String machineType;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getCmpId() {
        return cmpId;
    }

    public void setCmpId(String cmpId) {
        this.cmpId = cmpId;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCreateDateAt() {
        return createDateAt;
    }

    public void setCreateDateAt(String createDateAt) {
        this.createDateAt = createDateAt;
    }

    public String getCreateTimeAt() {
        return createTimeAt;
    }

    public void setCreateTimeAt(String createTimeAt) {
        this.createTimeAt = createTimeAt;
    }

    public Integer getRepeatComplaintNumber() {
        return repeatComplaintNumber;
    }

    public void setRepeatComplaintNumber(Integer repeatComplaintNumber) {
        this.repeatComplaintNumber = repeatComplaintNumber;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
