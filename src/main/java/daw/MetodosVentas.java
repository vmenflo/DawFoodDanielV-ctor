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
    public static LocalDate preguntarFecha() {
        //Pedir al usuario la fecha quiere obtener todos los tickets
        //Pedir día
        int d = 0;
        boolean valida = false;
        do {//Bucle para controlar excepcion y datos
            try {
                String dia = String.valueOf(JOptionPane.showInputDialog(
                        "Introduce el día. Ejemplo: 01"));
                d = Integer.parseInt(dia);
                if (d > 0 && d <= 31) {
                    valida = true;//Si todo bien se sale del bucle
                } else {//Que no, indica que lo introduzca bien
                    JOptionPane.showMessageDialog(null,
                            "Por favor, introduce un día válido "
                            + "(entre 1 y 31).");
                }
                //Si salta excepcion lanza el mensaje
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Ingresa un valor numérico válido para el día.");
            }
        } while (!valida);
        //Pedir mes
        int m = 0;
        boolean valido = false;
        do {
            try {
                String mes = String.valueOf(JOptionPane.showInputDialog(
                        "Introduce el mes. Ej 01"));
                m = Integer.parseInt(mes);
                if (m >= 1 && m <= 12) {
                    valido = true;//Si todo bien se sale del bucle  
                } else {//Que no, indica que lo introduzca bien
                    JOptionPane.showMessageDialog(null,
                            "Por favor, introduce un día válido "
                            + "(entre 1 y 12).");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error: Ingresa un valor numérico válido para el mes.");
            }
        } while (!valido);
        //Pedir año
        int a = 0;
        boolean correcto = false;
        while (!correcto) {
            try {
                String año = String.valueOf(JOptionPane.showInputDialog(
                        "Introduce el año. Ej 2024")).trim();
                a = Integer.parseInt(año);
                correcto = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Error. Ingresa un valor númerico válido para el año");
            }
        }

        LocalDate fecha = LocalDate.of(a, m, d);
        return fecha;
    }
}
