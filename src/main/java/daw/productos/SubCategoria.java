/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw.productos;

/**
 *
 * @author daniel
 */
public enum SubCategoria {
    AGUA("Agua"), 
    CERVEZA("Cerveza"), 
    ZUMONARANJA("Zumo de naranja"),
    POLLO("Pollo"), 
    TERNERA("Ternera"), 
    PESCADO("Pescado");
    
    private String subcategoria;
    
    //Creación de constructor subcategoría
    private SubCategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }
}
