package com.edu.parcialdinamicos.aplicacion;

import com.edu.parcialdinamicos.dominio.Persona;
import com.edu.parcialdinamicos.transversal.EvaluarPoblacion;
import com.edu.parcialdinamicos.transversal.GenerarPoblacion;

public class AppSimulacionEpidemia {

    public static void main(String[] args) {

        int numeroInteraciones = 10;
        int tiempoDeRecuperacion = 3;
        float porcentajeSeparado = (float) 0.2;
        int filas = 5;
        int columnas = 5;

        Persona[][] poblacion = new Persona[filas][columnas];
        GenerarPoblacion epidemia = new GenerarPoblacion();
        EvaluarPoblacion evaluar = new EvaluarPoblacion();

        poblacion = epidemia.generarPoblacion(poblacion, filas, columnas);
        evaluar.evaluarPoblacion(poblacion,filas,columnas,numeroInteraciones,tiempoDeRecuperacion,
                porcentajeSeparado);
    }
}
