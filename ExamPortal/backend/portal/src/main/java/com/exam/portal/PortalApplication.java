package com.exam.portal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.portal.entity.Role;
import com.exam.portal.entity.User;
import com.exam.portal.entity.UserRole;
import com.exam.portal.service.UserService;

@SpringBootApplication
public class PortalApplication implements CommandLineRunner {
	@Autowired
	private UserService userservice;
	

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("I am running");
//		User user = new User();
//		user.setFirstname("Amit");
//		user.setLastname("Kumar");
//		user.setUsername("Amit1907");
//		user.setPassword(this.bcryptpasswordencoder.encode(rawPassword:"Amit@123"));
//		user.setEmail("amitkumar2001@gmail.com");
//    	user.setProfile("default.png");
//
//		Role role1 = new Role();
//		role1.setRoleId(7L);
//		role1.setRoleName("ADMIN");
//
//		Set<UserRole> userRoleset = new HashSet<UserRole>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//
//		userRoleset.add(userRole);
//		userservice.createUser(user, userRoleset);
//		System.out.println(user.getUsername());

	}

}
