package com.freitas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freitas.course.entities.Category;
import com.freitas.course.repositories.CategoryRepository;
import com.freitas.course.services.exceptions.ResourceAlreadyExistsException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
	public Category insert(Category obj ) {
		repository.findByName(obj.getName())
	    .ifPresent(existing -> {
	        throw new ResourceAlreadyExistsException("Categoria já cadastrada: " + obj.getName());
	    });
		
		return obj;
	}
}
