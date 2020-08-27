package com.spring.boot.web.rest.minishop.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.web.rest.minishop.model.Purchase;
import com.spring.boot.web.rest.minishop.model.User;
import com.spring.boot.web.rest.minishop.model.UserBalance;
import com.spring.boot.web.rest.minishop.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/api/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		
		User result = userService.createUser(user);
		if (result == null) {
			return new ResponseEntity<>("Error creating user!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return ResponseEntity.ok(result);

	}
	@PostMapping("/api/users/balance")
	public ResponseEntity<Object> addBalance(@Valid @RequestBody UserBalance userBalance, Errors errors){
		
		if (errors.hasErrors()) {

			String error = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(","));

			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

		}
		
		User user = userService.getUserByUserName(userBalance.getUserName());
		
		if(user==null) {
			return new ResponseEntity<>("user not found!", HttpStatus.NOT_FOUND);
		}
		
		float result = userService.addBalance(userBalance, user);
		
		return ResponseEntity.ok(result);
		
	}
	
}
