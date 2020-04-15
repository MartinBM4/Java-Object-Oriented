package org.uma.mbd.mdGenetico.genetico;
import java.util.Random;

public class Poblacion {
	private Individuo[] individuos;
	private int numIndividuos;
	private Random alea = new Random();
	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema a resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		if(tamaño < 0){
			throw new RuntimeException("tamaño no valido");
		}
		if(longitud <0){
			throw new RuntimeException("longitud cromosoma no valido");
		}
		individuos = new Individuo[tamaño];
		numIndividuos = tamaño;
		for(int i = 0; i<tamaño;i++) {
			individuos[i] = new Individuo(longitud, problema);
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int getNumIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		double fit=0;
		int pos=0;
		for(int i=0;i<individuos.length;i++){
			if(individuos[i].getFitness()>fit){
				fit=individuos[i].getFitness();
				pos=i;
			}
		}
		return individuos[pos];
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo a devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public  Individuo getIndividuo(int i) {
		if(i<0 || i>=individuos.length){
			throw new RuntimeException("indice fuera de rango");
		}
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {
		Individuo c = mejorIndividuo(); //?¿?
		double fit=c.getFitness();
		int pos=0;
		for(int i=0;i<individuos.length;i++){
			if(individuos[i].getFitness()<fit){
				fit=individuos[i].getFitness();
				pos=i;
			}
		}
		if(fit<ind.getFitness()){
			individuos[pos]= ind;
		}
	}

}
