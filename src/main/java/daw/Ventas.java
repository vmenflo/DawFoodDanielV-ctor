/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
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
    private ArrayList<TicketVenta> ventasTotales;
    
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
        sb.append("ventasTotales=").append(ventasTotales);
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
    
    //MÈTODOS PARA BUSCAR POR DÍA
    public ArrayList<TicketVenta> busquedaVentasDiaConcreto(){
        ArrayList<TicketVenta> seleccionados=null;
        //Pedir al usuario que día quiere obtener todos los tickets
        String dia = String.valueOf(JOptionPane.showInputDialog("Introduce el dia"));
        int d = Integer.parseInt(dia);

        String mes = String.valueOf(JOptionPane.showInputDialog("Introduce el mes"));
        int m = Integer.parseInt(mes);

        String año = String.valueOf(JOptionPane.showInputDialog("Introduce el año")).trim();
        int a = Integer.parseInt(año);
        LocalDate fecha = LocalDate.of(d, m, a);
       
        
        for(int i=0; i<ventasTotales.size();i++){
            if(fecha.equals(ventasTotales.get(i).getFechaHoraCompra())){
                seleccionados.add(ventasTotales.get(i));
            }
        }
        
       return seleccionados;
    }
    
    
}
