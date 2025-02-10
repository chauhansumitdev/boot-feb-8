package com.example.ordermanagement.dto;

import com.example.ordermanagement.entity.Product;

import java.util.List;
import java.util.UUID;

public class OrderResponseDTO {

    private UUID orderid;
    private Long orderNumber;
    private String status;

    private List<Product> products;

    public UUID getId() {
        return orderid;
    }

    public void setId(UUID id) {
        this.orderid = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
