
package com.pending_bills;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
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

}
