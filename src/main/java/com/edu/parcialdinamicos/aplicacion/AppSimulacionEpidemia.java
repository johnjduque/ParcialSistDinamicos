package com.edu.parcialdinamicos.aplicacion;

import com.edu.parcialdinamicos.dominio.Persona;
import com.edu.parcialdinamicos.transversal.EvaluarPoblacion;
import com.edu.parcialdinamicos.transversal.GenerarYmostrarPoblacion;

public class AppSimulacionEpidemia {

    public static void main(String[] args) {

        int numeroInteraciones = 5;
        int tiempoDeRecuperacion = 2;
        int tiempoMuerte = 1;
        float porcentajeSeparado = (float) 0.5;
        int filas = 4;
        int columnas = 4;

        Persona[][] poblacion = new Persona[filas][columnas];
        GenerarYmostrarPoblacion epidemia = new GenerarYmostrarPoblacion();
        EvaluarPoblacion evaluar = new EvaluarPoblacion();

        epidemia.generarPoblacion(poblacion,filas,columnas);
        evaluar.evaluarPoblacion(poblacion,filas,columnas,numeroInteraciones,tiempoDeRecuperacion,
                tiempoMuerte,porcentajeSeparado);
    }
}
