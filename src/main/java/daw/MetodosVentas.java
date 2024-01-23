/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor
 */
public class MetodosVentas {
    //Método para preguntar y recoger una fecha
    public static LocalDate preguntarFecha(){
        //Pedir al usuario que día quiere obtener todos los tickets
        String dia = String.valueOf(JOptionPane.showInputDialog("Introduce el dia"));
        int d = Integer.parseInt(dia);

        String mes = String.valueOf(JOptionPane.showInputDialog("Introduce el mes"));
        int m = Integer.parseInt(mes);

        String año = String.valueOf(JOptionPane.showInputDialog("Introduce el año")).trim();
        int a = Integer.parseInt(año);
        LocalDate fecha = LocalDate.of(a, m, d);
        return fecha;
    }
}
