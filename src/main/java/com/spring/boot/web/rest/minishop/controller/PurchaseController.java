package com.spring.boot.web.rest.minishop.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.web.rest.minishop.model.Purchase;
import com.spring.boot.web.rest.minishop.model.User;
import com.spring.boot.web.rest.minishop.service.PurchaseService;
import com.spring.boot.web.rest.minishop.service.UserService;

@RestController
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;
	@Autowired
	UserService userService;
	
	@PostMapping("/api/products/purchase")
	public ResponseEntity<Object> perchaseProduct(@Valid @RequestBody Purchase purchase, Errors errors) {
		System.out.println(purchase);
		if (errors.hasErrors()) {
			
			String error = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}

		Purchase purchaseStatus = purchaseService.productPurchase(purchase);
		if (purchaseStatus == null) {
			return new ResponseEntity<>("Error performing purchase!", HttpStatus.NOT_MODIFIED);
		}

		return ResponseEntity.ok(purchaseStatus);

	}
	
	@GetMapping("/api/users/purchase/{userName}")
	public ResponseEntity<Object> displayPurchaseHistory(@PathVariable("userName") String name) {
		
//		purchase history contains --> 
		/* User full name, UserDAO getUserByUserName
		 * Product name , 
		 * Product code , 
		 * Product description, 
		 * Product category, 
		 * product price, 
		 * Purchase date,
		 * Purchase quantity
	   */ 

		if (name == null) {
			
			return new ResponseEntity<>("User Name not found!", HttpStatus.BAD_REQUEST);
		}

		User user = userService.getUserByUserName(name);

		if (user == null) {
			
			return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	

}
