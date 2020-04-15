package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urnas.Urna;
import java.lang.Throwable;
import java.io.LineNumberReader;

public class Main {
    public static void main(String[] args) {
        String s1 = args[0];
        String s2 = args[1];
        try {
            int nb = Integer.parseInt(args[0]);
            int nn = Integer.parseInt(args[1]);

            Urna u = new Urna(nb, nn);

            while (u.totalBolas() > 1) {

                Urna.ColorBola b = u.extraerBola();
                Urna.ColorBola a = u.extraerBola();
                if (b == a) {
                    u.ponerBlanca();

                } else {
                    u.ponerNegra();

                }

            }
            System.out.println(u.extraerBola());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(" Error en la entrada de datos. Debes proporcionar dos argumentos");
        }catch (NumberFormatException e){
            System.err.println (" Algun dato no es numerico " +e.getMessage());
        }catch (IllegalArgumentException e){
            System.err.println (e.getMessage());
        }
    }
}
