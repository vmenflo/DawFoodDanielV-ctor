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
public class Postres {
    //Creamos atributos encapsulados
    private int id;
    private String descripcion;
    private double precio;
    private Iva iva;
    private int stock = 0;

    //Creamos constructor parametrizado
    public Postres(int id, String descripcion, double precio, Iva iva, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }
    
    //Creamos constructor vacío
    public Postres() {
    }
    
        
    //Insertamos los getter y los setters
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

    //Añadimos el método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Postres{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
    
    //Añadimos el hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.iva);
        hash = 61 * hash + this.stock;
        return hash;
    }

    //Añadimos el equals
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
        final Postres other = (Postres) obj;
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
        return this.iva == other.iva;
    }
    
}
