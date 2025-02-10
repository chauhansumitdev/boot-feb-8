package com.example.ordermanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id")
    private UUID id;

    @JsonProperty("orderNumber")
    private Long orderNumber;

    @JsonProperty("status")
    @NotBlank(message = "Please enter the status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonProperty("customer")
    private Customer customer;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
