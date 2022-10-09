package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping
	public List<Product> listAllProducts(){
		return productRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product savedProduct = productRepository.save(product);
		URI productURI = URI.create("/products/" + savedProduct.getId()) ;
		return ResponseEntity.created(productURI).body(savedProduct);
	}
}
