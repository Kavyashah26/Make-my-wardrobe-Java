package com.MakeMyWardrobe.services;

import com.MakeMyWardrobe.models.*;
import com.MakeMyWardrobe.models.Influencer;
import com.MakeMyWardrobe.services.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfluencerServiceImpl implements InfluencerService {

    @Autowired
    private InfluencerDao influencerDao;

    @Override
    public Influencer save(Influencer influencer) {
        return influencerDao.save(influencer);
    }

    @Override
    public Optional<Influencer> findById(int id) {
        return influencerDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        influencerDao.deleteById(id);
    }

    @Override
    public List<Influencer> findAll() {
        return influencerDao.findAll();
    }
}
