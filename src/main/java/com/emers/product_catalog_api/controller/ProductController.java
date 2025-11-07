package com.emers.product_catalog_api.controller;

import com.emers.product_catalog_api.model.Product;
import com.emers.product_catalog_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.emers.product_catalog_api.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> getAllProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteById(id);
    }

}
