package com.example.ordermanagement.controller;


import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/v1/create")
    public Customer createCustomers(Customer customer){
        return customerService.createCustomer(customer);
    }

    @GetMapping("/v1")
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }
}
