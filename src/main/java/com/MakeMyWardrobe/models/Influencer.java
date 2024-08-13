package com.MakeMyWardrobe.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "influencer")
public class Influencer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int influencerId;  // Primary key field

    private String name;
    
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OutfitPage> outfitPages;  // Relationship with OutfitPage

    // Default constructor
    public Influencer() {}

    // Parameterized constructor
    public Influencer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getInfluencerId() {
        return influencerId;  // Getter for ID
    }

    public void setInfluencerId(int influencerId) {
        this.influencerId = influencerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OutfitPage> getOutfitPages() {
        return outfitPages;
    }

    public void setOutfitPages(List<OutfitPage> outfitPages) {
        this.outfitPages = outfitPages;
    }

	@Override
	public String toString() {
		return "Influencer [influencerId=" + influencerId + ", name=" + name + ", email=" + email + ", outfitPages="
				+ outfitPages + "]";
	}

    
}
