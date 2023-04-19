package com.VillasimiusBeachAdvisor.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.VillasimiusBeachAdvisor.main.entity.Spiaggia;
import com.VillasimiusBeachAdvisor.main.repository.SpiaggiaRepository;

import java.util.List;

@Service
public class SpiaggiaService {

    @Autowired
    private SpiaggiaRepository spiaggiaRepository;

    public List<Spiaggia> getAllSpiagge() {
        return spiaggiaRepository.findAll();
    }

    public Spiaggia createSpiaggia(Spiaggia spiaggia) {
        return spiaggiaRepository.save(spiaggia);
    }

    public Spiaggia getSpiaggiaById(Long id) {
        return spiaggiaRepository.findById(id).orElse(null);
    }
}