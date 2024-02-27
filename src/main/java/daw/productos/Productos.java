/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.util.Objects;

/**
 *
 * @author danielnavasborjas
 */
//la ponemos como abstract ya que no se va a poder crear objetos de esta clase,
//las hijas heredarán todo y las hijas si se podrán crear
public abstract class Productos {
     //Creamos atributos encapsulados
    private int id;
    private String descripcion;
    private double precio;
    private Iva iva;
    private int stock = 0;
    private int cantidadPedida=0;
    
    //insertamos constructor parametrizado y sin parametrizar
    public Productos(int id, String descripcion, double precio, Iva iva, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }
    public Productos() {
    }
    
    //insertamos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Iva getIva() {
        return iva;
    }

    public void setIva(Iva iva) {
        this.iva = iva;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Productos{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append(", cantidadPedida=").append(cantidadPedida);
        sb.append('}');
        return sb.toString();
    }
    
    //insertamos equals y hashcode 
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.descripcion);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.iva);
        hash = 41 * hash + this.stock;
        hash = 41 * hash + this.cantidadPedida;
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
        if (this.cantidadPedida != other.cantidadPedida) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return this.iva == other.iva;
    }
    
}
