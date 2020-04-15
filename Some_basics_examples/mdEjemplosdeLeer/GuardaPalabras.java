package org.uma.mbd.mdEjemplosdeLeer;

import java.io.*;
public class GuardaPalabras {           //esto crea en mdEjemplosdeLeer un datos.txt

    public static void main(String[] args) {
// crear un fichero de palabras
        String fichero = "src/main/java/org/uma/mbd/mdEjemplosdeLeer/datos.txt";
        try (PrintWriter pw = new PrintWriter(fichero)) {
            pw.println("amor roma mora ramo");
            pw.println("rima mira");
            pw.println("rail liar");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: falta el nombre del fichero");
        } catch (IOException e) {
            System.out.println("ERROR: no se puede escribir el fichero");
        }
    }
}