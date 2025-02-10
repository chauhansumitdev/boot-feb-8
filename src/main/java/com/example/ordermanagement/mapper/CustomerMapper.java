package com.example.ordermanagement.mapper;

import com.example.ordermanagement.dto.CustomerRequestDTO;
import com.example.ordermanagement.dto.CustomerResponseDTO;
import com.example.ordermanagement.entity.Address;
import com.example.ordermanagement.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDTO customer){
        Address address = new Address();
        address.setCity(customer.getCity());
        address.setStreet(customer.getStreet());

        Customer newCustomer = new Customer();
        newCustomer.setAddress(address);
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());

        return newCustomer;
    }

    public CustomerResponseDTO toCustomerDTO(Customer customer){
        CustomerResponseDTO customerDTO = new CustomerResponseDTO();
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setStreet(customer.getAddress().getStreet());
        customerDTO.setCity(customer.getAddress().getCity());
        customerDTO.setCustomerID(customer.getId());
        customerDTO.setAddressID(customer.getAddress().getId());

        return customerDTO;
    }
}
