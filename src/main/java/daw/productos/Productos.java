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
//la ponemos como abstract ya que no se va a poder crear objetos de esta clase,
//las hijas heredarán todo y las hijas si se podrán crear
public abstract class Productos {
    //Creamos atributos encapsulados

    private int id;
    private String descripcion;
    private double precio;
    private Iva iva;
    private int stock = 0;
    private int cantidadPedida = 0;

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

    //Método para que elija qué quiere modificar de la comida
    //En el TPV habra un switch y depende de lo que coja
    final public static String elegirQueCambiar() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        String[] opciones = {"Descripción", "Subcategoría", "Precio", "Iva", "stock"};

        String eleccion = (String) JOptionPane.showInputDialog(null,
                "Elige el campo que quiere modificar:",
                "Seleccione para modificar",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (eleccion == null) {
            JOptionPane.showMessageDialog(null,
                    "Debes elegir entre las opciones", "Aviso",
                    JOptionPane.WARNING_MESSAGE, null);
            return null;
        }

        return eleccion;
    }

    //Método para que elija entre las categorías que hay
    final public static String elegirCategorias() {
        //Creamos un array de String para hacer un desplegable y que elija 
        //la categoría
        String[] opciones = {"Comida", "Bebida", "Postres", "salir"};

        String eleccion = (String) JOptionPane.showInputDialog(null,
                "Elige la categoría:",
                "Seleccione Categoría",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        if (eleccion != null) {
            return eleccion;
        } else {
            return eleccion = "salir";
        }
    }
    
    //Método para mostrar un desplegable de Iva comida
    final public static Iva elegirIva() {
        //Creamos un array de String para hacer un desplegable y que elija qué
        //es lo que quiere cambiar
        Iva[] opciones = Iva.values();

        Iva eleccion = (Iva) JOptionPane.showInputDialog(null,
                "Elige el IVA",
                "Selección de IVA",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }
}
