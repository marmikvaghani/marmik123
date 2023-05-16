
package com.example.cms.pending_bills;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


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


    public class PartsDetail {

        @SerializedName("partsName")
        @Expose
        private String partsName;
        @SerializedName("partsQuantity")
        @Expose
        private Integer partsQuantity;
        @SerializedName("isWarranty")
        @Expose
        private String isWarranty;
        @SerializedName("partsPrice")
        @Expose
        private Integer partsPrice;
        @SerializedName("partsQty")
        @Expose
        private Integer partsQty;
        @SerializedName("currentDate")
        @Expose
        private String currentDate;

        public String getPartsName() {
            return partsName;
        }

        public void setPartsName(String partsName) {
            this.partsName = partsName;
        }

        public Integer getPartsQuantity() {
            return partsQuantity;
        }

        public void setPartsQuantity(Integer partsQuantity) {
            this.partsQuantity = partsQuantity;
        }

        public String getIsWarranty() {
            return isWarranty;
        }

        public void setIsWarranty(String isWarranty) {
            this.isWarranty = isWarranty;
        }

        public Integer getPartsPrice() {
            return partsPrice;
        }

        public void setPartsPrice(Integer partsPrice) {
            this.partsPrice = partsPrice;
        }

        public Integer getPartsQty() {
            return partsQty;
        }

        public void setPartsQty(Integer partsQty) {
            this.partsQty = partsQty;
        }

        public String getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(String currentDate) {
            this.currentDate = currentDate;
        }

        @Override
        public String toString() {
            return "PartsDetail{" +
                    "partsName='" + partsName + '\'' +
                    ", partsQuantity=" + partsQuantity +
                    ", isWarranty='" + isWarranty + '\'' +
                    ", partsPrice=" + partsPrice +
                    ", partsQty=" + partsQty +
                    ", currentDate='" + currentDate + '\'' +
                    '}';
        }
    }
    @Override
    public String toString() {
        return "Datum{" +
                "id='" + id + '\'' +
                ", billId='" + billId + '\'' +
                ", comId='" + comId + '\'' +
                ", partyName='" + partyName + '\'' +
                ", partyCity='" + partyCity + '\'' +
                ", machineNumber=" + machineNumber +
                ", machineType='" + machineType + '\'' +
                ", isMachineWarranty=" + isMachineWarranty +
                ", isAdmin=" + isAdmin +
                ", partsDetails=" + partsDetails +
                ", isPaymentsStatus=" + isPaymentsStatus +
                ", createAt='" + createAt + '\'' +
                ", upadateAt='" + upadateAt + '\'' +
                ", mainTotal=" + mainTotal +
                ", v=" + v +
                '}';
    }
}
