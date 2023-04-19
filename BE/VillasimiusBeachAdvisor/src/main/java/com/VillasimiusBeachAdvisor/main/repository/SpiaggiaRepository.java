package com.VillasimiusBeachAdvisor.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.VillasimiusBeachAdvisor.main.entity.Spiaggia;

@Repository
public interface SpiaggiaRepository extends JpaRepository<Spiaggia, Long> {
}