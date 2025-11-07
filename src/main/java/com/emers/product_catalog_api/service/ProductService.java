package com.emers.product_catalog_api.service;

import com.emers.product_catalog_api.model.Product;
import com.emers.product_catalog_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service // Indica que essa classe é um componente de serviço do Spring
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<Product> findAll(){
        return repository.findAll();
    }

    // Busca um produto pelo ID, lançando exceção se não existir
    public Product findById(Long id){
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new RuntimeException ("Produto não encontrado com ID: " + id));
    }

    @Transactional
    public Product save(Product product){
        return repository.save(product);
    }

    // Atualiza um produto existente
    public Product update(Long id, Product updatedProduct){
        Product existingProduct =  findById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        return repository.save(existingProduct);
    }

    public void deleteById(Long id){
        Product existingProduct =  findById(id);
        repository.delete(existingProduct);
    }
}
