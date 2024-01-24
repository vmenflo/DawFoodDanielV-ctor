/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import daw.productos.Bebida;
import daw.productos.ListasProductos;
import java.util.ArrayList;

/**
 *
 * @author danielnavasborjas
 */
public class Carrito {
    //Añadimos los atributos encapsulados, en este caso será un ArrayList
    //de tipo ListaProductos
    private ArrayList<ListasProductos> rellenarCarrito;
    
    //Insertamos constructor predeterminado sin nada
    public Carrito() {
        this.rellenarCarrito = new ArrayList<>();
    }
    
    //Insertamos getter y setters
    public ArrayList<ListasProductos> getRellenarCarrito() {
        return rellenarCarrito;
    }

    public void setRellenarCarrito(ArrayList<ListasProductos> rellenarCarrito) {
        this.rellenarCarrito = rellenarCarrito;
    }
    
    //Insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito{");
        sb.append("rellenarCarrito=").append(rellenarCarrito);
        sb.append('}');
        return sb.toString();
    }
    
    //No necesitamos comparar ningún carrito por lo que no pondremos ningún
    //hashcode ni equals
    
    //Hacemos método para muestre lo que tiene en el carrito
    public void mostrarCarrito() {
        //creamos un stringbuildes
        StringBuilder sb = new StringBuilder();
        
        //Hacemos un bucle para ir guardando todos los elementos de producto
        //en sb
        for (int i = 0; i < rellenarCarrito.size(); i++) {
            sb.append(rellenarCarrito.add())
        }
    }
    
    
}
