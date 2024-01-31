package com.nagarro.trainning.CustomerMangement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.trainning.CustomerMangement.entity.Account;
import com.nagarro.trainning.CustomerMangement.entity.Customer;
import com.nagarro.trainning.CustomerMangement.services.AccountService;

@RestController
@RequestMapping("/Account")
public class AccountController {
	@Autowired
	private AccountService accountservice;

	@PostMapping("/")
	public Account addAccount(@RequestBody Account account) {
		accountservice.saveAccount(account);
		return account;
	}

	@DeleteMapping("{id}")
	public String deleteAccount(@PathVariable int id) {

		accountservice.deleteAccount(id);
		return "deleted";

	}

	@GetMapping("/")

	public List<Account> getAccounts() {
		return accountservice.findAllAccounts();

	}

	@PutMapping("/")
	public Account updateAccount(Account account) {
		accountservice.updateAccount(account);
		return account;
	}

	@GetMapping("/{accountid}")
	public Account getaccount(@PathVariable("accountid") int accountid) {
		return this.accountservice.getaccount(accountid);
	}

}
