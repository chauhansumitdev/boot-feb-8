package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Address;
import com.example.ordermanagement.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/v1/create")
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.createAddress(address), HttpStatus.CREATED);
    }

    @GetMapping("/v1/read/{id}")
    public ResponseEntity<Address> readAddress(@PathVariable UUID id) {
        return new ResponseEntity<>(addressService.readAddress(id), HttpStatus.OK);
    }

    @PutMapping("/v1/update/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable UUID id, @RequestBody Address address) {
        return new ResponseEntity<>(addressService.updateAddress(id, address), HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
