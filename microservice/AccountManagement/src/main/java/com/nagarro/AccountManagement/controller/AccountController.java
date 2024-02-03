package com.nagarro.AccountManagement.controller;

import java.io.InvalidClassException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.AccountManagement.domain.Account;
import com.nagarro.AccountManagement.dto.AccountCustomerDetail;
import com.nagarro.AccountManagement.dto.AccountDetail;
import com.nagarro.AccountManagement.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/deposit")
	public AccountDetail depositMoney(@RequestBody AccountDetail accountDetail) throws InvalidClassException {
		accountService.addMoney(accountDetail);
		return accountDetail;
	}

	@PostMapping("/withdraw")
	public AccountDetail withdrawMoney(@RequestBody AccountDetail accountDetail) throws InvalidClassException {
		accountService.withdrawlMoney(accountDetail);
		return accountDetail;
	}

	@DeleteMapping("{accountNumber}")
	public String deleteAccount(@PathVariable String accountNumber) {

		accountService.deleteAccount(accountNumber);
		return "deleted";

	}

	@GetMapping("/")
	public List<Account> getAccounts() {
		return accountService.findAllAccounts();

	}

	@GetMapping("/{accountNumber}")
	public AccountCustomerDetail getaccount(@PathVariable("accountNumber") String accountNumber) {
		return this.accountService.getAccount(accountNumber);
	}

}
