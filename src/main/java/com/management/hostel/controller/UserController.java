package com.management.hostel.controller;

import com.management.hostel.model.UserEntity;
import com.management.hostel.model.dto.response.UserResponse;
import com.management.hostel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1.0/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/search/{emailId}")
	public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String emailId) {
		return new ResponseEntity<>(userService.findUserById(emailId), HttpStatus.OK);
	}

	@GetMapping("/search/all")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UserResponse> registerUser(@RequestBody UserEntity user) {
		return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
	}

}
