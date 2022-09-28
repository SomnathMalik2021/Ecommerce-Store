package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;
import com.example.demo.repo.ProductRepository;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	
	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	public List<Product> getAllProducts(int page,int pageSize){
		return this.productRepository.getAllProducts(page*pageSize, pageSize);
		
	}
	
	public List<Product>getAllProductsByMerchant(String merchant,int page,int pageSize){
				return this.productRepository.getAllProductsByMerchant(merchant, page*pageSize,pageSize);
		
	}
	
	public Product addProduct(@RequestBody Product product){
		return this.productRepository.save(product);
		
	}
	public Product updateProduct(@RequestBody Product product){
		return this.productRepository.save(product);
		
	}
	public List<Product> getAvailableProducts(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
				return this.productRepository.getAvailableProducts(page*pageSize, pageSize);
		
	}
    public List<Product> getNotAvailableProducts(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize){
				return this.productRepository.getNotAvailableProducts(page*pageSize, pageSize);
		
	}
	
}
