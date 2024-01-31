package com.nagarro.trainning.CustomerMangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.trainning.CustomerMangement.entity.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {

}
