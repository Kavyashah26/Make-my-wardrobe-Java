package com.MakeMyWardrobe.models;

import com.MakeMyWardrobe.models.ProductDao;
import com.MakeMyWardrobe.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ProductDAOJpaImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if (product.getProductId() == 0) {  // Assuming ID is 0 for new entries
            entityManager.persist(product);
            return product;
        } else {
            return entityManager.merge(product);
        }
    }

    @Override
    public Optional<Product> findById(long id) {
        Product product = entityManager.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public void deleteById(long id) {
        Product product = findById(id).orElse(null);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}
