package org.uma.mbd.mdIndicePalabrasV2;

import org.uma.mbd.mdIndicePalabrasV2.indices.*;

import java.io.FileNotFoundException;

public class EjIndice {
	public static void main(String args[]) throws FileNotFoundException {
		String delimitadores = "[ .,:;-[¡][!][¿][?]]+";

		Indice indice = new Indice1aLinea();
//		Indice indices = new IndiceLineas();
//		Indice indices = new IndicePosicionesEnLineas();

		indice.agregarDesdeFichero("recursos/mdIndicePalabrasV2/frases.txt");
		indice.resolver(delimitadores, "recursos/mdIndicePalabrasV2/noSig.txt");
		indice.presentarIndice("recursos/mdIndicePalabrasV2/salida.txt");
		indice.presentarIndiceConsola();
	}
}
