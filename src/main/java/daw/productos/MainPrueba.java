/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class MainPrueba {
    public static void main(String[] args) {
        //Añadimos comida
        Comida cm1 = new Comida(1, "Charmander", SubCategoriaComida.POLLO, 2.3, Iva.IVA_COMIDA, 5);
        
        ListasProductos l1 = new ListasProductos();
        
        //Añadimos a la lista la comida
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        l1.añadirUnElemento(cm1);
        
//        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduzca posición"));
//        
//        JOptionPane.showMessageDialog(null, l1.getListaComida().get(pos));
//        
//        String des = JOptionPane.showInputDialog("¿Desea modificar descripcion?");
//        
//        double precio = Double.parseDouble(JOptionPane.showInputDialog("¿Desea modificar el precio?"));
//        
//        int stock = Integer.parseInt(JOptionPane.showInputDialog("Introduzca stock"));
//        
//        l1.modificarProductos(pos, des, precio, stock);
//        
        l1.elegirComida();
        l1.editarComida(l1.elegirComida(), MetodosProductos.elegirQueCambiar());
        
        
        System.out.println(l1.getListaComida().get(0));
        
        
    }
}
