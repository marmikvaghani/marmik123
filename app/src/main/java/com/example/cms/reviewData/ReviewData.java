
package com.example.cms.reviewData;

import com.example.cms.reviewData.Datum;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class ReviewData {

        @SerializedName("statusCode")
        @Expose
        private Integer statusCode;
        @SerializedName("data")
        @Expose
        private List<com.example.cms.reviewData.Datum> data;
        @SerializedName("message")
        @Expose
        private String message;

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public List<com.example.cms.reviewData.Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
