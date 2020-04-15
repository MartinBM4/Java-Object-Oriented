package org.uma.mbd.mdUrna.urnas;

import java.util.Random;
import java.util.NoSuchElementException;

public class Urna {
    public static enum ColorBola{Blanca, Negra};
    public static Random alea = new Random();
    public int blancas;
    public int negras;

    public Urna(int nb, int nn){
        if (nb >=0 && nn >=0 && nb+nn >0){
            blancas =nb;
            negras=nn;
        }else{
            throw new IllegalArgumentException("Bolas invalidas");
        }
    }

    public void ponerBlanca(){
        blancas++;
    }
    public void ponerNegra(){
        negras++;
    }

    public int totalBolas(){
        return blancas + negras;
    }

    public ColorBola extraerBola (){
        int t = totalBolas();
        if(t==0){
            throw new NoSuchElementException("No hay bolas");
        }
        int va = alea.nextInt(t);
        ColorBola salida;
        if (va < blancas){
            //blanca
            salida = ColorBola.Blanca;
            blancas--;
        }else{
            //negra
            salida= ColorBola.Negra;
            negras--;
        }
        return salida;
    }
    public String toString (){
        return "U(" + blancas + ", " + negras + ")";
    }

}
