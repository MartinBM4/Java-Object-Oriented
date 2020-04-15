package org.uma.mbd.mdLibreriaV1.libreria;

import java.util.Arrays;
import java.util.StringJoiner;

public class Libreria {
    private Libro [] libros;
    private int numLibros;
    private static final int TAM_DEFECTO = 16;  // este a diferencia del IVA no se puede cambiar en un futuro

    public Libreria (int n){
        libros = new Libro[n];
        numLibros =0;
    }

    public Libreria (){
        this(TAM_DEFECTO);
        // o asi: libros = new Libro[TAM_DEFECTO]; numLibros =0 ;
    }

    public void addLibro(String aut,String tit, double pb){
        Libro libro = new Libro (aut, tit, pb);
        addLibro(libro);
    }

    private int posicionLibro(String aut, String tit){
        int pos = 0;
        while (pos < numLibros &&
                !(aut.equalsIgnoreCase(libros[pos].getAutor()) &&
                tit.equalsIgnoreCase(libros[pos].getTitulo()))){
            pos++;
        }
        return (pos == numLibros)? -1 : pos; //si la cosa booleana sea cierta devuelve -1
                                             // y en caso de que no sea cierta devuelvo posicion

    }

    private void addLibro (Libro libro){
        int i = posicionLibro(libro.getAutor(), libro.getTitulo());
        if(i<0){
            libros[numLibros]=libro;
        }else{
            libros[i] = libro; //esto solo lo sustituye
        }
    }

    private void aseguraQueCabe(){
        if (numLibros == libros.length){
            libros = Arrays.copyOf(libros,numLibros*2); //esto es para multiplicar el tamaño de un arraays por 2
        }
    }

    public void remLibro(String aut, String tit){
        int pos = posicionLibro(aut, tit);
        if(pos >= 0){
            for (int i = pos+1; i<numLibros; i++){
                libros[i-1]=libros[i];
            }
            numLibros--;
        }

    }

    public double getPrecioBase(String aut, String tit){
        int pos = posicionLibro(aut, tit);
        return (pos>=0)? libros[pos].getPrecioBase() : 0;
    }

    public double getPrecioFinal (String aut, String tit){
        int pos = posicionLibro(aut, tit);
        return (pos>=0)? libros[pos].getPrecioFinal() : 0;
    }

    // como se hace un toString de un ARRAY.
    @Override
    public String toString () {
        StringJoiner sj = new StringJoiner(",","[","]");
        for(int i = 0; i<numLibros;i++){
            sj.add(libros[i].toString());
        }
        return sj.toString();
    }
    /*  ESTO ES OTRA FORMA, LA DE ARRIBA MEJOR

        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<libros.length-1;i++){
            sb.append(libros[i]);
            sb.append(", ");
        }
        if(libros.length > 0){
            sb.append(libros[libros.length - 1]);
        }
        sb.append("]");
        return sb.toString();
    }

    */


        //en lugar de lo siguiente se hace como arriba:

    /*
    public String toString(){
        String salida = "[";
        for(int i= 0; i<numLibros; i++){
            salida += libros [i];
            if(i<numLibros - 1 ){
                salida += ", ";
            }
        }
        return salida + "]";
 //  tambien se puede hacer asi aunque al profe le gusta menos: return Arrays.toString(Arrays.copyOf(libros, numLibros));
    }*/

}
