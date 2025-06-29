package com.freitas.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.freitas.course.entities.User;
import com.freitas.course.repositories.UserRepository;
import com.freitas.course.services.exceptions.DatabaseException;
import com.freitas.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TransactionRequiredException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
    @PersistenceContext
    private EntityManager entityManager;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert (User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
	    try {
	        repository.deleteById(id); 
	        entityManager.flush();
	    } catch (TransactionRequiredException e) {
	        throw new ResourceNotFoundException(id);
	    } catch (DataIntegrityViolationException e) {
	    	throw new DatabaseException(e.getMessage());
	    }
	}  
	
	//FAZER UM GIT PARA O UPDATE
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
}
