package com.cars.cars.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerAddress;
    private String customerEmail;
    private String customerPhone;
    private String customerUserName;
    private String customerPassword;

    public Customer(){

    }
    public Customer(int customerId, String customerFirstName, String customerLastName, String customerAddress, String customerEmail, String customerPhone, String customerUserName, String customerPassword) {
        this.customerId = customerId;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerUserName = customerUserName;
        this.customerPassword = customerPassword;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }
    public void setCustomerUserName(String customerUserName) {

    }

    public String getCustomerPassword() {
        return customerPassword;
    }
    public void setCustomerPassword(String customerPassword) {

    }
}

