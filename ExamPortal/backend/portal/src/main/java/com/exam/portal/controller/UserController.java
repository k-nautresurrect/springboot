package com.exam.portal.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.Role;
import com.exam.portal.entity.User;
import com.exam.portal.entity.UserRole;
import com.exam.portal.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService userservice;


	@PostMapping("/user")
	public User createUser(@RequestBody User user) throws Exception {
//		encoding password with bcryptencoder
//		user.setPassword(this.bcryptpasswordencoder.encode(user.getPassword()));

		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(8L);
		role.setRoleName("Normal");

		UserRole userrole = new UserRole();
		userrole.setUser(user);
		userrole.setRole(role);
		roles.add(userrole);
		return this.userservice.createUser(user, roles);

	}
	@GetMapping("/{username}")
	public User getUser(@PathVariable("username") String username) {
		return this.userservice.getUser(username);
		
	}

}
