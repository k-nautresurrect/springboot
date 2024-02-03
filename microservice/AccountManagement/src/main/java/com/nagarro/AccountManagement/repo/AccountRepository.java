package com.nagarro.AccountManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.AccountManagement.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account getByAccountNumber(String accountNumber);

}
