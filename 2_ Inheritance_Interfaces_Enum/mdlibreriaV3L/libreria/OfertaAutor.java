package org.uma.mbd.mdlibreriaV3L.libreria;

public class OfertaAutor implements OfertaFlex{
    private String[] autores;
    private double porDescuento;

    public OfertaAutor(double pd, String [] at){
        autores = at;
        porDescuento = pd;
    }

    @Override
    public double getDescuento(Libro libro) {
       double descuento = 0;
        if(esAutorEnOferta(libro.getAutor())){
           descuento=porDescuento;
       }
        return descuento;
    }

    private boolean esAutorEnOferta(String aut){
        int i=0;
        while (i < autores.length && !aut.equalsIgnoreCase(autores[i])){
            i++;
        }
        return i<autores.length;
    }






}
