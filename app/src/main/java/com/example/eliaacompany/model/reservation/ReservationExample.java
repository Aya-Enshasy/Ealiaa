
package com.example.eliaacompany.model.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReservationExample implements Serializable
{

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ReservationData data;
    private final static long serialVersionUID = -4383257488159063161L;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReservationData getData() {
        return data;
    }

    public void setData(ReservationData data) {
        this.data = data;
    }

}
