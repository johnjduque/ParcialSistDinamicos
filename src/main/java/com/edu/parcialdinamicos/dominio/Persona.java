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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setProbabilidadMuerte(float probabilidadMuerte) {
        this.probabilidadMuerte = probabilidadMuerte;
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

    public void setProbabilidadInmune(float probabilidadInmune) {
        this.probabilidadInmune = probabilidadInmune;
    }
}
