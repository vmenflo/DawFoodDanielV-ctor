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
final public class Bebida extends Productos {
    //Creación de atributos encapsulados
    private SubCategoriaBebida subBebida;
    
    //insertamos constructor parametrizado y sin parametrizar
    public Bebida(SubCategoriaBebida subBebida, int id, String descripcion, double precio, Iva iva, int stock) {
        super(id, descripcion, precio, iva, stock);
        this.subBebida = subBebida;
    }
    public Bebida() {
    }
    
    //insertamos getter y setter
    public SubCategoriaBebida getSubBebida() {
        return subBebida;
    }

    public void setSubBebida(SubCategoriaBebida subBebida) {
        this.subBebida = subBebida;
    }
    
    //insertamos toString

    @Override
    public String toString() {
        return super.toString() + "Bebida{" + "subBebida=" + subBebida + '}';
    }
    
    //insertamos equals y hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.subBebida);
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
        final Bebida other = (Bebida) obj;
        return this.subBebida == other.subBebida;
    }
    
}
