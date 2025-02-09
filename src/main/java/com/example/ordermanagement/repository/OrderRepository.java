package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Page<Order> findByStatusContainingIgnoreCase(String status, Pageable pageable);
    Page<Order> findAll(Pageable pageable);
    List<Order> findByCustomer(Customer customer);
}
