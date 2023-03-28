package com.edu.parcialdinamicos.transversal;

import com.edu.parcialdinamicos.dominio.Persona;

public class MostrarPoblacion {

    public MostrarPoblacion() {
    }

    public void mostrarPoblacion (Persona[][] poblacion, int filas, int columnas){

        String azul = "\033[34m";
        String rojo = "\033[31m";
        String verde = "\033[32m";

        for (int f=0; f<filas; f++){
            for (int c=0; c<columnas; c++){
                if (poblacion[f][c].getEstado() == 0){
                    System.out.print(rojo + poblacion[f][c].getEstado() + " ");
                } else if (poblacion[f][c].getEstado() == 1) {
                    System.out.print(verde + poblacion[f][c].getEstado() + " ");
                }
                else if(poblacion[f][c].getEstado() == 2){
                    System.out.print(azul + poblacion[f][c].getEstado() + " ");
                }
            }
            System.out.println("");
        }
    }
}
