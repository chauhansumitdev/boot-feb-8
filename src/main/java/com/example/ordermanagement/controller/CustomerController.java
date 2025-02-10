package com.example.ordermanagement.controller;


import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/v1/create")
    public ResponseEntity<Customer> createCustomers(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/v1/filter/{firstName}")
    public ResponseEntity<List<Customer>> filterByFirstName(@PathVariable  String firstName){
        return new ResponseEntity<>(customerService.filterByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/v1/filter/{email}")
    public ResponseEntity<List<Customer>> filterByEmail(@PathVariable String email){
        return new ResponseEntity<>(customerService.filterByEmail(email), HttpStatus.OK);
    }


    @GetMapping("/v1/read/{id}")
    public ResponseEntity<Customer> readCustomer(@PathVariable  UUID id){
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }


    @PutMapping("/v1/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.CREATED);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/v1/list")
    public Page<Customer> getCustomers(
            @RequestParam(defaultValue = "") String firstName,
            @RequestParam(defaultValue = "") String email,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "firstName") String sortBy) {

        return customerService.getCustomers(firstName, email, page, size, sortBy);
    }

    @GetMapping("/v1/fetch-all")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomers();
    }
}
