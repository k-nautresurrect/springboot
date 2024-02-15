package com.nagarro.mini.java.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.mini.java.assignment.model.Notes;
import com.nagarro.mini.java.assignment.model.User;
import com.nagarro.mini.java.assignment.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userrepo;

	public void saveuser(User user) {
		userrepo.save(user);

	}

	public List<User> findAllUser() {
		List<User> allUser = userrepo.findAll();

		return allUser;
	}

}
