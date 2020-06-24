/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

/**
 *
 * @author Emily
 */
public class Nodo {

    String dato;
    Nodo siguiente;

    /**
     *
     * @return
     */
    public String getDato() {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
