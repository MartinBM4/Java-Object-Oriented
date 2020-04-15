package org.uma.mbd.mdAnagramas;

import org.uma.mbd.mdAnagramas.anagramas.DicAnagramas;
import org.uma.mbd.mdAnagramas.anagramas.SatSignatura;

public class TestAnagramas{
	public static void main (String[] args) {

		System.out.println("Ordenadas alfabeticamente");
		DicAnagramas dic = new DicAnagramas();
		for (String palabra : args) {
			dic.agregarPalabra(palabra);
		}
		dic.presentaDiccionario();
		/*
		System.out.println("Ahora ordenadas por longitud de la palabra");
		dic = new DicAnagramas(new SatSignatura());
		for (String palabra : args) {
			dic.agregarPalabra(palabra);
		}
		dic.presentaDiccionario();
		*/
	}
}
