package org.uma.mbd.mdEjemplosdeLeer;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.net.URL;
public class LeeURLFile {
    public static void main(String[] args) throws IOException, CsvException {
        String urlPath = "http://datosabiertos.malaga.eu/recursos/transporte" +
        "/EMT/EMTLineasUbicaciones/lineasyubicaciones.csv";                             // esta pagina te dice a tiempo real donde estan los autobuses de malaga
        URL url = new URL(urlPath);
        try (InputStream fs = url.openStream();                 // inputstream, inputstream reader y bufferedreader se utilizan casi siempre en este sentido
             InputStreamReader isr = new InputStreamReader(fs); // para pasar de bytes a codigo y de codigo a string
             BufferedReader br = new BufferedReader(isr);
             CSVReader csv = new CSVReader(br)){
            //esto es otra forma de hacerlo:
            csv.readNext();
            for(String[] datoBus: csv.readAll()) {
                System.out.print("CodBus: " + datoBus[0] + " ");
                System.out.print("CodLin: " + datoBus[1] + " ");
                System.out.print("Lon: " + datoBus[3] + " ");
                System.out.println("Lat: " + datoBus[4]);
            }

     /*
            csv.readNext(); //readnext tiene una excepcion de obligada captura (CsvValidationException)
            String[] datoBus = csv.readNext();
             String linea = br.readLine();
             while (datoBus != null) {
                System.out.print("CodBus: "+datoBus[0]+" ");
                System.out.print("CodLin: "+datoBus[1]+" ");
                System.out.print("Lon: "+datoBus[3]+" ");
                System.out.println("Lat: "+datoBus[4]);
                // esto era antes de usar la libreria CSV linea = br.readLine();
                 datoBus = csv.readNext();
                 */


        }
    }
}
