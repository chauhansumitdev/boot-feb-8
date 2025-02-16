package com.example.ordermanagement.service;


import com.example.ordermanagement.dto.ProductRequestDTO;
import com.example.ordermanagement.dto.ProductResponseDTO;
import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.exception.ProductException;
import com.example.ordermanagement.mapper.ProductMapper;
import com.example.ordermanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;


    public ProductResponseDTO createProduct(ProductRequestDTO product){
        Product currentProduct = productMapper.toProduct(product);
        return productMapper.toProductDTO(productRepository.save(currentProduct));
    }

    public Product readProduct(UUID id){
        Product product = productRepository.findById(id).orElse(null);

        if(product == null){
            throw new ProductException("Product does not exist");
        }

        return product;
    }

    public Product updateProduct(UUID id, Product product){
        Product existingProduct = productRepository.findById(id).orElse(null);


        if(existingProduct == null){
            throw new ProductException("Product does not exist");
        }

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


    public List<Product> getProductsByPriceRange(Double minPrice, Double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public Page<Product> getProductsByPriceRangePaginated(Double minPrice, Double maxPrice, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
    }

    public Page<Product> getProductsSortedByPrice(int page, int size, String sortDirection) {
        Sort sort = Sort.by(sortDirection.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, "price");
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable);
    }
}
