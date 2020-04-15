package org.uma.mbd.mdlibreriaV2L.libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private String [] oferta;
    private double descuento;

    public LibreriaOferta(double des, String[] auOf){
        super(); //aunque si no lo ponemos no pasa nada
        setOferta(des,auOf);
       /* hace lo mismo que:
             descuento =des;
             oferta=auOf; */
    }

    public void setOferta(double d, String [] auOf){
        descuento = d;
        oferta = auOf;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public void addLibro(String a, String t, double p) {
        Libro libro;
        if(esAutorEnOferta(a)){
            libro = new LibroEnOferta(a,t,p,descuento); //este seria LibroEnOferta pero es una vinculacion dinamica

        }else{
            libro = new Libro (a,t,p);

        }
        addLibro(libro);
    }

    private boolean esAutorEnOferta(String aut){
        int i=0;
        while (i < oferta.length && !aut.equalsIgnoreCase(oferta[i])){
            i++;
        }
        return i<oferta.length;
    }

    @Override
    public String toString(){
        return descuento + "%; "+ Arrays.toString(oferta)+
                super.toString();
    }


}
