package com.VillasimiusBeachAdvisor.main.util;

public enum DirezioneVento {
    TRAMONTANA(0, 20),
    GRECALE(21, 69),
    LEVANTE(70, 109),
    SCIROCCO(110, 159),
    OSTRO(160, 199),
    LIBECCIO(200,249),
    PONENTE(250, 289),
    MAESTRALE(290, 360);

    private final int minDirection;
    private final int maxDirection;

    DirezioneVento(int minDirection, int maxDirection) {
        this.minDirection = minDirection;
        this.maxDirection = maxDirection;
    }

    public int getMinDirection() {
        return minDirection;
    }

    public int getMaxDirection() {
        return maxDirection;
    }
    
}