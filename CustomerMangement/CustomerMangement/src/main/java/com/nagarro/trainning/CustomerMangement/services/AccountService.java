package com.nagarro.trainning.CustomerMangement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.trainning.CustomerMangement.entity.Account;
import com.nagarro.trainning.CustomerMangement.entity.AccountType;
import com.nagarro.trainning.CustomerMangement.entity.Customer;
import com.nagarro.trainning.CustomerMangement.repository.AccountRepository;
import com.nagarro.trainning.CustomerMangement.repository.AccountTypeRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository Accountrepo;
	@Autowired
	private AccountTypeRepository Accounttyperepo;

	public void saveAccount(Account account) {

		Accountrepo.save(account);

	}

	public void deleteAccount(int id) {
		Account acc = Accountrepo.getOne(id);
		Accountrepo.delete(acc);

	}

	public List<Account> findAllAccounts() {
		List<Account> allaccounts = Accountrepo.findAll();

		return allaccounts;
	}

	public void updateAccount(Account account) {
		Accountrepo.save(account);

	}

	public Account getaccount(int id) {

		return this.Accountrepo.findById(id).get();

	}

}
