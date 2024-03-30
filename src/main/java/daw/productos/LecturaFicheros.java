/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import daw.TarjetaBanco;
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
        lineas.remove(0);
        return lineas;
    }

    //Método para generar objetos comida en la lista de productos
    public static void generarListaDeComida(ListasProductos listaProductos) {
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
            Comida temporal = new Comida(Integer.parseInt(datos[0]), datos[1],
                    subCategoria, Double.parseDouble(datos[3]),
                    Iva.IVA_COMIDA, Integer.parseInt(datos[5]));
            //Añadimos a la lista
            listaProductos.añadirUnElemento(temporal);
        }
    }

    //Método para generar objetos de postre a partir del fichero a la lista productos
    public static void generarListaDePostre(ListasProductos listaProductos) {
        //En esta lista almacenamos los datos del fichero
        List<String> listaPostre = extraerDatos("postre.csv");

        //Bucle para recorrer los datos y convertislos en Personas
        // y almacenarlso en la lista de personas
        for (int i = 0; i < listaPostre.size() - 1; i++) {
            //Extraigo los datos y lo almaceno en la array de String
            String datos[] = listaPostre.get(i).split(";");

            //Creamos una variable temporal de Persona para almacenarla
            Postres temporal = new Postres(Integer.parseInt(datos[0]), datos[1], Double.parseDouble(datos[2]), Iva.IVA_POSTRES, Integer.parseInt(datos[4]));
            //Añadimos a la lista
            listaProductos.añadirUnElemento(temporal);
        }
    }

    //Método para generar objetos bebidas a partir de un fichero a lista productos
    public static void generarListaDeBebida(ListasProductos listaProductos) {
        //En esta lista almacenamos los datos del fichero
        List<String> listaBebida = extraerDatos("bebida.csv");

        //Bucle para recorrer los datos y convertislos en Personas
        // y almacenarlso en la lista de personas
        for (int i = 0; i < listaBebida.size() - 1; i++) {
            //Extraigo los datos y lo almaceno en la array de String
            String datos[] = listaBebida.get(i).split(";");

            //Para pasar el dato del enum de subcategoria
            SubCategoriaBebida subCategoria;
            Iva iva;
            if (datos[2].equalsIgnoreCase("refrescos")) {
                subCategoria = SubCategoriaBebida.REFRESCOS;
                iva = Iva.IVA_REFRESCOS;
            } else if (datos[2].equalsIgnoreCase("cerveza")) {
                subCategoria = SubCategoriaBebida.CERVEZA;
                iva = Iva.IVA_ALCOHOL;
            } else if (datos[2].equalsIgnoreCase("otros")) {
                subCategoria = SubCategoriaBebida.OTROS;
                iva = Iva.IVA_RESTOBEBIDAS;
            } else {
                //En el caso de que halla algún problema devuelve null
                subCategoria = null;
                iva = null;
            }

            //Creamos una variable temporal de Persona para almacenarla
            Bebida temporal = new Bebida(Integer.parseInt(datos[0]), datos[1],
                    subCategoria, Double.parseDouble(datos[3]),
                    iva, Integer.parseInt(datos[5]));
            //Añadimos a la lista
            listaProductos.añadirUnElemento(temporal);
        }
    }
    
    //Método para generar objetos de postre a partir del fichero a la lista productos
    public static void generarListaTarjetas(ArrayList<TarjetaBanco> lista) {
        //En esta lista almacenamos los datos del fichero
        List<String> listaTarjetas = extraerDatos("tarjetas.csv");

        //Bucle para recorrer los datos y convertislos en Personas
        // y almacenarlso en la lista de personas
        for (int i = 0; i < listaTarjetas.size() - 1; i++) {
            //Extraigo los datos y lo almaceno en la array de String
            String datos[] = listaTarjetas.get(i).split(";");

            //Creamos una variable temporal de Persona para almacenarla
            TarjetaBanco temporal = new TarjetaBanco(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Double.parseDouble(datos[5]));
            //Añadimos a la lista
            lista.add(temporal);
        }
    }
}
