package com.edu.parcialdinamicos.dominio;

public class Persona {

    private int id;
    private int estado;
    private float probabilidadMuerte;
    private int tiempoEnfermo;
    private float probabilidadInmune;

    public Persona(int id, int estado, float probabilidadMuerte, int tiempoEnfermo, float probabilidadInmune) {
        this.id = id;
        this.estado = estado;
        this.probabilidadMuerte = probabilidadMuerte;
        this.tiempoEnfermo = tiempoEnfermo;
        this.probabilidadInmune = probabilidadInmune;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public float getProbabilidadMuerte() {
        return probabilidadMuerte;
    }

    public int getTiempoEnfermo() {
        return tiempoEnfermo;
    }

    public void setTiempoEnfermo(int tiempoEnfermo) {
        this.tiempoEnfermo = tiempoEnfermo;
    }

    public float getProbabilidadInmune() {
        return probabilidadInmune;
    }
}
