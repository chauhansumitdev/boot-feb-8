package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.OrderProduct;
import com.example.ordermanagement.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;

    @PostMapping("/v1/create")
    public ResponseEntity<OrderProduct> createOrderProduct(@RequestBody OrderProduct orderProduct) {
        return new ResponseEntity<>(orderProductService.createOrderProduct(orderProduct), HttpStatus.CREATED);
    }

    @GetMapping("/v1/read/{id}")
    public ResponseEntity<OrderProduct> readOrderProduct(@PathVariable UUID id) {
        return new ResponseEntity<>(orderProductService.readOrderProduct(id), HttpStatus.OK);
    }

    @PutMapping("/v1/update/{id}")
    public ResponseEntity<OrderProduct> updateOrderProduct(@PathVariable UUID id, @RequestBody OrderProduct orderProduct) {
        return new ResponseEntity<>(orderProductService.updateOrderProduct(id, orderProduct), HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<Void> deleteOrderProduct(@PathVariable UUID id) {
        orderProductService.deleteOrderProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
