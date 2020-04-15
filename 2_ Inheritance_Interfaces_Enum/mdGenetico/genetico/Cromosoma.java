package org.uma.mbd.mdGenetico.genetico;
import java.util.Arrays;
import java.util.Random;

public class Cromosoma {
	private int longitud;
	protected int[] datos;
	protected static Random gna = new Random(100);
	protected static int GEN_POR_DEFECTO = 0;

	//constructor
	public Cromosoma(int longitud, boolean aleatorio) {
		if(longitud <0){
			throw new RuntimeException("Valor longitud negativo");
		}
		datos = new int[longitud];
		this.longitud = longitud;
		int i=0;
		if(aleatorio){
			while(i<longitud){
				datos[i] = gna.nextInt(2);
				i++;
			}
		}else{
			while(i<longitud){
				datos[i]=GEN_POR_DEFECTO;
				i++;
			}
		}
	}

	public int getGen(int i) {
		if(i>datos.length){
			throw new RuntimeException("El indice se sale del arrays");
		}
		return datos[i];
	}

	public void setGen(int i, int val) {
		if(i>=0 && i<datos.length) {
			datos[i] = val;
		}else{
			throw new RuntimeException("El indice se sale del arrays o valur no apto");
		}
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		if(probMutacion>100 || probMutacion<0){
			throw new RuntimeException("dato probabilidad no valido");
		}
		int i=0;
		double p=probMutacion;
		while(i<datos.length) {
			double prob = gna.nextDouble();
			if (prob <= p) {
				datos[i]= - datos[i];
			}
			i++;
		}
	}

	public int getLongitud() {
		return datos.length;
	}

	/**
	 * Realiza una copia en profundidad del cromosoma.
	 * 
	 * @return Un objeto Cromosoma copia del objeto que recibe el mensaje.
	 */
	public Cromosoma copia() {
		Cromosoma c = new Cromosoma(getLongitud() , false);
		for(int i=0;i<datos.length;i++){
			c.datos[i]=datos[i];
		}
		return c;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < datos.length - 1; i++) {
			s.append(datos[i]).append(", ");
		}
		return "Cromosoma(" + s + datos[datos.length - 1] + ")";
	}
}
