package com.example.ordermanagement.dto;

import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.Product;

import java.util.List;
import java.util.UUID;

public class OrderResponseDTO {

    private Order order;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
