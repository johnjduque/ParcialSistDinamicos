package com.edu.parcialdinamicos.transversal;

import com.edu.parcialdinamicos.dominio.Persona;

public class GenerarPoblacion {

    public GenerarPoblacion() {
    }

    public Persona [][] generarPoblacion (Persona [][] poblacion, int filas, int columnas){

        int id = 0;

        for (int f=0; f<filas; f++){
            for (int c=0; c<columnas; c++){
                int estado = GenerarAleatorio.generarEstado();
                float probabilidadMuerte = GenerarAleatorio.generarProbabilidadMuerte();
                int tiempoEnfermo = 0;
                float probabilidadInmune = GenerarAleatorio.generarProbabilidadInmune();
                Persona personaActual = new Persona(id,estado,probabilidadMuerte,tiempoEnfermo,probabilidadInmune);
                poblacion [f][c] = personaActual;
                id = id + 1;
            }
        }

        return poblacion;
    }
}
