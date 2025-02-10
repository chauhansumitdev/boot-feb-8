package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.CustomerRequestDTO;
import com.example.ordermanagement.dto.CustomerResponseDTO;
import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.exception.CustomerException;
import com.example.ordermanagement.mapper.CustomerMapper;
import com.example.ordermanagement.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;


    public CustomerResponseDTO createCustomer(CustomerRequestDTO customer){

        Customer request = customerMapper.toCustomer(customer);

        Customer response =  customerRepository.save(request);

        return customerMapper.toCustomerDTO(response);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomer(UUID id){
        Customer customer =  customerRepository.findById(id).orElse(null);

        if(customer == null){
            throw  new CustomerException("Customer not found");
        }

        return customer;
    }

    public Customer updateCustomer(UUID id, Customer customer){
        Customer existingCustomer = customerRepository.findById(id).orElse(null);

        if(existingCustomer == null){
            throw new CustomerException("Customer does not exit");
        }

        existingCustomer.setFirstName(customer.getFirstName());
        existingCustomer.setLastName(customer.getLastName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setAddress(customer.getAddress());
        customerRepository.save(existingCustomer);

        return existingCustomer;
    }


    public void deleteCustomer(UUID id){
        customerRepository.deleteById(id);
    }


    public List<Customer> filterByEmail(String email){
        return customerRepository.findByEmailContainingIgnoreCase(email);
    }

    public List<Customer> filterByFirstName(String name){
        return customerRepository.findByFirstNameContainingIgnoreCase(name);
    }

    public Page<Customer> getCustomers(String firstName, String email, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return customerRepository.findByFirstNameContainingIgnoreCaseAndEmailContainingIgnoreCase(firstName, email, pageable);
    }
}
