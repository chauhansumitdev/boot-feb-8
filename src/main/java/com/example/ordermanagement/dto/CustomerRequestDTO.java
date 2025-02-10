package com.example.ordermanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class CustomerRequestDTO {

    @NotEmpty(message = "first name cannot be empty")
    private String firstName;
    @NotEmpty(message = "last name cannot be empty")
    private String lastName;
    @NotEmpty(message = "email cannot be empty")
    private String email;
    @NotEmpty(message = "street cannot be empty")
    private String street;
    @NotEmpty(message = "city cannot be empty")
    private String city;

    public CustomerRequestDTO(){}

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
