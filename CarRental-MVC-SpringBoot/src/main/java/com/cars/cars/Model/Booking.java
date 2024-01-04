package com.cars.cars.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int carId;
    private int customerId;
    private String bookingDateFrom;
    private String bookingDateTo;
    private int priceDay;
    private String image;
    private double totalPrice;

    public Booking(){

    }

    public Booking(int bookingId, int carId, int customerId, String bookingDateFrom, String bookingDateTo, int priceDay, String image, double totalPrice) {
        this.bookingId = bookingId;
        this.carId = carId;
        this.customerId = customerId;
        this.bookingDateFrom = bookingDateFrom;
        this.bookingDateTo = bookingDateTo;
        this.priceDay = priceDay;
        this.image = image;
        this.totalPrice = totalPrice;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBookingDateFrom() {
        return bookingDateFrom;
    }

    public void setBookingDateFrom(String bookingDateFrom) {
        this.bookingDateFrom = bookingDateFrom;
    }

    public String getBookingDateTo() {
        return bookingDateTo;
    }

    public void setBookingDateTo(String bookingDataTo) {
        this.bookingDateTo = bookingDataTo;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
