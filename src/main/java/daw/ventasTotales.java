/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor
 */
public record ventasTotales(ArrayList<TicketVenta> ventasTotales) {
//MÈTODOS PARA BUSCAR POR DÍA
    public void busquedaVentasDiaConcreto(){
        ArrayList<TicketVenta> seleccionados= new ArrayList<>();
        
       //Llamo al metodo preguntar fecha
       LocalDate fecha=MetodosVentas.preguntarFecha();
        for(int i=0; i<ventasTotales.size();i++){
            if(fecha.equals(ventasTotales.get(i).getFechaCompra())){
                seleccionados.add(ventasTotales.get(i));
            }
        }
        JOptionPane.showMessageDialog(null, seleccionados);
    }
//MÈTODOS PARA BUSCAR ENTRE FECHAS
    public void busquedaEntreFechas(){
        ArrayList<TicketVenta> seleccionados= new ArrayList<>();
        //LLamo a lo métodos para tener las dos fechas
        JOptionPane.showMessageDialog(null, 
                "Ingrese primera fecha");
        LocalDate fecha1 = MetodosVentas.preguntarFecha();
        JOptionPane.showMessageDialog(null, 
                "Ingrese segunda fecha");
        LocalDate fecha2 = MetodosVentas.preguntarFecha();
       
        LocalDate fechaVenta ;
        for(int i=0; i<ventasTotales.size();i++){
            fechaVenta = ventasTotales.get(i).getFechaCompra();
            if((fechaVenta.isEqual(fecha1) || fechaVenta.isAfter(fecha1)) &&
            (fechaVenta.isEqual(fecha2) || fechaVenta.isBefore(fecha2))){
                seleccionados.add(ventasTotales.get(i));
            }
        }
       JOptionPane.showMessageDialog(null, seleccionados);
    }
    //Método para mostrar toda las ventas
    public void mostrarVentas(){
        JOptionPane.showMessageDialog(null, 
                ventasTotales.toString());
    }
}
