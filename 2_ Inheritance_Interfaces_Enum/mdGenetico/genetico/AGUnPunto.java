package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class AGUnPunto extends AlgoritmoGenetico {
	private Random alea = new Random();

	public AGUnPunto(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		super(tPoblacion, longCromosoma, pasos, probMutacion, problema);
	}

	/**
	 * @see AlgoritmoGenetico#recombinar(Cromosoma, Cromosoma)
	 */

	@Override
	protected Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2) {
		int x = alea.nextInt(cromosoma1.getLongitud());
		Cromosoma c = new Cromosoma(cromosoma1.getLongitud(),false);
		for(int i=0;i<x;i++){
			c.datos[i]=cromosoma1.datos[i];
		}
		for(int i=x;i<cromosoma1.getLongitud();i++){
			c.datos[i]=cromosoma2.datos[i];
		}
		return c;
	}

}
