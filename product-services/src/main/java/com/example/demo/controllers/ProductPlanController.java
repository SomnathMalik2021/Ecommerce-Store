package com.example.demo.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entity.Product;
import com.example.demo.services.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path= "/api/v1")
@AllArgsConstructor
public class ProductPlanController {

	private ProductService service;
	
	@GetMapping("/product/list")
	List<Product> getAllProducts(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
		return this.service.getAllProducts(page, pageSize);
		
	}
	@GetMapping("product/list/{merchant}")
	List<Product>getAllProductsByMerchant(@PathVariable("merchant") String merchant,@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
				return this.service.getAllProductsByMerchant(merchant, page, pageSize);
		
	}
	
	@PostMapping("product/save")
	ResponseEntity<Product> addProduct(@RequestBody Product product){
     Product product1 = this.service.addProduct(product);
     URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product1.getProductId())
				.toUri();
		return ResponseEntity.created(location).body(product1);
		
	}
	@PutMapping("product/save")
	ResponseEntity<Product> updateProduct(@RequestBody Product product){
		this.service.updateProduct(product);
        return ResponseEntity.ok().body(product);
		
	}
	@GetMapping("product/available")
	List<Product> getAvailableProducts(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
				return this.service.getAvailableProducts(page, pageSize);
		
	}
	@GetMapping("product/not-available")
	List<Product> getNotAvailableProducts(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
				return this.service.getNotAvailableProducts(page, pageSize);
		
	}
}
