package com.nagarro.trainning.CustomerMangement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainning.CustomerMangement.entity.AccountType;
import com.nagarro.trainning.CustomerMangement.repository.AccountTypeRepository;

@Service
public class AccountTypeService {

	@Autowired
	private AccountTypeRepository accountTypeRepository;

	public List<AccountType> getAllAccountTypes() {
		return accountTypeRepository.findAll();
	}

	public AccountType createAccountType(AccountType accountType) {
		return accountTypeRepository.save(accountType);
	}

}
