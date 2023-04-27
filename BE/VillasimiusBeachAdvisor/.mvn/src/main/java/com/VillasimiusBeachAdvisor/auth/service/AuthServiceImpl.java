package com.VillasimiusBeachAdvisor.auth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.VillasimiusBeachAdvisor.auth.entity.ERole;
import com.VillasimiusBeachAdvisor.auth.entity.Role;
import com.VillasimiusBeachAdvisor.auth.entity.User;
import com.VillasimiusBeachAdvisor.auth.exception.MyAPIException;
import com.VillasimiusBeachAdvisor.auth.exception.ResourceNotFoundException;
import com.VillasimiusBeachAdvisor.auth.payload.LoginDto;
import com.VillasimiusBeachAdvisor.auth.payload.RegisterDto;
import com.VillasimiusBeachAdvisor.auth.repository.RoleRepository;
import com.VillasimiusBeachAdvisor.auth.repository.UserRepository;
import com.VillasimiusBeachAdvisor.auth.security.JwtTokenProvider;
import com.VillasimiusBeachAdvisor.main.entity.Spiaggia;
import com.VillasimiusBeachAdvisor.main.repository.SpiaggiaRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private SpiaggiaRepository spiaggiaRepository;


    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider,
                           SpiaggiaRepository spiaggiaRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.spiaggiaRepository = spiaggiaRepository;
    }

    @Override
    public String login(LoginDto loginDto) {
        
    	Authentication authentication = authenticationManager.authenticate(
        		new UsernamePasswordAuthenticationToken(
        				loginDto.getUsername(), loginDto.getPassword()
        		)
        ); 
    	
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto) {


        if(userRepository.existsByUsername(registerDto.getUsername())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new MyAPIException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setName(registerDto.getName());
        user.setSurname(registerDto.getSurname());
        user.setUsername(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        
        if(registerDto.getRoles() != null) {
	        registerDto.getRoles().forEach(role -> {
	        	Role userRole = roleRepository.findByRoleName(getRole(role)).get();
	        	roles.add(userRole);
	        });
        } else {
        	Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER).get();
        	roles.add(userRole);
        }
        
        user.setRoles(roles);
        System.out.println(user);
        userRepository.save(user);

        return "User registered successfully!.";
    }
    
    public ERole getRole(String role) {
    	if(role.equals("ROLE_ADMIN")) return ERole.ROLE_ADMIN;
    	else if(role.equals("ROLE_MODERATOR")) return ERole.ROLE_MODERATOR;
    	else return ERole.ROLE_USER;
    }
    
    public void aggiungiPreferito(Long utenteId, Long spiaggiaId) {
        User user = userRepository.findById(utenteId)
                .orElseThrow(() -> new MyAPIException(HttpStatus.NOT_FOUND, "User not found"));

        Spiaggia spiaggia = spiaggiaRepository.findById(spiaggiaId)
                .orElseThrow(() -> new MyAPIException(HttpStatus.NOT_FOUND, "Spiaggia not found"));

        user.getSpiagge().add(spiaggia);
        userRepository.save(user);
    }
    
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);
    }
    
}
