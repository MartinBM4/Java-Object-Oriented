package org.uma.mbd.mdlibreriaV2L.libreria;

public class LibroEnOferta extends Libro{
    private double descuento;
    private double precioFinal;

    public LibroEnOferta(String aut, String tit, double pb, double des) {
        super(aut,tit,pb);
        descuento = des;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public double getPrecioFinal() {
        double px = getPrecioBase() - getPrecioBase() *  descuento / 100;
        return px + px * getIVA() / 100 ;
    }

    @Override
    public String toString(){
        return "("+getAutor() +"; "+getTitulo() +"; " +
                getPrecioBase() + "; " + descuento + "%; "+
                (getPrecioBase() - getPrecioBase() *  descuento / 100) + "; "+
                getIVA() + "%; "+getPrecioFinal() +")";
    }
}
