package com.edu.parcialdinamicos.transversal;

import com.edu.parcialdinamicos.dominio.Persona;

public class GenerarYmostrarPoblacion {

    public GenerarYmostrarPoblacion() {
    }

    public Persona [][] generarPoblacion (Persona [][] poblacion, int filas, int columnas){

        Persona [][] poblado = poblacion;
        int fila = filas;
        int columna = columnas;
        int id = 0;

        for (int f=0; f<fila; f++){
            for (int c=0; c<columna; c++){
                int identificacion = id;
                int estado = GenerarAleatorio.generarEstado();
                float probabilidadMuerte = GenerarAleatorio.generarProbabilidadMuerte();
                int tiempoEnfermo = 0;
                float probabilidadInmune = GenerarAleatorio.generarProbabilidadInmune();
                Persona personaActual = new Persona(id,estado,probabilidadMuerte,tiempoEnfermo,probabilidadInmune);
                poblado [f][c] = personaActual;
                id = id + 1;
            }
        }

        return poblado;
    }

    public void mostrarPoblacion (Persona [][] poblacion, int filas, int columnas){

        Persona [][] poblado = poblacion;
        int fila = filas;
        int columna = columnas;
        int id = 0;
        String azul = "\033[34m";
        String negro = "\033[30m";
        String rojo = "\033[31m";

        for (int f=0; f<fila; f++){
            for (int c=0; c<columna; c++){
                if (poblado[f][c].getEstado() == 0){
                    System.out.print(negro + poblado[f][c].getEstado() + " ");
                } else if (poblado[f][c].getEstado() == 1) {
                    System.out.print(rojo + poblado[f][c].getEstado() + " ");
                }
                else {
                        System.out.print(azul + poblado[f][c].getEstado() + " ");
                }
            }
            System.out.println("");
        }
    }
}
