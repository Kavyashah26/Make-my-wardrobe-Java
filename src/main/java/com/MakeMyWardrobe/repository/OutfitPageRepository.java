package com.MakeMyWardrobe.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MakeMyWardrobe.models.OutfitPage;

@Repository
public interface OutfitPageRepository extends JpaRepository<OutfitPage, Integer> {
}
