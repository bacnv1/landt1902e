package com.t3h.chat.model;

import com.google.gson.annotations.SerializedName;

public class Chat {
    @SerializedName("id")
    private int id;
    @SerializedName("message")
    private String message;
    @SerializedName("pubDate")
    private String pubDate;
    @SerializedName("name")
    private String name;
    @SerializedName("userName")
    private String userName;

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }
}
