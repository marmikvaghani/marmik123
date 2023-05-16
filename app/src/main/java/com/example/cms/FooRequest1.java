package com.example.cms;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FooRequest1 {
    @SerializedName("notification_token")
    @Expose
    private String notificationToken;

    public FooRequest1(String id, String notification) {

        this.notificationToken = notification;
        // name = null;

    }

}
