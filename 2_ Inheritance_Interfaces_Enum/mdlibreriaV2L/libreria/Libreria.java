package org.uma.mbd.mdlibreriaV2L.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private List<Libro> libros; //se puede poner el constructor aqui:
    // private List <Libro> libros = new ArrayList<>();

    public Libreria (){
        libros = new ArrayList<>();
    }

    public void addLibro(String aut, String tit, double pb){
        Libro libro = new Libro(aut,tit,pb);
        addLibro (libro);
    }

    protected void addLibro(Libro libro){
        int i = posicionLibro(libro.getAutor(), libro.getTitulo());
        if(i<0){
            libros.add(libro);
        }else{
            libros.set(i,libro);
        }

    }

    private int posicionLibro(String aut, String tit){
        int pos = 0;
        while (pos < libros.size() &&
                !(aut.equalsIgnoreCase(libros.get(pos).getAutor()) &&
                        tit.equalsIgnoreCase(libros.get(pos).getTitulo()))){
            pos++;
        }
        return (pos == libros.size())? -1 : pos;

    }

    public void remLibro(String aut, String tit){
        int pos = posicionLibro(aut, tit);
        if(pos >=0) {
            libros.remove(pos);
        }
    }

    public double getPrecioBase(String aut, String tit){
        int pos = posicionLibro(aut, tit);
        return (pos>=0)? libros.get(pos).getPrecioBase() : 0;
    }

    public double getPrecioFinal (String aut, String tit){
        int pos = posicionLibro(aut, tit);
        return (pos>=0)? libros.get(pos).getPrecioFinal() : 0;
    }

    // como se hace un toString de un ARRAY
    public String toString(){
        return libros.toString();

    }
}
