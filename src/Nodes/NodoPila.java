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
public class NodoPila {

    char dato;
    NodoPila siguiente;

    /**
     *
     * @return
     */
    public char getDato() {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(char dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public NodoPila getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}
