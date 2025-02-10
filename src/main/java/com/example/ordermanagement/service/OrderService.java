package com.example.ordermanagement.service;


import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.exception.OrderException;
import com.example.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerService customerService;



    public Order createOrder(UUID id){
        Customer get_customer = customerService.getCustomer(id);

        Order new_order = new Order();
        new_order.setStatus("INITIATED");
        new_order.setCustomer(get_customer);

        return orderRepository.save(new_order);
    }


    public Order readOrder(UUID id){
        Order order = orderRepository.findById(id).orElse(null);

        if(order == null){
            throw  new OrderException("Order does not exist");
        }

        return order;
    }

    public Order updateOrder(UUID id, Order order){
        Order existingOrder = orderRepository.findById(id).orElse(null);

        if(existingOrder == null){
            throw new OrderException("Order does not exist");
        }


        if(existingOrder != null){
            existingOrder.setOrderNumber(order.getOrderNumber());
            existingOrder.setStatus(order.getStatus());
            existingOrder.setCustomer(order.getCustomer());
            orderRepository.save(existingOrder);
        }

        return existingOrder;
    }

    public Order updateOrder(UUID id, String status){
        Order existingOrder = orderRepository.findById(id).orElse(null);

        if(existingOrder == null){
            throw new OrderException("Order does not exist");
        }

        if(existingOrder.getStatus().equals("DELIVERED")){
            throw new OrderException("Order already delivered");
        }

        if(existingOrder != null){
            existingOrder.setStatus(status);
            orderRepository.save(existingOrder);
        }

        return existingOrder;
    }

    public void deleteOrder(UUID id){
        orderRepository.deleteById(id);
    }

    public Page<Order> getOrdersByStatus(String status, int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return orderRepository.findByStatusContainingIgnoreCase(status, pageable);
    }

    public Page<Order> getOrders(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return orderRepository.findAll(pageable);
    }

    public List<Order> getOrdersByCustomer(UUID customerId) {
        Customer customer = customerService.getCustomer(customerId) ;
        return orderRepository.findByCustomer(customer);
    }
}
