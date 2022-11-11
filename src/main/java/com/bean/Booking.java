package com.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private Date bookingDate;
    private Date userDate;
    private int token;
    private String status;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Store store;

    public Booking(Date bookingDate, Date userDate, int token) {
        this.bookingDate = bookingDate;
        this.userDate = userDate;
        this.token = token;
        this.status = "booked";
    }



    public Booking(Date bookingDate, Date userDate, int token,Customer customer, Store store) {
        this.bookingDate = bookingDate;
        this.userDate = userDate;
        this.token = token;
        this.customer = customer;
        this.store = store;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
