package com.example.ordermanagement.service;


import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public Order createOrder(Order order){
        return orderRepository.save(order);
    }

    public Order readOrder(UUID id){
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(UUID id, Order order){
        Order existingOrder = orderRepository.findById(id).orElse(null);

        if(existingOrder != null){
            existingOrder.setOrderNumber(order.getOrderNumber());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setCustomer(order.getCustomer());
            orderRepository.save(existingOrder);
        }

        return existingOrder;
    }

    public void deleteOrder(UUID id){
        orderRepository.deleteById(id);
    }
}
