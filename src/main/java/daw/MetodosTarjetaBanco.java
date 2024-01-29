/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import daw.productos.ListasProductos;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Víctor
 */
public class MetodosTarjetaBanco {
    //Método para crear una arrayList de tipo TarjetaBanco 
    //Y rellenarla de varias tarjetas para usarlas en el programa

    public static ArrayList<TarjetaBanco> generarArrayTarjetas() {
        //Creamos array que devolveremos con el método
        ArrayList<TarjetaBanco> tarjetas = new ArrayList<>();
        //Creamos varias tarjetas
        TarjetaBanco tarjetaUno = new TarjetaBanco("ES98549623584239",
                "VICTOR MENA FLORES", 2025, 11, 919, 500);
        TarjetaBanco tarjetaDos = new TarjetaBanco("ES98549623588745",
                "DANIEL NAVAS BORJA", 2025, 11, 971, 1000);
        TarjetaBanco tarjetaTres = new TarjetaBanco("ES98549623583652",
                "RAMÓN TIESO", 2025, 11, 856, 10);
        //Las añadimos
        tarjetas.add(tarjetaUno);
        tarjetas.add(tarjetaDos);
        tarjetas.add(tarjetaTres);
        return tarjetas;
    }
    //Método para pedir al usuario que introduzca datos tarjeta
    public static boolean tarjetaValida(ArrayList<TarjetaBanco> tarjetas, ListasProductos listas){
    boolean correcto=false;
    //Datos que pedimos al usuario con llamadas de métodos
    String numero =MetodosTarjetaBanco.pedirNumeroTarjeta();
    int cvc = MetodosTarjetaBanco.pedirCVC();
    YearMonth fecha = MetodosTarjetaBanco.pedirCaducidad();
    //Datos a comparar
    int cvcTemporal=0;
    String numeroTemporal=null;
    YearMonth fechaTemporal = null;
    YearMonth hoy = YearMonth.now();
    String ultimosCuatro=null;
    double totalCompra=0;
    double saldo=0;
    //Bucle para comparar
    for(int i=0;i<tarjetas.size();i++){
        cvcTemporal=tarjetas.get(i).getCvc();
        fechaTemporal=tarjetas.get(i).getCaducidad();
        numeroTemporal=tarjetas.get(i).getNumeroTarjeta();
        ultimosCuatro=numeroTemporal.substring(tarjetas.get(i).getNumeroTarjeta().length()-4);
        totalCompra= TicketVenta.calcularImporteTotal(listas);
        saldo=tarjetas.get(i).getSaldo();
        //condicional para parar y devolver true una vez que se cumple la condición
        if((cvc==cvcTemporal)
                &&(numero.equals(ultimosCuatro))
                &&(fecha.equals(fechaTemporal)&&fecha.isAfter(hoy))&&(totalCompra<=saldo)){
            correcto=true;
            break;
        }
    }
    
    return correcto;
    }
    //Pedir numero de la tarjeta
    public static String pedirNumeroTarjeta(){
    String numero=null;
    boolean valido=false;
    while(!valido){
        try{
            numero=JOptionPane.showInputDialog(
                    "¿Intorduce los últimos 4 dígitos? ");
            if(numero.length()<5){
                valido=true;
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Por favor, intoduzca el dato correctamente. Ej.1111");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,
                    "Error. Dato introducido incorrecto");
        }
    }//Cierre while
    return numero;
    }
    
    //Pedir datos de la fecha
    public static YearMonth pedirCaducidad(){
    int año=0;
    int mes=0;
    //Pedir año
    boolean valido=false;
    while(!valido){
        try{
            año=Integer.parseInt(JOptionPane.showInputDialog(
                    "¿En qué año caduca tu tarjeta? "));
            if(año>0&&año<9999){
                valido=true;
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Por favor, intoduzca el año correctamente Ej. 2024");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,
                    "Error. Has introducido letras");
        }
    }//Cierre while
    
    //Pedir mes
    boolean valida=false;
    while(!valida){
        try{
            mes=Integer.parseInt(JOptionPane.showInputDialog(
                    "¿En qué mes caduca tu tarjeta? "));
            if(mes>0&&mes<=12){
                valida=true;
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Por favor, intoduzca el mes correctamente Ej. 01");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,
                    "Error. Al introducir los datos");
        }
    }//Cierre while
    
    YearMonth fecha = YearMonth.of(año,mes);
    return fecha;
    }
    
    //Pedir datos de CVC
    public static int pedirCVC(){
        int cvc=0;
        boolean valido=false;
        while(!valido){
        try{
            cvc=Integer.parseInt(JOptionPane.showInputDialog(
                    "¿Cúal es el número de CVC. \n(Recuerda, los 3 dígitos"
                            + " detrás de tu tarjeta) "));
            if(cvc>0&&cvc<=999){
                valido=true;
            }else{
                JOptionPane.showMessageDialog(null, 
                        "Por favor, intoduzca sólo los tres dígitos");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,
                    "Error. Has introducido letras");
        }
        }
        return cvc;
    }
    
}
