package org.uma.mbd.mdBancoV1.Bancos;

import java.util.Arrays;

public class Banco {
    private String nombre;
    //ppl=primera posicion libre en el array
    //snc=siguiente numero de cuenta libre
    private int ppl, snc;
    private Cuenta[] ctas;
    private static final int TAM_ARRAY_CTAS = 10;
    private static final int PRIMER_NUM_CTA = 1001;

    public Banco(String nameB){
        nombre=nameB;
        ctas = new Cuenta[10];
        ppl = 0;
        snc = PRIMER_NUM_CTA;
    }

    public Banco(String nameB, int nc){
        nombre=nameB;
        ctas = new Cuenta[nc];
        ppl = 0;
        snc = PRIMER_NUM_CTA;
    }

    public int abrirCuenta(String name, double sal){
        aumentaCapsinocabe();
        Cuenta cuenta = new Cuenta(name, snc, sal);
        ctas[ppl]= cuenta;
        snc++;
        ppl++;
        return snc-1;
    }

    public int abrirCuenta(String name){
        return this.abrirCuenta(name,0);
    }

    public void aumentaCapsinocabe(){
        if(ppl == ctas.length){
            ctas = Arrays.copyOf(ctas, ctas.length*2);
        }
    }

    public void cerrarCuenta(int nc){
        int i = posicionCuenta(nc);
        if(i>=0){
            for(int j=i;j<ppl;j++){
                ctas[j]=ctas[j+1];
            }
        }
        ppl--;
    }

    public int posicionCuenta(int nCuenta){
        int pos = 0;
        while(pos<ppl && ctas[pos].getNumCuenta() != nCuenta){
            pos++;
        }
        if(pos == ppl){
            throw new RuntimeException("No existe la cuenta dada.");
        }
        return (pos < ppl)? pos : -1;
    }

    public void ingreso(int nc, double sal){
        int pos = posicionCuenta(nc);
        ctas[pos].ingreso(sal);
    }

    public void debito(int nc, double sal){
        int pos = posicionCuenta(nc);
        if(ctas[pos].getSaldo() < sal){
            double s =ctas[pos].getSaldo();
            ctas[pos].debito(s);
        }else{
            ctas[pos].debito(sal);
        }
    }

    public double saldo (int nc){
        int pos = posicionCuenta(nc);
        return ctas[pos].getSaldo();
    }

    public void transferencia(int nc1, int nc2, double din) {
        int pos1 = posicionCuenta(nc1);
        int pos2 = posicionCuenta(nc2);

        ctas[pos1].debito(din); // ó debito(nc1,din);
        ctas[pos2].ingreso(din); // ó ingreso(nc2,din);
    }

    @Override
    public String toString(){
        String salida = nombre + ": [";
        for(int i = 0; i < ppl; i++){
            salida += ctas[i].toString();
        }
        return salida + "]";
    }

}
