/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Víctor
 */
public class EscrituraFicheros {
    //MÉTODOS PARA GENERAR FICHEROS
    //Queremos almacenar los datos de las ventas en un fichero
    
    //Método para obtener un objeto de ticket de venta y lo guardamos en un fichero
    public static void añadirTicketAlFichero(TicketVenta ticket){
        //Creamos el archivo ventas.txt si no existe y añadimos el ticket
        try {
                Files.write(Paths.get("ventas.txt"), (ticket + "\n" + "**********************").getBytes(StandardCharsets.UTF_8),
                        StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.out.println("Error creando el fichero");
            }
    }
}
