package com.example.ordermanagement.service;


import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product readProduct(UUID id){
        return productRepository.findById(id).orElse(null);
    }

    public Product updateProduct(UUID id, Product product){
        Product existingProduct = productRepository.findById(id).orElse(null);

        if(existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setPrice((product.getPrice()));
            productRepository.save(existingProduct);
        }

        return existingProduct;
    }

    public void delete(UUID id){
        productRepository.deleteById(id);
    }

}
