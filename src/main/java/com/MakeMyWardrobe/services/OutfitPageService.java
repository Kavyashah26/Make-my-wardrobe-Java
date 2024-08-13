package com.MakeMyWardrobe.services;

import com.MakeMyWardrobe.models.OutfitPage;

import java.util.List;
import java.util.Optional;

public interface OutfitPageService {
    OutfitPage save(OutfitPage outfitPage);
    Optional<OutfitPage> findById(int id);
    void deleteById(int id);
    List<OutfitPage> findAll();
}
