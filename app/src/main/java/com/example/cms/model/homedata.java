package com.example.cms.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class homedata {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("totalMachineCount")
    @Expose
    private Integer totalMachineCount;
    @SerializedName("totalComplaintCount")
    @Expose
    private Integer totalComplaintCount;
    @SerializedName("completeComplaintCount")
    @Expose
    private Integer completeComplaintCount;
    @SerializedName("pendingComplaintCount")
    @Expose
    private Integer pendingComplaintCount;
    @SerializedName("reviewComplaintCount")
    @Expose
    private Integer reviewComplaintCount;
    @SerializedName("AmcDateCheck")
    @Expose
    private Integer amcDateCheck;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getTotalMachineCount() {
        return totalMachineCount;
    }

    public void setTotalMachineCount(Integer totalMachineCount) {
        this.totalMachineCount = totalMachineCount;
    }

    public Integer getTotalComplaintCount() {
        return totalComplaintCount;
    }

    public void setTotalComplaintCount(Integer totalComplaintCount) {
        this.totalComplaintCount = totalComplaintCount;
    }

    public Integer getCompleteComplaintCount() {
        return completeComplaintCount;
    }

    public void setCompleteComplaintCount(Integer completeComplaintCount) {
        this.completeComplaintCount = completeComplaintCount;
    }

    public Integer getPendingComplaintCount() {
        return pendingComplaintCount;
    }

    public void setPendingComplaintCount(Integer pendingComplaintCount) {
        this.pendingComplaintCount = pendingComplaintCount;
    }

    public Integer getReviewComplaintCount() {
        return reviewComplaintCount;
    }

    public void setReviewComplaintCount(Integer reviewComplaintCount) {
        this.reviewComplaintCount = reviewComplaintCount;
    }

    public Integer getAmcDateCheck() {
        return amcDateCheck;
    }

    public void setAmcDateCheck(Integer amcDateCheck) {
        this.amcDateCheck = amcDateCheck;
    }    }