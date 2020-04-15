package org.uma.mbd.mdCoches.coches;

public class CocheImportado extends Coche{
    private double homologacion;

    public CocheImportado(String n, double p, double h) {
        super(n, p);
        homologacion = h;
    }

    @Override
    public double precioTotal(){
        return super.precioTotal() + homologacion;
    }
//en esta clase no hemos puesto un toString, entonces a la hora de ejecutar
    //llama al de arriba solo (Coche)
}

