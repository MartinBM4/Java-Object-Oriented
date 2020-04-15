package org.uma.mbd.mdBancoV1L.Bancos;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cuenta> ctas;
    private String nombre;
    //snc=siguiente numero de cuenta libre
    private int snc;
    private static final int PRIMER_NUM_CTA = 1001;

    public Banco(String nameB){
        nombre=nameB;
        ctas = new ArrayList<>();
        snc = PRIMER_NUM_CTA;
    }

    public int abrirCuenta(String name, double sal){
        Cuenta cuenta = new Cuenta(name,snc,sal);
        ctas.add(cuenta);
        snc++;
        return snc-1;
    }

    public int abrirCuenta(String name){
        return this.abrirCuenta(name,0);
    }

    public void cerrarCuenta(int nc){
        int pos = posicionCuenta(nc);
        if(pos != ctas.size()) {
            ctas.remove(pos);
        }
    }

    public int posicionCuenta(int nCuenta){
        int pos = 0;
        while(pos<ctas.size() && ctas.get(pos).getNumCuenta() != nCuenta){
            pos++;
        }
        if(pos == ctas.size()){
            throw new RuntimeException("No existe la cuenta dada.");
        }
        return (pos < ctas.size())? pos : -1;
    }

    public void ingreso(int nc, double sal){
        int pos = posicionCuenta(nc);
        ctas.get(pos).ingreso(sal);
    }

    public void debito(int nc, double sal){
        int pos = posicionCuenta(nc);
        if(ctas.get(pos).getSaldo() < sal){
            double s =ctas.get(pos).getSaldo();
            ctas.get(pos).debito(s);
        }else{
            ctas.get(pos).debito(sal);
        }
    }

    public double saldo (int nc){
        int pos = posicionCuenta(nc);
        return ctas.get(pos).getSaldo();
    }

    public void transferencia(int nc1, int nc2, double din) {
        int pos1 = posicionCuenta(nc1);
        int pos2 = posicionCuenta(nc2);

        ctas.get(pos1).debito(din); // ó debito(nc1,din);
        ctas.get(pos2).ingreso(din); // ó ingreso(nc2,din);
    }


    // NO SE HACERLO
    @Override
    public String toString(){
        String salida = nombre + ": [";
        return salida + "]" + ctas;
    }

}
