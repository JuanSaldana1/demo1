package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<User> listAllUsers() {
		return userRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<User> createProduct(@RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI userURI = URI.create("/users♦/" + savedUser.getId());
		return ResponseEntity.created(userURI).body(savedUser);
	}
}
