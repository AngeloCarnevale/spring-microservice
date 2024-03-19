package com.angelo.productms.domain.repositories;

import com.angelo.productms.domain.entities.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
