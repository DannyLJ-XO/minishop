package com.spring.boot.web.rest.minishop.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.web.rest.minishop.model.Product;
import com.spring.boot.web.rest.minishop.model.Quantity;
import com.spring.boot.web.rest.minishop.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/api/products")
	public ResponseEntity<Object> addItem(@Valid @RequestBody Product product, Errors errors) {
		if (errors.hasErrors()) {

			String error = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}

		Product newProduct = productService.addProduct(product);
		if (newProduct == null) {
			return new ResponseEntity<>("Error adding product!", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(product);

	}

	@PostMapping("/api/products/updatequantity")
	public ResponseEntity<Object> addQuantity(@Valid @RequestBody Quantity quantity, Errors errors) {
		if (errors.hasErrors()) {

			String error = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}

		int status = productService.updateQuantity(quantity);
		if (status == 0) {
			return new ResponseEntity<>("Error updating quantity!", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok("Quantity updated");

	}

	@GetMapping("/api/products/bycatagory")
	public ResponseEntity<Object> displayItem(@RequestParam(value = "category") String category) {

		List<Product> products = productService.getProductByCategory(category);

		return ResponseEntity.ok(products);

	}

	@GetMapping("/api/products")
	public ResponseEntity<Object> displayItem() {

		List<Product> products = productService.getProducts();

		return ResponseEntity.ok(products);
	}

}
