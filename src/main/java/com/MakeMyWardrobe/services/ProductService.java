package com.MakeMyWardrobe.services;

import com.MakeMyWardrobe.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> findById(long id);
    void deleteById(long id);
    List<Product> findAll();
}
