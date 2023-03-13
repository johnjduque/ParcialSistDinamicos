package com.edu.parcialdinamicos.aplicacion;

import com.edu.parcialdinamicos.dominio.Persona;
import com.edu.parcialdinamicos.transversal.GenerarYmostrarPoblacion;

public class AppSimulacionEpidemia {

    public static void main(String[] args) {

        int numeroInteraciones = 0;
        int sanos = 0;
        int enfermos = 0;
        int inmunes = 0;
        int muertos = 0;
        int tiempoDeRecuperacion = 0;
        int tiempoMuerte = 0;
        float porcentajeMuerte = 0;
        float porcentajeInmunidad = 0;
        int filas = 20;
        int columnas = 30;

        Persona[][] poblacion = new Persona[filas][columnas];
        GenerarYmostrarPoblacion epidemia = new GenerarYmostrarPoblacion();

        epidemia.generarPoblacion(poblacion,filas,columnas);
        epidemia.mostrarPoblacion(poblacion,filas,columnas);

    }
}
