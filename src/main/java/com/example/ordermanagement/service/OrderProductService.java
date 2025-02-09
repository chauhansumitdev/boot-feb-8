package com.example.ordermanagement.service;


import com.example.ordermanagement.entity.OrderProduct;
import com.example.ordermanagement.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    public OrderProduct createOrderProduct(OrderProduct orderProduct){
        return orderProductRepository.save(orderProduct);
    }

    public OrderProduct readOrderProduct(UUID id){
        return orderProductRepository.findById(id).orElse(null);
    }

    public OrderProduct updateOrderProduct(UUID id, OrderProduct orderProduct){
        OrderProduct existingOrderProduct = orderProductRepository.findById(id).orElse(null);

        if(existingOrderProduct != null){
            existingOrderProduct.setOrder(orderProduct.getOrder());
            existingOrderProduct.setProduct(orderProduct.getProduct());
            orderProductRepository.save(existingOrderProduct);
        }

        return existingOrderProduct;
    }

    public void deleteOrderProduct(UUID id){
        orderProductRepository.deleteById(id);
    }

}
