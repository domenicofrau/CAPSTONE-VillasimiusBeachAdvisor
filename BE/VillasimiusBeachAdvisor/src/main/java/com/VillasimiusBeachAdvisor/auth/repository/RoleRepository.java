package com.VillasimiusBeachAdvisor.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VillasimiusBeachAdvisor.auth.entity.ERole;
import com.VillasimiusBeachAdvisor.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
