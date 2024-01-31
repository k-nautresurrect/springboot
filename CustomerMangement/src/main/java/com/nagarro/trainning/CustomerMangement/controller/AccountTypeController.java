package com.nagarro.trainning.CustomerMangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainning.CustomerMangement.entity.AccountType;
import com.nagarro.trainning.CustomerMangement.services.AccountTypeService;

@RestController
@RequestMapping("/accountype")
public class AccountTypeController {

	@Autowired
	private AccountTypeService accountTypeService;

	@GetMapping
	public List<AccountType> getAllAccountTypes() {
		return accountTypeService.getAllAccountTypes();
	}

	@PostMapping
	public AccountType createAccountType(@RequestBody AccountType accountType) {
		return accountTypeService.createAccountType(accountType);
	}

}
