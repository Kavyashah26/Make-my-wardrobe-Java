package com.MakeMyWardrobe.Controller;


import com.MakeMyWardrobe.exceptions.ResourceNotFoundException;
import com.MakeMyWardrobe.models.Influencer;
import com.MakeMyWardrobe.services.InfluencerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/influencers")
public class InfluencerController {

    @Autowired
    private InfluencerService influencerService;

    @PostMapping
    public ResponseEntity<?> createInfluencer(@RequestBody Influencer influencer) {
        try {
            if (influencer.getName() == null || influencer.getEmail() == null) {
                return ResponseEntity.badRequest().body("Name and email are required.");
            }
            Influencer createdInfluencer = influencerService.save(influencer);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInfluencer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while creating the influencer.");
        }
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Influencer> getInfluencerById(@PathVariable int id) {
    	System.out.println("In id");
        Optional<Influencer> influencer = influencerService.findById(id);
        return influencer.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Influencer>> getAllInfluencers() {
        List<Influencer> influencers = influencerService.findAll();
        return ResponseEntity.ok(influencers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Influencer> updateInfluencer(@PathVariable int id, @RequestBody Influencer influencer) {
        influencer.setInfluencerId(id); // Updated method name
        Influencer updatedInfluencer = influencerService.save(influencer);
        return ResponseEntity.ok(updatedInfluencer);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfluencer(@PathVariable int id) {
        influencerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
