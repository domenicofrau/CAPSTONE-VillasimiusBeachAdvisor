package com.VillasimiusBeachAdvisor.main.entity;

import java.util.List;

import com.VillasimiusBeachAdvisor.main.util.DirezioneVento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Spiaggia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<DirezioneVento> ottimaDirezioneVento;
    private List<DirezioneVento> pessimaDirezioneVento;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double latitudine;

    @Column(nullable = false)
    private Double longitudine;
    
    @Column(nullable = false)
    private String descrizione;
    
    @Column
    private String condizione;
    
    @Column
    private String imageUrl;
}
