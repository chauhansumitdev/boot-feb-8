package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.Product;
import com.example.ordermanagement.exception.AddressException;
import com.example.ordermanagement.exception.ErrorResponse;
import com.example.ordermanagement.exception.ProductException;
import com.example.ordermanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/v1/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/v1/read/{id}")
    public ResponseEntity<Product> readProduct(@PathVariable UUID id) {
        return new ResponseEntity<>(productService.readProduct(id), HttpStatus.OK);
    }

    @PutMapping("/v1/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.OK);
    }

    @DeleteMapping("/v1/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/v1/filter-by-price")
    public List<Product> getProductsByPriceRange(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/v1/filter-by-price-paginated")
    public Page<Product> getProductsByPriceRangePaginated(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return productService.getProductsByPriceRangePaginated(minPrice, maxPrice, page, size);
    }

    @GetMapping("/v1/sort-by-price")
    public Page<Product> getProductsSortedByPrice(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "asc") String sortDirection) {
        return productService.getProductsSortedByPrice(page, size, sortDirection);
    }


    @ExceptionHandler(value = ProductException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse productException(ProductException ex) {
        return new ErrorResponse(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
