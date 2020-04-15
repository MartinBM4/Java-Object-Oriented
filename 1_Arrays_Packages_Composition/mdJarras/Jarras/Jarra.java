package org.uma.mbd.mdJarras.Jarras;

public class Jarra {
    private final int capacidad;    // DES ESTA FORMA NO SE PUEDE  MODIFICAR DESPUES DE HABERSE CREADO
    private int contenido;

    public Jarra(int ci){
        if(ci<=0) {
        throw new IllegalArgumentException("DATO INVALIDO");
        }
            capacidad = ci;
            contenido = 0;

    }

    // se puede hacer con el GENERATE
            public int getCapacidad(){
                return capacidad;
            }

            public int getContenido(){
                return contenido;
            }

    public void llena(){
        contenido=capacidad;
    }

    public void vacia(){
        contenido=0;
    }

/*  ESTO LO HE HECHO YO
    public void llenaDesde(Jarra j) {
        if(contenido+j.contenido > capacidad){
            j.contenido = j.contenido- (capacidad - contenido);
            contenido = capacidad;

        }else{
            contenido += j.contenido;
            j.contenido = 0;
        }
    }
*/

        // LO SIGUIENTE POR EL PROFESOR:
    public void llenaDesde(Jarra j){
        int cabe = capacidad - contenido;
        if(cabe >= j.contenido){
            // cabe todo
            contenido += j.contenido;
            j.contenido = 0;
        }else{
            //no cabe todo
            contenido += capacidad;
            j.contenido -= cabe;
        }
    }


    public String toString() {
        return "J(capacidad: " + capacidad + ", contenido: " + contenido + ")";
    }

}
