/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class Ventas {
    
    //Atributos
    private ArrayList<TicketVenta> ventasTotales = new ArrayList<>();
    
    //Constructor

    public Ventas() {
        
    }
    
    
    //GETTER AND SETTER

    public ArrayList<TicketVenta> getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(ArrayList<TicketVenta> ventasTotales) {
        this.ventasTotales = ventasTotales;
    }
    
    //To String

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ventas{");
        for(int i=0;i<ventasTotales.size();i++){
        sb.append("ventasTotales=").append(ventasTotales.get(i));
        }
        sb.append('}');
        return sb.toString();
    }
    
    //HASHCODE AND EQUALS

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.ventasTotales);
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
        final Ventas other = (Ventas) obj;
        return Objects.equals(this.ventasTotales, other.ventasTotales);
    }
    // Método para añadir
    public void añadirTicket(TicketVenta ticket){
        ventasTotales.add(ticket);
    }
    //MÈTODOS PARA BUSCAR POR DÍA
    public ArrayList<TicketVenta> busquedaVentasDiaConcreto(){
        ArrayList<TicketVenta> seleccionados= new ArrayList<>();
        
       //Llamo al metodo preguntar fecha
       LocalDate fecha=MetodosVentas.preguntarFecha();
        for(int i=0; i<ventasTotales.size();i++){
            if(fecha.equals(ventasTotales.get(i).getFechaCompra())){
                seleccionados.add(ventasTotales.get(i));
            }
        }
        
        
       return seleccionados;
    }
    
     //MÈTODOS PARA BUSCAR ENTRE FECHAS
    public ArrayList<TicketVenta> busquedaEntreFechas(){
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
       return seleccionados;
    }
    //Método para mostrar toda las ventas
    public void mostrarVentas(){
        JOptionPane.showMessageDialog(null, 
                ventasTotales.toString());
    }
    
}
