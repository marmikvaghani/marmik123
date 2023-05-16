package com.example.cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FooRequest {
    @Expose
    @SerializedName("name")
    final String name;

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("rating")
    @Expose
    private String rating;


    public FooRequest(String name) {
        this.name = name;
    }

    public FooRequest(String id, String rating) {

//        this.id = id;
        this.rating = rating;
        name = null;

    }

}
