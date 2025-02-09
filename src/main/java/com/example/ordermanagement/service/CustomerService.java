package com.example.ordermanagement.service;


import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(UUID id){
        return customerRepository.findById(id).orElse(null);
    }

    public Customer updateCustomer(UUID id, Customer customer){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if(existingCustomer != null){
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setAddress(customer.getAddress());
            customerRepository.save(existingCustomer);
        }

        return existingCustomer;
    }


    public void deleteCustomer(UUID id){
        customerRepository.deleteById(id);
    }
}
