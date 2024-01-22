/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class ListasProductos {

    //Creamos los atributos encapsulados de tipo ArrayList
    private ArrayList<Comida> listaComida;
    private ArrayList<Bebida> listaBebida;
    private ArrayList<Postres> listaPostres;

    //Creamos constructor por defecto
    public ListasProductos() {
        this.listaComida = new ArrayList<>();
        this.listaBebida = new ArrayList<>();
        this.listaPostres = new ArrayList<>();
    }

    //Insertamos los getters y setter
    public ArrayList<Comida> getListaComida() {
        return listaComida;
    }

    public void setListaComida(ArrayList<Comida> listaComida) {
        this.listaComida = listaComida;
    }

    public ArrayList<Bebida> getListaBebida() {
        return listaBebida;
    }

    public void setListaBebida(ArrayList<Bebida> listaBebida) {
        this.listaBebida = listaBebida;
    }

    public ArrayList<Postres> getListaPostres() {
        return listaPostres;
    }

    public void setListaPostres(ArrayList<Postres> listaPostres) {
        this.listaPostres = listaPostres;
    }

    //Insertamos el método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListasProductos{");
        sb.append("listaComida=").append(listaComida);
        sb.append(", listaBebida=").append(listaBebida);
        sb.append(", listaPostres=").append(listaPostres);
        sb.append('}');
        return sb.toString();
    }

    //Por ahora no metemos hashcode ni equals, porque no necesitamos comparar
    //estas listas, comentar con victor y llegar a un acuerdo 
    //Insertamos los métodos que vamos a usar sobre estas listas para poder 
    //trabajar con ellas
    //Hacemos 3 métodos para poder añadir productos a cada una de las lista:
    public void añadirUnElemento(Comida comidaAGuardar) {
        listaComida.add(comidaAGuardar);
    }

    public void añadirUnElemento(Bebida bebidaAGuardar) {
        listaBebida.add(bebidaAGuardar);
    }

    public void añadirUnElemento(Postres postresAGuardar) {
        listaPostres.add(postresAGuardar);
    }

    //Método para que elija que comida quiere modificar
    public Comida elegirComida() {
        //Convertimos la lista en un array y lo guardamos en una variable de
        //tipo object
        Object[] opciones = listaComida.toArray();

        //Mostramos el cuadro de diálogo para que el usurio elija que elemento
        //de la lista quiere modificar
        Object seleccion = JOptionPane.showInputDialog(null, "Selecciona una comida a modificar:",
                "Selección de comida", JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        //Verificar si el usuario seleccionó algo o no y devolver el elemento seleccionado
        if (seleccion != null) {
            //Hacemos un casting para devolver un objeto de Comida
            return (Comida) seleccion;
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento",
                    "Ninguna Selección", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    //Método para que elija que bebida quiere modificar
    public Bebida elegirBebida() {
        //Convertimos la lista en un array y lo guardamos en una variable de
        //tipo object
        Object[] opciones = listaBebida.toArray();

        //Mostramos el cuadro de diálogo para que el usurio elija que elemento
        //de la lista quiere modificar
        Object seleccion = JOptionPane.showInputDialog(null, "Selecciona una bebida a modificar:",
                "Selección de bebida", JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        //Verificar si el usuario seleccionó algo o no y devolver el elemento seleccionado
        if (seleccion != null) {
            //Hacemos un casting para devolver un objeto de Bebida
            return (Bebida) seleccion;
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento",
                    "Ninguna Selección", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    //Método para que elija que postre quiere modificar
    public Postres elegirPostres() {
        //Convertimos la lista en un array y lo guardamos en una variable de
        //tipo object
        Object[] opciones = listaBebida.toArray();

        //Mostramos el cuadro de diálogo para que el usurio elija que elemento
        //de la lista quiere modificar
        Object seleccion = JOptionPane.showInputDialog(null,
                "Selecciona un postre a modificar:",
                "Selección de postres",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        //Verificar si el usuario seleccionó algo o no y devolver el elemento seleccionado
        if (seleccion != null) {
            //Hacemos un casting para devolver un objeto de Postres
            return (Postres) seleccion;
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento",
                    "Ninguna Selección", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    //Método para modificar una comida en concreto
    public void editarComida(Comida comidaAModificar, String queCambiar) {
        switch (queCambiar) {
            case "Descripción" -> {
                String descripcionNueva = JOptionPane.showInputDialog(
                        "Introduce la nueva descripción");
                comidaAModificar.setDescripcion(descripcionNueva);
            }
            case "Subcategoría" -> {
                comidaAModificar.setSubComida(MetodosProductos.elegirSubCategoríaComida());
            }
            case "Precio" -> {
                double precioNuevo = 0;
                try {
                    precioNuevo = Double.parseDouble(JOptionPane.showInputDialog(
                            "Introduce el nuevo precio"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debes Introducir el precio con números", "Alerta", JOptionPane.WARNING_MESSAGE);
                }

                comidaAModificar.setPrecio(precioNuevo);
            }
            case "Iva" -> {
                comidaAModificar.setIva(MetodosProductos.elegirIva());
            }
            case "stock" -> {

                int stockNuevo = 0;
                try {
                    stockNuevo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Introduce el nuevo stock"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debes Introducir el stock con números", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                comidaAModificar.setStock(stockNuevo);
            }
        }
    }
    
    //Método para modificar una bebida en concreto
    public void editarBebida(Bebida bebidaAModificar, String queCambiar) {
        switch (queCambiar) {
            case "Descripción" -> {
                String descripcionNueva = JOptionPane.showInputDialog(
                        "Introduce la nueva descripción");
                bebidaAModificar.setDescripcion(descripcionNueva);
            }
            case "Subcategoría" -> {
                bebidaAModificar.setSubBebida(MetodosProductos.elegirSubCategoríaBebida());
            }
            case "Precio" -> {
                double precioNuevo = 0;
                try {
                    precioNuevo = Double.parseDouble(JOptionPane.showInputDialog(
                            "Introduce el nuevo precio"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debes Introducir el precio con números", "Alerta", JOptionPane.WARNING_MESSAGE);
                }

                bebidaAModificar.setPrecio(precioNuevo);
            }
            case "Iva" -> {
                bebidaAModificar.setIva(MetodosProductos.elegirIva());
            }
            case "stock" -> {

                int stockNuevo = 0;
                try {
                    stockNuevo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Introduce el nuevo stock"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debes Introducir el stock con números", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                bebidaAModificar.setStock(stockNuevo);
            }
        }
    }
    
    //Método para modificar un postre en concreto
    public void editarPostres(Postres postreAModificar, String queCambiar) {
        switch (queCambiar) {
            case "Descripción" -> {
                String descripcionNueva = JOptionPane.showInputDialog(
                        "Introduce la nueva descripción");
                postreAModificar.setDescripcion(descripcionNueva);
            }
            case "Subcategoría" -> {
                JOptionPane.showMessageDialog(null, 
                        "No hay subcategoría de postres", 
                        "NO EXISTE SUBCATEGORÍA", 
                        JOptionPane.WARNING_MESSAGE);
            }
            case "Precio" -> {
                double precioNuevo = 0;
                try {
                    precioNuevo = Double.parseDouble(JOptionPane.showInputDialog(
                            "Introduce el nuevo precio"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debes Introducir el precio con números", "Alerta", JOptionPane.WARNING_MESSAGE);
                }

                postreAModificar.setPrecio(precioNuevo);
            }
            case "Iva" -> {
                postreAModificar.setIva(MetodosProductos.elegirIva());
            }
            case "stock" -> {

                int stockNuevo = 0;
                try {
                    stockNuevo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Introduce el nuevo stock"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,
                            "Debes Introducir el stock con números", "Alerta", JOptionPane.WARNING_MESSAGE);
                }
                postreAModificar.setStock(stockNuevo);
            }
        }
    }
}
