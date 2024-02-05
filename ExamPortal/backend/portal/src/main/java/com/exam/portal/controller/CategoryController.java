package com.exam.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.portal.entity.exam.Category;
import com.exam.portal.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
	@Autowired
	private CategoryService catservice;

	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
		catservice.addCategory(category);
		return category;
	}

	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable long id) {

		catservice.deleteCategory(id);
		return "deleted";

	}

	@GetMapping("/")

	public List<Category> getCategories() {
		return catservice.findAllCategories();

	}

	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		catservice.updateCategory(category);
		return category;
	}

	@GetMapping("/{categoryid}")
	public Category getcategory(@PathVariable("categoryid") Long categoryid) {
		return this.catservice.getCategory(categoryid);
	}

}
