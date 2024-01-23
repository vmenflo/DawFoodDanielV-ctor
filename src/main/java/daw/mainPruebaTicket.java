/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Víctor
 */
public class mainPruebaTicket {
    public static void main(String[] args) {
        TicketVenta ticket1 = new TicketVenta();
        TicketVenta ticket2 = new TicketVenta();
        TicketVenta ticket3 = new TicketVenta();
        TicketVenta ticket4 = new TicketVenta();
        TicketVenta ticket5 = new TicketVenta();
        LocalDate mañana = LocalDate.of(2024, 1, 24);
        LocalDate veinticinco = LocalDate.of(2024, 1, 25);
        ticket4.setFechaCompra(mañana);
        ticket5.setFechaCompra(veinticinco);
        
        Ventas ventas = new Ventas();
        ventas.añadirTicket(ticket1);
        ventas.añadirTicket(ticket2);
        ventas.añadirTicket(ticket3);
        ventas.añadirTicket(ticket4);
        ventas.añadirTicket(ticket5);
        
        System.out.println(ventas);
        
        Ventas diaSeleccionado = new Ventas();
        diaSeleccionado.setVentasTotales(ventas.busquedaEntreFechas());
        
        System.out.println(diaSeleccionado);
        
        
        
    }
}
