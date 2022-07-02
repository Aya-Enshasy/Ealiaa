
package com.example.eliaacompany.model.login;

import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataLogin implements Serializable
{
    @SerializedName("user")
    @Expose
    private UserLogin user;
    @SerializedName("token")
    @Expose
    private String token;
    private final static long serialVersionUID = -6261842968564313191L;

    public UserLogin getUser() {
        return user;
    }

    public void setUser(UserLogin user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}