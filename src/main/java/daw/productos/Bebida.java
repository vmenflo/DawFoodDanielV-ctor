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

    //Método para mostrar un desplegable de subcategoría Bebida
    public static SubCategoriaBebida elegirSubCategoríaBebida() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Object[] opciones = SubCategoriaBebida.values();
        SubCategoriaBebida eleccion;

        //Hacemos un bucle para que tenga que elegir sí o sí una subcategoría
        do {
            eleccion = (SubCategoriaBebida) JOptionPane.showInputDialog(null,
                    "Elige la subcategoría",
                    "Selección de subcategoría",
                    JOptionPane.QUESTION_MESSAGE, null,
                    opciones, opciones[0]);
        } while (eleccion == null);

        return eleccion;
    }

    //Método para preguntar al usuario si es mayor de edad
    public static int eresMayorA18() {
        //Hago un array que tiene solo los valores "Si" y "No"
        String[] elegir = {"Si", "No"};
        int mayorOMenorA18 = JOptionPane.showOptionDialog(
                null,
                "¿Eres Mayor de edad?",
                "Restricción de edad",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                elegir,
                elegir[1]);
        return mayorOMenorA18;
    }
}
