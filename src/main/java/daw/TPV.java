/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.MetodosTPV.cargaDatos;
import daw.productos.Bebida;
import daw.productos.Comida;
import daw.productos.ListasProductos;
import daw.productos.MetodosProductos;
import daw.productos.Postres;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class TPV {

    //Atributos
    private UUID identificador;
    private String ubicacion;
    private LocalDateTime fechaHora;
    //ArrayList<ticket> regristroCompra;
    private String contraseña;
    // generar contraseña
    private static final String LETRAS_MINUSCULAS = "abcdefghijklmnopqrstuvwkyz";
    private static final String LETRAS_MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWKYZ";
    private static final String NUMEROS = "0123456789";
    private static final String CARACTERES_ESPECIALES = "#$%&()*+,-.:;<=>@";

    //Constructores
    public TPV(String ubicacion) {
        this.identificador = UUID.randomUUID(); //Se genera un identificador
        this.ubicacion = ubicacion;
        this.fechaHora = LocalDateTime.now();
        this.contraseña = generarContraseña(); //Llama al método para generar contraseña
    }

    //SETTERS AND GETTERS
    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    //TO STRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TPV{");
        sb.append("identificador=").append(identificador);
        sb.append(", ubicacion=").append(ubicacion);
        sb.append(", fechaHora=").append(fechaHora);
        sb.append(", contrase\u00f1a=").append(contraseña);
        sb.append('}');
        return sb.toString();
    }

    //EQUALS Y HASHCODE
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.identificador);
        hash = 53 * hash + Objects.hashCode(this.ubicacion);
        hash = 53 * hash + Objects.hashCode(this.fechaHora);
        hash = 53 * hash + Objects.hashCode(this.contraseña);
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
        final TPV other = (TPV) obj;
        if (!Objects.equals(this.ubicacion, other.ubicacion)) {
            return false;
        }
        if (!Objects.equals(this.contraseña, other.contraseña)) {
            return false;
        }
        if (!Objects.equals(this.identificador, other.identificador)) {
            return false;
        }
        return Objects.equals(this.fechaHora, other.fechaHora);
    }

    //METODOS
    //Metodo para generar contraseña
    public String generarContraseña() {
        //Objeto random
        Random r = new Random();
        //Creamos el StringBuilder para poder agregar los char
        StringBuilder contraseña = new StringBuilder();

        //Añadimos 2 de cada tipo de String
        contraseña.append(generarCharAleatorio(LETRAS_MINUSCULAS));
        contraseña.append(generarCharAleatorio(LETRAS_MAYUSCULAS));
        contraseña.append(generarCharAleatorio(NUMEROS));
        contraseña.append(generarCharAleatorio(CARACTERES_ESPECIALES));
        contraseña.append(generarCharAleatorio(LETRAS_MINUSCULAS
                + LETRAS_MAYUSCULAS + CARACTERES_ESPECIALES + NUMEROS));
        contraseña.append(generarCharAleatorio(LETRAS_MINUSCULAS
                + LETRAS_MAYUSCULAS + CARACTERES_ESPECIALES + NUMEROS));

        //Llamamos al metodo para remover la contraseña
        revolver(contraseña);
        return contraseña.toString();
    }

    //Metodo para introducir char en el String
    public char generarCharAleatorio(String letras) {
        Random v = new Random();
        int indice = v.nextInt(letras.length());
        return letras.charAt(indice);

    }

    //Metodo para Revolver
    public void revolver(StringBuilder contraseña) {
        Random r = new Random();
        for (int i = 0; i < contraseña.length(); i++) {
            int indice = r.nextInt(contraseña.length());
            //En el char temporal almacena un char aleatorio
            char temporal = contraseña.charAt(indice);
            //Cambia en el char que ha sido seleccionado por aleatorio por el que
            //corresponde en la posicion que recorra el bucle
            contraseña.setCharAt(indice, contraseña.charAt(i));
            //Y cambia en i, el char que estaba en donde indice aleatorio
            contraseña.setCharAt(i, temporal);
        }
    }

    //PROGRAMA PRINCIPAL
    public static void encender() {
        //Carga de datos TPV
        ArrayList<TPV> tpvs = MetodosTPV.cargaDatos();
        //Carga de datos Productos
        ListasProductos productos = MetodosProductos.datosProductos();
        //Creación de carrito
        ListasProductos carrito = new ListasProductos();
        //Creación de Lista de ventas (Tickets)
        Ventas ventas = new Ventas();
        //Carga de datos de tarjetas
        ArrayList<TarjetaBanco> tarjetasRegistradas = MetodosTarjetaBanco.generarArrayTarjetas();
        System.out.println(tpvs.toString());
        boolean terminar = false;
        do {//Bucle general del programa

            //LLamo al método para preguntar en que modo quiere iniciar el programa
            int opcion = MetodosTPV.seleccionarModo();
            switch (opcion) {
                case 0 -> { //Modo Usuario
                    //Controlador bucle menu Usuario
                    boolean salir = false;
                    do {
                        String eleccion = MetodosTPV.seleccionMenuUsuario();
                        switch (eleccion) {
                            case "Comida" -> { //Opcion Comidas
                                //Añadimos al carrito una comida
                                Comida comidaElegida = productos.elegirComida();
                                int cantidad = carrito.preguntarPorCantidadComidaCarrito(comidaElegida);
                                carrito.añadirUnElementoCarrito(comidaElegida, cantidad);
                            }
                            case "Bebida" -> { //Opcion Bebidas
                                //Añadimos al carrito una bebida
                                Bebida bebidaElegida = productos.elegirBebida();
                                int cantidad = carrito.preguntarPorCantidadBebidaCarrito(bebidaElegida);
                                carrito.añadirUnElementoCarrito(bebidaElegida, cantidad);
                            }
                            case "Postre" -> { //Opcion Postres
                                //Añadimos al carrito un postre
                                Postres postreElegida = productos.elegirPostres();
                                int cantidad = carrito.preguntarPorCantidadPostreCarrito(postreElegida);
                                carrito.añadirUnElementoCarrito(postreElegida, cantidad);
                            }
                            case "Carrito" -> { //Carrito
                                boolean seguir = false;
                                while (!seguir) {
                                    String seleccion = MetodosTPV.seleccionOpcionesCarrito();
                                    switch (seleccion) {
                                        case "Ver Carrito" -> {
                                            carrito.verCarrito();
                                        }
                                        case "Borrar Carrito" -> {
                                            MetodosTPV.borrarCarrito(carrito);
                                        }
                                        case "Seguir Comprando" -> {
                                            seguir = true;
                                        }
                                        case "Pagar" -> {
                                            JOptionPane.showMessageDialog(null,
                                                    "Para completar el pedido"
                                                    + " introduzca la tarjeta.");
                                            boolean ok = MetodosTarjetaBanco.tarjetaValida(
                                                    tarjetasRegistradas);
                                            if (ok) {
                                                TicketVenta ticket
                                                        = MetodosTPV.generarTicket(carrito);
                                                //IMPORTANTE METODO PARA VACIAR CARRITO
                                                ventas.añadirTicket(ticket);
                                                JOptionPane.showMessageDialog(null, ticket);
                                                break;
                                            } else {
                                                JOptionPane.showMessageDialog(null,
                                                        "Se ha producido "
                                                        + "un Error. "
                                                        + "Intentelo de nuevo");
                                            }
                                        }
                                    }
                                }//Cierre del bucle del menu
                            }
                            case "Salir" -> { //Salir
                                salir = true;
                            }
                        }
                    } while (!salir);

                }
                case 1 -> {//Modo Administrador

                    //Bucle que controla la selección de tpv
                    boolean validoTPV = false;
                    //Bucle para controlar el acceso modo administrador
                    boolean salir = false;
                    //Bucle que controla el menú modificar un producto
                    boolean retroceso = false;
                    do {
                        int elegirTPV = MetodosTPV.preguntarTpv();
                        String password = MetodosTPV.preguntarContraseñaTpv();
                        if (password.equals(tpvs.get(elegirTPV).getContraseña())) {
                            validoTPV = true;
                        }
                    } while (!validoTPV);

                    do {
                        String eleccion = MetodosTPV.seleccionMenuAdministrador();

                        switch (eleccion) {
                            case "Modificar datos productos" -> {
                                do {
                                    String categoria = MetodosProductos.elegirCategorias();
                                    switch (categoria) {
                                        case "Comida" -> {
                                            //llamamos al método para que modifique
                                            //alguna comida
                                            productos.editarComida(productos.elegirComida(),
                                                    MetodosProductos.elegirQueCambiar());
                                        }
                                        case "Bebida" -> {
                                            //llamamos al método para que modifique
                                            //alguna bebida
                                            productos.editarBebida(productos.elegirBebida(),
                                                    MetodosProductos.elegirQueCambiar());
                                        }
                                        case "Postres" -> {
                                            //llamamos al método para que modifique
                                            //algun postre
                                            productos.editarPostres(productos.elegirPostres(),
                                                    MetodosProductos.elegirQueCambiar());
                                        }
                                        case "salir" -> {
                                            retroceso = true;
                                        }
                                    }
                                } while (!retroceso);

                            }
                            case "Crear producto" -> {
                                retroceso = false;
                                do {
                                    String categoria = MetodosProductos.elegirCategorias();
                                    switch (categoria) {
                                        case "Comida" -> {
                                            //llamamos al método para que cree una comida
                                            productos.nuevaComida();
                                        }
                                        case "Bebida" -> {
                                            //llamamos al método para que cree una bebida
                                            productos.nuevaBebida();
                                        }
                                        case "Postres" -> {
                                            //llamamos al método para que cree un postre
                                            productos.nuevoPostre();
                                        }
                                        case "salir" -> {
                                            retroceso = true;
                                        }
                                    }
                                } while (!retroceso);

                            }
                            case "Borrar producto" -> {
                                String categoria = MetodosProductos.elegirCategorias();
                                productos.borrarProductos(categoria);
                            }
                            case "Consultar ventas" -> {
                                boolean atras = false;
                                do {//Bucle para controlar el menu consultar fecha
                                    String busqueda = MetodosTPV.seleccionConsultarVentas();
                                    switch (busqueda) {
                                        case "Día concreto" -> {//Por día
                                            ventas.busquedaVentasDiaConcreto();
                                        }
                                        case "Fecha concreto" -> {//Enrte fechas
                                            ventas.busquedaEntreFechas();
                                        }
                                        case "Todas las ventas" -> {//Sin filtro
                                            ventas.mostrarVentas();
                                        }
                                        case "atras" -> {
                                            atras = true;
                                        }
                                    }
                                } while (!atras);

                            }
                            case "Salir" -> { //Salir del menu Administrador
                                salir = true;
                            }
                        }
                    } while (!salir);
                }
                case 2 -> {// Opcion salir del programa
                    terminar = true;
                }
                default -> {
                    terminar = true;
                }
            }

        } while (!terminar); //Bucle para no salir del programa
        JOptionPane.showMessageDialog(null,
                "Apagando el sistema.\nHasta pronto!");
    }
}
