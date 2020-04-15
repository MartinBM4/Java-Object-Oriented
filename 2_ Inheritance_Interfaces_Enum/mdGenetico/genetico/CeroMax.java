package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema{

    public double evalua(Cromosoma cromosoma) {
        double nCero = 0;
        for(int i = 0;i<cromosoma.getLongitud();i++){
            if(cromosoma.datos[i]==0){
                nCero++;
            }
        }
        return nCero;
    }
}
