/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class MetodosProductos {

    //Método para que elija qué quiere modificar de la comida
    //En el TPV habra un switch y depende de lo que coja
    public static String elegirQueCambiar() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        String[] opciones = {"Descripción", "Subcategoría", "Precio", "Iva", "stock"};
        
        String eleccion = (String) JOptionPane.showInputDialog(null,
                "Elige el campo que quiere modificar:",
                "Seleccione para modificar",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (eleccion == null) {
            JOptionPane.showMessageDialog(null,
                    "Debes elegir entre las opciones", "Aviso",
                    JOptionPane.WARNING_MESSAGE, null);
            return null;
        }

        return eleccion;
    }
    
    //Método para que elija entre las categorías que hay
    public static String elegirCategorias(){
        //Creamos un array de String para hacer un desplegable y que elija 
        //la categoría
        String[] opciones = {"Comida", "Bebida", "Postres"};
        
        String eleccion = (String) JOptionPane.showInputDialog(null,
                "Elige la categoría:",
                "Seleccione Categoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (eleccion == null) {
            JOptionPane.showMessageDialog(null,
                    "Debes elegir entre las opciones", "Aviso",
                    JOptionPane.WARNING_MESSAGE, null);
            return null;
        }

        return eleccion;
    }

    //Método para mostrar un desplegable de subcategoría comida
    public static SubCategoriaComida elegirSubCategoríaComida() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Object[] opciones = SubCategoriaComida.values();

        SubCategoriaComida eleccion = (SubCategoriaComida) JOptionPane.showInputDialog(null,
                "Elige la subcategoría",
                "Selección de subcategoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //Método para mostrar un desplegable de subcategoría Bebida
    public static SubCategoriaBebida elegirSubCategoríaBebida() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Object[] opciones = SubCategoriaBebida.values();

        SubCategoriaBebida eleccion = (SubCategoriaBebida) JOptionPane.showInputDialog(null,
                "Elige la subcategoría",
                "Selección de subcategoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //Método para mostrar un desplegable de Iva comida
    public static Iva elegirIva() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Iva[] opciones = Iva.values();

        Iva eleccion = (Iva) JOptionPane.showInputDialog(null,
                "Elige el IVA",
                "Selección de IVA",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //Método para preguntar al usuario si es mayor de edad
    public static int eresMayorA18() {
        //Hago un array que tiene solo los valores "Si" y "No"
        String[] elegir = {"Si", "No"};
        int mayorOMenorA18 = JOptionPane.showOptionDialog(
                null,
                "¿Eres Mayor de edad?",
                "Restricción de edad",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                elegir,
                elegir[1]);
        return mayorOMenorA18;
    }
     
    //Hacemos un método donde estén todos los datos cargados
    public static ListasProductos datosProductos(){
        //Creamos los productos principales
        //Comidas:
        Comida c1 = new Comida(1, "McPollo", 
                SubCategoriaComida.POLLO, 2.5, 
                Iva.IVA_COMIDA, 150);
        Comida c2 = new Comida(2, "McTernera", 
                SubCategoriaComida.TERNERA, 3.2, 
                Iva.IVA_COMIDA, 150);
        Comida c3 = new Comida(3, "McPescado", 
                SubCategoriaComida.PESCADO, 2.1, 
                Iva.IVA_COMIDA, 150);
        //Bebidas:
        Bebida b1 = new Bebida(1, "Agua natural", 
                SubCategoriaBebida.AGUA, 1, 
                Iva.IVA_REFRESCOS, 200);
        Bebida b2 = new Bebida(2, "Zumo Naranja", 
                SubCategoriaBebida.ZUMONARANZA, 1.5, 
                Iva.IVA_RESTOBEBIDAS, 50);
        Bebida b3 = new Bebida(3, "Cerveza", 
                SubCategoriaBebida.CERVEZA, 1.6, 
                Iva.IVA_ALCOHOL, 200);
        //Postres:
        Postres p1 = new Postres(1, "Milk Shake", 3.5, 
                Iva.IVA_POSTRES, 100);
        Postres p2 = new Postres(2, "Browni", 3, 
                Iva.IVA_POSTRES, 300);
        Postres p3 = new Postres(3, "Gofres", 3.8, 
                Iva.IVA_POSTRES, 178);
        
        //Instanciamos el objeto
        ListasProductos listaDeProductos = new ListasProductos();
        
        //Añadimos todos los objetos a sus listas:
        listaDeProductos.añadirUnElemento(c1);
        listaDeProductos.añadirUnElemento(c2);
        listaDeProductos.añadirUnElemento(c3);
        listaDeProductos.añadirUnElemento(b1);
        listaDeProductos.añadirUnElemento(b2);
        listaDeProductos.añadirUnElemento(b3);
        listaDeProductos.añadirUnElemento(p1);
        listaDeProductos.añadirUnElemento(p2);
        listaDeProductos.añadirUnElemento(p3);
        
        return listaDeProductos;
    }
}
