 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class MetodosProductos {
    //Hacemos un método donde estén todos los datos cargados
    public static ListasProductos datosProductos() {
        //Creamos los productos principales
        //Comidas:
//        Comida c1 = new Comida(1, "McPollo",
//                SubCategoriaComida.POLLO, 2.5,
//                Iva.IVA_COMIDA, 150);
//        Comida c2 = new Comida(2, "McTernera",
//                SubCategoriaComida.TERNERA, 3.2,
//                Iva.IVA_COMIDA, 150);
//        Comida c3 = new Comida(3, "McPescado",
//                SubCategoriaComida.PESCADO, 2.1,
//                Iva.IVA_COMIDA, 150);
//        //Bebidas:
//        Bebida b1 = new Bebida(1, "Agua natural",
//                SubCategoriaBebida.AGUA, 1,
//                Iva.IVA_REFRESCOS, 200);
//        Bebida b2 = new Bebida(2, "Zumo Naranja",
//                SubCategoriaBebida.ZUMONARANZA, 1.5,
//                Iva.IVA_RESTOBEBIDAS, 50);
//        Bebida b3 = new Bebida(3, "Cerveza",
//                SubCategoriaBebida.CERVEZA, 1.6,
//                Iva.IVA_ALCOHOL, 200);
//        //Postres:
//        Postres p1 = new Postres(1, "Milk Shake", 3.5,
//                Iva.IVA_POSTRES, 100);
//        Postres p2 = new Postres(2, "Browni", 3,
//                Iva.IVA_POSTRES, 300);
//        Postres p3 = new Postres(3, "Gofres", 3.8,
//                Iva.IVA_POSTRES, 178);
//
//        //Instanciamos el objeto
       ListasProductos listaDeProductos = new ListasProductos();
//
//        //Añadimos todos los objetos a sus listas:
//        listaDeProductos.añadirUnElemento(c1);
//        listaDeProductos.añadirUnElemento(c2);
//        listaDeProductos.añadirUnElemento(c3);
//        listaDeProductos.añadirUnElemento(b1);
//        listaDeProductos.añadirUnElemento(b2);
//        listaDeProductos.añadirUnElemento(b3);
//        listaDeProductos.añadirUnElemento(p1);
//        listaDeProductos.añadirUnElemento(p2);
//        listaDeProductos.añadirUnElemento(p3);
        LecturaFicheros.generarListaDeComida(listaDeProductos);
        LecturaFicheros.generarListaDeBebida(listaDeProductos);
        LecturaFicheros.generarListaDePostre(listaDeProductos);

        return listaDeProductos;
    }
}
