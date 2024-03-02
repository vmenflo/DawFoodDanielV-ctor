/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import daw.Iva;
import static daw.productos.SubCategoriaComida.PESCADO;
import static daw.productos.SubCategoriaComida.POLLO;
import static daw.productos.SubCategoriaComida.TERNERA;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author danielnavasborjas
 */
public class ListasProductos {

    //Creamos los atributos encapsulados de tipo ArrayList
    private ArrayList<Productos> listaProductos;

    //Creamos constructor por defecto
    public ListasProductos() {
        this.listaProductos = new ArrayList<>();
    }

    //Insertamos los getters y setter
    public ArrayList<Productos> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    //Insertamos el método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListasProductos{");
        sb.append("listaProductos=").append(listaProductos);
        sb.append('}');
        return sb.toString();
    }
    
    //Insertamos los métodos que vamos a usar sobre estas listas para poder 
    //trabajar con ellas
    public void añadirUnElemento(Productos productoAGuardar) {
        listaProductos.add(productoAGuardar);
    }

    public void añadirUnElementoCarrito(Productos productoAGuardar, int cantidad) {
        productoAGuardar.setCantidadPedida(cantidad);
        listaProductos.add(productoAGuardar);
    }

    //Método para para que cuando escoja entre una de las categorias muestre dichas
    public ArrayList<Comida> filtrarPorSubCategoriaComida(SubCategoriaComida elegirSub) {
        //Creamos el ArrayList que vamos a devolver
        ArrayList<Comida> comidaAMostrar = new ArrayList<>();

        //Depende de la subcategoría se ejecutará una de estas lógicas
        switch (elegirSub) {
            case POLLO -> {
                //Bucle para que vaya añadiendo las comidas de subcategoria pollo
                for (int i = 0; i < listaProductos.size(); i++) {
                    //con en el instanceof miramos que el producto en concreto
                    //de tipo Comida
                    if (listaProductos.get(i) instanceof Comida) {
                        //con esta lógica conseguimos que se vaya añadiendo
                        //todos los elementos que tengan una subcategoria de pollo
                        if (((Comida) listaProductos.get(i)).getSubComida().equals(SubCategoriaComida.POLLO)) {
                            comidaAMostrar.add((Comida) listaProductos.get(i));
                        }
                    }
                }
            }
            case PESCADO -> {
                //Bucle para que vaya añadiendo las comidas de subcategoria pescado
                for (int i = 0; i < listaProductos.size(); i++) {
                    //con en el instanceof miramos que el producto en concreto
                    //de tipo Comida
                    if (listaProductos.get(i) instanceof Comida) {
                        //con esta lógica conseguimos que se vaya añadiendo
                        //todos los elementos que tengan una subcategoria de pescado
                        if (((Comida) listaProductos.get(i)).getSubComida().equals(SubCategoriaComida.PESCADO)) {
                            comidaAMostrar.add((Comida) listaProductos.get(i));
                        }
                    }
                }
            }
            case TERNERA -> {
                //Bucle para que vaya añadiendo las comidas de subcategoria ternera
                for (int i = 0; i < listaProductos.size(); i++) {
                    //con en el instanceof miramos que el producto en concreto
                    //de tipo Comida
                    if (listaProductos.get(i) instanceof Comida) {
                        //con esta lógica conseguimos que se vaya añadiendo
                        //todos los elementos que tengan una subcategoria de ternera
                        if (((Comida) listaProductos.get(i)).getSubComida().equals(SubCategoriaComida.TERNERA)) {
                            comidaAMostrar.add((Comida) listaProductos.get(i));
                        }
                    }
                }
            }
        }
        return comidaAMostrar;
    }

    //Método para para que cuando escoja entre una de las categorias muestre dichas
    public ArrayList<Bebida> filtrarPorSubCategoriaBebida(SubCategoriaBebida elegirSub) {
        //Creamos el ArrayList que vamos a devolver
        ArrayList<Bebida> bebidaAMostrar = new ArrayList<>();

        //Depende de la subcategoría se ejecutará una de estas lógicas
        switch (elegirSub) {
            case AGUA -> {
                //Bucle para que vaya añadiendo las bebidas de subcategoria agua
                for (int i = 0; i < listaProductos.size(); i++) {
                    //con en el instanceof miramos que el producto en concreto
                    //de tipo bebida
                    if (listaProductos.get(i) instanceof Bebida) {
                        //con esta lógica conseguimos que se vaya añadiendo
                        //todos los elementos que tengan una subcategoria de agua
                        if (((Bebida) listaProductos.get(i)).getSubBebida().equals(SubCategoriaBebida.AGUA)) {
                            bebidaAMostrar.add((Bebida) listaProductos.get(i));
                        }
                    }
                }
            }
            case CERVEZA -> {
                int eresMayorOMenor = Bebida.eresMayorA18();
                //Lógica para que si es mayor de edad (llamaremos al método a la
                // hora de llamar al método) pueda elegir alguna bebida alcohólica
                if (eresMayorOMenor == 0) {
                    //Bucle para que vaya añadiendo las bebidas de subcategoria cerveza
                    for (int i = 0; i < listaProductos.size(); i++) {
                        //con en el instanceof miramos que el producto en concreto
                        //de tipo bebida
                        if (listaProductos.get(i) instanceof Bebida) {
                            //con esta lógica conseguimos que se vaya añadiendo
                            //todos los elementos que tengan una subcategoria de cerveza
                            if (((Bebida) listaProductos.get(i)).getSubBebida().equals(SubCategoriaBebida.CERVEZA)) {
                                bebidaAMostrar.add((Bebida) listaProductos.get(i));
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Eres menor a 18, no puedes alcoholizarte",
                            "Menor a la vista", JOptionPane.WARNING_MESSAGE);
                }

            }
            case ZUMONARANZA -> {
                //Bucle para que vaya añadiendo las Bebidas de subcategoria zumo de naranja
                for (int i = 0; i < listaProductos.size(); i++) {
                    //con en el instanceof miramos que el producto en concreto
                    //de tipo bebida
                    if (listaProductos.get(i) instanceof Bebida) {
                        //con esta lógica conseguimos que se vaya añadiendo
                        //todos los elementos que tengan una subcategoria de zumo de naranja
                        if (((Bebida) listaProductos.get(i)).getSubBebida().equals(SubCategoriaBebida.ZUMONARANZA)) {
                            bebidaAMostrar.add((Bebida) listaProductos.get(i));
                        }
                    }
                }
            }
        }
        return bebidaAMostrar;
    }

    //método para que elija un producto
    public Productos elegirProducto(String eleccion) {
        //convertimos la lista en un array y lo guardamos en una variable
        //de tipo object
        Object[] opciones;
        ArrayList<Productos> optionList = new ArrayList<>();
        Object seleccion = 0;

        switch (eleccion) {
            case "Comida" -> {
                //en el caso de que fuese comida llamamos al método
                //filtrarPorSubCategoriaComida(), este métod ya comprueba
                //que sea de tipo comida con el instanceof
                opciones = filtrarPorSubCategoriaComida(
                        Comida.elegirSubCategoríaComida()).toArray();

                //Mostramos el cuadro de diálogo para que el usurio elija que elemento
                //de la lista quiere modificar
                seleccion = JOptionPane.showInputDialog(null,
                        "Selecciona una comida:",
                        "Selección de comida",
                        JOptionPane.QUESTION_MESSAGE, null,
                        opciones, opciones[0]);
            }
            case "Bebida" -> {
                //en el caso de que fuese Bebida llamamos al método
                //filtrarPorSubCategoriaBebida(), este método ya comprueba
                //que sea de tipo bebida con el instanceof
                opciones = filtrarPorSubCategoriaBebida(
                        Bebida.elegirSubCategoríaBebida()).toArray();

                //Mostramos el cuadro de diálogo para que el usurio elija que elemento
                //de la lista quiere modificar
                seleccion = JOptionPane.showInputDialog(null,
                        "Selecciona una bebida:",
                        "Selección de bebida",
                        JOptionPane.QUESTION_MESSAGE, null,
                        opciones, opciones[0]);

            }
            case "Postre" -> {
                //hacemos un bucle for para reccorrer todos los elementos
                //de la lista de productos
                for (int i = 0; i < listaProductos.size(); i++) {
                    //hacemos un if con un instanceof para saber si 
                    //es de tipo postre
                    if (listaProductos.get(i) instanceof Postres) {
                        //vamos añadiendo al ArrayList creado con anterioridad
                        //todos los objetos de tipo Postre
                        optionList.add(listaProductos.get(i));
                    }
                }
                //Al array de tipo Object le metemos la lista anterior
                opciones = optionList.toArray();

                //Mostramos el cuadro de diálogo para que el usurio elija que elemento
                //de la lista quiere modificar
                seleccion = JOptionPane.showInputDialog(null,
                        "Selecciona un postre:",
                        "Selección de postre",
                        JOptionPane.QUESTION_MESSAGE, null,
                        opciones, opciones[0]);
            }
        }

        //Verificar si el usuario seleccionó algo o no y devolver 
        //el elemento seleccionado
        if (seleccion != null) {
            //hacemos un instanceof para saber que objeto devolver
            if (seleccion instanceof Comida) {
                //Hacemos un casting para devolver un objeto de Comida
                return (Comida) seleccion;
            }
            if (seleccion instanceof Bebida) {
                //Hacemos un casting para devolver un objeto de Comida
                return (Bebida) seleccion;
            }
            if (seleccion instanceof Postres) {
                //Hacemos un casting para devolver un objeto de Comida
                return (Postres) seleccion;
            }

        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento",
                    "Ninguna Selección", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    //Método para modificar una producto en concreto
    public void editarProducto(Productos productosAModificar, String queCambiar) {
        //Hacemos una condición por si es null que no se edite la comida
        if (productosAModificar != null && queCambiar != null) {
            switch (queCambiar) {
                case "Descripción" -> {
                    String descripcionNueva = JOptionPane.showInputDialog(
                            "Introduce la nueva descripción");
                    productosAModificar.setDescripcion(descripcionNueva);
                }
                case "Subcategoría" -> {
                    if (productosAModificar instanceof Comida) {
                        ((Comida) productosAModificar).setSubComida(Comida.elegirSubCategoríaComida());
                    }
                    if (productosAModificar instanceof Bebida) {
                        ((Bebida) productosAModificar).setSubBebida(Bebida.elegirSubCategoríaBebida());
                    }
                    if (productosAModificar instanceof Postres) {
                        JOptionPane.showMessageDialog(null,
                                "Postre no tiene Subcategorías",
                                "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                }
                case "Precio" -> {
                    double precioNuevo;
                    try {
                        //Le preguntamos al usuario en una variable String
                        //para poder controlar la excepción
                        String nuevo = JOptionPane.showInputDialog(
                                "Introduce el nuevo precio");

                        //Lógica para controlar excepción
                        if (nuevo != null) {
                            precioNuevo = Double.parseDouble(nuevo);
                            //Modificamos el precio
                            productosAModificar.setPrecio(precioNuevo);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Debes elegir entre las opciones", "Aviso",
                                    JOptionPane.WARNING_MESSAGE, null);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Debes Introducir el precio con números",
                                "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                }
                case "Iva" -> {
                    productosAModificar.setIva(Productos.elegirIva());
                }
                case "stock" -> {

                    int stockNuevo = 0;
                    try {
                        stockNuevo = Integer.parseInt(JOptionPane.showInputDialog(
                                "Introduce el nuevo stock"));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,
                                "Debes Introducir el stock con números",
                                "Alerta", JOptionPane.WARNING_MESSAGE);
                    }
                    productosAModificar.setStock(stockNuevo);
                }
            }
        }

    }
    
    //Método para ver que un id no se repita en una bebida
    public int comprobarIdUnicoProducto() {
        //Inicializamos variables
        int id = 0;
        int posicionABuscar = -1;
        //ordenamos por id para luego hacer una búsqueda binaria, para que si
        //encuentra dicho número, se repita
        Collections.sort(listaProductos, (e1, e2) -> e1.getId() - e2.getId());
        do {
            //le preguntamos al usuario que id quiere introducir
            id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id"));

            //Hacemos un for para ver en productos de qué tipo es
            // y en función del tipo que sea se hace una busqueda binaria
            // a ese producto en concreto
            for (Productos listaProducto : listaProductos) {
                //si listaProducto es de tipo comida hace busqueda binaria en
                //comida
                if (listaProducto instanceof Comida) {
                    Comida x = new Comida();
                    x.setId(id);

                    //Comprobamos y guardamos en una variable si ha encontrado 
                    // el id introducido
                    posicionABuscar = Collections.binarySearch(listaProductos,
                            x, (e1, e2) -> e1.getId() - e2.getId());
                }
                //si listaProducto es de tipo bebida hace busqueda binaria en
                //bebida
                if (listaProducto instanceof Bebida) {
                    Bebida x = new Bebida();
                    x.setId(id);

                    //Comprobamos y guardamos en una variable si ha encontrado 
                    // el id introducido
                    posicionABuscar = Collections.binarySearch(listaProductos,
                            x, (e1, e2) -> e1.getId() - e2.getId());
                }
                //si listaProducto es de tipo postre hace busqueda binaria en
                //postre
                if (listaProducto instanceof Postres) {
                    Postres x = new Postres();
                    x.setId(id);

                    //Comprobamos y guardamos en una variable si ha encontrado 
                    // el id introducido
                    posicionABuscar = Collections.binarySearch(listaProductos,
                            x, (e1, e2) -> e1.getId() - e2.getId());
                }
            }
            if (posicionABuscar > -1) {
                JOptionPane.showMessageDialog(null,
                        "El id ya existe",
                        "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } while (posicionABuscar > -1);
        return id;
    }

    //Método para dar de altas nueva comida
    //eleccion es para que en el switch del main escoja si es de tipo comida
    //o de tipo bebida o de tipo postre
    public void nuevaProducto(String eleccion) {
        //Inicializamos variables
        int id = 0;
        String descripcion = "";
        double precio = 0;
        int stock = 0;
        //esta variable es para que se repita el proceso hasta que
        //ponga bien los datos
        boolean repetir;

        //Bucle para que se repita el programa hasta ponga bien los datos
        do {
            //Controlamos las excepciones
            try {
                id = comprobarIdUnicoProducto();

                //Añadimos al nuevo producto nueva descripción
                descripcion = JOptionPane.showInputDialog(
                        "Introduce nueva descripción de " + eleccion);

                //Añadimos un precio al producto nuevo
                precio = Double.parseDouble(JOptionPane.showInputDialog(
                        "Introduce un precio a la nueva " + eleccion));

                //Añadimos un stock al nuevo producto
                stock = Integer.parseInt(JOptionPane.showInputDialog(
                        "Introduce el stock"));
                repetir = false;
            } catch (NumberFormatException j) {
                JOptionPane.showMessageDialog(null,
                        "Debes rellenar los campos bien", "Aviso",
                        JOptionPane.WARNING_MESSAGE, null);
                repetir = true;
            }
        } while (repetir);

        //Añadimos el nuevo producto creado
        //hacemos un switch para si la eleccion es de tipo comida, bebida o postre
        //se guarde el tipo correctamente
        switch (eleccion) {
            case "Comida" -> {
                añadirUnElemento(new Comida(id, descripcion,
                        Comida.elegirSubCategoríaComida(),
                        precio, Productos.elegirIva(), stock));
            }
            case "Bebida" -> {
                añadirUnElemento(new Bebida(id, descripcion,
                        Bebida.elegirSubCategoríaBebida(), precio,
                        Productos.elegirIva(), stock));
            }
            case "Postres" -> {
                añadirUnElemento(new Postres(id, descripcion, precio,
                        Productos.elegirIva(), stock));
            }
        }
    }

    //Método para borrar productos existentes
    public void borrarProductos(String elegirCategoria) {
        boolean retroceso = false;

        do {
            switch (elegirCategoria) {
                case "Comida" -> {
                    //llamamos al metodo elegirComida para que nos muestre cuál
                    //quiere borrar
                    Comida comidaABorrar = (Comida)elegirProducto(elegirCategoria);
                    this.listaProductos.remove(comidaABorrar);
                }
                case "Bebida" -> {
                    //llamamos al metodo elegirComida para que nos muestre cuál
                    //quiere borrar
                    Bebida bebidaABorrar = (Bebida)elegirProducto(elegirCategoria);
                    this.listaProductos.remove(bebidaABorrar);
                }
                case "Postres" -> {
                    //llamamos al metodo elegirComida para que nos muestre cuál
                    //quiere borrar
                    Postres postreABorrar = (Postres)elegirProducto(elegirCategoria);
                    this.listaProductos.remove(postreABorrar);
                }
                case "salir" -> {
                    retroceso = true;
                }
            }
        } while (!retroceso);

    }
    
    //Método para preguntar qué cantidad quiere de Cualquier producto
    public int preguntarPorCantidadProductoCarrito(Productos prodcutos) {
        boolean okey = false;
        int cantidad = 0;
        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Qué cantidad quieres añadir?"));
                if (cantidad > 0 && cantidad <= prodcutos.getStock()) {
                    okey = true;
                    prodcutos.setStock(prodcutos.getStock() - cantidad);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Los siento, nuestro stock es de " + prodcutos.getStock());
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error al introducir la cantidad" + e);
            }
        } while (!okey);
        return cantidad;
    }

    //Método para mostrar lista de carrito
    public void verCarrito() {

        StringBuilder sb = new StringBuilder();
        sb.append("                    CARRITO\n");
        sb.append("\n");
        for (int i = 0; i < listaProductos.size(); i++) {
            sb.append("Producto: ").append(listaProductos.get(i).getDescripcion()).append(" precio ").append(listaProductos.get(i).getPrecio()).append(" € ").append(" x ").append(listaProductos.get(i).getCantidadPedida()).append("\n");
        }
        sb.append("\n");
        sb.append(totalCarrito());
        JOptionPane.showMessageDialog(null, sb);

    }

    //Método para calcular totalCarrito
    public String totalCarrito() {
        double total = 0;
        double iva = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
            double precio = listaProductos.get(i).getPrecio();
            int cantidad = listaProductos.get(i).getCantidadPedida();
            double importe = precio * cantidad;
            total += importe;
            double IVA = listaProductos.get(i).getIva().getCantidadIva();
            iva += precio * IVA;
        }
        String texto = """
                      El importe total es de %.2f €
                                            (IVA %.2f €)
                      """.formatted(total, iva);
        return texto;
    }
}