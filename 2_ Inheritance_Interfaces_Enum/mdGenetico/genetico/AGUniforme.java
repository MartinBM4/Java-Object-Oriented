package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class AGUniforme extends AlgoritmoGenetico {
	private Random alea = new Random();
	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va a utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AGUniforme(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */
	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		Cromosoma c = new Cromosoma(cromosoma1.getLongitud(),true);
		//double p = 50/100;

		for(int i=0;i<cromosoma1.getLongitud();i++){
			double x = Cromosoma.gna.nextDouble();
			if(Cromosoma.gna.nextBoolean()){
				c.datos[i]=cromosoma1.datos[i];
			}else{
				c.datos[i]=cromosoma2.datos[i];
			}
		}

		return c;
	}

}
