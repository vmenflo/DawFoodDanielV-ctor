/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import daw.SubCategoriaBebida;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class Bebida {
    //Creación de atributos encapsulados
    private int id;
    private String descripcion;
    private final SubCategoriaBebida subBebida;
    private double precio;
    private final Iva iva;
    private int stock = 0;
    
    //Creamos constructor parametrizado
    public Bebida(int id, String descripcion, SubCategoriaBebida subBebida, double precio, Iva iva, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.subBebida = subBebida;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }
    
    //Creamos constructor copia
    public Bebida(Bebida origen){
        this.id = origen.id;
        this.descripcion = origen.descripcion;
        this.subBebida = origen.subBebida;
        this.precio = origen.precio;
        this.iva = origen.iva;
        //En el atributo encapsulado stock le sumamos uno al stock origen
        //porque esto significaría de que estamos añadiendo un producto más
        this.stock = origen.stock+1;
    }
    
    //Insertamos los getters y los setters

    public int getId() {
        return id;
    }

    //Eliminamos el set del id porque nadie puede cambiar el id

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    //Insertamos el toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bebida{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", subBebida=").append(subBebida);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
    
    //insertamos el hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.descripcion);
        hash = 53 * hash + Objects.hashCode(this.subBebida);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.iva);
        hash = 53 * hash + this.stock;
        return hash;
    }

    //insertamos el equals
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
        final Bebida other = (Bebida) obj;
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
        if (this.subBebida != other.subBebida) {
            return false;
        }
        return this.iva == other.iva;
    }
    
    
    
}
