/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw.productos;

/**
 *
 * @author daniel
 */
public enum SubCategoriaBebida {
    REFRESCOS("Refrescos"), 
    CERVEZA("Cerveza"), 
    OTROS("Otros");
    
    private String subcategoria;
    
    //Creación de constructor subcategoría
    private SubCategoriaBebida(String subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    
}
