package com.res.DTO;

import java.sql.Timestamp;

public class Orders {

    private int order_id;
    private Timestamp order_date;
    private int restaurant_id;
    private int user_id;
    private int total_amount;
    private String paymethod_method;
    private String status;
    private String address;

    public Orders() {}

    public Orders(Timestamp order_date, int restaurant_id, int user_id, int total_amount, String paymethod_method,
                  String status, String address) {

        this.order_date = order_date;
        this.restaurant_id = restaurant_id;
        this.user_id = user_id;
        this.total_amount = total_amount;
        this.paymethod_method = paymethod_method;
        this.status = status;
        this.address = address;
    }

    public Orders(int order_id, Timestamp order_date, int restaurant_id, int user_id, int total_amount,
                  String paymethod_method, String status, String address) {

        this.order_id = order_id;
        this.order_date = order_date;
        this.restaurant_id = restaurant_id;
        this.user_id = user_id;
        this.total_amount = total_amount;
        this.paymethod_method = paymethod_method;
        this.status = status;
        this.address = address;
    }

    // Getters & Setters

    public int getOrder_id() { return order_id; }
    public void setOrder_id(int order_id) { this.order_id = order_id; }

    public Timestamp getOrder_date() { return order_date; }
    public void setOrder_date(Timestamp order_date) { this.order_date = order_date; }

    public int getRestaurant_id() { return restaurant_id; }
    public void setRestaurant_id(int restaurant_id) { this.restaurant_id = restaurant_id; }

    public int getUser_id() { return user_id; }
    public void setUser_id(int user_id) { this.user_id = user_id; }

    public int getTotal_amount() { return total_amount; }
    public void setTotal_amount(int total_amount) { this.total_amount = total_amount; }

    public String getPaymethod_method() { return paymethod_method; }
    public void setPaymethod_method(String paymethod_method) { this.paymethod_method = paymethod_method; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Orders {" +
                "order_id=" + order_id +
                ", order_date=" + order_date +
                ", restaurant_id=" + restaurant_id +
                ", user_id=" + user_id +
                ", total_amount=" + total_amount +
                ", paymethod_method='" + paymethod_method + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
