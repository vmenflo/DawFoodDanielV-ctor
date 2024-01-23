/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import daw.productos.ListasProductos;
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
    private UUID id;
    private int numeroPedido=0;
    private ArrayList<ListasProductos> productosComprados;
    private LocalDateTime fechaHoraCompra;
    private double TotalImporte;
   
    //Constructor
    public TicketVenta() {
        this.id = UUID.randomUUID();
        this.numeroPedido++;
        this.productosComprados=null;
        this.fechaHoraCompra=null;
        this.TotalImporte=0;
    }
    
    //GETTER AND SETTER

    public UUID getId() {
        return id;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public ArrayList<ListasProductos> getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(ArrayList<ListasProductos> productosComprados) {
        this.productosComprados = productosComprados;
    }

    public LocalDateTime getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(LocalDateTime fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
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
        sb.append(", fechaHoraCompra=").append(fechaHoraCompra);
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
        hash = 97 * hash + Objects.hashCode(this.fechaHoraCompra);
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
        return Objects.equals(this.fechaHoraCompra, other.fechaHoraCompra);
    }
    
    
}
