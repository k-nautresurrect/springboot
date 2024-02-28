package com.nagarro.mini.java.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.mini.java.assignment.model.User;
import com.nagarro.mini.java.assignment.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;

	@PostMapping("/User")
	public User addUser(@RequestBody User user) {
		userservice.saveuser(user);
		return user;
	}

	@GetMapping("/getUser")

	public List<User> getUser() {
		return userservice.findAllUser();

	}

}
