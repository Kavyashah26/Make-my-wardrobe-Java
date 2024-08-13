package com.MakeMyWardrobe.models;

import com.MakeMyWardrobe.models.*;
import com.MakeMyWardrobe.models.OutfitPage;
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
public class OutfitPageDAOJpaImpl implements OutfitPageDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OutfitPage save(OutfitPage outfitPage) {
        if (outfitPage.getId() == 0) {  // Assuming ID is 0 for new entries
            entityManager.persist(outfitPage);
            return outfitPage;
        } else {
            return entityManager.merge(outfitPage);
        }
    }

    @Override
    public Optional<OutfitPage> findById(int id) {
        OutfitPage outfitPage = entityManager.find(OutfitPage.class, id);
        return Optional.ofNullable(outfitPage);
    }

    @Override
    public void deleteById(int id) {
        OutfitPage outfitPage = findById(id).orElse(null);
        if (outfitPage != null) {
            entityManager.remove(outfitPage);
        }
    }

    @Override
    public List<OutfitPage> findAll() {
        TypedQuery<OutfitPage> query = entityManager.createQuery("SELECT o FROM OutfitPage o", OutfitPage.class);
        return query.getResultList();
    }
}
