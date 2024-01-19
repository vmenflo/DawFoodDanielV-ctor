/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author danielnavasborjas
 */
public class Productos {

    //Creamos atributos encapsulados
    private int id;
    private String descripcion;
    private Categorias categoria;
    private final SubCategoria subcategoria;
    private double precio;
    private final Iva iva;
    private int stock = 0;

    //Creamos constructor parametrizado
    public Productos(int id, String descripcion, Categorias categoria, 
            SubCategoria subcategoria, double precio, Iva iva, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }
    
    //Creamos constructor copia y hacemos que si se hace una copia el stock vaya
    //en incremento

    public Productos(Productos origen) {
        this.id = origen.id;
        this.descripcion = origen.descripcion;
        this.categoria = origen.categoria;
        this.subcategoria = origen.subcategoria;
        this.precio = origen.precio;
        this.iva = origen.iva;
        //Hacemos que el stock se sume uno por cada producto que copiemos 
        //(ya que estamos añadiendo realmente uno por cada copia)
        this.stock = origen.stock++;
    }
    
    //Creamos getters y setters

    public int getId() {
        return id;
    }

    //Quitamos el setter del id ya que el administrador no va a poder modificar
    //el id

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Insertamos el toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", categoria=").append(categoria);
        sb.append(", subcategoria=").append(subcategoria);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
    
    //Insertamos el hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.descripcion);
        hash = 47 * hash + Objects.hashCode(this.categoria);
        hash = 47 * hash + Objects.hashCode(this.subcategoria);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.iva);
        hash = 47 * hash + this.stock;
        return hash;
    }

    //Insertamos el equals
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
        final Productos other = (Productos) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.categoria != other.categoria) {
            return false;
        }
        if (this.subcategoria != other.subcategoria) {
            return false;
        }
        return this.iva == other.iva;
    }
    
    public static List<Productos> filtradoPorCategoria(
            ArrayList<Productos> listaDeProductos, Categorias categoriaABuscar){
        return listaDeProductos.stream()
                .filter(Productos->Productos.getCategoria() == categoriaABuscar)
                .collect(Collectors.toList());
    }
}
