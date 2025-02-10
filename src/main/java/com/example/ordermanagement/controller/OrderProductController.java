package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.OrderProduct;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.service.OrderProductService;
import com.example.ordermanagement.service.OrderService;
import com.example.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {

    @Autowired
    private OrderProductService orderProductService;


    @PostMapping("/v1/create/{orderID}/add/{productID}")
    public ResponseEntity<OrderProduct> createOrderProduct(@PathVariable UUID orderID, @PathVariable UUID productID) {

        return new ResponseEntity<>(orderProductService.createOrderProduct(orderID, productID), HttpStatus.CREATED);
    }


    @GetMapping("/v1/read/{id}")
    public ResponseEntity<OrderProduct> readOrderProduct(@PathVariable UUID id) {
        return new ResponseEntity<>(orderProductService.readOrderProduct(id), HttpStatus.OK);
    }


    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<Void> deleteOrderProduct(@PathVariable UUID id) {
        orderProductService.deleteOrderProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/v1/find-all")
    public ResponseEntity<List<OrderProduct>> getAll() {
        return new ResponseEntity<>(orderProductService.getAllOrderProduct(), HttpStatus.OK);
    }

    @GetMapping("/v1/find/{id}")
    public ResponseEntity<List<OrderProduct>> getAllByOrderId(@PathVariable UUID id) {
        return new ResponseEntity<>(orderProductService.getAllProductsInParticularOrder(id), HttpStatus.OK);
    }
}
