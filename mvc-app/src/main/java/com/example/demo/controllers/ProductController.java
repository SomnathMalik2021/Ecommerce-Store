package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Order;
import com.example.demo.entity.Product;

@Controller
public class ProductController {

	@Autowired
	private RestTemplate template;
	
	@GetMapping(path="/product-section/{pageNo}")
	public String getProducts(@PathVariable("pageNo") int pageNo,Model model) {
	    ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICES/api/v1/product/list?page="+pageNo+"&pageSize=5", Product[].class) ;
	    model.addAttribute("isSearching", false);
	    model.addAttribute("pageNo", pageNo); 
    	model.addAttribute("hasNextPage", products.getBody().length !=0 );
	    model.addAttribute("products", products.getBody());
		return "products" ; 
	}
	
	@PostMapping(path="/product-section/search/{pageNo}")
	public String getProductsByMerchant(@RequestParam("merchant") String merchant,@PathVariable("pageNo") int pageNo,Model model) {
	    ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICES/api/v1/product/list/"+merchant+"?page="+pageNo+"&pageSize=5", Product[].class) ;
	    System.out.println(products.getBody());
	    model.addAttribute("merchant", merchant);
	    model.addAttribute("isSearching", true);
    	model.addAttribute("pageNo", pageNo);
    	model.addAttribute("hasNextPage", !(products.getBody().length==0));
	    model.addAttribute("products", products.getBody());
		return "products" ; 
	}
	@GetMapping(path="/product-section/search/{merchant}/{pageNo}")
	public String getProductsByMerchantWithPaging(@PathVariable("merchant") String merchant,@PathVariable("pageNo") int pageNo,Model model) {
	    ResponseEntity<Product[]> products  = template.getForEntity("lb://PRODUCT-SERVICES/api/v1/product/list/"+merchant+"?page="+pageNo+"&pageSize=5", Product[].class) ;
	    System.out.println(products.getBody());
	    model.addAttribute("merchant", merchant);
	    model.addAttribute("isSearching", true);
    	model.addAttribute("pageNo", pageNo);
    	model.addAttribute("hasNextPage", !(products.getBody().length==0));
	    model.addAttribute("products", products.getBody());
		return "products" ; 
	}
	@GetMapping(path="/product-section/addOrUpdate/{addOrUpdate}")
	public String AddOrUpdateProducts(@PathVariable("addOrUpdate") String addorUpdate,Model model) {
    model.addAttribute("addOrUpdate",addorUpdate);
		return "addAndUpdateProduct" ; 
	}
	@PostMapping(path="/product-section/addOrUpdate/0")
	public String addProduct(@RequestParam("product_id") String product_id,
			@RequestParam("ProductName") String ProductName,
			@RequestParam("merchant") String merchant,
			@RequestParam("inventory") String inventory,Model model){
		Product requestProduct = new Product(Integer.parseInt(product_id), ProductName, merchant, Integer.parseInt(inventory));
		ResponseEntity<Product> products  = template.postForEntity("lb://PRODUCT-SERVICES/api/v1/product/save",requestProduct , Product.class);
		model.addAttribute("addOrUpdate",0);
		
		return "addAndUpdateProduct";
	}
	@PostMapping(path="/product-section/addOrUpdate/1")
	public String upDateProduct(@RequestParam("product_id") String product_id,
			@RequestParam("ProductName") String ProductName,
			@RequestParam("merchant") String merchant,
			@RequestParam("inventory") String inventory,Model model){
		Product requestProduct = new Product(Integer.parseInt(product_id), ProductName, merchant, Integer.parseInt(inventory));
		ResponseEntity<Product> products  = template.postForEntity("lb://PRODUCT-SERVICES/api/v1/product/save",requestProduct , Product.class);
		template.put("lb://PRODUCT-SERVICES/api/v1/product/save",requestProduct);
		model.addAttribute("addOrUpdate",1);
		return "addAndUpdateProduct";
	}
	
}
