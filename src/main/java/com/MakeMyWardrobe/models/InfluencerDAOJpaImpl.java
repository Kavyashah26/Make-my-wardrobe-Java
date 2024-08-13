package com.MakeMyWardrobe.models;

import com.MakeMyWardrobe.models.InfluencerDao;
import com.MakeMyWardrobe.models.Influencer;
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
public class InfluencerDAOJpaImpl implements InfluencerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Influencer save(Influencer influencer) {
        if (influencer.getInfluencerId() == 0) {  // Updated method name
            entityManager.persist(influencer);
            return influencer;
        } else {
            return entityManager.merge(influencer);
        }
    }

    @Override
    public Optional<Influencer> findById(int id) {
        Influencer influencer = entityManager.find(Influencer.class, id);
        return Optional.ofNullable(influencer);
    }

    @Override
    public Optional<Influencer> findByEmail(String email) {
        TypedQuery<Influencer> query = entityManager.createQuery("SELECT i FROM Influencer i WHERE i.email = :email", Influencer.class);
        query.setParameter("email", email);
        Influencer influencer = query.getResultStream().findFirst().orElse(null);
        return Optional.ofNullable(influencer);
    }

    @Override
    public void deleteById(int id) {
        Influencer influencer = findById(id).orElse(null);
        if (influencer != null) {
            entityManager.remove(influencer);
        }
    }

    @Override
    public List<Influencer> findAll() {
        TypedQuery<Influencer> query = entityManager.createQuery("SELECT i FROM Influencer i", Influencer.class);
        return query.getResultList();
    }
}
