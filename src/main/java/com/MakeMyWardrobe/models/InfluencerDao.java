package com.MakeMyWardrobe.models;

import com.MakeMyWardrobe.models.Influencer;

import java.util.List;
import java.util.Optional;

public interface InfluencerDao {

    /**
     * Save a new influencer or update an existing one.
     *
     * @param influencer the influencer to be saved or updated
     * @return the saved influencer
     */
    Influencer save(Influencer influencer);

    /**
     * Find an influencer by their ID.
     *
     * @param id the ID of the influencer
     * @return an Optional containing the found influencer or empty if not found
     */
    Optional<Influencer> findById(int id);

    /**
     * Find an influencer by their email.
     *
     * @param email the email of the influencer
     * @return an Optional containing the found influencer or empty if not found
     */
    Optional<Influencer> findByEmail(String email);

    /**
     * Delete an influencer by their ID.
     *
     * @param id the ID of the influencer to be deleted
     */
    void deleteById(int id);

    /**
     * Get a list of all influencers.
     *
     * @return a list of all influencers
     */
    List<Influencer> findAll();
}
