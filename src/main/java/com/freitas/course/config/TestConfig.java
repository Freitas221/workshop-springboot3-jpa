package com.freitas.course.config;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.freitas.course.entities.User;
import com.freitas.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com,", "98888888", "123456");
		User u2 = new User(null, "Alex Malta", "alex@gmail.com,", "97777777", "654321");
		
		userRepository.saveAll(Arrays.asList(u1, u2));

	}
}
