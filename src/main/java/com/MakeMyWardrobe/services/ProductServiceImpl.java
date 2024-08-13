package com.MakeMyWardrobe.services;

import com.MakeMyWardrobe.models.ProductDao;
import com.MakeMyWardrobe.models.Product;
import com.MakeMyWardrobe.models.OutfitPage;
import com.MakeMyWardrobe.repository.OutfitPageRepository;
import com.MakeMyWardrobe.services.ProductService;
import com.MakeMyWardrobe.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OutfitPageRepository outfitPageRepository; // Inject OutfitPageRepository

    @Override
    public Product save(Product product) {
        // Fetch the OutfitPage with the given ID to ensure it's not null
        OutfitPage outfitPage = outfitPageRepository.findById(product.getOutfitPage().getId())
                .orElseThrow(() -> new ResourceNotFoundException("OutfitPage not found"));

        product.setOutfitPage(outfitPage);
        return productDao.save(product);
    }	

    @Override
    public Optional<Product> findById(long id) {
        return productDao.findById(id);
    }

    @Override
    public void deleteById(long id) {
        productDao.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
