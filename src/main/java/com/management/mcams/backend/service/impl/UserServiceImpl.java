package com.management.mcams.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.mcams.backend.dto.User;
import com.management.mcams.backend.exception.NotFoundException;
import com.management.mcams.backend.repository.UserRepository;
import com.management.mcams.backend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

//	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User loginUser(String userName, String password) {
		User user = userRepository.findByUsernameAndPassword(userName, password);
		if(user != null) {
			return user;
		} else {
			throw new NotFoundException("User doesn't exists");
		}
	}
}
