package com.VillasimiusBeachAdvisor.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.VillasimiusBeachAdvisor.main.entity.Spiaggia;
import com.VillasimiusBeachAdvisor.main.service.SpiaggiaService;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/spiagge")
public class SpiaggiaController {

    @Autowired
    private SpiaggiaService spiaggiaService;

    @GetMapping
    public List<Spiaggia> getAllSpiagge() {
        return spiaggiaService.getAllSpiagge();
    }
    
    @GetMapping("/{id}/image")
    public ResponseEntity<Resource> getImagenSpiaggia(@PathVariable Long id) {
        Spiaggia spiaggia = spiaggiaService.getSpiaggiaById(id);
        if (spiaggia != null && spiaggia.getImageUrl() != null) {
            try {
                Path filePath = Paths.get(spiaggia.getImageUrl());
                Resource resource = new UrlResource(filePath.toUri());
                if (resource.exists()) {
                    return ResponseEntity.ok()
                            .header(HttpHeaders.CONTENT_TYPE, "image/jpeg")
                            .body(resource);
                }
            } catch (Exception e) {
            }
        }

        return ResponseEntity.notFound().build();
    }
}