package org.uma.mbd.mdGenetico.genetico;



public abstract class AlgoritmoGenetico {
	private Poblacion poblacion;
	private Problema problema;
	private int pasos;
	private double probMutacion;


	public AlgoritmoGenetico(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		this.problema = problema;
		this.pasos = pasos;
		this.probMutacion = probMutacion;
		poblacion = new Poblacion(tPoblacion,longCromosoma,problema);
	}

	/**
	 * Ejecuta la secuencia siguiente tantas veces como indique el número de
	 * pasos: seleccionar dos individuos de la población aleatoriamente, tomar
	 * sus cromosomas y recombinarlos usando el método abstracto recombinar(),
	 * mutar el resultado y, por último, crear un individuo con el cromosoma
	 * resultante que insertará en la población reemplazando al peor individuo
	 * siempre y cuando sea mejor que éste.
	 * 
	 * @return Mejor individuo de la población después de la terminación del
	 *         bucle.
	 */

	public Individuo ejecuta() {
		for (int i = 0; i < pasos; i++) {
			// Nos aseguramos de coger dos individuos distintos
			int a1 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
			int a2;
			do {
				a2 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
			} while (a1 == a2);
			// Seguro que a1 es distinto de a2
			Individuo ind1 = poblacion.getIndividuo(a1);
			Individuo ind2 = poblacion.getIndividuo(a2);
			Cromosoma c = recombinar(ind1.getCromosoma(),ind2.getCromosoma());
			c.mutar(probMutacion);
			Individuo indX = new Individuo(c,problema);
			poblacion.reemplaza(indX);


 		}
		return poblacion.mejorIndividuo();
	}

	/**
	 * Recombina los cromosomas pasados como argumento generando un tercer
	 * cromosoma.
	 * 
	 * Dado que el método es protected supnemos que siempre se llama con dos
	 * cromosomas de la misma longitud.
	 * 
	 * @param cromosoma1
	 *            Uno de los cromosoma a recombinar.
	 * @param cromosoma2
	 *            Uno de los cromosoma a recombinar.
	 * @return
	 * 			El cromosoma resultante de la recombinación
	 */
	protected abstract Cromosoma recombinar(Cromosoma cromosoma1,
											Cromosoma cromosoma2);


}



