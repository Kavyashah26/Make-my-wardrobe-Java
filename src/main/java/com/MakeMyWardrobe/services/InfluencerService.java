package com.MakeMyWardrobe.services;

import com.MakeMyWardrobe.models.Influencer;

import java.util.List;
import java.util.Optional;

public interface InfluencerService {
    Influencer save(Influencer influencer);
    Optional<Influencer> findById(int id);
    void deleteById(int id);
    List<Influencer> findAll();
}
