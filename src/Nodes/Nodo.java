/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

/**
 * The node queue class is in charge of generating the union link of an element
 *
 * @author Emily Herrera, Alana Atencio, Vanessa Guido
 *
 */
public class Nodo {

    //Attributes
    String dato; //String data
    Nodo siguiente;

    //sets ang gets
    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
