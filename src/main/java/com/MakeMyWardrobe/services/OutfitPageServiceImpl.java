package com.MakeMyWardrobe.services;

import com.MakeMyWardrobe.models.OutfitPageDao;
import com.MakeMyWardrobe.models.OutfitPage;
import com.MakeMyWardrobe.services.OutfitPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OutfitPageServiceImpl implements OutfitPageService {

    @Autowired
    private OutfitPageDao outfitPageDao;

    @Override
    public OutfitPage save(OutfitPage outfitPage) {
        return outfitPageDao.save(outfitPage);
    }

    @Override
    public Optional<OutfitPage> findById(int id) {
        return outfitPageDao.findById(id);
    }

    @Override
    public void deleteById(int id) {
        outfitPageDao.deleteById(id);
    }

    @Override
    public List<OutfitPage> findAll() {
        return outfitPageDao.findAll();
    }
}
