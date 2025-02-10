package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID> {
    List<OrderProduct> findByOrder(Order order);
}
