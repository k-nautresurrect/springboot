package com.nagarro.minijava2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.minijava2.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
