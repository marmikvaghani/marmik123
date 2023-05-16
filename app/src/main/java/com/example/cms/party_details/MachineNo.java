package com.example.cms.party_details;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MachineNo {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("partyMachineDetails")
    @Expose
    private List<PartyMachineDetails> partyMachineDetails;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<PartyMachineDetails> getPartyMachineDetails() {
        return partyMachineDetails;
    }

    public void setPartyMachineDetails(List<PartyMachineDetails> partyMachineDetails) {
        this.partyMachineDetails = partyMachineDetails;
    }

    public class MachineNumberDetail {

        @SerializedName("machineNumber")
        @Expose
        private String machineNumber;


        public String getMachineNumber() {
            return machineNumber;
        }

        public void setMachineNumber(String machineNumber) {
            this.machineNumber = machineNumber;
        }

        @Override
        public String toString() {
            return "MachineNumberDetail{" +
                    "machineNumber='" + machineNumber + '\'' +
                    '}';
        }
    }

    public class PartyMachineDetails {

        @SerializedName("machineNumberDetails")
        @Expose
        private List<MachineNumberDetail> machineNumberDetails;
        @SerializedName("partyName")
        @Expose
        private String partyName;
        @SerializedName("machineType")
        @Expose
        private String machineType;

        public List<MachineNumberDetail> getMachineNumberDetails() {
            return machineNumberDetails;
        }

        public void setMachineNumberDetails(List<MachineNumberDetail> machineNumberDetails) {
            this.machineNumberDetails = machineNumberDetails;
        }

        public String getPartyName() {
            return partyName;
        }

        public void setPartyName(String partyName) {
            this.partyName = partyName;
        }

        public String getMachineType() {
            return machineType;
        }

        public void setMachineType(String machineType) {
            this.machineType = machineType;
        }


        @Override
        public String toString() {
            return "PartyMachineDetails{" +
                    "machineNumberDetails=" + machineNumberDetails +
                    ", partyName='" + partyName + '\'' +
                    ", machineType='" + machineType + '\'' +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "MachineNo{" +
                "statusCode=" + statusCode +
                ", partyMachineDetails=" + partyMachineDetails +
                '}';
    }
}