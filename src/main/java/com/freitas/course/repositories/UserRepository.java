package com.freitas.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freitas.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
