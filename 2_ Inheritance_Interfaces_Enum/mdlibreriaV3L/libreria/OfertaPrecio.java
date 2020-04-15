package org.uma.mbd.mdlibreriaV3L.libreria;

public class OfertaPrecio implements OfertaFlex{
    private double umbralPrecio;
    private double porDescuento;

    public OfertaPrecio(double pd,double u){
        umbralPrecio = u;
        porDescuento = pd;
    }

    @Override
    public double getDescuento(Libro libro){
        double descuento = 0;
        if(libro.getPrecioBase() >= umbralPrecio){
            descuento = porDescuento;
        }
        return descuento;
    }
}
