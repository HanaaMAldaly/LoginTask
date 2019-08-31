package com.hanaa.logintask.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataCloud {
    @SerializedName("user")
    @Expose
    private UserCloud user;

    public UserCloud getUser() {
        return user;
    }

    public void setUser(UserCloud user) {
        this.user = user;
    }
}
