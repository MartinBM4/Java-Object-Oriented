package org.uma.mbd.mdlibreriaV3L.libreria;

public class Libro {

    private String autor;
    private String titulo;
    private double precioBase;
    private static double IVA = 10; //este valor es de CLASE y se pone static para que sea igual para todos

    public Libro(String aut, String tit, double pb){
        autor = aut;        //si en vez de aut pongo autor, tendriamos que poner:
        // (( this.autor = autor )) siendo el segundo autor el aut
        titulo = tit;
        precioBase = pb;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal(){
        return precioBase + precioBase * IVA /100;
    }

    public String toString(){
        return "(" + autor + "; " + titulo + "; " + precioBase + "; " + IVA + "%; " +
                getPrecioFinal() + ")" ;
    }
    // esto lo hacemos con generate + get&setter
    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double IVA) {
        Libro.IVA = IVA;
    }



}
