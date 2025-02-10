package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/v1/create/{id}")
    public ResponseEntity<Order> createOrder(@PathVariable UUID id){
        return new ResponseEntity<>(orderService.createOrder(id), HttpStatus.CREATED);
    }


    @GetMapping("/v1/read/{id}")
    public ResponseEntity<Order> readOrder(@PathVariable UUID id){
        return new ResponseEntity<>(orderService.readOrder(id), HttpStatus.OK);
    }


    @PostMapping("/v1/update/{id}/{status}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @PathVariable String status){
        return new ResponseEntity<>(orderService.updateOrder(id, status), HttpStatus.OK);
    }

    @PutMapping("/v1/update/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order order){
        return new ResponseEntity<>(orderService.updateOrder(id, order), HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id){
        orderService.deleteOrder(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/v1/listOrderByStatus")
    public Page<Order> getOrdersByStatus(
            @RequestParam(defaultValue = "") String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "orderNumber") String sortBy) {

        return orderService.getOrdersByStatus(status, page, size, sortBy);
    }


    @GetMapping("/v1/listOrderByOrderNumber")
    public Page<Order> getOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "orderNumber") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return orderService.getOrders(page, size, sortBy, direction);
    }

    @GetMapping("/v1/find/{id}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable UUID id){
        return new ResponseEntity<>(orderService.getOrdersByCustomer(id), HttpStatus.OK);
    }
}
