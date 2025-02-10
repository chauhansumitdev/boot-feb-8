package com.example.ordermanagement.dto;

import java.util.UUID;

public class CustomerResponseDTO {

    private UUID customerID;
    private UUID addressID;
    private String firstName;
    private String lastName;
    private String email;
    private String street;
    private String city;

    public CustomerResponseDTO(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

    public UUID getAddressID() {
        return addressID;
    }

    public void setAddressID(UUID addressID) {
        this.addressID = addressID;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
