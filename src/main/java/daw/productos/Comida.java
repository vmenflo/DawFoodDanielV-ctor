/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;
import daw.Iva;
import java.util.Objects;

/**
 *
 * @author daniel
 */
final public class Comida extends Productos{
    //Creamos atributos encapsulados
    private SubCategoriaComida subComida;
    
    //insertamos constructor parametrizado y sin parametrizar
    public Comida(SubCategoriaComida subComida, int id, String descripcion, double precio, Iva iva, int stock) {
        super(id, descripcion, precio, iva, stock);
        this.subComida = subComida;
    }
    public Comida() {
    }
    
    //insertamos getter y setters
    public SubCategoriaComida getSubComida() {
        return subComida;
    }

    public void setSubComida(SubCategoriaComida subComida) {
        this.subComida = subComida;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        return super.toString() + "Comida{" + "subComida=" + subComida + '}';
    }
    
    //insertamos equal y hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.subComida);
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
        final Comida other = (Comida) obj;
        return this.subComida == other.subComida;
    }
    
}
