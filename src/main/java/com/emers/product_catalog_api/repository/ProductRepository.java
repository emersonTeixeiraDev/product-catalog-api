package com.emers.product_catalog_api.repository;

import com.emers.product_catalog_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
