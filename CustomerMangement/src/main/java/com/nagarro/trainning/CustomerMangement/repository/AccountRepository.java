package com.nagarro.trainning.CustomerMangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.trainning.CustomerMangement.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
