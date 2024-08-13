package com.MakeMyWardrobe.Controller;


import com.MakeMyWardrobe.exceptions.ResourceNotFoundException;
import com.MakeMyWardrobe.models.OutfitPage;
import com.MakeMyWardrobe.models.Product;
import com.MakeMyWardrobe.services.OutfitPageService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/outfitpages")
public class OutfitPageController {

    @Autowired
    private OutfitPageService outfitPageService;

//    @PostMapping
//    public ResponseEntity<OutfitPage> createOutfitPage(@RequestBody OutfitPage outfitPage) {
//    	// Set the outfitPage reference in each product
//        for (Product product : outfitPage.getProducts()) {
//            product.setOutfitPage(outfitPage);
//        }
//
//        // Save the OutfitPage (this will cascade save the products as well)
//        OutfitPage savedOutfitPage = outfitPageService.save(outfitPage);
//
//        return ResponseEntity.ok(savedOutfitPage);    }
//    @PostMapping
//    public ResponseEntity<?> createOutfitPage(@RequestBody OutfitPage outfitPage) {
//        try {
//            // Validate the outfitPage object
//            if (outfitPage.getInfluencer() == null || 
//                outfitPage.getOutfitName() == null || 
//                outfitPage.getDescription() == null || 
//                outfitPage.getProducts() == null || 
//                outfitPage.getProducts().isEmpty()) {
//                return ResponseEntity.badRequest().body("All fields are required.");
//            }
//
//            // Set the outfitPage reference in each product
//            for (Product product : outfitPage.getProducts()) {
//                product.setOutfitPage(outfitPage);
//            }
//
//            // Save the OutfitPage (this will cascade save the products as well)
//            OutfitPage savedOutfitPage = outfitPageService.save(outfitPage);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedOutfitPage);
//
//        } catch (Exception e) {
//            // Log the exception
//            e.printStackTrace();
//
//            // Return a 500 Internal Server Error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while creating the outfit page.");
//        }
//    }

//    ----------------------

//    @PostMapping
//    public ResponseEntity<?> createOutfitPage(@RequestBody OutfitPage outfitPage) {
//        try {
//            // Validate the outfitPage object
//            if (outfitPage.getInfluencer() == null || 
//                outfitPage.getOutfitName() == null || 
//                outfitPage.getDescription() == null || 
//                outfitPage.getProducts() == null || 
//                outfitPage.getProducts().isEmpty()) {
//                return ResponseEntity.badRequest().body("All fields are required.");
//            }
//
//            // Extract ASIN from Amazon URL and update product details
//            for (Product product : outfitPage.getProducts()) {
//                String asin = extractASIN(product.getProductLink());
//                if (asin != null) {
//                    // Fetch product details from Scrapingdog API
//                    ProductDetails productDetails = fetchProductDetails(asin);
//                    if (productDetails != null) {
//                        product.setName(productDetails.getTitle()); // Update product name
//                    }
//                }
//                product.setOutfitPage(outfitPage); // Set the outfitPage reference
//            }
//
//            // Save the OutfitPage (this will cascade save the products as well)
//            OutfitPage savedOutfitPage = outfitPageService.save(outfitPage);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedOutfitPage);
//
//        } catch (Exception e) {
//            // Log the exception
//            e.printStackTrace();
//
//            // Return a 500 Internal Server Error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while creating the outfit page.");
//        }
//    }
//
//    // Utility method to extract ASIN from Amazon URL
//    private String extractASIN(String url) {
//        String asin = null;
//        try {
//            if (url != null && url.contains("/dp/")) {
//                String[] parts = url.split("/dp/");
//                if (parts.length > 1) {
//                    String[] asinPart = parts[1].split("/");
//                    if (asinPart.length > 0) {
//                        asin = asinPart[0];
//                    }
//                }
//            }
//        } catch (Exception e) {
//            // Log extraction error
//            e.printStackTrace();
//        }
//        return asin;
//    }
//
//    // Fetch product details from Scrapingdog API
//    private ProductDetails fetchProductDetails(String asin) {
//        final String url = "https://api.scrapingdog.com/amazon/product";
//        RestTemplate restTemplate = new RestTemplate();
//
//        try {
//            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//                    .queryParam("api_key", "66b3de1b806c3f45fde9b03a")
//                    .queryParam("domain", "in")
//                    .queryParam("asin", asin);
//
//            ProductDetails response = restTemplate.getForObject(builder.toUriString(), ProductDetails.class);
//            return response;
//        } catch (Exception e) {
//            // Log API call error
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    // Define a class to map the product details response
//    public static class ProductDetails {
//        private String title;
//
//        // Getters and setters
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//    }

//    --------------------
//    2
    
//    public static class ProductDetails {
//        private String title;
//        private String price; // Price is a String from the API
//
//        // Getters and setters
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getPrice() {
//            return price;
//        }
//
//        public void setPrice(String price) {
//            this.price = price;
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<?> createOutfitPage(@RequestBody OutfitPage outfitPage) {
//        try {
//            // Validate the outfitPage object
//            if (outfitPage.getInfluencer() == null || 
//                outfitPage.getOutfitName() == null || 
//                outfitPage.getDescription() == null || 
//                outfitPage.getProducts() == null || 
//                outfitPage.getProducts().isEmpty()) {
//                return ResponseEntity.badRequest().body("All fields are required.");
//            }
//
//            // Extract ASIN from Amazon URL and update product details
//            for (com.MakeMyWardrobe.models.Product product : outfitPage.getProducts()) {
//                String asin = extractASIN(product.getProductLink());
//                if (asin != null) {
//                    // Fetch product details from Scrapingdog API
//                    ProductDetails productDetails = fetchProductDetails(asin);
//                    if (productDetails != null) {
//                        product.setName(productDetails.getTitle()); // Update product name
//                        
//                        // Convert price from String to double
//                        double price = parsePrice(productDetails.getPrice());
//                        product.setPrice(price); // Update product price
//                    }
//                }
//                product.setOutfitPage(outfitPage); // Set the outfitPage reference
//            }
//
//            // Save the OutfitPage (this will cascade save the products as well)
//            OutfitPage savedOutfitPage = outfitPageService.save(outfitPage);
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedOutfitPage);
//
//        } catch (Exception e) {
//            // Log the exception
//            e.printStackTrace();
//
//            // Return a 500 Internal Server Error
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An error occurred while creating the outfit page.");
//        }
//    }
//
//    // Utility method to convert price string to double
//    private double parsePrice(String priceStr) {
//        try {
//            // Remove non-numeric characters (e.g., currency symbols, commas)
//            String cleanPriceStr = priceStr.replaceAll("[^\\d.]", "");
//            return Double.parseDouble(cleanPriceStr);
//        } catch (NumberFormatException e) {
//            // Log the parsing error
//            e.printStackTrace();
//            return 0.0; // Default value in case of parsing error
//        }
//    }
//
//        private String name;
//        private String price; // Add this field for price
//        private OutfitPage outfitPage;
//        private String productLink;
//
//        // Getters and setters
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getPrice() {
//            return price;
//        }
//
//        public void setPrice(String price) {
//            this.price = price;
//        }
//
//        public OutfitPage getOutfitPage() {
//            return outfitPage;
//        }
//
//        public void setOutfitPage(OutfitPage outfitPage) {
//            this.outfitPage = outfitPage;
//        }
//
//        public String getProductLink() {
//            return productLink;
//        }
//
//        public void setProductLink(String productLink) {
//            this.productLink = productLink;
//        }
//  
//
//    private ProductDetails fetchProductDetails(String asin) {
//      final String url = "https://api.scrapingdog.com/amazon/product";
//      RestTemplate restTemplate = new RestTemplate();
//
//      try {
//          UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//                  .queryParam("api_key", "66b3de1b806c3f45fde9b03a")
//                  .queryParam("domain", "in")
//                  .queryParam("asin", asin);
//
//          ProductDetails response = restTemplate.getForObject(builder.toUriString(), ProductDetails.class);
//          return response;
//      } catch (Exception e) {
//          // Log API call error
//          e.printStackTrace();
//          return null;
//      }
//  }
//    
//    private String extractASIN(String url) {
//      String asin = null;
//      try {
//          if (url != null && url.contains("/dp/")) {
//              String[] parts = url.split("/dp/");
//              if (parts.length > 1) {
//                  String[] asinPart = parts[1].split("/");
//                  if (asinPart.length > 0) {
//                      asin = asinPart[0];
//                  }
//              }
//          }
//      } catch (Exception e) {
//          // Log extraction error
//          e.printStackTrace();
//      }
//      return asin;
//  }
    
//    ------------------
//    3
    
//    @PostMapping
//  public ResponseEntity<?> createOutfitPage(@RequestBody OutfitPage outfitPage) {
//      try {
//          // Validate the outfitPage object
//          if (outfitPage.getInfluencer() == null || 
//              outfitPage.getOutfitName() == null || 
//              outfitPage.getDescription() == null || 
//              outfitPage.getProducts() == null || 
//              outfitPage.getProducts().isEmpty()) {
//              return ResponseEntity.badRequest().body("All fields are required.");
//          }
//
//          // Extract ASIN from Amazon URL and update product details
//          for (com.MakeMyWardrobe.models.Product product : outfitPage.getProducts()) {
//              String asin = extractASIN(product.getProductLink());
//              if (asin != null) {
//                  // Fetch product details from Scrapingdog API
//                  ProductDetails productDetails = fetchProductDetails(asin);
//                  if (productDetails != null) {
//                      product.setName(productDetails.getTitle()); // Update product name
//                      System.out.println("Asin no: "+ productDetails.getProductInformation().getAsin());
//                      product.setAsin(productDetails.getProductInformation().getAsin()); // Update product ASIN
//                      
//                      // Convert price from String to double
//                      double price = parsePrice(productDetails.getPrice());
//                      product.setPrice(price); // Update product price
//                  }
//              }
//              product.setOutfitPage(outfitPage); // Set the outfitPage reference
//          }
//
//          // Save the OutfitPage (this will cascade save the products as well)
//          OutfitPage savedOutfitPage = outfitPageService.save(outfitPage);
//
//          return ResponseEntity.status(HttpStatus.CREATED).body(savedOutfitPage);
//
//      } catch (Exception e) {
//          // Log the exception
//          e.printStackTrace();
//
//          // Return a 500 Internal Server Error
//          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                  .body("An error occurred while creating the outfit page.");
//      }
//  }
  
    
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductDetails {
        private String title;
        private String price;
        private ProductInformation product_information; // Rename the field

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public ProductInformation getProduct_information() {
            return product_information;
        }

        public void setProduct_information(ProductInformation product_information) {
            this.product_information = product_information;
        }

        // Inner class for product information
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class ProductInformation {
            private String asin;

            public String getAsin() {
                return asin;
            }

            public void setAsin(String asin) {
                this.asin = asin;
            }
        }
    }



//   
    @PostMapping
    public ResponseEntity<?> createOutfitPage(@RequestBody OutfitPage outfitPage) {
        try {
            // Validate the outfitPage object
            if (outfitPage.getInfluencer() == null || 
                outfitPage.getOutfitName() == null || 
                outfitPage.getDescription() == null || 
                outfitPage.getProducts() == null || 
                outfitPage.getProducts().isEmpty()) {
                return ResponseEntity.badRequest().body("All fields are required.");
            }

            // Extract ASIN from Amazon URL and update product details
            for (com.MakeMyWardrobe.models.Product product : outfitPage.getProducts()) {
                String asin = extractASIN(product.getProductLink());
                if (asin != null) {
                    // Fetch product details from Scrapingdog API
                    ProductDetails productDetails = fetchProductDetails(asin);
                    if (productDetails != null) {
                        product.setName(productDetails.getTitle());
                        product.setAsin(asin); 
//                        Update product name
                        
                        // Convert price from String to double
                        double price = parsePrice(productDetails.getPrice());
                        product.setPrice(price); // Update product price
                        
                        // Access ASIN from ProductInformation
                        ProductDetails.ProductInformation productInfo = productDetails.getProduct_information();
                        if (productInfo != null) {
                            String fetchedAsin = productInfo.getAsin();
                            System.out.println("Fetched ASIN from details: " + fetchedAsin);
                        } else {
                            System.out.println("ProductInformation is null.");
                        }
                    }
                }
                product.setOutfitPage(outfitPage); // Set the outfitPage reference
            }

            // Save the OutfitPage (this will cascade save the products as well)
            OutfitPage savedOutfitPage = outfitPageService.save(outfitPage);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedOutfitPage);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred while creating the outfit page.");
        }
    }

    
    
//    private ProductDetails fetchProductDetails(String asin) {
//        final String url = "https://api.scrapingdog.com/amazon/product";
//        RestTemplate restTemplate = new RestTemplate();
//
//        try {
//            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//                    .queryParam("api_key", "66b3de1b806c3f45fde9b03a")
//                    .queryParam("domain", "in")
//                    .queryParam("asin", asin);
//
//            ProductDetails response = restTemplate.getForObject(builder.toUriString(), ProductDetails.class);
//            return response;
//        } catch (Exception e) {
//            // Log API call error
//            e.printStackTrace();
//            return null;
//        }
//    }
    
    private ProductDetails fetchProductDetails(String asin) {
        final String url = "https://api.scrapingdog.com/amazon/product";
        RestTemplate restTemplate = new RestTemplate();

        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                    .queryParam("api_key", "66b3de1b806c3f45fde9b03a")
                    .queryParam("domain", "in")
                    .queryParam("asin", asin);

            // Fetch the raw response
            String response = restTemplate.getForObject(builder.toUriString(), String.class);
            System.out.println("API Response: " + response);

            // Parse the response into ProductDetails
            ObjectMapper objectMapper = new ObjectMapper();
            ProductDetails productDetails = objectMapper.readValue(response, ProductDetails.class);
            return productDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
 // Utility method to convert price string to double
  private double parsePrice(String priceStr) {
      try {
          // Remove non-numeric characters (e.g., currency symbols, commas)
          String cleanPriceStr = priceStr.replaceAll("[^\\d.]", "");
          return Double.parseDouble(cleanPriceStr);
      } catch (NumberFormatException e) {
          // Log the parsing error
          e.printStackTrace();
          return 0.0; // Default value in case of parsing error
      }
  }
    private String extractASIN(String url) {
      String asin = null;
      try {
          if (url != null && url.contains("/dp/")) {
              String[] parts = url.split("/dp/");
              if (parts.length > 1) {
                  String[] asinPart = parts[1].split("/");
                  if (asinPart.length > 0) {
                      asin = asinPart[0];
                  }
              }
          }
      } catch (Exception e) {
          // Log extraction error
          e.printStackTrace();
      }
      return asin;
  }

    
//    -----------------
    // Exception handler for specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OutfitPage> getOutfitPageById(@PathVariable int id) {
        Optional<OutfitPage> outfitPage = outfitPageService.findById(id);
        return outfitPage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OutfitPage>> getAllOutfitPages() {
        List<OutfitPage> outfitPages = outfitPageService.findAll();
        return ResponseEntity.ok(outfitPages);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<OutfitPage> updateOutfitPage(@PathVariable int id, @RequestBody OutfitPage outfitPage) {
//        // Fetch existing OutfitPage or throw an exception if not found
//        OutfitPage existingOutfitPage = outfitPageService.findById(id)
//            .orElseThrow(() -> new ResourceNotFoundException("OutfitPage not found"));
//
//        // Update basic properties
//        existingOutfitPage.setOutfitName(outfitPage.getOutfitName());
//        existingOutfitPage.setDescription(outfitPage.getDescription());
//
//        // Print debug information
//        System.out.println("Updating OutfitPage with ID: " + id);
//
//        // Clear existing products and add new products with proper outfitPage reference
//        existingOutfitPage.getProducts().clear();
//        for (Product product : outfitPage.getProducts()) {
//            // Print product details before update
//            System.out.println("Product before update: " + product);
//
//            // Ensure that the outfitPage reference is set
//            product.setOutfitPage(existingOutfitPage);
//
//            // Print product details after update
//            System.out.println("Product after setting outfitPage: " + product);
//
//            existingOutfitPage.getProducts().add(product);
//        }
//
//        // Save the updated OutfitPage
//        OutfitPage updatedOutfitPage = outfitPageService.save(existingOutfitPage);
//        
//        // Return the updated OutfitPage
//        return ResponseEntity.ok(updatedOutfitPage);
//    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OutfitPage> updateOutfitPage(@PathVariable int id, @RequestBody OutfitPage outfitPage) {
        // Fetch existing OutfitPage from the database
        OutfitPage existingOutfitPage = outfitPageService.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("OutfitPage not found"));

        // Print debug information
        System.out.println("Updating OutfitPage with ID: " + id);

        // Update the existing outfit page's fields
        existingOutfitPage.setOutfitName(outfitPage.getOutfitName());
        existingOutfitPage.setDescription(outfitPage.getDescription());

        // Ensure the influencer remains unchanged
        existingOutfitPage.setInfluencer(existingOutfitPage.getInfluencer()); // Retain the existing influencer

        // Clear existing products and add new products
        existingOutfitPage.getProducts().clear();
        for (com.MakeMyWardrobe.models.Product product : outfitPage.getProducts()) {
            // Print debug information
            System.out.println("Product before update: " + product);
            product.setOutfitPage(existingOutfitPage); // Ensure the relationship is set
            System.out.println("Product after setting outfitPage: " + product);
            existingOutfitPage.getProducts().add(product);
        }

        // Save the updated OutfitPage
        OutfitPage updatedOutfitPage = outfitPageService.save(existingOutfitPage);

        // Return the updated OutfitPage
        return ResponseEntity.ok(updatedOutfitPage);
    }






    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOutfitPage(@PathVariable int id) {
        outfitPageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
