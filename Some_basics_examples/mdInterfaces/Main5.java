package org.uma.mbd.mdInterfaces;

import org.uma.mbd.mdInterfaces.caso4.Persona;

import java.util.*;

public class Main5 {    //APRENDEMOS A ORDENAR
    public static void main(String[] args) {
        Set<Persona> set = new HashSet<>();
        set.add(new Persona("juan",25));
        set.add(new Persona("pedro",12));
        set.add(new Persona("juan",25));
        set.add(new Persona("luisa",18));
        set.add(new Persona("andres",12));
        System.out.println(set);

        Set <Persona> set0 = new TreeSet<>();
        set0.add(new Persona("juan",25));
        set0.add(new Persona("pedro",12));
        set0.add(new Persona("juan",25));
        set0.add(new Persona("luisa",18));
        set0.add(new Persona("andres",12));
        System.out.println(set0);

        Comparator <Persona> oE = (p1,p2)->Integer.compare(p1.getEdad(),p2.getEdad());
        Comparator <Persona> oN = (p1,p2)->p1.getNombre().compareTo(p2.getNombre());
        Set <Persona> setA = new TreeSet<>(oE.reversed().thenComparing(oN));
        setA.addAll(set0);
        System.out.println(setA);

        Set <String> setS = new TreeSet<>(List.of("hola","antonio","que","tal","estas","hoy"));
        System.out.println(setS);

        Comparator<String> comp = (s1,s2)->Integer.compare(s1.length(),s2.length());
        Comparator<String> comp2 = comp.thenComparing(Comparator.naturalOrder());
        Set<String> setS2 = new TreeSet<>(comp2);
        setS2.addAll(setS);
        System.out.println(setS2);
    }



}
