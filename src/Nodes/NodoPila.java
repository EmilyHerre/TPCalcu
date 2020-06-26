/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

/**
 * The node stack class is in charge of generating the union link of an element
 * @author Emily Herrera, Alana Atencio, Sofia Guido
 */
public class NodoPila {
    
    //Attributes
    char dato; //char type data
    NodoPila siguiente;

    
    public char getDato() {
        return dato;
    }

   
    public void setDato(char dato) {
        this.dato = dato;
    }

    
    public NodoPila getSiguiente() {
        return siguiente;
    }

   
    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

}
