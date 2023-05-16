
package com.amc_exa;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class AmcClass {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("AmcDateCheck")
    @Expose
    private List<AmcDateCheck> amcDateCheck;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<AmcDateCheck> getAmcDateCheck() {
        return amcDateCheck;
    }

    public void setAmcDateCheck(List<AmcDateCheck> amcDateCheck) {
        this.amcDateCheck = amcDateCheck;
    }

}
