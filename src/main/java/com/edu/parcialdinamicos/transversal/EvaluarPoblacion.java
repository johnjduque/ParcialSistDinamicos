package com.edu.parcialdinamicos.transversal;

import com.edu.parcialdinamicos.dominio.Persona;
import com.edu.parcialdinamicos.dominio.Poblacion;

public class EvaluarPoblacion {

    public EvaluarPoblacion() {
    }

    public void evaluarPoblacion(Persona [][] poblado, int filas, int columnas, int numeroInteraciones,
                                        int tiempoDeRecuperacion, float porcentajeSeparado){

        Poblacion situacion = new Poblacion();
        MostrarPoblacion mostrar = new MostrarPoblacion();
        int iteracciones = 1;
        float separado = (filas*columnas)*porcentajeSeparado;
        situacion.SituacionPoblacion(poblado);
        String azul = "\033[34m";
        String rojo = "\033[31m";
        String verde = "\033[32m";
        System.out.println("Poblacion Inicial");
        mostrar.mostrarPoblacion(poblado, filas, columnas);

        System.out.println(azul + "Los sanos actuales son: "+situacion.getSanos());
        System.out.println(verde + "Los enfermos actuales son: "+situacion.getEnfermos());
        System.out.println(rojo + "Los separados actuales son: "+situacion.getSeparados());
        System.out.println("");

        while (iteracciones < numeroInteraciones+1){
            for (int f=0; f<filas; f++){
                for (int c=0; c<columnas; c++){
                    if (poblado[f][c].getEstado() == 2){
                        if(poblado[f][c].getProbabilidadInmune()>0.9){
                            if(situacion.getSeparados() < separado){
                                poblado[f][c].setEstado(0);
                                situacion.setSeparados(situacion.getSeparados() + 1);
                                situacion.setSanos(situacion.getSanos() - 1);
                            }
                            else if (conVecinoEnfermo(poblado, f, c) == 1) {
                                poblado[f][c].setEstado(1);
                                situacion.setEnfermos(situacion.getEnfermos() + 1);
                                situacion.setSanos(situacion.getSanos() - 1);
                            }
                        }
                        else if (conVecinoEnfermo(poblado, f, c) == 1) {
                            poblado[f][c].setEstado(1);
                            situacion.setEnfermos(situacion.getEnfermos() + 1);
                            situacion.setSanos(situacion.getSanos() - 1);
                        }
                    }
                    else if (poblado[f][c].getEstado() == 1) {
                        if(poblado[f][c].getProbabilidadMuerte() > 0.9){
                            if(situacion.getSeparados() < separado){
                                poblado[f][c].setEstado(0);
                                situacion.setSeparados(situacion.getSeparados() + 1);
                                situacion.setEnfermos(situacion.getEnfermos() - 1);
                            }
                        }
                        else if (poblado[f][c].getTiempoEnfermo() > tiempoDeRecuperacion) {
                            poblado[f][c].setEstado(2);
                            situacion.setEnfermos(situacion.getEnfermos() - 1);
                            situacion.setSanos(situacion.getSanos() + 1);
                        }
                        else{
                            poblado[f][c].setTiempoEnfermo(poblado[f][c].getTiempoEnfermo() + 1);
                        }
                    }
                }
            }
            mostrar.mostrarPoblacion(poblado, filas, columnas);

            System.out.println(azul + "Los sanos actuales son: "+situacion.getSanos());
            System.out.println(verde + "Los enfermos actuales son: "+situacion.getEnfermos());
            System.out.println(rojo + "Los separados actuales son: "+situacion.getSeparados());
            System.out.println("Numero iteracion: " + iteracciones);
            System.out.println("");
            iteracciones = iteracciones + 1;
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

