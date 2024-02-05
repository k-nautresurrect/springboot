package com.exam.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.entity.exam.Category;
import com.exam.portal.repo.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository catrepo;
	
	public void addCategory(Category category) {
		catrepo.save(category);

	}

	public void deleteCategory(Long id) {
		Category cat = catrepo.getOne(id);
		catrepo.delete(cat);

	}

	public List<Category> findAllCategories() {
		List<Category> allCategories = catrepo.findAll();

		return allCategories;
	}

	public void updateCategory(Category category) {
		catrepo.save(category);

	}
	public Category getCategory(Long id) {
		
		return this.catrepo.findById(id).get();
		
	}

}
