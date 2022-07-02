
package com.example.eliaacompany.model.reservation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ReservationData implements Serializable
{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("reservation_reason")
    @Expose
    private String reservation_reason;
    @SerializedName("customer_number")
    @Expose
    private String customer_number;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("bus_count")
    @Expose
    private String bus_count;
    @SerializedName("reservation_type")
    @Expose
    private String reservation_type;
    @SerializedName("reservation_arrival_time")
    @Expose
    private String reservation_arrival_time;
    @SerializedName("reservation_return_time")
    @Expose
    private String reservation_return_time;
    @SerializedName("booking_side")
    @Expose
    private String booking_side;
    @SerializedName("remaining")
    @Expose
    private String remaining;
    @SerializedName("driver_name")
    @Expose
    private String driver_name;
    @SerializedName("reservation_date")
    @Expose
    private String reservation_date;
    @SerializedName("collecting_side")
    @Expose
    private String collecting_side;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("customer_name")
    @Expose
    private String customer_name;

    private final static long serialVersionUID = 5896961503232451022L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReservation_reason() {
        return reservation_reason;
    }

    public void setReservation_reason(String reservation_reason) {
        this.reservation_reason = reservation_reason;
    }

    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBus_count() {
        return bus_count;
    }

    public void setBus_count(String bus_count) {
        this.bus_count = bus_count;
    }

    public String getReservation_type() {
        return reservation_type;
    }

    public void setReservation_type(String reservation_type) {
        this.reservation_type = reservation_type;
    }

    public String getReservation_arrival_time() {
        return reservation_arrival_time;
    }

    public void setReservation_arrival_time(String reservation_arrival_time) {
        this.reservation_arrival_time = reservation_arrival_time;
    }

    public String getReservation_return_time() {
        return reservation_return_time;
    }

    public void setReservation_return_time(String reservation_return_time) {
        this.reservation_return_time = reservation_return_time;
    }

    public String getBooking_side() {
        return booking_side;
    }

    public void setBooking_side(String booking_side) {
        this.booking_side = booking_side;
    }

    public String getRemaining() {
        return remaining;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }

    public String getCollecting_side() {
        return collecting_side;
    }

    public void setCollecting_side(String collecting_side) {
        this.collecting_side = collecting_side;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }
}