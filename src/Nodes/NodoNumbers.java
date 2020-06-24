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
public class NodoNumbers {

   double dato;
    NodoNumbers siguiente;

    /**
     *
     * @return
     */
    public double getDato() {
        return dato;
    }

    /**
     *
     * @param dato
     */
    public void setDato(double dato) {
        this.dato = dato;
    }

    /**
     *
     * @return
     */
    public NodoNumbers getSiguiente() {
        return siguiente;
    }

    /**
     *
     * @param siguiente
     */
    public void setSiguiente(NodoNumbers siguiente) {
        this.siguiente = siguiente;
    }

}
