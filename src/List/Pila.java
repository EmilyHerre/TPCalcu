/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import Nodes.NodoPila;
import Exceptions.PilaException;

/**
 *
 * @author Emily Herrera, Alana Atencio, Sofia Guido 
 */
public class Pila {

    private NodoPila cima;
    private int tam;

     /**
     * This method indicates if the battery is empty
     * @return true if it is empty or false if it not 
     */
    public boolean empty() {
        return cima == null;
    }

    

     /**
     * This method displays the top item in the stack
     * @return the top element
     * @throws PilaException
     */
    public char top() throws PilaException {
        if (cima == null) {
            throw new PilaException("La lista está vacía");
        }
        return cima.getDato();
    }

  

     /**
     * This method takes the items off the stack
     * @return The item that was removed
     * @throws PilaException
     */
    public char pop() throws PilaException {
        char dato;
        if (cima == null) {
            throw new PilaException("La pila está vacía ");
        } else {
            dato = cima.getDato();
            cima = cima.getSiguiente();
            tam--;
        }
        return dato;

    }

    

     /**
     * This method enter character type elements to the stack
     * @param dato
     * @return el elemento que se ingreso
     * @throws PilaException
     */
    public char push(char dato) throws PilaException {
        NodoPila nuevo = new NodoPila();
        nuevo.setDato(dato);

        if (cima == null) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
        tam++;
        return cima.getDato();
    }

      /**
     * This method searches for a specific item in the stack
     * @param dato the item to search
     * @return 
     * @throws PilaException
     */
    public int search(char dato) throws PilaException {
        int contador = 0;
        if (cima == null) {
            throw new PilaException("La pila está vacía");
        } else {
            NodoPila actual = cima;
            while (actual != null) {
                if (actual.getDato() == dato) {
                    return contador;
                }
                contador++;
                actual = actual.getSiguiente();
            }
        }
        return -1;

    }

    /**
     * This method shows the size of the stack
     * @return the size
     */
    public int size() {
        return tam;
    }

}
