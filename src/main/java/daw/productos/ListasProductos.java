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
    private ArrayList<Comida> listaComida;
    private ArrayList<Bebida> listaBebida;
    private ArrayList<Postres> listaPostres;
    private ArrayList<Productos> listaProductos;

    //Creamos constructor por defecto
    public ListasProductos() {
        this.listaComida = new ArrayList<>();
        this.listaBebida = new ArrayList<>();
        this.listaPostres = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
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
    
    public void añadirUnElemento(Productos productoAGuardar) {
        listaProductos.add(productoAGuardar);
    }

    //Hacemos 3 métodos para poder añadir productos a Carrito:
    public void añadirUnElementoCarrito(Comida comidaAGuardar, int cantidad) {
        comidaAGuardar.setCantidadPedida(cantidad);
        listaComida.add(comidaAGuardar);
    }

    public void añadirUnElementoCarrito(Bebida bebidaAGuardar, int cantidad) {
        bebidaAGuardar.setCantidadPedida(cantidad);
        listaBebida.add(bebidaAGuardar);
    }

    public void añadirUnElementoCarrito(Postres postresAGuardar, int cantidad) {
        postresAGuardar.setCantidadPedida(cantidad);
        listaPostres.add(postresAGuardar);
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
                for (int i = 0; i < listaComida.size(); i++) {
                    //con esta lógica conseguimos que se vaya añadiendo
                    //todos los elementos que tengan una subcategoria de pollo
                    if (listaComida.get(i).getSubComida().equals(SubCategoriaComida.POLLO)) {
                        comidaAMostrar.add(listaComida.get(i));
                    }
                }
            }
            case PESCADO -> {
                //Bucle para que vaya añadiendo las comidas de subcategoria pescado
                for (int i = 0; i < listaComida.size(); i++) {
                    //con esta lógica conseguimos que se vaya añadiendo
                    //todos los elementos que tengan una subcategoria de pescado
                    if (listaComida.get(i).getSubComida().equals(SubCategoriaComida.PESCADO)) {
                        comidaAMostrar.add(listaComida.get(i));
                    }
                }
            }
            case TERNERA -> {
                //Bucle para que vaya añadiendo las comidas de subcategoria ternera
                for (int i = 0; i < listaComida.size(); i++) {
                    //con esta lógica conseguimos que se vaya añadiendo
                    //todos los elementos que tengan una subcategoria de ternera
                    if (listaComida.get(i).getSubComida().equals(SubCategoriaComida.TERNERA)) {
                        comidaAMostrar.add(listaComida.get(i));
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
                for (int i = 0; i < listaComida.size(); i++) {
                    //con esta lógica conseguimos que se vaya añadiendo
                    //todos los elementos que tengan una subcategoria de agua
                    if (listaBebida.get(i).getSubBebida().equals(SubCategoriaBebida.AGUA)) {
                        bebidaAMostrar.add(listaBebida.get(i));
                    }
                }
            }
            case CERVEZA -> {
                int eresMayorOMenor = MetodosProductos.eresMayorA18();
                //Lógica para que si es mayor de edad (llamaremos al método a la
                // hora de llamar al método) pueda elegir alguna bebida alcohólica
                if (eresMayorOMenor == 0) {
                    //Bucle para que vaya añadiendo las bebidas de subcategoria cerveza
                    for (int i = 0; i < listaComida.size(); i++) {
                        //con esta lógica conseguimos que se vaya añadiendo
                        //todos los elementos que tengan una subcategoria de cerveza
                        if (listaBebida.get(i).getSubBebida().equals(SubCategoriaBebida.CERVEZA)) {
                            bebidaAMostrar.add(listaBebida.get(i));
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
                for (int i = 0; i < listaComida.size(); i++) {
                    //con esta lógica conseguimos que se vaya añadiendo
                    //todos los elementos que tengan una subcategoria de zumo de naranja
                    if (listaBebida.get(i).getSubBebida().equals(SubCategoriaBebida.ZUMONARANZA)) {
                        bebidaAMostrar.add(listaBebida.get(i));
                    }
                }
            }
        }
        return bebidaAMostrar;
    }

    //Método para que elija que comida quiere modificar
    public Comida elegirComida() {
        //Convertimos la lista en un array y lo guardamos en una variable de
        //tipo object
        Object[] opciones = filtrarPorSubCategoriaComida(
                MetodosProductos.elegirSubCategoríaComida()).toArray();

        //Mostramos el cuadro de diálogo para que el usurio elija que elemento
        //de la lista quiere modificar
        Object seleccion = JOptionPane.showInputDialog(null,
                "Selecciona una comida:", "Selección de comida",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);

        //Verificar si el usuario seleccionó algo o no y devolver el elemento seleccionado
        if (seleccion != null) {
            //Hacemos un casting para devolver un objeto de Comida
            return (Comida) seleccion;
        } else {
            JOptionPane.showMessageDialog(null,
                    "No ha seleccionado ningún elemento",
                    "Ninguna Selección", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    //Método para que elija que bebida quiere modificar
    public Bebida elegirBebida() {
        //Convertimos la lista en un array y lo guardamos en una variable de
        //tipo object
        Object[] opciones = filtrarPorSubCategoriaBebida(
                MetodosProductos.elegirSubCategoríaBebida()).toArray();

        //Mostramos el cuadro de diálogo para que el usurio elija que elemento
        //de la lista quiere modificar
        Object seleccion = JOptionPane.showInputDialog(null,
                "Selecciona una bebida:", "Selección de bebida",
                JOptionPane.QUESTION_MESSAGE, null,
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
        Object[] opciones = listaPostres.toArray();

        //Mostramos el cuadro de diálogo para que el usurio elija que elemento
        //de la lista quiere modificar
        Object seleccion = JOptionPane.showInputDialog(null,
                "Selecciona un postre:",
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
        //Hacemos una condición por si es null que no se edite la comida
        if (comidaAModificar != null && queCambiar != null) {
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
                            comidaAModificar.setPrecio(precioNuevo);
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
                    comidaAModificar.setIva(MetodosProductos.elegirIva());
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
                    comidaAModificar.setStock(stockNuevo);
                }
            }
        }

    }

    //Método para modificar una bebida en concreto
    public void editarBebida(Bebida bebidaAModificar, String queCambiar) {
        //Hacemos una condición por si es null que no se edite la bebida
        if (bebidaAModificar != null && queCambiar != null) {
            switch (queCambiar) {
                case "Descripción" -> {
                    String descripcionNueva = JOptionPane.showInputDialog(
                            "Introduce la nueva descripción");
                    bebidaAModificar.setDescripcion(descripcionNueva);
                }
                case "Subcategoría" -> {
                    bebidaAModificar.setSubBebida(
                            MetodosProductos.elegirSubCategoríaBebida());
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
                            bebidaAModificar.setPrecio(precioNuevo);
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
                    bebidaAModificar.setIva(MetodosProductos.elegirIva());
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
                    bebidaAModificar.setStock(stockNuevo);
                }
            }
        }
    }

    //Método para modificar un postre en concreto
    public void editarPostres(Postres postreAModificar, String queCambiar) {
        //Hacemos una condición por si es null que no se edite el postre
        if (postreAModificar != null && queCambiar != null) {
            switch (queCambiar) {
                case "Descripción" -> {
                    String descripcionNueva = JOptionPane.showInputDialog(
                            "Introduce la nueva descripción");
                    postreAModificar.setDescripcion(descripcionNueva);
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
                            postreAModificar.setPrecio(precioNuevo);
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
                    postreAModificar.setIva(MetodosProductos.elegirIva());
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
                    postreAModificar.setStock(stockNuevo);
                }
            }
        }
    }

    //Método para ver que un id no se repita en una comida
    public int comprobarIdUnicoComida() {
        //Inicializamos variables
        int id = 0;
        int posicionABuscar = 0;
        //ordenamos por id para luego hacer una búsqueda binaria, para que si
        //encuentra dicho número, se repita
        Collections.sort(listaComida, (e1, e2) -> e1.getId() - e2.getId());
        do {
            //le preguntamos al usuario que id quiere introducir
            id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id"));

            //Le indicamos qué buscar posteriormente con el binarySearch
            Comida x = new Comida();
            x.setId(id);

            //Comprobamos y guardamos en una variable si ha encontrado 
            // el id introducido
            posicionABuscar = Collections.binarySearch(listaComida,
                    x, (e1, e2) -> e1.getId() - e2.getId());
        } while (posicionABuscar >= 0);
        return id;
    }

    //Método para ver que un id no se repita en una bebida
    public int comprobarIdUnicoBebida() {
        //Inicializamos variables
        int id = 0;
        int posicionABuscar = 0;
        //ordenamos por id para luego hacer una búsqueda binaria, para que si
        //encuentra dicho número, se repita
        Collections.sort(listaBebida, (e1, e2) -> e1.getId() - e2.getId());
        do {
            //le preguntamos al usuario que id quiere introducir
            id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id"));

            //Le indicamos qué buscar posteriormente con el binarySearch
            Bebida x = new Bebida();
            x.setId(id);

            //Comprobamos y guardamos en una variable si ha encontrado 
            // el id introducido
            posicionABuscar = Collections.binarySearch(listaBebida,
                    x, (e1, e2) -> e1.getId() - e2.getId());
        } while (posicionABuscar >= 0);
        return id;
    }

    //Método para ver que un id no se repita en una bebida
    public int comprobarIdUnicoPostres() {
        //Inicializamos variables
        int id = 0;
        int posicionABuscar = 0;
        //ordenamos por id para luego hacer una búsqueda binaria, para que si
        //encuentra dicho número, se repita
        Collections.sort(listaPostres, (e1, e2) -> e1.getId() - e2.getId());
        do {
            //le preguntamos al usuario que id quiere introducir
            id = Integer.parseInt(JOptionPane.showInputDialog("Introduce el id"));

            //Le indicamos qué buscar posteriormente con el binarySearch
            Postres x = new Postres();
            x.setId(id);

            //Comprobamos y guardamos en una variable si ha encontrado 
            // el id introducido
            posicionABuscar = Collections.binarySearch(listaPostres,
                    x, (e1, e2) -> e1.getId() - e2.getId());
        } while (posicionABuscar >= 0);
        return id;
    }

    //Método para dar de altas nueva comida
    public void nuevaComida() {
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
                id = comprobarIdUnicoComida();

                //Añadimos al nuevo producto nueva descripción
                descripcion = JOptionPane.showInputDialog(
                        "Introduce nueva descripción de comida");

                //Añadimos un precio al producto nuevo
                precio = Double.parseDouble(JOptionPane.showInputDialog(
                        "Introduce un precio a la nueva comida"));

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
        añadirUnElemento(new Comida(id, descripcion,
                MetodosProductos.elegirSubCategoríaComida(), precio,
                MetodosProductos.elegirIva(), stock));
    }

    //Método para dar de altas nueva bebida
    public void nuevaBebida() {
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
                id = comprobarIdUnicoBebida();

                //Añadimos al nuevo producto nueva descripción
                descripcion = JOptionPane.showInputDialog(
                        "Introduce nueva descripción de bebida");

                //Añadimos un precio al producto nuevo
                precio = Double.parseDouble(JOptionPane.showInputDialog(
                        "Introduce un precio a la nueva bebida"));

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
        añadirUnElemento(new Bebida(id, descripcion,
                MetodosProductos.elegirSubCategoríaBebida(), precio,
                MetodosProductos.elegirIva(), stock));
    }

    //Método para dar de altas nuevos postres
    public void nuevoPostre() {
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
                id = comprobarIdUnicoPostres();

                //Añadimos al nuevo producto nueva descripción
                descripcion = JOptionPane.showInputDialog(
                        "Introduce nueva descripción de postres");

                //Añadimos un precio al producto nuevo
                precio = Double.parseDouble(JOptionPane.showInputDialog(
                        "Introduce un precio a el nuevo postre"));

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
        añadirUnElemento(new Postres(id, descripcion, precio,
                MetodosProductos.elegirIva(), stock));
    }

    //Método para borrar productos existentes
    public void borrarProductos(String elegirCategoria) {
        boolean retroceso = false;

        do {
            switch (elegirCategoria) {
                case "Comida" -> {
                    //llamamos al metodo elegirComida para que nos muestre cuál
                    //quiere borrar
                    Comida comidaABorrar = elegirComida();
                    this.listaComida.remove(comidaABorrar);
                }
                case "Bebida" -> {
                    //llamamos al metodo elegirComida para que nos muestre cuál
                    //quiere borrar
                    Bebida bebidaABorrar = elegirBebida();
                    this.listaBebida.remove(bebidaABorrar);
                }
                case "Postres" -> {
                    //llamamos al metodo elegirComida para que nos muestre cuál
                    //quiere borrar
                    Postres postreABorrar = elegirPostres();
                    this.listaPostres.remove(postreABorrar);
                }
                case "salir" -> {
                    retroceso = true;
                }
            }
        } while (!retroceso);

    }

    //Método para preguntar qué cantidad quiere de comida
    public int preguntarPorCantidadComidaCarrito(Comida comida) {
        boolean okey = false;
        int cantidad = 0;
        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Qué cantidad quieres añadir?"));
                if (cantidad > 0 && cantidad <= comida.getStock()) {
                    okey = true;
                    comida.setStock(comida.getStock()-cantidad);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Los siento, nuestro stock es de " + comida.getStock());
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error al introducir la cantidad" + e);
            }
        } while (!okey);
        return cantidad;
    }

    //Método para preguntar qué cantidad quiere de comida
    public int preguntarPorCantidadBebidaCarrito(Bebida bebida) {
        boolean okey = false;
        int cantidad = 0;
        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Qué cantidad quieres añadir?"));
                if (cantidad > 0 && cantidad <= bebida.getStock()) {
                    okey = true;
                    bebida.setStock(bebida.getStock()-cantidad);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Los siento, nuestro stock es de " + bebida.getStock());
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error al introducir la cantidad" + e);
            }
        } while (!okey);
        return cantidad;
    }

    //Método para preguntar qué cantidad quiere de Postres
    public int preguntarPorCantidadPostreCarrito(Postres postre) {
        boolean okey = false;
        int cantidad = 0;
        do {
            try {
                cantidad = Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Qué cantidad quieres añadir?"));
                if (cantidad > 0 && cantidad <= postre.getStock()) {
                    okey = true;
                    postre.setStock(postre.getStock()-cantidad);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Los siento, nuestro stock es de " + postre.getStock());
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
        for (int i = 0; i < listaComida.size(); i++) {
            sb.append("Producto: ").append(listaComida.get(i).getDescripcion()).append(" precio ").append(listaComida.get(i).getPrecio()).append(" € ").append(" x ").append(listaComida.get(i).getCantidaPpedida()).append("\n");
        }
        for (int i = 0; i < listaBebida.size(); i++) {
            sb.append("Producto: ").append(listaBebida.get(i).getDescripcion()).append(" precio ").append(listaBebida.get(i).getPrecio()).append(" € ").append(" x ").append(listaBebida.get(i).getCantidadPedida()).append("\n");
        }
        for (int i = 0; i < listaPostres.size(); i++) {
            sb.append("Producto: ").append(listaPostres.get(i).getDescripcion()).append(" precio ").append(listaPostres.get(i).getPrecio()).append(" € ").append(" x ").append(listaPostres.get(i).getCantidadPedida()).append("\n");
        }
        sb.append("\n");
        sb.append(totalCarrito());
        JOptionPane.showMessageDialog(null, sb);

    }

    //Método para calcular totalCarrito
    public String totalCarrito() {
        double total = 0;
        double iva = 0;
        for (int i = 0; i < listaComida.size(); i++) {
            double precio = listaComida.get(i).getPrecio();
            int cantidad = listaComida.get(i).getCantidaPpedida();
            double importe = precio * cantidad;
            total += importe;
            double IVA = listaComida.get(i).getIva().getCantidadIva();
            iva += precio * IVA;
        }
        for (int i = 0; i < listaBebida.size(); i++) {
            double precio = listaBebida.get(i).getPrecio();
            int cantidad = listaBebida.get(i).getCantidadPedida();
            double importe = precio * cantidad;
            total += importe;
            double IVA = listaBebida.get(i).getIva().getCantidadIva();
            iva += precio * IVA;
        }
        for (int i = 0; i < listaPostres.size(); i++) {
            double precio = listaPostres.get(i).getPrecio();
            int cantidad = listaPostres.get(i).getCantidadPedida();
            double importe = precio * cantidad;
            total += importe;
            double IVA = listaPostres.get(i).getIva().getCantidadIva();
            iva += precio * IVA;
        }
        String texto = """
                      El importe total es de %.2f €
                                            (IVA %.2f €)
                      """.formatted(total, iva);
        return texto;
    }
}
