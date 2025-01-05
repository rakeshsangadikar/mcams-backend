package com.management.mcams.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.mcams.backend.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUsernameAndPassword(String username, String password);
}
