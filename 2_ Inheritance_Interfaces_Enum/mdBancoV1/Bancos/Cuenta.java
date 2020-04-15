package org.uma.mbd.mdBancoV1.Bancos;

public class Cuenta {
    private int numCuenta;
    private String titular;
    private double saldo;

    public Cuenta(String tit, int nc, double sal){
        titular = tit;
        numCuenta = nc;
        saldo = sal;
    }

    public Cuenta(String tit, int nc){
        this(tit,nc,0);
    }

    public void ingreso(double sal){
        saldo += sal;
    }

    public void debito( double deb){
        saldo += deb;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String toString(){
        return "Cuenta(" + titular + ", "+ numCuenta+", "+saldo+")";
    }

}
