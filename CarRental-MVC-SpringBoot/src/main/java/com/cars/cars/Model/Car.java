package com.cars.cars.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;
    private String carName;
    private String carModel;
    private String carImage;
    private int carPrice;
    private boolean carStatus = true; // available or not

    public Car(){

    }

    public Car(int carId, String carName, String carModel, String carImage, int carPrice, boolean carStatus) {
        this.carId = carId;
        this.carName = carName;
        this.carModel = carModel;
        this.carImage = carImage;
        this.carPrice = carPrice;
        this.carStatus = carStatus;
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

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public boolean isCarStatus() {
        return carStatus;
    }

    public void setCarStatus(boolean carStatus) {
        this.carStatus = carStatus;
    }
}
