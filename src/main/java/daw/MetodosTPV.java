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
        int opcion =JOptionPane.showOptionDialog(
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
    
    public static int seleccionarModo(){
        String[] modo ={"Modo punto de venta", "Modo Administrador"};
        
        int opcion =JOptionPane.showOptionDialog(
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
    
    public static void menuUsuario(){
        
    }
}
