/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw.productos;

import java.util.ArrayList;

/**
 *
 * @author danielnavasborjas
 */
public class ListasProductos {
    //Creamos los atributos encapsulados de tipo ArrayList
    private ArrayList<Comida> listaComida;
    private ArrayList<Bebida> listaBebida;
    private ArrayList<Postres> listaPostres;
    
    //Creamos constructor por defecto
    public ListasProductos() {
        this.listaComida = new ArrayList<>();
        this.listaBebida = new ArrayList<>();
        this.listaPostres = new ArrayList<>();
    }

    //Insertamos los getters y setter
    public ArrayList<Comida> getListaComida() {
        return listaComida;
    }

    public void setListaComida(ArrayList<Comida> listaComida) {
        this.listaComida = listaComida;
    }

    public ArrayList<Bebida> getListaBebida() {
        return listaBebida;
    }

    public void setListaBebida(ArrayList<Bebida> listaBebida) {
        this.listaBebida = listaBebida;
    }

    public ArrayList<Postres> getListaPostres() {
        return listaPostres;
    }

    public void setListaPostres(ArrayList<Postres> listaPostres) {
        this.listaPostres = listaPostres;
    }
    
    //Insertamos el método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListasProductos{");
        sb.append("listaComida=").append(listaComida);
        sb.append(", listaBebida=").append(listaBebida);
        sb.append(", listaPostres=").append(listaPostres);
        sb.append('}');
        return sb.toString();
    }
    
    //Por ahora no metemos hashcode ni equals, porque no necesitamos comparar
    //estas listas, comentar con victor y llegar a un acuerdo 
}
