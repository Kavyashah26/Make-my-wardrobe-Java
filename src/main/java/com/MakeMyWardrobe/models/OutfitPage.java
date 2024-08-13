package com.MakeMyWardrobe.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "outfit_page")
public class OutfitPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    @JsonBackReference
    private Influencer influencer;

    @OneToMany(mappedBy = "outfitPage", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Product> products;

    @Column(name = "outfit_name")
    private String outfitName;

    @Column(name = "description")
    private String description;

    
    public int getInfluencerId() {
        if (this.influencer != null) {
            return this.influencer.getInfluencerId();
        }
        return -1; // Or handle as appropriate if the influencer is null
    }

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "outfit_image")
    private String outfitImage; // URL or path to the image of the complete outfit

    @Column(name = "affiliate_link")
    private String affiliateLink; // Amazon affiliate link for the whole outfit

    // Default constructor
    public OutfitPage() {
    }

    // Parameterized constructor
    public OutfitPage(Influencer influencer, String outfitName, String description, List<Product> products, 
                      String creationDate, String outfitImage, String affiliateLink) {
        this.influencer = influencer;
        this.outfitName = outfitName;
        this.description = description;
        this.products = products;
        this.creationDate = creationDate;
        this.outfitImage = outfitImage;
        this.affiliateLink = affiliateLink;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Influencer getInfluencer() {
        return influencer;
    }

    public void setInfluencer(Influencer influencer) {
        this.influencer = influencer;
    }

    public String getOutfitName() {
        return outfitName;
    }

    public void setOutfitName(String outfitName) {
        this.outfitName = outfitName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getOutfitImage() {
        return outfitImage;
    }

    public void setOutfitImage(String outfitImage) {
        this.outfitImage = outfitImage;
    }

    public String getAffiliateLink() {
        return affiliateLink;
    }

    public void setAffiliateLink(String affiliateLink) {
        this.affiliateLink = affiliateLink;
    }

    @Override
    public String toString() {
        return "OutfitPage [id=" + id + 
               ", influencer=" + influencer + 
               ", outfitName=" + outfitName + 
               ", description=" + description + 
               ", creationDate=" + creationDate + 
               ", outfitImage=" + outfitImage + 
               ", affiliateLink=" + affiliateLink + "]";
    }
}
