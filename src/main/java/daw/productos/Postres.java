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
    //insertamos constructor parametrizado y sin parametrizar
    public Postres(int id, String descripcion, double precio, Iva iva, int stock) {
        super(id, descripcion, precio, iva, stock);
    }
    public Postres() {
    }
    
    //insertamos toString
    @Override
    public String toString() {
        return super.toString() + "Postres{" + "tipoPostre=" + '}';
    }    
}
