/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Objects;

/**
 *
 * @author Víctor
 * De una tarjeta de crédito se guardará el número de tarjeta,
 * la fecha de vencimiento y el CVV, así como el nombre del titular
 * de la tarjeta y el saldo que tiene.
 */
public class TarjetaBanco {
    //Atributos
    private String numeroTarjeta;
    private String titular;
    private YearMonth caducidad;
    private int cvc;
    private double saldo;
    
    //Constructores
    public TarjetaBanco(String numeroTarjeta, String titular, int año, int mes, int cvc, double saldo) {    
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.caducidad = YearMonth.of(año, mes);
        this.cvc = cvc;
        this.saldo = saldo;
    }

    //Getter and Setter
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public YearMonth getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(YearMonth caducidad) {
        this.caducidad = caducidad;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    //Equals HashCode

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.numeroTarjeta);
        hash = 79 * hash + Objects.hashCode(this.titular);
        hash = 79 * hash + Objects.hashCode(this.caducidad);
        hash = 79 * hash + this.cvc;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.saldo) ^ (Double.doubleToLongBits(this.saldo) >>> 32));
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
        final TarjetaBanco other = (TarjetaBanco) obj;
        if (this.cvc != other.cvc) {
            return false;
        }
        if (Double.doubleToLongBits(this.saldo) != Double.doubleToLongBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.numeroTarjeta, other.numeroTarjeta)) {
            return false;
        }
        if (!Objects.equals(this.titular, other.titular)) {
            return false;
        }
        return Objects.equals(this.caducidad, other.caducidad);
    }
    
    //To String
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TarjetaBanco{");
        sb.append("numeroTarjeta=").append(numeroTarjeta);
        sb.append(", titular=").append(titular);
        sb.append(", caducidad=").append(caducidad);
        sb.append(", cvc=").append(cvc);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }
    
    
}
