
package com.example.eliaacompany.model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ExampleLogin implements Serializable
{


    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataLogin data;
    private final static long serialVersionUID = -4524950285438068429L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLogin getData() {
        return data;
    }

    public void setData(DataLogin data) {
        this.data = data;
    }

}