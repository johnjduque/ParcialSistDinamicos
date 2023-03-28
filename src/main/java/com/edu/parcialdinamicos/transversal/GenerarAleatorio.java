package com.edu.parcialdinamicos.transversal;

public class GenerarAleatorio {

    public static int generarEstado(){
        float aleatorio;
        int estado;
        aleatorio = (float) (Math.random() * 3);

        if(aleatorio<=0.7){
            estado = 0;
        } else if (aleatorio>0.7 && aleatorio<=1.3) {
            estado = 1;
        }
        else {
            estado = 2;
        }
        return estado;
    }

    public static float generarProbabilidadMuerte(){
        float aleatorio;

        aleatorio = (float) (Math.random() * 1);
        return aleatorio;
    }

    public static float generarProbabilidadInmune(){
        float aleatorio;

        aleatorio = (float) (Math.random() * 1);
        return aleatorio;
    }
}
