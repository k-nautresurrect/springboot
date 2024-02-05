package com.nagarro.minijava2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.minijava2.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
    private UserService userServices;


	@PostMapping("/{size}")
	public void addUser(@PathVariable int size) {
	userServices.postUsers(size);
		
	}  
    
}
