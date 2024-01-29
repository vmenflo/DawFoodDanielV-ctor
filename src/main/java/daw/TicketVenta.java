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
 * @author victor Cada Ticket emitido debe tener un ID, que se debe generar
 * asegurando la unicidad del mismo, un número de pedido único (que puede ser
 * reseteado cada día y debe ser sencillo porque es el número que se utilizaría
 * para recoger el pedido con la comida), la lista de productos comprados, el
 * total del importe del ticket y la fecha y hora de la operación. Los datos a
 * guardar de cada producto en un ticket son su ID, descripción, precio e IVA.
 *
 */
public class TicketVenta {

    //Atributos
    private static int contador = 1;
    private UUID id;
    private int numeroPedido;
    private ListasProductos productosComprados;
    private LocalDate fechaCompra;
    private double TotalImporte = 0;
    private double TotalIVA = 0;

    //Constructor
    public TicketVenta(ListasProductos productosComprados) {
        this.id = UUID.randomUUID();
        //Controlo que no pase de 100
        if (contador > 99) {
            contador = 1;
        }
        this.numeroPedido = contador++;
        this.productosComprados = productosComprados;
        this.fechaCompra = LocalDate.now();
        this.TotalImporte = calcularImporteTotal(productosComprados);
        this.TotalIVA = calcularIVATotal(productosComprados);
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

    public ListasProductos getProductosComprados() {
        return productosComprados;
    }

    public void setProductosComprados(ListasProductos productosComprados) {
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
        sb.append("\n{Ticket:  ").append(id);
        sb.append("\nNúmero de pedido=").append(numeroPedido);
        sb.append("\nFecha de la compra=").append(fechaCompra);
        sb.append("\nProductos comprados:\n");
        for (int i = 0; i < productosComprados.getListaComida().size(); i++) {
            sb.append(productosComprados.getListaComida().get(i).getDescripcion()).append(" x ").append(productosComprados.getListaComida().get(i).getCantidaPpedida()).append(" - ").append(productosComprados.getListaComida().get(i).getPrecio()).append(" €/unid\n");
        }
        for (int i = 0; i < productosComprados.getListaBebida().size(); i++) {
            sb.append(productosComprados.getListaBebida().get(i).getDescripcion()).append(" x ").append(productosComprados.getListaBebida().get(i).getCantidadPedida()).append(" - ").append(productosComprados.getListaBebida().get(i).getPrecio()).append(" €/unid\n");
        }
        for (int i = 0; i < productosComprados.getListaPostres().size(); i++) {
            sb.append(productosComprados.getListaPostres().get(i).getDescripcion()).append(" x ").append(productosComprados.getListaPostres().get(i).getCantidadPedida()).append(" - ").append(productosComprados.getListaPostres().get(i).getPrecio()).append(" €/unid\n");
        }
        sb.append("Total importe= ").append(TotalImporte).append(" €");
        sb.append("\nTotal (IVA)= ").append(TotalIVA).append(" €");
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

    public static double calcularImporteTotal(ListasProductos lista) {
        double importe = 0;

        for (int i = 0; i < lista.getListaComida().size(); i++) {
            importe += (lista.getListaComida().get(i).getPrecio())
                    * (lista.getListaComida().get(i).getCantidaPpedida());
        }

        for (int i = 0; i < lista.getListaBebida().size(); i++) {
            importe += (lista.getListaBebida().get(i).getPrecio())
                    * (lista.getListaBebida().get(i).getCantidadPedida());
        }

        for (int i = 0; i < lista.getListaPostres().size(); i++) {
            importe += (lista.getListaPostres().get(i).getPrecio())
                    * (lista.getListaPostres().get(i).getCantidadPedida());
        }

        return importe;
    }

    public static double calcularIVATotal(ListasProductos lista) {
        double importe = 0;

        for (int i = 0; i < lista.getListaComida().size(); i++) {
            importe += (lista.getListaComida().get(i).getPrecio())
                    * (lista.getListaComida().get(i).getIva().getCantidadIva());
        }

        for (int i = 0; i < lista.getListaBebida().size(); i++) {
            importe += (lista.getListaBebida().get(i).getPrecio())
                    * (lista.getListaBebida().get(i).getIva().getCantidadIva());
        }

        for (int i = 0; i < lista.getListaPostres().size(); i++) {
            importe += (lista.getListaPostres().get(i).getPrecio())
                    * (lista.getListaPostres().get(i).getIva().getCantidadIva());
        }

        return importe;
    }
}
