package com.management.mcams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.mcams.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	public Admin findByUsername(String username);
}
