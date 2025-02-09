package com.example.ordermanagement.repository;

import com.example.ordermanagement.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    List<Customer> findByEmailContainingIgnoreCase(String email);
    Page<Customer> findByFirstNameContainingIgnoreCaseAndEmailContainingIgnoreCase(
            String firstName, String email, Pageable pageable);
}
