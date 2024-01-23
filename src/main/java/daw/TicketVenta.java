/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import daw.productos.ListasProductos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author victor
 * Cada Ticket emitido debe tener un ID, que se debe generar asegurando la
 * unicidad del mismo, un número de pedido único (que puede ser reseteado 
 * cada día y debe ser sencillo porque es el número que se utilizaría para 
 * recoger el pedido con la comida), la lista de productos comprados, el total 
 * del importe del ticket y la fecha y hora de la operación. Los datos a guardar
 * de cada producto en un ticket son su ID, descripción, precio e IVA.

 */
public class TicketVenta {
    //Atributos
    private static int contador=1;
    private UUID id;
    private int numeroPedido;
    private ArrayList<ListasProductos> productosComprados;
    private LocalDate fechaCompra;
    private double TotalImporte;
   
    //Constructor
    public TicketVenta() {
        this.id = UUID.randomUUID();
        //Controlo que no pase de 100
            if (contador > 99) {
            contador = 1;
            }
        this.numeroPedido=contador++;
        this.productosComprados=null;
        this.fechaCompra=LocalDate.now();
        this.TotalImporte=0;
    }
    
    //GETTER AND SETTER

    public UUID getId() {
        return id;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }
    

    public ArrayList<ListasProductos> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(ArrayList<ListasProductos> productosComprados) {
        this.productosComprados = productosComprados;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalImporte() {
        return TotalImporte;
    }

    //TO String

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TicketVenta{");
        sb.append("id=").append(id);
        sb.append(", numeroPedido=").append(numeroPedido);
        sb.append(", productosComprados=").append(productosComprados);
        sb.append(", fechaHoraCompra=").append(fechaCompra);
        sb.append(", TotalImporte=").append(TotalImporte);
        sb.append('}');
        return sb.toString();
    }
    
    //HASHCODE Y EQUALS

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + this.numeroPedido;
        hash = 97 * hash + Objects.hashCode(this.productosComprados);
        hash = 97 * hash + Objects.hashCode(this.fechaCompra);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.TotalImporte) ^ (Double.doubleToLongBits(this.TotalImporte) >>> 32));
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
        final TicketVenta other = (TicketVenta) obj;
        if (this.numeroPedido != other.numeroPedido) {
            return false;
        }
        if (Double.doubleToLongBits(this.TotalImporte) != Double.doubleToLongBits(other.TotalImporte)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.productosComprados, other.productosComprados)) {
            return false;
        }
        return Objects.equals(this.fechaCompra, other.fechaCompra);
    }
    
    
}
