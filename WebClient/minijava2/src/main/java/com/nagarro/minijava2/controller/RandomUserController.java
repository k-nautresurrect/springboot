package com.nagarro.minijava2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.minijava2.Entity.User;
import com.nagarro.minijava2.services.RandomUserService;
import com.nagarro.minijava2.validation.Validator;
import com.nagarro.minijava2.validation.ValidatorFactory;

@RestController
@RequestMapping("/users")
public class RandomUserController {

	@Autowired
	private RandomUserService myUserService;

	@GetMapping("/{feild}")
	public List<User> getAllMyUser(@PathVariable String feild) {
           List<User> users = myUserService.getUser(feild);
		return users;

	}

	@GetMapping("/pagination/{offset}/{pageSize}")
	public Page<User> getUserWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<User> users = myUserService.getUserWithPagination(offset, pageSize);
		return users;
	}

	@GetMapping("/")
	public Page<User> getUserWithPaginationAndSort(@RequestParam(name = "sortType") String sortType,@RequestParam(name = "sortOrder") String sortOrder,@RequestParam(name = "offset") String offset,@RequestParam(name = "limit") String limit) {

		Validator sortTypeValidator = ValidatorFactory.getValidator(sortType);
		if (!sortTypeValidator.validate(sortType)) {
			throw new IllegalArgumentException("Invalid value for sortType");
		}
		Validator numericValidator = ValidatorFactory.getValidator(offset);
		if (!numericValidator.validate(offset) || !numericValidator.validate(limit)) {
			throw new IllegalArgumentException("Invalid value for offset or limit");
		}
		String field = sortType;
		int offSet = Integer.parseInt(offset);
		int pageSize = Integer.parseInt(limit);
		Page<User> users = myUserService.getUserWithPaginationAndSorting(offSet, pageSize, field);

		return users;

	}

}
