package com.angelo.productms.services;

import com.angelo.productms.domain.dtos.ProductDTO;
import com.angelo.productms.domain.entities.product.Product;
import com.angelo.productms.domain.repositories.ProductRepository;
import com.angelo.productms.infra.exceptions.ValidatePriceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product createProduct(ProductDTO data) throws Exception {

        if(data.price().compareTo(BigDecimal.valueOf(0)) <= 0 ) {
            throw new ValidatePriceException("The price value must be positive");
        }
        Product newProduct = new Product(data);
        this.saveProduct(newProduct);
        return newProduct;
    }
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    public void saveProduct(Product product){
        this.repository.save(product);
    }
}
