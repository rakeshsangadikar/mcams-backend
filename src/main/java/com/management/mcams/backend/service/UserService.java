package com.management.mcams.backend.service;

import com.management.mcams.backend.dto.User;

public interface UserService {

	public void createUser(User user);
	
	public User loginUser(String userName, String password);
	
}
