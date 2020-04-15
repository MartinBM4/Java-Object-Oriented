package org.uma.mbd.mdEjemplosFrecuencia;

import java.sql.SQLOutput;
import java.util.*;
public class FrecuenciasM {
    public static void main(String[] args) {
        Map<String, Integer> frecs = new HashMap<>();
        for (String arg : args) {
// Incr. la frec. De arg., o la pone a 1 si es la 1ª
            int frec = frecs.getOrDefault(arg, 0);
            frecs.put(arg, frec + 1);
        }
// Mostramos frecs. iterando sobre el conjunto de claves
        for (String valor : frecs.keySet()) {
            int frec = frecs.get(valor);
            char[] barra = new char[frec];
            Arrays.fill(barra, '*');
            System.out.println(valor + ": " + new String(barra));
        }
    }
}