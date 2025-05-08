package com.freitas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freitas.course.entities.Product;

@Repository //Optional, since JpaRepository is already registered
            //as a Spring component.
public interface ProductRepository extends JpaRepository<Product, Long>{

}

