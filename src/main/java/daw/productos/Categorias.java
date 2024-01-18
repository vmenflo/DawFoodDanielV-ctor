/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw.productos;

/**
 *
 * @author danielnavasborjas
 */
public enum Categorias {
    COMIDA("Comida"), 
    BEBIDA("Bebida"), 
    POSTRES("Postres");
    
    private String categorias;
    
    //Creación de constructor subcategoría
    private Categorias(String categorias) {
        this.categorias = categorias;
    }
}
