//package com.MakeMyWardrobe.models;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "Product")
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long productId;
//    
//    @Column(name = "product_link", length = 2048)  // Update length as needed
//    private String productLink;
//    
//    private String name;
//    private double price;
//    private String review;
//    private String image;
//    private String size;
//    private String description;
//    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "outfit_page_id", nullable = false)
//    @JsonIgnore
//    private OutfitPage outfitPage;
//
//    // Default constructor
//    public Product() {
//    }
//
//    // Getters and setters
//    public long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(long productId) {
//        this.productId = productId;
//    }
//
//    public String getProductLink() {
//        return productLink;
//    }
//
//    public void setProductLink(String productLink) {
//        this.productLink = productLink;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getReview() {
//        return review;
//    }
//
//    public void setReview(String review) {
//        this.review = review;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public String getSize() {
//        return size;
//    }
//
//    public void setSize(String size) {
//        this.size = size;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public OutfitPage getOutfitPage() {
//        return outfitPage;
//    }
//
//    public void setOutfitPage(OutfitPage outfitPage) {
//        this.outfitPage = outfitPage;
//    }
//
//    @Override
//    public String toString() {
//        return "Product [productId=" + productId + 
//               ", productLink=" + productLink + 
//               ", name=" + name + 
//               ", price=" + price + 
//               ", review=" + review + 
//               ", image=" + image + 
//               ", size=" + size + 
//               ", description=" + description + 
//               ", outfitPage=" + outfitPage + "]";
//    }
//}
//
//
////<dependency>
////<groupId>org.springframework.boot</groupId>
////<artifactId>spring-boot-starter-oauth2-client</artifactId>
////</dependency>





package com.MakeMyWardrobe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    
    @Column(name = "product_link", length = 2048)  // Update length as needed
    private String productLink;
    
    @Column(name = "asin", length = 20, unique = true) // Add ASIN column
    private String asin;

    private String name;
    private double price;
    private String review;
    private String image;
    private String size;
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outfit_page_id", nullable = false)
    @JsonIgnore
    private OutfitPage outfitPage;

    // Default constructor
    public Product() {
    }

    // Getters and setters
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OutfitPage getOutfitPage() {
        return outfitPage;
    }

    public void setOutfitPage(OutfitPage outfitPage) {
        this.outfitPage = outfitPage;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + 
               ", productLink=" + productLink + 
               ", asin=" + asin + 
               ", name=" + name + 
               ", price=" + price + 
               ", review=" + review + 
               ", image=" + image + 
               ", size=" + size + 
               ", description=" + description + 
               ", outfitPage=" + outfitPage + "]";
    }
}
