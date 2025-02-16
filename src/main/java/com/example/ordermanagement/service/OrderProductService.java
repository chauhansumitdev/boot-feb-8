package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.OrderResponseDTO;
import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.OrderProduct;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.mapper.OrderMapper;
import com.example.ordermanagement.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderMapper orderMapper;

    public OrderProduct createOrderProduct(UUID orderID, UUID productID){

        Order get_order = orderService.readOrder(orderID);
        Product get_product = productService.readProduct(productID);

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setProduct(get_product);
        orderProduct.setOrder(get_order);

        return orderProductRepository.save(orderProduct);
    }

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

    public List<OrderProduct> getAllOrderProduct(){
        return orderProductRepository.findAll();
    }


    public OrderResponseDTO getAllProductsInParticularOrder(UUID id) {
        Order retrieveOrder = orderService.readOrder(id);

        List<OrderProduct> orderProducts = orderProductRepository.findByOrder(retrieveOrder);

        return orderMapper.toOrderresponseDTO(retrieveOrder,orderProducts);
    }
}
