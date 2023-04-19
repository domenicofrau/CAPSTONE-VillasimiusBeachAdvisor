package com.VillasimiusBeachAdvisor.auth.runner;

import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.VillasimiusBeachAdvisor.auth.entity.ERole;
import com.VillasimiusBeachAdvisor.auth.entity.Role;
import com.VillasimiusBeachAdvisor.auth.entity.User;
import com.VillasimiusBeachAdvisor.auth.payload.RegisterDto;
import com.VillasimiusBeachAdvisor.auth.repository.RoleRepository;
import com.VillasimiusBeachAdvisor.auth.repository.UserRepository;
import com.VillasimiusBeachAdvisor.auth.service.AuthService;


@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Running --> ...................");
		//setRoleDefault();
		//setUserDefault();
	}
	
	@SuppressWarnings("unused")
	public void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		roleRepository.save(moderator);
		
		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		userRole = new HashSet<Role>();
		userRole.add(user);
	}
	
	@SuppressWarnings("unused")
	public void setUserDefault() {
		

		Set<String> roleAdmin = new HashSet<>(
				adminRole.stream()
						.map(r -> r.getRoleName().toString())
						.collect(Collectors.toList())
				);
		Set<String> roleModerator = new HashSet<>(
				moderatorRole.stream()
						.map(r -> r.getRoleName().toString())
						.collect(Collectors.toList())
				);
		Set<String> roleUser = new HashSet<>(
				userRole.stream()
						.map(r -> r.getRoleName().toString())
						.collect(Collectors.toList())
				);
		
		
		RegisterDto userAdmin = new RegisterDto();
		userAdmin.setName("Admin");
		userAdmin.setSurname("Admin");
		userAdmin.setUsername("admin");
		userAdmin.setEmail("admin@example.com");
		userAdmin.setPassword(passwordEncoder.encode("admin"));
		userAdmin.setRoles(roleAdmin);
		System.out.println(authService.register(userAdmin));
		
		RegisterDto simpleUser = new RegisterDto();
		simpleUser.setName("Mario");
		simpleUser.setSurname("Rossi");
		simpleUser.setUsername("mariorossi");
		simpleUser.setEmail("m.rossi@example.com");
		simpleUser.setPassword(passwordEncoder.encode("12345"));
		simpleUser.setRoles(roleUser);
		System.out.println(authService.register(simpleUser));
		
		RegisterDto userModerator = new RegisterDto();
		userModerator.setName("Giuseppe");
		userModerator.setSurname("Verdi");
		userModerator.setUsername("giuseppeverdi");
		userModerator.setEmail("g.verdi@example.com");
		userModerator.setPassword(passwordEncoder.encode("12345"));
		userModerator.setRoles(roleModerator);
		System.out.println(authService.register(userModerator));
	}

}
