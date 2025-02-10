package com.example.ordermanagement.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductResponseDTO {

    private UUID id;
    @NotEmpty(message = "name cannot be empty")
    private String name;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NotEmpty(message = "price cannot be empty")
    private Integer price;

}
