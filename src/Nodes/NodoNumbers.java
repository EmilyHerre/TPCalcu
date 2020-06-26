/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

/**
 * The node stack numbers class is in charge of generating the union link of an
 * element
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class NodoNumbers {

    //Attributes
    double dato; //double type data
    NodoNumbers siguiente;

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public NodoNumbers getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoNumbers siguiente) {
        this.siguiente = siguiente;
    }

}
