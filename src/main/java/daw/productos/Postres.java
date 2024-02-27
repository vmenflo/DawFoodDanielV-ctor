/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
final public class Postres extends Productos{
    //Creamos atributos encapsulados
    private String tipoPostre;

    //insertamos constructor parametrizado y sin parametrizar
    public Postres(String tipoPostre, int id, String descripcion, double precio, Iva iva, int stock) {
        super(id, descripcion, precio, iva, stock);
        this.tipoPostre = tipoPostre;
    }
    public Postres() {
    }
    
    //insertamos getter y setter
    public String getTipoPostre() {
        return tipoPostre;
    }

    public void setTipoPostre(String tipoPostre) {
        this.tipoPostre = tipoPostre;
    }
    
    //insertamos toString

    @Override
    public String toString() {
        return super.toString() + "Postres{" + "tipoPostre=" + tipoPostre + '}';
    }
    
    //insertamos equals y hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.tipoPostre);
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
        final Postres other = (Postres) obj;
        return Objects.equals(this.tipoPostre, other.tipoPostre);
    }
    
}
