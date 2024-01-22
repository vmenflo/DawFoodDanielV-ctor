/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

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
    
    //Método para mostrar un desplegable de subcategoría
    public static String elegirSubCategoría(){
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
}
