/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import daw.SubCategoriaComida;
import java.util.Objects;

/**
 *
 * @author daniel
 */
public class Comida {
    private int id;
    private String descripcion;
    private final SubCategoriaComida subComida;
    private double precio;
    private final Iva iva;
    private int stock = 0;
    
    //Creamos constructor parametrizado
    public Comida(int id, String descripcion, SubCategoriaComida subComida, double precio, Iva iva, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.subComida = subComida;
        this.precio = precio;
        this.iva = iva;
        this.stock = stock;
    }
    
    //Creamos un constructor copia
    public Comida(Comida origen){
        this.id = origen.id;
        this.descripcion = origen.descripcion;
        this.subComida = origen.subComida;
        this.precio = origen.precio;
        this.iva = origen.iva;
        //En el atributo encapsulado stock le sumamos uno al stock origen
        //porque esto significaría de que estamos añadiendo un producto más
        this.stock = origen.stock+1;
    }
    
    //Añadimos getter y setters
    public int getId() {
        return id;
    }

    //No añadiremos el set del id ya que ninguno de los usuario podrá modificar
    //este dato una vez creado

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
        sb.append("Comida{");
        sb.append("id=").append(id);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", subComida=").append(subComida);
        sb.append(", precio=").append(precio);
        sb.append(", iva=").append(iva);
        sb.append(", stock=").append(stock);
        sb.append('}');
        return sb.toString();
    }
    
    //Insertamos el hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
        hash = 73 * hash + Objects.hashCode(this.descripcion);
        hash = 73 * hash + Objects.hashCode(this.subComida);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 73 * hash + Objects.hashCode(this.iva);
        hash = 73 * hash + this.stock;
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
        final Comida other = (Comida) obj;
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
        if (this.subComida != other.subComida) {
            return false;
        }
        return this.iva == other.iva;
    }
    
    
    
}
