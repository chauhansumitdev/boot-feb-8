package com.example.ordermanagement.service;


import com.example.ordermanagement.entity.Address;
import com.example.ordermanagement.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address readAddress(UUID id){
        return addressRepository.findById(id).orElse(null);
    }

    public Address updateAddress(UUID id, Address address){
        Address existingAddress = addressRepository.findById(id).orElse(null);

        if(existingAddress != null){

            existingAddress.setStreet(address.getStreet());
            existingAddress.setCity(address.getCity());
            addressRepository.save(existingAddress);

        }

        return existingAddress;
    }

    public void deleteAddress(UUID id){
        addressRepository.deleteById(id);
    }
}
