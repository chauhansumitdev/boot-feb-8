package com.example.ordermanagement.mapper;

import com.example.ordermanagement.dto.OrderResponseDTO;
import com.example.ordermanagement.entity.Customer;
import com.example.ordermanagement.entity.Order;
import com.example.ordermanagement.entity.OrderProduct;
import com.example.ordermanagement.entity.Product;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public OrderResponseDTO toOrderresponseDTO(Order order, Customer customer, List<OrderProduct> orderProducts){

        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setCustomer(customer);
        orderResponseDTO.setOrder(order);

        List<Product> product = new ArrayList<>();

        for(OrderProduct orderProduct :orderProducts){
            product.add(orderProduct.getProduct());
        }

        orderResponseDTO.setProducts(product);

        return orderResponseDTO;
    }

}
