package com.nagarro.mini.java.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.mini.java.assignment.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
