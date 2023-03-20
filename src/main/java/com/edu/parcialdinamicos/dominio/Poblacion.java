package com.edu.parcialdinamicos.dominio;

public class Poblacion {

    private int sanos = 0;
    private int enfermos = 0;
    private int separados = 0;

    public Poblacion() {
    }

    public void SituacionPoblacion(Persona[][] matrizPoblacion){

        Persona[][] poblacion = matrizPoblacion;
        int fila = poblacion.length;
        int columna = poblacion[0].length;

        for (int f=0; f<fila; f++){
            for (int c=0; c<columna; c++){
                if (poblacion[f][c].getEstado() == 0){
                    separados = separados + 1;
                } else if (poblacion[f][c].getEstado() == 1) {
                    enfermos = enfermos + 1;
                }
                else {
                    sanos = sanos + 1;
                }
            }
        }
    }

    public int getSanos() {
        return sanos;
    }

    public int getEnfermos() {
        return enfermos;
    }

    public int getSeparados() {
        return separados;
    }

    public void setSanos(int sanos) {
        this.sanos = sanos;
    }

    public void setEnfermos(int enfermos) {
        this.enfermos = enfermos;
    }

    public void setSeparados(int separados) {
        this.separados = separados;
    }
}
