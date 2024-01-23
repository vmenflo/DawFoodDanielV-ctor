/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class MetodosProductos {
    //Método para que elija qué quiere modificar de la comida
    //En el TPV habra un switch y depende de lo que coja
    public static String elegirQueCambiar(){
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        String [] opciones = {"Descripción", "Subcategoría" ,"Precio", "Iva","stock"};
        
        String eleccion = (String) JOptionPane.showInputDialog(null, 
                "Elige el campo que quiere modificar:", 
                "Seleccione para modificar", 
                JOptionPane.QUESTION_MESSAGE, null, 
                opciones, opciones[0]);
        return eleccion;
    }
    
    //Método para mostrar un desplegable de subcategoría comida
    public static SubCategoriaComida elegirSubCategoríaComida(){
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Object [] opciones = SubCategoriaComida.values();
        
        SubCategoriaComida eleccion = (SubCategoriaComida) JOptionPane.showInputDialog(null, 
                "Elige la subcategoría", 
                "Selección de subcategoría", 
                JOptionPane.QUESTION_MESSAGE, null, 
                opciones, opciones[0]);
        return eleccion;
    }
    
    //Método para mostrar un desplegable de subcategoría Bebida
    public static SubCategoriaBebida elegirSubCategoríaBebida(){
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Object [] opciones = SubCategoriaBebida.values();
        
        SubCategoriaBebida eleccion = (SubCategoriaBebida) JOptionPane.showInputDialog(null, 
                "Elige la subcategoría", 
                "Selección de subcategoría", 
                JOptionPane.QUESTION_MESSAGE, null, 
                opciones, opciones[0]);
        return eleccion;
    }
    
    //Método para mostrar un desplegable de Iva comida
    public static Iva elegirIva(){
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Iva [] opciones = Iva.values();
        
        Iva eleccion = (Iva) JOptionPane.showInputDialog(null, 
                "Elige el IVA", 
                "Selección de IVA", 
                JOptionPane.QUESTION_MESSAGE, null, 
                opciones, opciones[0]);
        return eleccion;
    }
    
    //Método para preguntar al usuario si es mayor de edad
    public static int eresMayorA18(){
        //Hago un array que tiene solo los valores "Si" y "No"
        String[] elegir = {"Si","No"};
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
}
