
package com.example.cms.machien_problem;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MachineProblem {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("machineProblem")
    @Expose
    private String machineProblem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineProblem() {
        return machineProblem;
    }

    public void setMachineProblem(String machineProblem) {
        this.machineProblem = machineProblem;
    }

    @Override
    public String toString() {
        return "MachineProblem{" +
                "id=" + id +
                ", machineProblem='" + machineProblem + '\'' +
                '}';
    }
}
