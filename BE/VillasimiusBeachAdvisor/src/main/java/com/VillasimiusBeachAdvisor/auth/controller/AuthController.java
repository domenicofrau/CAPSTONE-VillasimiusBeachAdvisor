package com.VillasimiusBeachAdvisor.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VillasimiusBeachAdvisor.auth.payload.JWTAuthResponse;
import com.VillasimiusBeachAdvisor.auth.payload.LoginDto;
import com.VillasimiusBeachAdvisor.auth.payload.RegisterDto;
import com.VillasimiusBeachAdvisor.auth.service.AuthService;

@CrossOrigin(origins = "https://villasimiusbeachadvisor.osc-fr1.scalingo.io")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @CrossOrigin(origins = "https://villasimiusbeachadvisor.osc-fr1.scalingo.io")
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        
    	System.out.println("sono entrato");
    	System.out.println(loginDto.getUsername()+ loginDto.getPassword());
    	String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @CrossOrigin(origins = "https://villasimiusbeachadvisor.osc-fr1.scalingo.io")
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    @CrossOrigin(origins = "https://villasimiusbeachadvisor.osc-fr1.scalingo.io")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        authService.deleteUser(id);
        return ResponseEntity.ok("User with id " + id + " deleted successfully");
    }
}