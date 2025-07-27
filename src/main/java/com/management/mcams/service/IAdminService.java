package com.management.mcams.service;

import com.management.mcams.entity.Admin;

public interface IAdminService {

	public Admin authenticate(String username, String password);
	
}
