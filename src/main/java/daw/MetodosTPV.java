/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor
 */
public class MetodosTPV {

    //METODOS PARA ARRANCAR EL PROGRAMA
    public static ArrayList<TPV> cargaDatos() {
        TPV estepona = new TPV("Estepona");
        TPV sanPedro = new TPV("San Pedro");
        TPV laLinea = new TPV("La línea");
        ArrayList<TPV> listaTpv = new ArrayList<>();
        listaTpv.add(estepona);
        listaTpv.add(sanPedro);
        listaTpv.add(laLinea);
        return listaTpv;
    }

    //Método para preguntar que TPV quiere acceder
    public static int preguntarTpv() {

        ArrayList<TPV> tpvs = cargaDatos();
        //Con este String obtengo el nombre de los TPVS que hemos cargado antes
        String[] elegir = {tpvs.get(0).getUbicacion(),
            tpvs.get(1).getUbicacion(), tpvs.get(2).getUbicacion()};
        int opcion = JOptionPane.showOptionDialog(
                null,
                "¿Qué TPV quieres usar?",
                "Elige TPV",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                elegir,
                elegir[0]);

        return opcion; //Devuelve 1,2 o 3
    }

    //Metodo contraseña
    public static String preguntarContraseñaTpv() {
        //Pregunta la contraseña
        return JOptionPane.showInputDialog("Por favor, "
                + "introduzca la contraseña");
    }

    //Preguntar en que modo quiere entrar el usuario
    public static int seleccionarModo() {
        String[] modo = {"Modo punto de venta", "Modo Administrador", "Salir"};

        int opcion = JOptionPane.showOptionDialog(
                null,
                "Bienvenido ¿Cómo quieres accede al programa?",
                "SELECCION MODO",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                modo,
                modo[0]);
        return opcion;

    }

    //MÉTODOS DE NAVEGABILIDAD
    //Menu Usuario
    //Método para elegir opciones del menu del usuario
    public static String seleccionMenuUsuario() {
        //Array de las opciones disponibles
        String[] opciones = {"Comida", "Bebida", "Postre", "Carrito", "Salir"};
        //Mostrar el mensaje con las opciones
        String eleccion = (String) JOptionPane.showInputDialog(null,
                "Por favor, elija una opción para ver", "Menu Usuario",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //Menu Administrador
    //Metodo para navegar por el menu Administrador
    public static String seleccionMenuAdministrador() {
        //Array de las opciones disponibles
        String[] opciones = {"Modificar datos productos", "Crear producto",
            "Borrar producto", "Consultar ventas", "Salir"};
        //Mostrar el mensaje con las opciones
        String eleccion = (String) JOptionPane.showInputDialog(null,
                "¿Qué deseas hacer?", "Menu Mantenimiento",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }

    //Metodo para navegar por el menu consultar ventas
    public static String seleccionConsultarVentas() {
        //Array de las opciones disponibles
        String[] opciones = {"Día concreto", "Fecha concreta",
            "Todas las ventas", "Atrás"};
        //Mostrar el mensaje con las opciones
        String eleccion = (String) JOptionPane.showInputDialog(null,
                "¿Cómo deseas realizar la búsqueda?", "Consultar Ventas",
                JOptionPane.QUESTION_MESSAGE, null,
                opciones, opciones[0]);
        return eleccion;
    }
}
