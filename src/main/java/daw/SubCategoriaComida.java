/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author daniel
 */
public enum SubCategoriaComida {
    POLLO("Pollo"), 
    TERNERA("Ternera"), 
    PESCADO("Pescado");
    
    private String subcategoria;

    //Creación de constructor subcategoría
    private SubCategoriaComida(String subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    
}
