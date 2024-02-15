package com.nagarro.mini.java.assignment.util;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
//	@Autowired
//	RegistrationService service;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User("Amit@gmail.com", "Kumar@123", new ArrayList<>());
	}

}
