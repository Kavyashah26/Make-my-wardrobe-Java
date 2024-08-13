//package com.MakeMyWardrobe.Controller;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import com.MakeMyWardrobe.models.*;
//import com.MakeMyWardrobe.services.*;
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@RestController
//public class MakeMyWardrobeController {
//
//
////    @Autowired
////    private UrlService urlService;
////
////
////    @PostMapping("/generate/{employeeId}")
////    public ResponseEntity<?> generateShortLink(@PathVariable int employeeId, @RequestBody UrlDto urlReq) {
////        // Call service method passing employeeId along with UrlDto
////        Url urlToRet = urlService.generateShortLink(employeeId, urlReq);
////
////        if (urlToRet != null) {
////            UrlResponseDto urlResponseDto = new UrlResponseDto();
////            urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
////            urlResponseDto.setExpirationDate(urlToRet.getExpirationDate());
////            urlResponseDto.setShortLink(urlToRet.getShortLink());
////            return new ResponseEntity<>(urlResponseDto, HttpStatus.OK);
////        } else {
////            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
////            urlErrorResponseDto.setStatus("404");
////            urlErrorResponseDto.setError("There was an error processing your request. Please try again.");
////            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
////        }
////    }
////
////
////    @GetMapping("short.ly/{shortLink}")
////    public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {
////
////        if(StringUtils.isEmpty(shortLink))
////        {
////            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
////            urlErrorResponseDto.setError("Invalid Url");
////            urlErrorResponseDto.setStatus("400");
////            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
////        }
////        Url urlToRet = urlService.getEncodedUrl(shortLink);
////
////        if(urlToRet == null)
////        {
////            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
////            urlErrorResponseDto.setError("Url does not exist or it might have expired!");
////            urlErrorResponseDto.setStatus("400");
////            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
////        }
////
////        if(urlToRet.getExpirationDate().isBefore(LocalDateTime.now()))
////        {
////            urlService.deleteShortLink(urlToRet);
////            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
////            urlErrorResponseDto.setError("Url Expired. Please try generating a fresh one.");
////            urlErrorResponseDto.setStatus("200");
////            return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto,HttpStatus.OK);
////        }
////
////        response.sendRedirect(urlToRet.getOriginalUrl());
////        return null;
////    }
//////    @DeleteMapping("/{shortLink}")
//////    public ResponseEntity<?> deleteShortLink(@PathVariable String shortLink) {
//////        // Implement deletion logic here
//////        boolean deleted = urlService.deleteShortLinkByShortLink(shortLink);
//////        if (deleted) {
//////            return ResponseEntity.ok("Short link deleted successfully");
//////        } else {
//////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Short link not found");
//////        }
//////    }
////    
////    @PutMapping("update/{employeeId}/{shortLink}")
////    public ResponseEntity<?> updateUrl(@PathVariable int employeeId, @PathVariable String shortLink, @RequestBody UrlDto updatedUrl) {
////        // Call service method passing employeeId along with other parameters
////        Url existingUrl = urlService.getEncodedUrl(employeeId, shortLink);
////
////        if (existingUrl == null) {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found");
////        }
////
////        // Update the URL properties
////        if(updatedUrl.getUrl()!=null)
////            existingUrl.setOriginalUrl(updatedUrl.getUrl());
////        if(updatedUrl.getExpirationDate()!=null)
////            existingUrl.setExpirationDate(updatedUrl.getExpirationDate());
////
////        // Check if custom short ID is provided
////        if (StringUtils.isNotEmpty(updatedUrl.getCustomShortId())) {
////            // Check if the custom short ID is already in use
////            System.out.println(updatedUrl.getCustomShortId());
////            Url urlWithCustomShortId = urlService.getEncodedUrl(updatedUrl.getCustomShortId());
////            if (urlWithCustomShortId != null) {
////                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Custom short ID already in use");
////            }
////            existingUrl.setShortLink(updatedUrl.getCustomShortId());
////        }
////
////        Url updated = urlService.persistShortLink(existingUrl);
////        return ResponseEntity.ok(updated);
////    }
////
////
////    
////    @DeleteMapping("/delete/{employeeId}")
////    public ResponseEntity<?> deleteUrl(@PathVariable int employeeId, @RequestBody UrlDto urlDto) {
////        String shortLink = urlDto.getCustomShortId();
////        if (StringUtils.isBlank(shortLink)) {
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Short link cannot be empty");
////        }
////
////        boolean deleted = urlService.deleteShortLinkByShortLink(employeeId, shortLink);
////        if (deleted) {
////            return ResponseEntity.ok("URL deleted successfully");
////        } else {
////            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("URL not found");
////        }
////    }
//
//    
//private InfluencerService influencerService;
//	
//	@Autowired
//	public void InfluencerRestController(InfluencerService theInfluencerService) {
//		influencerService = theInfluencerService;
//	}
//	
//	// expose "/employees" and return list of employees
//	@GetMapping("/influencers")
//	public List<Influencer> findAll() {
//		return influencerService.findAll();
//	}
//
//	@GetMapping("/abc")
//	public String abc() {
//		return "Hello";
//	}
//	// add mapping for GET /employees/{employeeId}
//	
//	@GetMapping("/influencers/{influencerId}")
//	public Influencer getEmployee(@PathVariable int influencerId) {
//		
//		Influencer theInfluencer = influencerService.findById(influencerId);
//		
//		if (theInfluencer == null) {
//			throw new RuntimeException("Influencer id not found - " + influencerId);
//		}
//		
//		return theInfluencer;
//	}
//	
//	// add mapping for POST /employees - add new employee
//	
////	@PostMapping("/abc")
////	public Influencer addEmployee(@RequestBody Influencer theInfluencer) {
////		
////		// also just in case they pass an id in JSON ... set id to 0
////		// this is to force a save of new item ... instead of update
////		
//////		theEmployee.setId(1);
////		
////		influencerService.save(theInfluencer);
////		theInfluencer.setId(influencerService.findByEmail(theInfluencer.getEmail()).getId());
////		return theInfluencer;
////	}
//	
////	@PostMapping("/addInfluencer")
////	public ResponseEntity<Influencer> addEmployee(@RequestBody Influencer theInfluencer) {
////	    // Check if the influencer has an ID (which should be 0 for new records)
////	    System.out.println(theInfluencer.getId()+"\n");
////	    // Ensure that the email is not null or empty
////	    if (theInfluencer.getEmail() == null || theInfluencer.getEmail().isEmpty()) {
////	        return ResponseEntity.badRequest().body(null);  // Return a bad request response
////	    }
////	    
////	    // Check if an influencer with the same email already exists
////	    if (influencerService.findByEmail(theInfluencer.getEmail()) != null) {
////	        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);  // Return conflict response
////	    }
////	    
////	    // Save the new influencer
////	    Influencer savedInfluencer = influencerService.save(theInfluencer);
////	    return ResponseEntity.status(HttpStatus.CREATED).body(savedInfluencer);
////	}
//
//	
//	// add mapping for PUT /employees - update existing employee
//	
////	@PutMapping("/employees")
////	public Influencer updateEmployee(@RequestBody Influencer theEmployee) {
////		
////		influencerService.save(theEmployee);
////		
////		return theEmployee;
////	}
//	
//	// add mapping for DELETE /employees/{employeeId} - delete employee
//	
////	@DeleteMapping("/employees/{employeeId}")
////	public String deleteEmployee(@PathVariable int employeeId) {
////		
////		Influencer tempEmployee = influencerService.findById(employeeId);
////		
////		// throw exception if null
////		
////		if (tempEmployee == null) {
////			throw new RuntimeException("Employee id not found - " + employeeId);
////		}
////		
////		influencerService.deleteById(employeeId);
////		
////		return "Deleted employee id - " + employeeId;
////	}
//    
////-------------------------
////
//	
//	private OutfitPageService outfitPageService;
//	
//	@Autowired
//    public void OutfitPageController(OutfitPageService theOutfitPageService) {
//        outfitPageService = theOutfitPageService;
//    }
//	
//	@GetMapping("/all")
//    public List<OutfitPage> findAllOutfit() {
//        return outfitPageService.findAll();
//    }
//
//	@GetMapping("/alltest")
//    public String test() {
//        return "Hello Outfit";
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<OutfitPage> getOutfitPage(@PathVariable int id) {
//        OutfitPage theOutfitPage = outfitPageService.findById(id);
//        return new ResponseEntity<>(theOutfitPage, HttpStatus.OK);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<OutfitPage> addOutfitPage(@RequestBody OutfitPage theOutfitPage) {
////        theOutfitPage.setId(0);  // Ensure that a new ID will be generated
//        OutfitPage savedOutfitPage = outfitPageService.save(theOutfitPage);
//        return new ResponseEntity<>(savedOutfitPage, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<OutfitPage> updateOutfitPage(@RequestBody OutfitPage theOutfitPage) {
//        OutfitPage updatedOutfitPage = outfitPageService.save(theOutfitPage);
//        return new ResponseEntity<>(updatedOutfitPage, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteOutfitPage(@PathVariable int id) {
//        outfitPageService.deleteById(id);
//        return new ResponseEntity<>("Outfit page deleted - ID: " + id, HttpStatus.OK);
//    }
//	
//	
//	
////private ProductService productService;
////
////@Autowired
////public void productRestController(ProductService theProductService) {
////	productService = theProductService;
////}
////
////// expose "/employees" and return list of employees
////@GetMapping("/products")
////public List<Product> findAllproducts() {
////	return productService.findAll();
////}
////
////// add mapping for GET /employees/{employeeId}
////
////@GetMapping("/products/{productId}")
////public Product getProduct(@PathVariable int productId) {
////	
////	Product theProduct = productService.findById(productId);
////	
////	if (theProduct == null) {
////		throw new RuntimeException("Product id not found - " + productId);
////	}
////	
////	return theProduct;
////}
////
////// add mapping for POST /employees - add new employee
////
//////@PostMapping("/abc")
//////public Influencer addEmployee(@RequestBody Influencer theInfluencer) {
//////	
//////	// also just in case they pass an id in JSON ... set id to 0
//////	// this is to force a save of new item ... instead of update
//////	
////////	theEmployee.setId(1);
//////	
//////	influencerService.save(theInfluencer);
//////	theInfluencer.setId(influencerService.findByEmail(theInfluencer.getEmail()).getId());
//////	return theInfluencer;
//////}
////
//////@PostMapping("/addProduct")
//////public ResponseEntity<Product> addProduct(@RequestBody Product theProduct) {
//////    // Check if the influencer has an ID (which should be 0 for new records)
//////    System.out.println(theProduct.getProductId()+"\n");
//////    
//////    
//////    // Save the new influencer
//////    Influencer savedInfluencer = influencerService.save(theProduct);
//////    return ResponseEntity.status(HttpStatus.CREATED).body(savedInfluencer);
//////}
////
////@PostMapping
////public Product addProduct(@RequestBody Product theProduct) {
////    theProduct.setProductId(0); // Ensure the productId is 0 for new records
////
////    Product savedProduct = productService.save(theProduct);
////
////    return savedProduct;
////}
////
////// add mapping for PUT /employees - update existing employee
////
////@PutMapping("/employees")
////public Influencer updateEmployee(@RequestBody Influencer theEmployee) {
////	
////	influencerService.save(theEmployee);
////	
////	return theEmployee;
////}
////
////// add mapping for DELETE /employees/{employeeId} - delete employee
////
////@DeleteMapping("/employees/{employeeId}")
////public String deleteEmployee(@PathVariable int employeeId) {
////	
////	Influencer tempEmployee = influencerService.findById(employeeId);
////	
////	// throw exception if null
////	
////	if (tempEmployee == null) {
////		throw new RuntimeException("Employee id not found - " + employeeId);
////	}
////	
////	influencerService.deleteById(employeeId);
////	
////	return "Deleted employee id - " + employeeId;
////}
//
//}