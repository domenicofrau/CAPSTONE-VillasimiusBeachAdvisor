package com.VillasimiusBeachAdvisor.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@CrossOrigin(origins = "*")
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/auth")
	@PreAuthorize("isAuthenticated()")
	public String autenticatedAccess() {
		return "Autenticated Content.";
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}