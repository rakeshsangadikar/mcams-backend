package com.management.mcams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.mcams.entity.Admin;
import com.management.mcams.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/ping")
	public String ping() {
		return "admin running......";
	}

	@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Admin request) {
        Admin authenticated = adminService.authenticate(request.getUsername(), request.getPassword());
        if (authenticated != null) {
            return ResponseEntity.ok("Login success");
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
