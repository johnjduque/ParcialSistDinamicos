package com.edu.parcialdinamicos.transversal;

import com.edu.parcialdinamicos.dominio.Persona;
import com.edu.parcialdinamicos.dominio.Poblacion;

public class EvaluarPoblacion {

    public EvaluarPoblacion() {
    }

    public void evaluarPoblacion(Persona [][] poblado, int filas, int columnas, int numeroInteraciones,
                                        int tiempoDeRecuperacion, int tiempoMuerte, float porcentajeSeparado){

        Poblacion situacion = new Poblacion();
        Persona[][] poblacion = poblado;
        GenerarYmostrarPoblacion mostrar = new GenerarYmostrarPoblacion();
        int iteracciones = 1;
        int tiempo = numeroInteraciones;
        int fila = filas;
        int columna = columnas;
        int recuperacion = tiempoDeRecuperacion;
        int tiempoParaMuerte = tiempoMuerte;
        float separado = (fila*columna)*porcentajeSeparado;
        situacion.SituacionPoblacion(poblacion);

        while (iteracciones <= tiempo){
            for (int f=0; f<fila; f++){
                for (int c=0; c<columna; c++){
                    if (poblacion[f][c].getEstado() == 2){
                        if(poblacion[f][c].getProbabilidadInmune()>0.9){
                            if(situacion.getSeparados() < separado){
                                poblacion[f][c].setEstado(0);
                                situacion.setSeparados(situacion.getSeparados() + 1);
                                situacion.setSanos(situacion.getSanos() - 1);
                            }
                            else if (conVecinoEnfermo(poblacion, f, c) == 1) {
                                poblacion[f][c].setEstado(1);
                                situacion.setEnfermos(situacion.getEnfermos() + 1);
                                situacion.setSanos(situacion.getSanos() - 1);
                            }
                        }
                        else if (conVecinoEnfermo(poblacion, f, c) == 1) {
                            poblacion[f][c].setEstado(1);
                            situacion.setEnfermos(situacion.getEnfermos() + 1);
                            situacion.setSanos(situacion.getSanos() - 1);
                        }
                    }
                    else if (poblacion[f][c].getEstado() == 1) {
                        if(poblacion[f][c].getProbabilidadMuerte() > 0.9){
                            if(situacion.getSeparados() < separado){
                                poblacion[f][c].setEstado(0);
                                situacion.setSeparados(situacion.getSeparados() + 1);
                                situacion.setEnfermos(situacion.getEnfermos() - 1);
                            }
                        }
                        else if (poblacion[f][c].getTiempoEnfermo() > recuperacion) {
                            poblacion[f][c].setEstado(2);
                            situacion.setEnfermos(situacion.getEnfermos() - 1);
                            situacion.setSanos(situacion.getSanos() + 1);
                        }
                        else{
                            poblacion[f][c].setTiempoEnfermo(poblacion[f][c].getTiempoEnfermo() + 1);
                        }
                    }
                }
            }
            iteracciones = iteracciones + 1;
            mostrar.mostrarPoblacion(poblacion, fila, columna);

            System.out.println("Los sanos actuales son: "+situacion.getSanos());
            System.out.println("Los enfermos actuales son: "+situacion.getEnfermos());
            System.out.println("Los separados actuales son: "+situacion.getSeparados());
        }
    }


    private int conVecinoEnfermo (Persona[][] poblacion, int filaOrigen, int columnaOrige){

        int filas = poblacion.length;
        int columnas = poblacion[0].length;
        int resultado[][] = revisarVecinoEnfermo(filas, columnas, filaOrigen, columnaOrige);
        int vecinoEnfermo = 0;
        int f = 0, c = 0;

        while (vecinoEnfermo == 0){
            for(int i = 0; i < resultado.length; i++){
                for(int j = 0; j < resultado[0].length; j++){

                    if(j == 0){
                        f = resultado[i][j];
                    } else if (j == 1) {
                        c = resultado[i][j];
                    }
                }
                if(poblacion[f][c].getEstado() == 1){
                    vecinoEnfermo = 1;
                }
            }
        }
        return vecinoEnfermo;
    }

    private int[][] revisarVecinoEnfermo (int filas, int columnas, int filaOrigen, int columnaOrige){

        if(!(filaOrigen >= 0 && filaOrigen <= (filas - 1) && columnaOrige >=0 && columnaOrige <= (columnas - 1))){
            return null;
        }

        int numeroPosiciones;

        if(filaOrigen == 0 || filaOrigen == (filas - 1)){
            if(columnaOrige == 0 || columnaOrige == (columnas - 1)){
                numeroPosiciones = 3;
            }else {
                numeroPosiciones = 5;
            }
        }else {
            if(columnaOrige == 0 || columnaOrige == (columnas - 1)){
                numeroPosiciones = 5;
            }else {
                numeroPosiciones = 8;
            }
        }

        int posiciones[][] = new int[numeroPosiciones][2];
        int indicePosicion = 0;
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){

                if ((i != 0 || j != 0) && (filaOrigen + i) >= 0 && (filaOrigen + i) <= (filas - 1)
                        && (columnaOrige + j) >= 0 && (columnaOrige + j) <= (columnas - 1)){
                    posiciones[indicePosicion][0] = filaOrigen + i;
                    posiciones[indicePosicion][1] = columnaOrige + j;
                    indicePosicion++;
                }
            }
        }

        return posiciones;
    }
}

