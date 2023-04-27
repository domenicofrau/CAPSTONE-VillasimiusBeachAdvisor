package com.VillasimiusBeachAdvisor.auth.service;

import com.VillasimiusBeachAdvisor.auth.payload.LoginDto;
import com.VillasimiusBeachAdvisor.auth.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
    void aggiungiPreferito(Long utenteId, Long spiaggiaId);
    void deleteUser(Long id);
}
