
package com.example.cms.machien_problem;

import java.util.List;

import com.example.cms.machien_problem.MachineProblem;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("machineProblems")
    @Expose
    private List<MachineProblem> machineProblems;
    @SerializedName("machineType")
    @Expose
    private List<String> machineType;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MachineProblem> getMachineProblems() {
        return machineProblems;
    }

    public void setMachineProblems(List<MachineProblem> machineProblems) {
        this.machineProblems = machineProblems;
    }

    public List<String> getMachineType() {
        return machineType;
    }

    public void setMachineType(List<String> machineType) {
        this.machineType = machineType;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", machineProblems=" + machineProblems +
                ", machineType=" + machineType +
                ", v=" + v +
                '}';
    }
}
