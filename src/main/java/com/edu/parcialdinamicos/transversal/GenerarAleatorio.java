package com.edu.parcialdinamicos.transversal;

public class GenerarAleatorio {

    public static int generarEstado(){
        int aleatorio = 0;

        aleatorio = (int) (Math.random() * 3);
        return aleatorio;
    }

    public static float generarProbabilidadMuerte(){
        float aleatorio = 0;

        aleatorio = (float) (Math.random() * 1);
        return aleatorio;
    }

    public static float generarProbabilidadInmune(){
        float aleatorio = 0;

        aleatorio = (float) (Math.random() * 1);
        return aleatorio;
    }
}
