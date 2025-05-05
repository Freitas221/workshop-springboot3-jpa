package com.freitas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freitas.course.entities.Category;

@Repository //Optional, since JpaRepository is already registered
            //as a Spring component.
public interface CategoryRepository extends JpaRepository<Category, Long>{

}

