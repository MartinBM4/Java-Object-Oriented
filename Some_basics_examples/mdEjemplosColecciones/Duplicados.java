package org.uma.mbd.mdEjemplosColecciones;

import java.util.*;
public class Duplicados {       //transparencia 26 tema colecciones
    public static void main(String[] args) {
        Set<String> s = new HashSet<>();
        for (String arg : args) {
            if (!s.add(arg)) {
                System.out.println("duplicado: " + arg);
            }
        }
        System.out.println(
                s.size() + " palabras detectadas: " + s);
    }
}