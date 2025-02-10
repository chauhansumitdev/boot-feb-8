package com.example.ordermanagement.mapper;

import com.example.ordermanagement.dto.ProductRequestDTO;
import com.example.ordermanagement.dto.ProductResponseDTO;
import com.example.ordermanagement.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequestDTO productRequestDTO){

        Product product = new Product();
        product.setPrice(productRequestDTO.getPrice());
        product.setName(productRequestDTO.getName());

        return product;
    }

    public ProductResponseDTO toProductDTO(Product product){

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());

        return productResponseDTO;
    }
}
