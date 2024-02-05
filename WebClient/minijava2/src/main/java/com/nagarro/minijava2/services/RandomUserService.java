package com.nagarro.minijava2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nagarro.minijava2.Entity.Pageinfo;
import com.nagarro.minijava2.Entity.User;
import com.nagarro.minijava2.Repository.UserRepository;

@Service
public class RandomUserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> getUser(String feild) {
		List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, feild));
		return users;
	}

	public Page<User> getUserWithPagination(int offset, int pageSize) {
		Page<User> users = userRepository.findAll(PageRequest.of(offset, pageSize));
		return users;
	}

	public Page<User> getUserWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<User> users = userRepository
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(Sort.Direction.ASC, field)));

		boolean hasNext = users.hasNext();
		boolean hasPrevious = users.hasPrevious();

		Pageinfo<User> customPage = new Pageinfo<>(users.getContent(), PageRequest.of(offset, pageSize), hasNext,
				hasPrevious);

		return customPage;
	}

}
