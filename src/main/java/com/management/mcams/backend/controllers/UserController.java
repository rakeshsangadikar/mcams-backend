package com.management.mcams.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.mcams.backend.dto.User;
import com.management.mcams.backend.exception.BadRequestException;
import com.management.mcams.backend.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/ping")
	public String ping() {
		return "user running......";
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody(required = true) User user) {
		log.info("::::::::::::::Registering user with new ID::::::::::::::");
		if(!StringUtils.hasLength(user.getUserName())) {
			throw new BadRequestException("Username is empty/invalid");
		} else if(!StringUtils.hasLength(user.getUserPassword())) {
			throw new BadRequestException("Password is empty/invalid");
		} else {
//			userService.createUser(user);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password){
		if(!StringUtils.hasLength(username)) {
			throw new BadRequestException("Username is empty/invalid");
		} else if(!StringUtils.hasLength(password)) {
			throw new BadRequestException("Password is empty/invalid");
		} else {
			return new ResponseEntity<User>(userService.loginUser(username, password), HttpStatus.OK);
		}
	}
}
