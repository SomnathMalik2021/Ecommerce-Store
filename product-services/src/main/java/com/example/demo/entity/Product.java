package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Products")
public class Product {

	@Id
	@Column(name="product_id")
	int productId;
	
	@Column(name="product_name")
	String productName;
	
	@Column(name="merchant")
	String merchant;
	
	@Column(name="inventory")
	int inventory;
}
