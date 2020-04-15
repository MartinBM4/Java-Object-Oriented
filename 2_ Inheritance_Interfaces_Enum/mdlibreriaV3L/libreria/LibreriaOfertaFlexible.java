package org.uma.mbd.mdlibreriaV3L.libreria;

public class LibreriaOfertaFlexible extends Libreria {
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex of){
        ofertaFlexible = of;
    }

    @Override
    public void addLibro(String a, String t, double p){
        Libro libro = new Libro (a,t,p);
        double descuento = ofertaFlexible.getDescuento(libro);
        if(descuento >0){
            libro = new LibroEnOferta(a,t,p,descuento);
        }
        addLibro(libro);
    }

}
