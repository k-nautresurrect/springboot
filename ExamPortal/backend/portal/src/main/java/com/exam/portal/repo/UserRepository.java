package com.exam.portal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.portal.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);

}
