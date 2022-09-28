package com.example.demo.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Product;




public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value="select * from Products order by product_id limit :pageSize offset :pageStart",nativeQuery=true)
	List<Product> getAllProducts(@Param("pageStart") int i,@Param("pageSize") int pageSize);
	
	@Query(value="select * from Products where merchant=:merchant order by product_id limit :pageSize offset :pageStart",nativeQuery=true)
	List<Product>getAllProductsByMerchant(@Param("merchant") String merchant,@Param("pageStart") int i,@Param("pageSize") int pageSize);
	
	@Query(value="select * from Products where inventory>0 order by product_id limit :pageSize offset :pageStart",nativeQuery=true)
	List<Product> getAvailableProducts(@Param("pageStart") int i,@Param("pageSize") int pageSize);
	
	@Query(value="select * from Products where inventory=0 order by product_id limit :pageSize offset :pageStart",nativeQuery=true)
	List<Product> getNotAvailableProducts(@Param("pageStart") int i,@Param("pageSize") int pageSize);
}
	
	
