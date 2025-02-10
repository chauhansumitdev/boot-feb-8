package com.example.ordermanagement.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProductRequestDTO {

    @NotEmpty(message = "name cannot be empty")
    private String name;
    @NotEmpty(message = "price cannot be empty")
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
