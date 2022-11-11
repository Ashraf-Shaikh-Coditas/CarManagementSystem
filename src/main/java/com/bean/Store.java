package com.bean;

import javax.persistence.*;
import java.util.List;

@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String carName;
    private String model;
    private int carPrice;
    private int quantity;
    private int reqDays;

    @OneToMany(mappedBy = "store")
    private List<Booking> bookings;

    public Store(int carId, String carName, String model, int carPrice, int reqDays, int quantity) {
        this.carId = carId;
        this.carName = carName;
        this.model = model;
        this.carPrice = carPrice;
        this.quantity = quantity;
        this.reqDays = reqDays;
    }

    public Store() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReqDays() {
        return reqDays;
    }

    public void setReqDays(int reqDays) {
        this.reqDays = reqDays;
    }

    @Override
    public String toString() {
        return "Store{" +
                "carId=" + carId +
                ", carName='" + carName + '\'' +
                ", model='" + model + '\'' +
                ", carPrice=" + carPrice +
                ", quantity=" + quantity +
                ", reqDays=" + reqDays +
                ", bookings=" + bookings +
                '}';
    }
}
