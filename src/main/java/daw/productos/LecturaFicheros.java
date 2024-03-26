/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Víctor
 */
public class LecturaFicheros {
    //AQUI ESTARÁN TODOS LOS MÉTODOS RELACIONADOS CON LA LECTURA, 
    //CARGA Y ESCRITURA DE DATOS
    
    //Método para leer datos de cualquier fichero
    public static List<String> extraerDatos(String idFichero) {
        
        List<String> lineas = new ArrayList<>();
        try {
            lineas = Files.readAllLines(Paths.get(idFichero),
                    StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println("Error leyendo el fichero");
        }
        return lineas;
    }
    
    //Método para generar objetos comida
    public static void generarListaDeComida(ListasProductos listaProductos){
        //En esta lista almacenamos los datos del fichero
        List<String> listaComida = extraerDatos("comida.csv");
      
        //Bucle para recorrer los datos y convertislos en Personas
        // y almacenarlso en la lista de personas
        for (int i = 0; i < listaComida.size() - 1; i++) {
            //Extraigo los datos y lo almaceno en la array de String
            String datos[] = listaComida.get(i).split(";");
            
            //Para pasar el dato del enum de subcategoria
            SubCategoriaComida subCategoria;
            if (datos[2].equalsIgnoreCase("pollo")) {
                subCategoria = SubCategoriaComida.POLLO;
            } else if (datos[2].equalsIgnoreCase("ternera")) {
                subCategoria = SubCategoriaComida.TERNERA;
            } else if (datos[2].equalsIgnoreCase("pescado")) {
                subCategoria = SubCategoriaComida.PESCADO;
            } else {
                //En el caso de que halla algún problema devuelve null
                subCategoria = null;
            }
                      
            //Creamos una variable temporal de Persona para almacenarla
            Comida temporal = new Comida(Integer.parseInt(datos[0]), datos[1], subCategoria, Double.parseDouble(datos[3]), Iva.IVA_COMIDA, Integer.parseInt(datos[5]));
            //Añadimos a la lista
            listaProductos.añadirUnElemento(temporal);
        }
        
    }
}
