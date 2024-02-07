/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import daw.productos.ListasProductos;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author Víctor
 */
public class Carrito {

    //Atributos
    private Map<ListasProductos, Integer> carrito;

    //Constructor
    public Carrito() {
        this.carrito = new TreeMap<ListasProductos, Integer>();
    }

    //GETTER AND SETTER
    public Map<ListasProductos, Integer> getCarrito() {
        return carrito;
    }

    public void setCarrito(Map<ListasProductos, Integer> carrito) {
        this.carrito = carrito;
    }

    //To string
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrito{");
        sb.append("carrito=").append(carrito);
        sb.append('}');
        return sb.toString();
    }

    //Eqauals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.carrito);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carrito other = (Carrito) obj;
        return Objects.equals(this.carrito, other.carrito);
    }

    //Método para añadir al carrito
    public void añadirAlCarrito(ListasProductos producto, Integer numero) {
        if (this.carrito.containsKey(producto)) {
            int cantidad = this.carrito.get(producto);
            this.carrito.replace(producto, cantidad + numero);
        } else {
            this.carrito.put(producto, numero);
        }
    }
    //Metodo para borrar
    public void borrarElementoCarrito(ListasProductos producto){
        this.carrito.remove(producto);
    }
    //Metodo para borrar todo
    public void vaciar(){
        this.carrito.clear();
    }
}
