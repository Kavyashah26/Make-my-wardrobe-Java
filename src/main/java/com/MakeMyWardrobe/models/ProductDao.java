package com.MakeMyWardrobe.models;

import com.MakeMyWardrobe.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product save(Product product);
    Optional<Product> findById(long id);
    void deleteById(long id);
    List<Product> findAll();
}
